package com.sport.chocolateros.app.service.imp;

import com.sport.chocolateros.app.document.Team;
import com.sport.chocolateros.app.repository.TeamRepository;
import com.sport.chocolateros.app.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TeamServiceImp implements TeamService {

    @Autowired
    private TeamRepository repository;

    @Override
    public Mono<Team> save(Team team) {
        return repository.save(team);
    }

    @Override
    public Flux<Team> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Team> findByName(String name) {
        return repository.findByNameTeam(name);
    }
}
