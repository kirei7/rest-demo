package com.epam.rd.demo.repository;

import com.epam.rd.demo.model.ListItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListItemRepository extends JpaRepository<ListItem, Long> {
}
