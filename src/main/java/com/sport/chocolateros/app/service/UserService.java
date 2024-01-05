package com.sport.chocolateros.app.service;

import com.sport.chocolateros.app.document.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Flux<User> findall();

    Mono<User> save(User user);

    Mono<User> findById(String id);
}
