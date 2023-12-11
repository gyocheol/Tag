package com.example.tag.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 게시판 작성시 받아야 할 데이터
 * 문자열 정규식 어노테이션 달아야 함!
 */
@Getter
@NoArgsConstructor
public class BoardReqDto {

    @NotBlank
    private String name;
    @NotBlank
    @Size(min = 11, max = 11, message = "최대 11자리까지 입력하세요")
    @Pattern(regexp = "^[0-9]{11}$", message = "숫자만 11자리 써주세요")
    private String phoneNum;
    
    @Size(min = 4, max = 4)
    private String password;        // 비밀번호가 없다면 모두가 조회 가능
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
