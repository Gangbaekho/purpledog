package com.example.purpledog.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String email;
    private String password;

    @Builder
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void updatePassword(String password){
        this.password = password;
    }
}
