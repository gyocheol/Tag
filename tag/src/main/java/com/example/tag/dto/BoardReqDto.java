package com.example.tag.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardReqDto {

    private String email;
    private String name;
    private String phoneNum;
    private String password;
    private String title;
    private String content;
}
