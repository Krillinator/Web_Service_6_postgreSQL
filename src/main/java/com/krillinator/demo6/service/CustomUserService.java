package com.krillinator.demo6.service;

import com.krillinator.demo6.model.CustomUser;
import com.krillinator.demo6.repository.CustomUserRepository;
import com.krillinator.demo6.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService {

    private static final Logger log = LoggerFactory.getLogger(CustomUserService.class);
    private final CustomUserRepository customUserRepository;
    private final TodoRepository todoRepository;

    @Autowired
    public CustomUserService(CustomUserRepository customUserRepository, TodoRepository todoRepository) {
        this.customUserRepository = customUserRepository;
        this.todoRepository = todoRepository;
    }

    public CustomUser createNewUser(CustomUser customUser) {
        log.info("Creating new User with username: {}", customUser.getUsername());

        return customUserRepository.save(customUser);
    }
    

}
