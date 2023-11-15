package com.example.tag.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class BoardUser {
    @Id
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Board board;
    private String written;
}
