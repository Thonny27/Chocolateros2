package com.sport.chocolateros.app.handler;

import com.sport.chocolateros.app.document.Reserve;
import com.sport.chocolateros.app.dto.SoccerFieldReserved;
import com.sport.chocolateros.app.service.CustomerSoccerFieldService;
import com.sport.chocolateros.app.service.ReserveService;
import java.net.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ReserveHandler {

    private static final Logger log = LoggerFactory.getLogger(ReserveHandler.class);

    @Autowired
    private ReserveService reserveService;

    @Autowired
    private CustomerSoccerFieldService customerSoccerFieldService;

    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<Reserve> reserveMono = request.bodyToMono(Reserve.class);
        String id = request.pathVariable("id");

//        return reserveMono.flatMap(reserve->{
//            return reserveService.save(reserve).flatMap(r->ServerResponse.created(URI.create("/api/chocolateros/reserve/".concat(r.getId())))
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .syncBody(r));
//        });
        return reserveMono.flatMap(reserve -> customerSoccerFieldService.findById(reserve.getCustomerSoccerFieldId())
                .flatMap(customerSoccerField -> {
                    SoccerFieldReserved soccerFieldReserved = new SoccerFieldReserved();
                    soccerFieldReserved.setName(customerSoccerField.getSoccerFieldName());
                    soccerFieldReserved.setLogo(customerSoccerField.getPhoto());
                    soccerFieldReserved.setPhone(customerSoccerField.getPhone());
                    soccerFieldReserved.setAddress(customerSoccerField.getSoccerFieldAddress());
                    reserve.setSoccerFieldReserved(soccerFieldReserved);

                    return reserveService.save(reserve).flatMap(reserved -> ServerResponse.created(URI.create("/api/chocolateros/reserve/".concat(reserved.getId())))
                            .contentType(MediaType.APPLICATION_JSON)
                            .syncBody(reserved));
                }));
    }

    public Mono<ServerResponse> findAllReserves(ServerRequest request) {

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(reserveService.findAll(), Reserve.class);
    }

    public Mono<ServerResponse> findReservesByUserId(ServerRequest request) {
        String userId = request.pathVariable("id");

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(reserveService.findByUserId(userId), Reserve.class);
    }
}
