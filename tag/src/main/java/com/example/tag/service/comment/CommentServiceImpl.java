package com.example.tag.service.comment;

import com.example.tag.code.Role;
import com.example.tag.dto.CommentReqDto;
import com.example.tag.entity.Board;
import com.example.tag.entity.Comment;
import com.example.tag.repository.BoardRepository;
import com.example.tag.repository.CommentRepository;
import com.example.tag.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final BoardService boardService;

    @Override
    public void createComment(CommentReqDto dto) {
        Board board = boardService.validationBoard(dto.getBoardId());
        Comment comment = Comment.builder()
                .board(board)
                .content(dto.getContent())
                .role(Role.USER)
                .createdAt(LocalDateTime.now())
                .build();
        commentRepository.save(comment);
    }
}
