package com.sport.chocolateros.app.repository;

import com.sport.chocolateros.app.document.CustomerSoccerField;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CustomerSoccerFieldRepository extends ReactiveMongoRepository<CustomerSoccerField,String> {

    @Query(value = "{'soccerFieldName':?0, 'departament':?1,'soccerFields.typeField':?2 , 'soccerFields.maxNumberOfPlayers':?3 ,'soccerFields.price':?4 }")
    Flux<CustomerSoccerField> findByFilters(String name,String departament,String type,Integer maxPlayers,Float price);
}
