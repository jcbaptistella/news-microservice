package com.syncnews.newsms.controller.token.response;

public record LoginResponse(String accessToken, Long expiresIn) {
}
