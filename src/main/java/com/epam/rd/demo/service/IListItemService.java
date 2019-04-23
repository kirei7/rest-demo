package com.epam.rd.demo.service;

import com.epam.rd.demo.model.ListItem;

public interface IListItemService {
    ListItem createListItem(String body);
    ListItem findById(Long id);
}
