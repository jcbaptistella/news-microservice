package com.syncnews.newsms.service.user.dto;

import com.syncnews.newsms.service.role.dto.RoleCreateDto;

public record UserCreateDto (String username, String name, String password, String phoneNumber, RoleCreateDto role) {
}
