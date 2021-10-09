package com.example.purpledog.dto;

import com.example.purpledog.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCreateResponseDto {

    private Long id;
    private String email;

    public UserCreateResponseDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
    }
}
