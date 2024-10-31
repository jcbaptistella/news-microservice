package com.syncnews.newsms.usecase.user.mapper;

import com.syncnews.newsms.controller.user.response.UserResponse;
import com.syncnews.newsms.service.user.dto.UserDto;
import com.syncnews.newsms.usecase.user.mapper.helper.PostUserUseCaseMapperHelper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetUserUseCaseMapper {
    UserResponse mappingUserResponseBy(final UserDto userDto);
}
