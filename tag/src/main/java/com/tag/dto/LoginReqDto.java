package com.tag.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginReqDto {
    private String username;
    private String password;

    @Builder
    public LoginReqDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
