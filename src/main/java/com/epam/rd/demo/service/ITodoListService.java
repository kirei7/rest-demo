package com.epam.rd.demo.service;

import com.epam.rd.demo.model.TodoList;

import java.util.List;

public interface ITodoListService {
    TodoList createList(String name);
    void save(TodoList list);
    List<TodoList> getAll();
    TodoList findByName(String name);
}
