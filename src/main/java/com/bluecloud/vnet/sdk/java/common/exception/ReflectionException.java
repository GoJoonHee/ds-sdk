package com.bluecloud.vnet.sdk.java.common.exception;

/**
 * @author hexinyu
 * @version 1.0
 * @description
 * @date 2021/08/13
 * @see
 */
public class ReflectionException extends RuntimeException{

    public ReflectionException() {
    }

    public ReflectionException(String message) {
        super(message);
    }

    public ReflectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReflectionException(Throwable cause) {
        super(cause);
    }

    public ReflectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
