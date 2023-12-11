package com.example.tag.service.board;

import com.example.tag.dto.BoardAllResDto;
import com.example.tag.dto.BoardReqDto;
import com.example.tag.dto.BoardUpdateReqDto;
import com.example.tag.dto.UserReqDto;
import com.example.tag.entity.Board;
import com.example.tag.entity.User;
import com.example.tag.repository.BoardRepository;
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
        // board 의 id가 필요하기 때문에 먼저 한번 저장 이 코드 때문에 느려지면 삭제 예정
        boardRepository.save(board);
        // 유저가 있다면 작성 글 id 업데이트
        if (user.isPresent()) {
            user.get().setWritten(user.get().getWritten() + "," + board.getId().toString());
            board.setUser(user.get());
        }
        // 유저가 없다면 저장
        else {
            User newUser = User.builder()
                    .name(dto.getName())
                    .phoneNum(dto.getPhoneNum())
                    .written(board.getId().toString())
                    .build();
            userRepository.save(newUser);
            board.setUser(newUser);
            log.info("[새로운 유저가 글 작성]");
        }
        // 게시판 저장
        boardRepository.save(board);
        log.info("[게시판에 글 작성 완료]");
    }

    @Override
    public void deleteBoard(UserReqDto dto, Long boardId) {
        Board board = validationBoard(boardId);
        validationUser(dto.getPhoneNum(), dto.getPassword(), board);

        boardRepository.delete(board);

    }

    @Override
    public void updateBoard(UserReqDto userDto, BoardUpdateReqDto updateDto, Long boardId) {
        Board board = validationBoard(boardId);
        validationUser(userDto.getPhoneNum(), userDto.getPassword(), board);
        board.updateBoard(updateDto.getTitle(), updateDto.getContent());
    }

    @Override
    public Page<BoardAllResDto> getAllBoard(Pageable pageable) {
        Page<Board> board = boardRepository.findAllByOrderByCreatedDateDesc(pageable);
        return new PageImpl<>(
                board.stream().map(BoardAllResDto::new).collect(Collectors.toList()),
                pageable,
                board.getTotalPages());
    }

    /**
     * Board 유효성 검사
     * @param boardId
     * @return Board
     */
    private Board validationBoard(Long boardId) {
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
