package com.example.tag.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * 사용자
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    private Long id;
    private String email;
    private String name;
    @Column(name = "phone_num")
    private String phoneNum;
    private int password;

    @Builder
    public User(Long id, String email, String name, String phoneNum, int password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phoneNum = phoneNum;
        this.password = password;
    }
}
