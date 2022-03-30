package com.bluecloud.vnet.sdk.java.common.exception;

/**
 * @author hexinyu
 * @version 1.0
 * @description
 * @date 2021/08/13
 * @see
 */
public class ValidationErrorException extends RuntimeException{

    public ValidationErrorException() {
    }

    public ValidationErrorException(String message) {
        super(message);
    }

    public ValidationErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationErrorException(Throwable cause) {
        super(cause);
    }

    public ValidationErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
