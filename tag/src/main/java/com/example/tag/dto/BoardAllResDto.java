package com.example.tag.dto;


import com.example.tag.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardAllResDto {
    Long id;
    String title;
    String name;
    LocalDateTime createDate;
    Long commentCnt;

    public BoardAllResDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.name = board.getUser().getName();
        this.createDate = board.getCreatedDate();
        this.commentCnt = board.getComment().stream().count();
    }
}
