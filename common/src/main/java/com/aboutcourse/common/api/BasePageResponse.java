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
public class BasePageResponse<T> {

    private String message;

    private HttpStatus code = HttpStatus.OK;

    private T data;

    private boolean hasMore;

    private int pageNumber;

    public BasePageResponse(T data, boolean more, int pageNumber) {
        this.data = data;
        hasMore = more;
        this.pageNumber = pageNumber;
    }

    public boolean isSuccess() {
        return code == HttpStatus.OK;
    }
}
