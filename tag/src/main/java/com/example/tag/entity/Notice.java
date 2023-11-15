package com.example.tag.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 공지사항
 * 관리자만 작성 가능 - MongoDB
 */
@Getter
@NoArgsConstructor
public class Notice {
    private String title;
    private String content;
}
