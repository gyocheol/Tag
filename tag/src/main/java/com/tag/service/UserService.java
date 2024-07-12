package com.tag.service;

import com.tag.dto.LoginReqDto;
import com.tag.dto.SignUpReqDto;

public interface UserService {
    //    회원가입
    void signUp(SignUpReqDto dto);
    //    로그인
    void login(LoginReqDto dto);

}
