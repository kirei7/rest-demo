package com.epam.rd.demo.rest;

import com.epam.rd.demo.model.ListItem;
import com.epam.rd.demo.model.TodoList;
import com.epam.rd.demo.service.IListItemService;
import com.epam.rd.demo.service.ITodoListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class TodoListResource {

    private ITodoListService todoListService;
    private IListItemService listItemService;

    @GetMapping("lists")
    public List<TodoList> getAllLists() {
        return todoListService.getAll();
    }

    @GetMapping("lists/{name}")
    public TodoList getList(@PathVariable String name) {
        return todoListService.findByName(name);
    }

    @GetMapping("lists/")
    public TodoList getListAnother(@RequestParam String name) {
        return todoListService.findByName(name);
    }

    @GetMapping("lists/{name}/items")
    public List<ListItem> getAllItems(@PathVariable String name) {
        return todoListService.findByName(name)
                .getListItems();
    }
    @GetMapping("lists/{name}/items/{id}")
    public ListItem getItemById(@PathVariable String name,
                                @PathVariable Long id) {
        //don't do this
        return todoListService.findByName(name)
                .getListItems()
                .stream()
                .filter(item -> item.getId().equals(id))
                .findFirst().get();
    }

    @PostMapping(value = "lists/{name}/items")
    public TodoList addItem(@PathVariable String name,
                            @RequestBody ListItem listItem) {
        TodoList list = todoListService.findByName(name);
        list.addItem(listItem);
        todoListService.save(list);
        return list;
    }
}
