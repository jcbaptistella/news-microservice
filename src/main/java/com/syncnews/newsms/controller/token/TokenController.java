package com.syncnews.newsms.controller.token;

import com.syncnews.newsms.controller.token.request.LoginRequest;
import com.syncnews.newsms.controller.token.response.LoginResponse;
import com.syncnews.newsms.usecase.token.GetTokenUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth")
public class TokenController {

    private final GetTokenUseCase getTokenUseCase;

    @PostMapping("/token")
    public ResponseEntity<LoginResponse> getToken(@RequestBody LoginRequest loginRequest) {
        final LoginResponse response = getTokenUseCase.execute(loginRequest);
        return ResponseEntity.ok(response);
    }
}
