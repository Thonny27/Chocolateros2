package com.sport.chocolateros.app.repository;

import com.sport.chocolateros.app.document.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User,String> {

    Mono<User> findAllByEmailAndPassword(String email, String password);

}
