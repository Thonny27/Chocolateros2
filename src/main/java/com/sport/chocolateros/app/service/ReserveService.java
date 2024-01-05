package com.sport.chocolateros.app.service;

import com.sport.chocolateros.app.document.Reserve;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReserveService {
    Flux<Reserve> findAll();

    Flux<Reserve> findByUserId(String userId);

    Mono<Reserve> save(Reserve reserve);
}
