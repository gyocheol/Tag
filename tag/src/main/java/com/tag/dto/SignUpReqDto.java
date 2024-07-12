package com.tag.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignUpReqDto {
    private String username;
    private String password;

    @Builder
    public SignUpReqDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

