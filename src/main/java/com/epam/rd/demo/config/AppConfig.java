package com.epam.rd.demo.config;

import com.epam.rd.demo.model.ListItem;
import com.epam.rd.demo.model.TodoList;
import com.epam.rd.demo.service.IListItemService;
import com.epam.rd.demo.service.ITodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class AppConfig {

    @Autowired
    private ITodoListService todoListService;
    @Autowired
    private IListItemService listItemService;

    @PostConstruct
    public void init() {
        todoListService.save(createList1());
        todoListService.save(createList2());
    }

    private TodoList createList1() {
        ListItem item1 = listItemService.createListItem("Simple message in list 1");
        TodoList list = new TodoList("First");
        list.addItem(item1);
        return list;
    }
    private TodoList createList2() {
        ListItem item1 = listItemService.createListItem("Simple message in list 2");
        ListItem item2 = listItemService.createListItem("Another message in list 2");
        ListItem item3 = listItemService.createListItem("Third item in list 2");
        TodoList list = new TodoList("Second");
        list.addItem(item1);
        list.addItem(item2);
        list.addItem(item3);
        return list;
    }

}
