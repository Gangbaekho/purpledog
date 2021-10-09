package com.example.purpledog.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCreateRequestDto {

    private String email;
    private String password;

    @Builder
    public UserCreateRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
