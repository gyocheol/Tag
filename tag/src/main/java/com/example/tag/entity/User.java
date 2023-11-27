package com.example.tag.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 사용자
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "phone_num")
    private String phoneNum;
    private String written;

    @Builder
    public User(Long id, String email, String name, String phoneNum, String password, String written) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.written = written;
    }
}
