package com.example.tag.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateReqTwoDto {
    private UserReqDto userDto;
    private BoardUpdateReqDto updateDto;
}
