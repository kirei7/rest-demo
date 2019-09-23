package com.epam.rd.demo.service;

import com.epam.rd.demo.model.TodoList;
import com.epam.rd.demo.repository.TodoListRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@AllArgsConstructor
public class TodoListService implements ITodoListService, InitializingBean {

    private TodoListRepository todoListRepository;

    @PostConstruct
    public void postConstruct() {
        System.out.println("PostConstruct called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet called");
    }

    public void init() {
        System.out.println("init called");
    }

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
