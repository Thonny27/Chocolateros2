package com.sport.chocolateros.app.repository;

import com.sport.chocolateros.app.document.Reserve;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ReserveRepository extends ReactiveMongoRepository<Reserve, String> {
    @Query(value = "{'customerSoccerFieldId':?0}")
    Flux<Reserve> findByUserId(String userId);
}
