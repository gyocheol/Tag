package com.example.tag.service.board;

import com.example.tag.dto.BoardReqDto;
import com.example.tag.dto.BoardUpdateReqDto;
import com.example.tag.dto.UserReqDto;
import com.example.tag.entity.Board;
import com.example.tag.entity.User;
import com.example.tag.repository.BoardRepository;
import com.example.tag.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@NoArgsConstructor
public class BoardServiceImpl implements BoardService{

    private BoardRepository boardRepository;
    private UserRepository userRepository;

    @Override
    public void createBoard(BoardReqDto dto) {
        User user = userRepository.findByEmailAndPhoneNum(dto.getEmail(), dto.getPhoneNum())
                .orElseThrow();


        Board board = Board.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }

    @Override
    public void deleteBoard(UserReqDto dto) {

    }

    @Override
    public void updateBoard(UserReqDto userDto, BoardUpdateReqDto updateDto) {

    }
}
