package com.aboutcourse.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse<T> {

    private String message;
    @Builder.Default
    private ResultCode code = ResultCode.SUCCESS;

    private T data;

    public BaseResponse(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return code == ResultCode.SUCCESS;
    }
}
