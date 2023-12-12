package com.example.tag.controller;

import com.example.tag.dto.CommentReqDto;
import com.example.tag.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentService;

    /**
     * 고객이 자신의 글에 댓글 달기
     * @param dto
     * @return
     */
    @PostMapping
    public ResponseEntity<HttpStatus> createComment(@RequestBody CommentReqDto dto) {
        commentService.createComment(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
