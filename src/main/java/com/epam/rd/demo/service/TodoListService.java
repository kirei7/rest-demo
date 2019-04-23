package com.epam.rd.demo.service;

import com.epam.rd.demo.model.TodoList;
import com.epam.rd.demo.repository.TodoListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoListService implements ITodoListService {

    private TodoListRepository todoListRepository;

    @Override
    public TodoList createList(String name) {
        return new TodoList(name);
    }

    @Override
    public void save(TodoList list) {
        todoListRepository.save(list);
    }

    @Override
    public List<TodoList> getAll() {
        return todoListRepository.findAll();
    }

    @Override
    public TodoList findByName(String name) {
        return todoListRepository.findByName(name);
    }

}
