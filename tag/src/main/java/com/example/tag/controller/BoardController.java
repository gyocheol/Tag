package com.example.tag.controller;

import com.example.tag.dto.BoardReqDto;
import com.example.tag.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller     // jsp를 파싱할때는 @Controller, boot에서 html을 사용하려면 @RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    /**
     * 게시글 생성 및 유저 생성 or 유저 글 저장
     * @param dto
     * @return
     */
    @PostMapping
    public ResponseEntity<HttpStatus> createBoard(@Valid @RequestBody BoardReqDto dto) {
        boardService.createBoard(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
