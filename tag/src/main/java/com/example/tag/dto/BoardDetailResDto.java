package com.example.tag.dto;

import com.example.tag.entity.Board;
import com.example.tag.entity.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@NoArgsConstructor
public class BoardDetailResDto {
    private String name;
    private String title;
    private String content;
    private String createDate;
    private List<Comment> comments;

    @Builder
    public BoardDetailResDto(String name, String title, String content, LocalDateTime createDate, List<Comment> comments) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.createDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(createDate);
        this.comments = comments;
    }
}
