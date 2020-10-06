package com.aboutcourse.common.error;

public class KnownException extends RuntimeException {

    public KnownException() {

    }

    public KnownException(String message) {
        super(message);
    }
}
