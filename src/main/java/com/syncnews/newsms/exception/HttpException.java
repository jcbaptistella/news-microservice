package com.syncnews.newsms.exception;

import org.springframework.http.HttpStatus;

public class HttpException extends BaseException {

    private ErrorMessages errorMessages;
    private HttpStatus httpStatus;

    public HttpException(ErrorMessages errorMessages, HttpStatus httpStatus, Throwable e) {
        super(errorMessages.getMessage(), e);
        this.errorMessages = errorMessages;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getCode() {
        return errorMessages.getCode();
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getErrorMessage() {
        return errorMessages.getMessage();
    }
}
