package com.example.purpledog.service;

import com.example.purpledog.domain.user.User;
import com.example.purpledog.domain.user.UserRepository;
import com.example.purpledog.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserCreateResponseDto createUser(UserCreateRequestDto requestDto){

        Boolean exists = userRepository.existsByEmail(requestDto.getEmail());

        if(exists){
            throw new IllegalArgumentException("already exists user email : " + requestDto.getEmail());
        }

        User user = User.builder()
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .build();

        userRepository.save(user);

        return new UserCreateResponseDto(user);
    }

    @Transactional
    public UserUpdateResponseDto updateUser(UserUpdateRequestDto requestDto){

        User user = userRepository.findByEmailAndPassword(requestDto.getEmail(),requestDto.getOldPassword())
                .orElseThrow(() -> new IllegalArgumentException("user not found email : " + requestDto.getEmail() + " password : " + requestDto.getOldPassword()));

        user.updatePassword(requestDto.getNewPassword());

        return new UserUpdateResponseDto(user);
    }

    @Transactional
    public UserDeleteResponseDto deleteUser(UserDeleteRequestDto requestDto){

        User user = userRepository.findByEmailAndPassword(requestDto.getEmail(),requestDto.getPassword())
                .orElseThrow(() -> new IllegalArgumentException("user not found email : " + requestDto.getEmail() + " password : " + requestDto.getPassword()));

        userRepository.delete(user);

        return new UserDeleteResponseDto(user);
    }

    @Transactional(readOnly = true)
    public UserGetResponseDto getUser(UserGetRequestDto requestDto){

        User user = userRepository.findByEmailAndPassword(requestDto.getEmail(),requestDto.getPassword())
                .orElseThrow(() -> new IllegalArgumentException("user not found email : " + requestDto.getEmail() + " password : " + requestDto.getPassword()));

        return new UserGetResponseDto(user);
    }

}
