package com.syncnews.newsms.controller.user;

import com.syncnews.newsms.controller.user.request.UserCreateRequest;
import com.syncnews.newsms.controller.user.response.UserResponse;
import com.syncnews.newsms.usecase.user.GetUserUseCase;
import com.syncnews.newsms.usecase.user.PostUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final PostUserUseCase postUserUseCase;
    private final GetUserUseCase getUserUseCase;

    @Transactional
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserCreateRequest request) {
        final UserResponse response = postUserUseCase.execute(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserResponse> findByUsername(@PathVariable("username") String username) {
        final UserResponse response = getUserUseCase.execute(username);
        return ResponseEntity.ok(response);
    }
}
