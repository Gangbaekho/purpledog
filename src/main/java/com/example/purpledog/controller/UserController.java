package com.example.purpledog.controller;

import com.example.purpledog.dto.*;
import com.example.purpledog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public UserCreateResponseDto createUser(UserCreateRequestDto requestDto){

        return userService.createUser(requestDto);
    }

    // email과 password를 통해 user의 정보를 가져옵니다.
    // getMapping을 사용하게 되면 password가 노출되기 때문에 PostMapping으로 대체하여습니다.
    @PostMapping("/info")
    public UserGetResponseDto getUser(UserGetRequestDto requestDto){

        return userService.getUser(requestDto);
    }

    @PutMapping("")
    public UserUpdateResponseDto updateUser(UserUpdateRequestDto requestDto){

        return userService.updateUser(requestDto);
    }

    @DeleteMapping("")
    public UserDeleteResponseDto deleteUser(UserDeleteRequestDto requestDto){

        return userService.deleteUser(requestDto);
    }

}
