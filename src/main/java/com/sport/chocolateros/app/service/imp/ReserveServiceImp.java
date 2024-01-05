package com.sport.chocolateros.app.service.imp;

import com.sport.chocolateros.app.document.Reserve;
import com.sport.chocolateros.app.repository.ReserveRepository;
import com.sport.chocolateros.app.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReserveServiceImp implements ReserveService {

    @Autowired
    private ReserveRepository repository;

    @Override
    public Flux<Reserve> findAll() {
        return repository.findAll();
    }

    @Override
    public Flux<Reserve> findByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public Mono<Reserve> save(Reserve reserve) {
        return repository.save(reserve);
    }
}
