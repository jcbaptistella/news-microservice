package com.syncnews.newsms.controller.token;

import com.syncnews.newsms.controller.token.request.LoginRequest;
import com.syncnews.newsms.controller.token.response.LoginResponse;
import com.syncnews.newsms.usecase.token.GetTokenUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth")
public class TokenController {

    private final GetTokenUseCase getTokenUseCase;

    @PostMapping("/token")
    @CrossOrigin(origins = "https://news-b8d1c.web.app/")
    public ResponseEntity<LoginResponse> getToken(@RequestBody LoginRequest loginRequest) {
        final LoginResponse response = getTokenUseCase.execute(loginRequest);
        return ResponseEntity.ok(response);
    }
}
