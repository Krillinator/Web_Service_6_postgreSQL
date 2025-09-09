package com.krillinator.demo6.repository;

import com.krillinator.demo6.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    Optional<Todo> findTodoById(long id);

}
