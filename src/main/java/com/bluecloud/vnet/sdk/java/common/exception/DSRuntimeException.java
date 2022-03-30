package com.bluecloud.vnet.sdk.java.common.exception;

/**
 * @author dong.liping3
 * @version 1.0
 * @description TODO
 * @date 2022/3/23
 * @see
 */
public class DSRuntimeException extends RuntimeException {

    //错误码
    private String errorCode;

    //错误信息参数
    private String[] errorMessageParams;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String[] getErrorMessageParams() {
        return errorMessageParams;
    }

    public void setErrorMessageParams(String[] errorMessageParams) {
        this.errorMessageParams = errorMessageParams;
    }

    public DSRuntimeException(String errorCode) {
        this.errorCode = errorCode;
    }

    public DSRuntimeException(String errorCode, String detailMessage) {
        super(detailMessage);
        this.errorCode = errorCode;
    }

    public DSRuntimeException(String errorCode, String detailMessage, String[] errorMessageParams) {
        super(detailMessage);
        this.errorCode = errorCode;
        this.errorMessageParams = errorMessageParams;
    }
}
