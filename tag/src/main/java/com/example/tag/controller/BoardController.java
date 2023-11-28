package com.example.tag.controller;

import com.example.tag.dto.BoardAllResDto;
import com.example.tag.dto.BoardReqDto;
import com.example.tag.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller     // jsp를 파싱할때는 @Controller, boot에서 html을 사용하려면 @RestController
@RequiredArgsConstructor
@Slf4j
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

    /**
     * 게시글 조회
     * @param model
     * @param pageable
     * @return
     */
    @GetMapping
    public String boardAllList(Model model, @PageableDefault(page = 0, size = 20) Pageable pageable) {
        Page<BoardAllResDto> boardList = boardService.getAllBoard(pageable);
        int nowPage = boardList.getPageable().getPageNumber() + 1;
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("boardList", boardList);
        return "board";
    }
}
