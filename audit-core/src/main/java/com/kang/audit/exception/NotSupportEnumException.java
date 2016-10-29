package com.kang.audit.exception;

/**
 * Created by feshfans on 2016/10/29.
 */
public class NotSupportEnumException extends RuntimeException {
    public NotSupportEnumException() {
    }

    public NotSupportEnumException(String message) {
        super(message);
    }

    public NotSupportEnumException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSupportEnumException(Throwable cause) {
        super(cause);
    }

    public NotSupportEnumException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
