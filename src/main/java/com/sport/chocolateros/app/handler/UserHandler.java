package com.sport.chocolateros.app.handler;

import com.sport.chocolateros.app.document.User;
import com.sport.chocolateros.app.dto.UserLogin;
import com.sport.chocolateros.app.service.UserService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    @Autowired
    private UserService userService;

    public Mono<ServerResponse> save(ServerRequest request) {

        Mono<User> userMono = request.bodyToMono(User.class);

        return userMono.flatMap(p -> {
            return userService.save(p).flatMap(prod -> ServerResponse.created(URI.create("/api/chocolateros/user/".concat(prod.getId())))
                    .contentType(MediaType.APPLICATION_JSON)
                    .syncBody(prod));
        });
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        String id = request.pathVariable("id");
        Mono<User> userRequest = request.bodyToMono(User.class);
        Mono<User> userDb = userService.findById(id);

        return userDb.zipWith(userRequest, (db, req) -> {
                    db.setName(req.getName());
                    db.setLastName(req.getLastName());
                    db.setAge(req.getAge());
                    db.setEmail(req.getEmail());
                    db.setDepartament(req.getDepartament());
                    db.setDistrict(req.getDistrict());
                    db.setAddress(req.getAddress());
                    db.setPhoto(req.getPhoto());
                    return db;
                }).flatMap(user -> ServerResponse.created(URI.create("/api/chocolateros/user/".concat(user.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(userService.save(user), User.class))
                .switchIfEmpty(ServerResponse.notFound().build());

    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userService.findall(), User.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return userService.findById(id).flatMap(user -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .syncBody(user))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> login(ServerRequest request) {
        Mono<UserLogin> userLoginMono = request.bodyToMono(UserLogin.class);
        return userLoginMono.flatMap(p -> {
            return userService.login(p).flatMap(prod -> ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .syncBody(prod))
                    .switchIfEmpty(ServerResponse.notFound().build());
        });
    }

}
