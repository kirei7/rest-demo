package com.epam.rd.demo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@EqualsAndHashCode(of = "body")
@NoArgsConstructor
@RequiredArgsConstructor
public class ListItem {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String body;
    private Long createdTimestamp;
}
