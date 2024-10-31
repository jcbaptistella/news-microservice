package com.syncnews.newsms.exception;

public class LoginOrPasswordInvalidException extends ConflictException {
    public LoginOrPasswordInvalidException() {
      super(ErrorMessages.LOGIN_OR_PASSWORD_INVALID, null);
    }
}
