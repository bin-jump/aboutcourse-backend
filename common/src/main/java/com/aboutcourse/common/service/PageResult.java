package com.aboutcourse.common.service;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResult<T> {

    private long total;

    private int pageNumber;

    private int totalPage;

    private List<T> data;

    public boolean hasMore() {
        return pageNumber < totalPage - 1;
    }
}
