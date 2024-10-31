package com.syncnews.newsms.usecase.user.mapper;

import com.syncnews.newsms.controller.user.request.UserCreateRequest;
import com.syncnews.newsms.controller.user.response.UserResponse;
import com.syncnews.newsms.service.role.dto.RoleDto;
import com.syncnews.newsms.service.user.dto.UserCreateDto;
import com.syncnews.newsms.service.user.dto.UserDto;
import com.syncnews.newsms.usecase.user.mapper.helper.PostUserUseCaseMapperHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PostUserUseCaseMapperHelper.class})
public interface PostUserUseCaseMapper {

    @Mapping(target = "password", source = "request.password", qualifiedByName = "cryptPassword")
    @Mapping(target = "name", source = "request.name")
    UserCreateDto mappingUserCreateDtoBy(final UserCreateRequest request, final RoleDto role);

    UserResponse mappingUserResponseBy(final UserDto userDto);
}
