package com.syncnews.newsms.usecase.user;

import com.syncnews.newsms.controller.user.response.UserResponse;
import com.syncnews.newsms.service.user.UserService;
import com.syncnews.newsms.service.user.dto.UserDto;
import com.syncnews.newsms.usecase.user.mapper.GetUserUseCaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetUserUseCase {

    private final UserService userService;
    private final GetUserUseCaseMapper mapper;

    public UserResponse execute(String username) {
        UserDto userDto = userService.getUserByUsername(username);
        return mapper.mappingUserResponseBy(userDto);
    }
}
