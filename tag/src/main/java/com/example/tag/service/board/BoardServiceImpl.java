package com.example.tag.service.board;

import com.example.tag.dto.BoardAllResDto;
import com.example.tag.dto.BoardDetailResDto;
import com.example.tag.dto.BoardReqDto;
import com.example.tag.dto.BoardUpdateReqDto;
import com.example.tag.dto.UserReqDto;
import com.example.tag.entity.Board;
import com.example.tag.entity.User;
import com.example.tag.repository.BoardRepository;
import com.example.tag.repository.CommentRepository;
import com.example.tag.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Transactional
    @Override
    public void createBoard(BoardReqDto dto) {
        Optional<User> user = userRepository.findByPhoneNum(dto.getPhoneNum());
        // 게시판 작성
        Board board = Board.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .password(dto.getPassword())
                .createdDate(LocalDateTime.now())
                .build();
        // 유저가 없다면 유저 생성
        if (user.isEmpty()) {
            User newUser = User.builder()
                    .name(dto.getName())
                    .phoneNum(dto.getPhoneNum())
                    .build();
            userRepository.save(newUser);
            board.setUser(newUser);
            log.info("[새로운 유저가 글 작성]");
        }
        // 게시판 저장
        boardRepository.save(board);
        log.info("[게시판에 글 작성 완료]");
    }

    @Transactional
    @Override
    public void deleteBoard(UserReqDto dto, Long boardId) {
        Board board = validationBoard(boardId);
        validationUser(dto.getPhoneNum(), dto.getPassword(), board);
        // 댓글 모두 삭제
        commentRepository.deleteAllByBoardId(boardId);
        // 게시글 삭제
        boardRepository.delete(board);
    }

    @Override
    public void updateBoard(UserReqDto userDto, BoardUpdateReqDto updateDto, Long boardId) {
        Board board = validationBoard(boardId);
        validationUser(userDto.getPhoneNum(), userDto.getPassword(), board);
        board.updateBoard(updateDto.getTitle(), updateDto.getContent());
        boardRepository.save(board);
    }

    @Override
    public Page<BoardAllResDto> getAllBoard(Pageable pageable) {
        Page<Board> board = boardRepository.findAllByOrderByCreatedDateDesc(pageable);
        return new PageImpl<>(
                board.stream().map(BoardAllResDto::new).collect(Collectors.toList()),
                pageable,
                board.getTotalPages());
    }

    @Override
    public BoardDetailResDto getDetailBoard(Long boardId, UserReqDto dto) {
        Board board = validationBoard(boardId);
        validationUser(dto.getPhoneNum(), dto.getPassword(), board);
        return BoardDetailResDto.builder()
                .name(board.getUser().getName())
                .title(board.getTitle())
                .content(board.getContent())
                .createDate(board.getCreatedDate())
                .comments(commentRepository.findByBoardId(boardId))
                .build();
    }

    /**
     * Board 유효성 검사
     * @param boardId
     * @return Board
     */
    public Board validationBoard(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalStateException("게시판이 없습니다."));
    }

    /**
     * 휴대폰 번호와 비밀번호의 유효성 검사
     * @param phoneNum
     * @param password
     * @param board
     */
    private void validationUser(String phoneNum, String password, Board board) {
        if (!phoneNum.equals(board.getUser().getPhoneNum())) {
            throw new IllegalStateException("휴대폰 번호가 다릅니다.");
        }
        if (!password.equals(board.getPassword())) {
            throw new IllegalStateException("비밀번호가 다릅니다.");
        }
    }
}
