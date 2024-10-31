package com.syncnews.newsms.service.user.mapper;

import com.syncnews.newsms.entity.UserEntity;
import com.syncnews.newsms.service.user.dto.UserCreateDto;
import com.syncnews.newsms.service.user.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto mappingUserDtoBy(final UserEntity userEntity);

    UserEntity mappingUserEntityBy(final UserCreateDto userCreateDto);
}
