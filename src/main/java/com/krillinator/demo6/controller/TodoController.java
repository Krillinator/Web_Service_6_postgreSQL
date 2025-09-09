package com.krillinator.demo6.controller;

import com.krillinator.demo6.model.Todo;
import com.krillinator.demo6.model.response.TodoResponse;
import com.krillinator.demo6.service.TodoService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/todo")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/create")
    public ResponseEntity<TodoResponse> test(
            @RequestParam("userId") long userId,
            @RequestBody Todo newTodo
    ) {

        TodoResponse todoResponse = new TodoResponse(newTodo, "");

        try {
            ResponseEntity.ok(todoService.createNewTodo(userId,newTodo));

            return ResponseEntity.status(201).body(todoResponse);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.badRequest().body(todoResponse);
        }


    }

}
