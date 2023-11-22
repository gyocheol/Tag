package com.example.tag.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    private String email;
    private String name;
    @Column(name = "phone_num")
    private String phoneNum;
    private String password;
    private String written;

    @Builder
    public User(Long id, String email, String name, String phoneNum, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phoneNum = phoneNum;
        this.password = password;
    }

    public void encodeStudentPassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(password);
    }
}
