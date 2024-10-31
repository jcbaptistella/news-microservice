package com.syncnews.newsms.service.enums;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN(1L),
    BASIC(2L);

    private final Long id;

    Role(Long id) {
        this.id = id;
    }
}
