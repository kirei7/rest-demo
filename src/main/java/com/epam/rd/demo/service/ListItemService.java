package com.epam.rd.demo.service;

import com.epam.rd.demo.model.ListItem;
import com.epam.rd.demo.repository.ListItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListItemService implements IListItemService{

    private ListItemRepository listItemRepository;

    @Override
    public ListItem createListItem(String body) {
        ListItem item = new ListItem(body);
        item.setCreatedTimestamp(System.currentTimeMillis());
        return item;
    }

    @Override
    public ListItem findById(Long id) {
        return listItemRepository.findById(id).get();
    }

}
