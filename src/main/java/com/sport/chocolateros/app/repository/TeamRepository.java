package com.sport.chocolateros.app.repository;

import com.sport.chocolateros.app.document.Team;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface TeamRepository extends ReactiveMongoRepository<Team,String> {

    Mono<Team> findByNameTeam(String name);
}
