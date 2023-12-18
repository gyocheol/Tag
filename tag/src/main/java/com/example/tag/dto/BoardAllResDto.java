package com.example.tag.dto;


import com.example.tag.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
public class BoardAllResDto {
    Long id;
    String title;
    String name;
    String createdDate;

    public BoardAllResDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.name = board.getUser().getName();
        this.createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(board.getCreatedDate());
    }
}
