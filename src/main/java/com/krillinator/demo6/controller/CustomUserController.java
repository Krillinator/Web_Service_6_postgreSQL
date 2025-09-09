package com.krillinator.demo6.controller;

import com.krillinator.demo6.model.CustomUser;
import com.krillinator.demo6.repository.CustomUserRepository;
import com.krillinator.demo6.service.CustomUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
public class CustomUserController {

    private final CustomUserService customUserService;
    private final CustomUserRepository customUserRepository;

    @Autowired
    public CustomUserController(CustomUserService customUserService, CustomUserRepository customUserRepository) {
        this.customUserService = customUserService;
        this.customUserRepository = customUserRepository;
    }

    @GetMapping
    public ResponseEntity<List<CustomUser>> getAllUsersDebug() {

        return ResponseEntity.ok().body(customUserRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<CustomUser> createNewUser(@Valid @RequestBody CustomUser customUser) {

        return ResponseEntity.ok(customUserService.createNewUser(customUser));
    }



















}
