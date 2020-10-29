package com.aboutcourse.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse<T> {

    private String message;

    private HttpStatus code = HttpStatus.OK;

    private T data;

    public BaseResponse(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return code == HttpStatus.OK;
    }
}
