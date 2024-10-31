package com.syncnews.newsms.usecase.token;

import com.syncnews.newsms.controller.token.request.LoginRequest;
import com.syncnews.newsms.controller.token.response.LoginResponse;
import com.syncnews.newsms.exception.LoginOrPasswordInvalidException;
import com.syncnews.newsms.service.user.UserService;
import com.syncnews.newsms.service.user.dto.UserDto;
import com.syncnews.newsms.usecase.token.mapper.GetTokenUseCaseMapper;
import com.syncnews.newsms.utils.TokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.syncnews.newsms.utils.TokenUtils.getClaims;
import static com.syncnews.newsms.utils.TokenUtils.getScopes;

@Component
@RequiredArgsConstructor
public class GetTokenUseCase {

    public static final long EXPIRES_IN = 864000L;
    private final GetTokenUseCaseMapper mapper;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final TokenUtils tokenUtils;

    public LoginResponse execute(LoginRequest request) {
         final UserDto userDto = userService.getUserByUsername(request.username());

        if (Objects.isNull(userDto) || !isLoginCorrect(request.password(), userDto.password())) {
            throw new LoginOrPasswordInvalidException();
        }

        var jwtValue = handleJwtValue(userDto);

        return mapper.mappingLoginResponseBy(jwtValue, EXPIRES_IN);
    }

    private String handleJwtValue(UserDto userDto) {
        var scopes = getScopes(userDto);

        var claims = getClaims(userDto, EXPIRES_IN, scopes);

        return  tokenUtils.getTokenValue(claims);
    }

    public boolean isLoginCorrect(final String passwordRequest, final String passwordDataBase) {
        return passwordEncoder.matches(passwordRequest, passwordDataBase);
    }

}
