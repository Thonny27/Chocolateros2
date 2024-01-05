package com.sport.chocolateros.app.service;

import com.sport.chocolateros.app.document.Team;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TeamService {

    Mono<Team> save(Team team);
    Flux<Team> findAll();
    Mono<Team> findByName(String name);
}
