package com.syncnews.newsms.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.syncnews.newsms.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GeneralExceptionHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<DefaultExceptionBody> handleBaseException(BaseException e) {
        log.error(e.getErrorMessage(), e);
        DefaultExceptionBody defaultExceptionBody = new DefaultExceptionBody();
        defaultExceptionBody.setCode(e.getCode());
        defaultExceptionBody.setMessage(e.getErrorMessage());
        defaultExceptionBody.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(defaultExceptionBody, e.getHttpStatus());
    }
}
