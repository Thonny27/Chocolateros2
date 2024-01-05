package com.sport.chocolateros.app.service.imp;

import com.sport.chocolateros.app.document.CustomerSoccerField;
import com.sport.chocolateros.app.dto.Filters;
import com.sport.chocolateros.app.repository.CustomerSoccerFieldRepository;
import com.sport.chocolateros.app.service.CustomerSoccerFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerSoccerFieldServiceImp implements CustomerSoccerFieldService {

    @Autowired
    private CustomerSoccerFieldRepository repository;

    @Override
    public Mono<CustomerSoccerField> save(CustomerSoccerField customerSoccerField) {
        return repository.save(customerSoccerField);
    }

    @Override
    public Flux<CustomerSoccerField> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<CustomerSoccerField> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Flux<CustomerSoccerField> findByFilters(Filters filters) {
        return repository.findByFilters(filters.getName(), filters.getDepartament(), filters.getType(), filters.getMaxPlayers(), filters.getPrice());
    }
}
