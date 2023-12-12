package com.example.tag.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 게시판
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @Column(nullable = false)
    private String title;
    @Column(length = 1023, nullable = false)
    private String content;
    private String password;
    @CreatedDate
    @Column(name = "create_date")
    private LocalDateTime createdDate;


    @Builder
    public Board(Long id, String title, String content,String password, LocalDateTime createdDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.password = password;
        this.createdDate = createdDate;
    }

    /**
     * 게시판 수정
     * @param title
     * @param content
     */
    public void updateBoard(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
