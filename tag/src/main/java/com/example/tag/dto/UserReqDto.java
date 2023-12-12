package com.example.tag.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserReqDto {
    @NotBlank
    private String phoneNum;

    @NotBlank
    private String password;
}
