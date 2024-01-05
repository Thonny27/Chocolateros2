package com.sport.chocolateros.app.handler;

import com.sport.chocolateros.app.document.CustomerSoccerField;
import com.sport.chocolateros.app.dto.Filters;
import com.sport.chocolateros.app.service.CustomerSoccerFieldService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class CustomerSoccerFieldHandler {

    @Autowired
    private CustomerSoccerFieldService service;

    public Mono<ServerResponse> save(ServerRequest request) {

        Mono<CustomerSoccerField> userMono = request.bodyToMono(CustomerSoccerField.class);

        return userMono.flatMap(customerSoccerField -> {
            return service.save(customerSoccerField).flatMap(csf -> ServerResponse.created(URI.create("/api/chocolateros/customerSoccerField/".concat(csf.getId())))
                    .contentType(MediaType.APPLICATION_JSON)
                    .syncBody(csf));
        });
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        String id = request.pathVariable("id");
        Mono<CustomerSoccerField> customerSoccerFielRequest = request.bodyToMono(CustomerSoccerField.class);
        Mono<CustomerSoccerField> customerSoccerFielDB = service.findById(id);

        return customerSoccerFielDB.zipWith(customerSoccerFielRequest, (db, req) -> {
                    db.setCustomerName(req.getCustomerName());
                    db.setCustomerLastName(req.getCustomerLastName());
                    db.setCustomerAge(req.getCustomerAge());
                    db.setSoccerFieldName(req.getSoccerFieldName());
                    db.setDepartament(req.getDepartament());
                    db.setDistrict(req.getDistrict());
                    db.setSoccerFieldAddress(req.getSoccerFieldAddress());
                    db.setStartTime(req.getStartTime());
                    db.setEndTime(req.getEndTime());
                    db.setPhone(req.getPhone());
                    db.setQuantitySoccersField(req.getQuantitySoccersField());
                    db.setPhoto(req.getPhoto());
                    db.setSoccerFields(req.getSoccerFields());
                    return db;
                }).flatMap(csf -> ServerResponse.created(URI.create("/api/chocolateros/customerSoccerField/".concat(csf.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(service.save(csf), CustomerSoccerField.class))
                .switchIfEmpty(ServerResponse.notFound().build());

    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), CustomerSoccerField.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");

        return service.findById(id).flatMap(csf -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromObject(csf)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> findByFilters(ServerRequest request) {

        Mono<Filters> filters = request.bodyToMono(Filters.class);

//        Optional<String> name=  request.queryParam("name");
//        Optional<String> departament= request.queryParam("departament");
//        Optional<String> type= request.queryParam("type");
//        Optional<String> maxPlayers= request.queryParam("maxPlayers");
//        Optional<String> price= request.queryParam("price");
        return filters.flatMap(flt -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(service.findByFilters(flt), CustomerSoccerField.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

}
