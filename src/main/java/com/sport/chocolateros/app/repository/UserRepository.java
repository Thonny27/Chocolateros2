package com.sport.chocolateros.app.repository;

import com.sport.chocolateros.app.document.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User,String> {
}
