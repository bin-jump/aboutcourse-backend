package com.aboutcourse.common.error;

import com.aboutcourse.common.api.BaseResponse;
import com.aboutcourse.common.api.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionTranslator {

    @ExceptionHandler(ResourceNotFoundException.class)
    public BaseResponse handleError(ResourceNotFoundException e) {
        log.error("404 Not Found", e);
        return BaseResponse
                .builder()
                .code(ResultCode.NOT_FOUND)
                .message(e.getMessage())
                .build();
    }
}
