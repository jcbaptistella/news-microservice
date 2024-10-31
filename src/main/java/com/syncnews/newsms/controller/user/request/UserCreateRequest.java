package com.syncnews.newsms.controller.user.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserCreateRequest(@NotBlank @NotNull String username,
                                @NotBlank @NotNull String name,
                                @NotBlank @NotNull String password,
                                @NotBlank @NotNull String phoneNumber) {
}
