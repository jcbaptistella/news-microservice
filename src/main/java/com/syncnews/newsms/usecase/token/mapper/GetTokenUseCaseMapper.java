package com.syncnews.newsms.usecase.token.mapper;

import com.syncnews.newsms.controller.token.response.LoginResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GetTokenUseCaseMapper {

    @Mapping(target = "accessToken", source = "jwtValue")
    LoginResponse mappingLoginResponseBy(final String jwtValue, final long expiresIn);
}
