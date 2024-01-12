package com.sport.chocolateros.app.service.imp;

import com.sport.chocolateros.app.document.User;
import com.sport.chocolateros.app.dto.Login;
import com.sport.chocolateros.app.dto.UserLogin;
import com.sport.chocolateros.app.repository.UserRepository;
import com.sport.chocolateros.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Flux<User> findall() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Mono<User> login(UserLogin userLogin) {
        return userRepository.findAllByEmailAndPassword(userLogin.getEmail(),userLogin.getPassword());
    }

}
