package com.example.tag.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 게시판
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board {
    @Id
    private Long id;
    private String title;
    private String content;
}
