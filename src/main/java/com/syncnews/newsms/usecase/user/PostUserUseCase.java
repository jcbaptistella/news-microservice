package com.syncnews.newsms.usecase.user;

import com.syncnews.newsms.controller.user.request.UserCreateRequest;
import com.syncnews.newsms.controller.user.response.UserResponse;
import com.syncnews.newsms.exception.EmailAlreadyException;
import com.syncnews.newsms.service.enums.Role;
import com.syncnews.newsms.service.role.RoleService;
import com.syncnews.newsms.service.role.dto.RoleDto;
import com.syncnews.newsms.service.user.UserService;
import com.syncnews.newsms.service.user.dto.UserCreateDto;
import com.syncnews.newsms.service.user.dto.UserDto;
import com.syncnews.newsms.usecase.user.mapper.PostUserUseCaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.ErrorResponseException;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class PostUserUseCase {

    private final UserService userService;
    private final RoleService roleService;
    private final PostUserUseCaseMapper mapper;

    public UserResponse execute(final UserCreateRequest request) {
        final UserDto userDto = userService.getUserByUsername(request.username());

        if (Objects.nonNull(userDto)) {
            throw new EmailAlreadyException();
        }

        final RoleDto roleDto = roleService.getRoleByName(Role.BASIC.name());

        final UserCreateDto userCreateDto = mapper.mappingUserCreateDtoBy(request, roleDto);

        return mapper.mappingUserResponseBy(userService.createUser(userCreateDto));
    }

}
