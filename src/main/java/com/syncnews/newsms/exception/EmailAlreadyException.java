package com.syncnews.newsms.exception;

public class EmailAlreadyException extends ConflictException {
    public EmailAlreadyException() {
        super(ErrorMessages.EMAIL_ALREADY_EXISTS, null);
    }
}
