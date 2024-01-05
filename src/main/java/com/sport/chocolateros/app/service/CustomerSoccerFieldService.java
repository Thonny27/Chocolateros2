package com.sport.chocolateros.app.service;

import com.sport.chocolateros.app.document.CustomerSoccerField;
import com.sport.chocolateros.app.dto.Filters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerSoccerFieldService {

    Mono<CustomerSoccerField> save(CustomerSoccerField customerSoccerField);

    Flux<CustomerSoccerField> findAll();

    Mono<CustomerSoccerField> findById(String id);

    Flux<CustomerSoccerField> findByFilters(Filters filters);
}
