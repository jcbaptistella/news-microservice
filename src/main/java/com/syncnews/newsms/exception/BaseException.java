package com.syncnews.newsms.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {

    public BaseException(String message, Throwable e) {super(message, e);}

    public abstract String getCode();
    public abstract HttpStatus getHttpStatus();
    public abstract String getErrorMessage();

}
