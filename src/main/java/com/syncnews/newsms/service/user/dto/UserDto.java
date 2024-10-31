package com.syncnews.newsms.service.user.dto;

import com.syncnews.newsms.service.role.dto.RoleDto;

import java.util.List;

public record UserDto(String publicId, String username, String name, String password, String phoneNumber, List<RoleDto> roles) {
}
