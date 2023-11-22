package com.example.tag.service.board;

import com.example.tag.dto.BoardUpdateReqDto;
import com.example.tag.dto.BoardReqDto;
import com.example.tag.dto.UserReqDto;

public interface BoardService {

    /**
     * 게시판 글쓰기 & 글쓴이 유저로 저장
     * @param dto
     */
    void createBoard(BoardReqDto dto);

    /**
     * 자신이 쓴 글만 삭제
     * @param dto
     */
    void deleteBoard(UserReqDto dto);

    /**
     * 자신이 쓴 글만 제목 및 내용 수정
     * @param userDto
     * @param updateDto
     */
    void updateBoard(UserReqDto userDto, BoardUpdateReqDto updateDto);
}
