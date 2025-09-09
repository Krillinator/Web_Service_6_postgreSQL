package com.krillinator.demo6.service;

import com.krillinator.demo6.model.CustomUser;
import com.krillinator.demo6.model.Todo;
import com.krillinator.demo6.repository.CustomUserRepository;
import com.krillinator.demo6.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private static final Logger log = LoggerFactory.getLogger(TodoService.class);
    private final CustomUserRepository customUserRepository;
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(CustomUserRepository customUserRepository, TodoRepository todoRepository) {
        this.customUserRepository = customUserRepository;
        this.todoRepository = todoRepository;
    }

    // Two queries must be done, as we don't have User Management (Spring Security)
    // This creates a huge security vulnerability, but is done simply for demonstration purposes
    public Todo createNewTodo(long owningUserId, Todo newTodo) {

        // Check if user exists
        CustomUser customUser = customUserRepository.findById(owningUserId).orElseThrow(
                () -> new IllegalArgumentException("User wasn't found")
        );

        // Check for null values
        if (
                newTodo.getTag() == null ||
                newTodo.getDescription() == null ||
                newTodo.getTitle() == null
        ) {
            throw new IllegalArgumentException();
        }

        // Create relationship
        newTodo.setUser(customUser);

        // Logging
        log.info("Creating new Todo with Title: {}", newTodo.getTitle());

        // Save
        return todoRepository.save(newTodo);
    }

}
