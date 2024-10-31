package com.syncnews.newsms.usecase.user.mapper.helper;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostUserUseCaseMapperHelper {

    private final PasswordEncoder passwordEncoder;

    @Named("cryptPassword")
    public String cryptPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
