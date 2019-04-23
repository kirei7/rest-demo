package com.epam.rd.demo.repository;

import com.epam.rd.demo.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {
    TodoList findByName(String name);
}
