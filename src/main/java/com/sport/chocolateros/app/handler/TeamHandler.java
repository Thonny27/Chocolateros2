package com.sport.chocolateros.app.handler;

import com.sport.chocolateros.app.document.CustomerSoccerField;
import com.sport.chocolateros.app.document.Team;
import com.sport.chocolateros.app.document.User;
import com.sport.chocolateros.app.service.TeamService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TeamHandler {

    @Autowired
    private TeamService service;

    public Mono<ServerResponse> save(ServerRequest request) {

        Mono<Team> teamMono = request.bodyToMono(Team.class);

        return teamMono.flatMap(team -> {
            return service.save(team).flatMap(t -> ServerResponse.created(URI.create("/api/chocolateros/team/".concat(t.getId())))
                    .contentType(MediaType.APPLICATION_JSON)
                    .syncBody(t));
        });
    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), Team.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> findByName(ServerRequest request) {
        String nameTeam = request.pathVariable("nameTeam");
        return service.findByName(nameTeam).flatMap(team -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .syncBody(team))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

}
