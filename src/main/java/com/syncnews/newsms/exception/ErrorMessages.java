package com.syncnews.newsms.exception;

public enum ErrorMessages {
    EMAIL_ALREADY_EXISTS("EMAIL_ALREADY_EXISTS", "User already registered"),
    LOGIN_OR_PASSWORD_INVALID("LOGIN_OR_PASSWORD_INVALID", "User or password is invalid");
    ;

    private String code;
    private String message;

    ErrorMessages(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
