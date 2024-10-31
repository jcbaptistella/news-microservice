package com.syncnews.newsms.utils;

import com.syncnews.newsms.service.role.dto.RoleDto;
import com.syncnews.newsms.service.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TokenUtils {

    private final JwtEncoder jwtEncoder;


    public String getTokenValue(JwtClaimsSet claims) {
        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public static JwtClaimsSet getClaims(UserDto userDto, long expiresIn, String scopes) {
        var now = Instant.now();

        return JwtClaimsSet.builder()
                .issuer("news-microservice")
                .subject(userDto.publicId())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .claim("scope", scopes)
                .build();
    }

    public static String getScopes(UserDto userDto) {
        return userDto.roles()
                .stream()
                .map(RoleDto::name)
                .collect(Collectors.joining(" "));
    }
}
