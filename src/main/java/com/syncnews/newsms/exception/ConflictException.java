package com.syncnews.newsms.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends HttpException {
    public ConflictException(ErrorMessages errorMessages, Throwable e) {
        super(errorMessages, HttpStatus.CONFLICT, e);
    }
}
