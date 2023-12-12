package com.example.tag.service.comment;

import com.example.tag.dto.CommentReqDto;

public interface CommentService {

    /**
     * 고객이 자신의 글에 댓글 달기
     * @param dto
     */
    void createComment(CommentReqDto dto);
}
