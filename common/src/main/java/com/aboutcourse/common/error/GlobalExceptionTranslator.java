package com.aboutcourse.common.error;

import com.aboutcourse.common.api.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionTranslator {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BaseResponse handleError(ResourceNotFoundException e) {
        log.error("404 Not Found", e);
        return BaseResponse
                .builder()
                .code(HttpStatus.NOT_FOUND)
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(InvalidValueException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public BaseResponse handleError(InvalidValueException e) {
        log.error("422 value not valid", e);
        return BaseResponse
                .builder()
                .code(HttpStatus.UNPROCESSABLE_ENTITY)
                .message(e.getMessage())
                .build();
    }
}
