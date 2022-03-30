package com.bluecloud.vnet.sdk.java.entity;

/**
 * @author dong.liping3
 * @version 1.0
 * @description TODO
 * @date 2022/3/23
 * @see
 */
public class CommonResult<T> {

    private boolean success;

    private String resultCode;

    private T data;

    private String resultMsg;

    private String[] msgParams;

    private Long total;

    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String[] getMsgParams() {
        return msgParams;
    }

    public void setMsgParams(String[] msgParams) {
        this.msgParams = msgParams;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public CommonResult() {
    }

    public CommonResult(boolean success) {
        this.success = success;
    }

    public CommonResult(boolean success, String resultCode) {
        this.success = success;
        this.resultCode = resultCode;
    }

    public CommonResult(boolean success, String resultCode, T data) {
        this.success = success;
        this.resultCode = resultCode;
        this.data = data;
    }

    public CommonResult(boolean success, String resultCode, T data, String resultMsg) {
        this.success = success;
        this.resultCode = resultCode;
        this.data = data;
        this.resultMsg = resultMsg;
    }

    public CommonResult(boolean success, String resultCode, T data, String resultMsg, String[] msgParams) {
        this.success = success;
        this.resultCode = resultCode;
        this.data = data;
        this.resultMsg = resultMsg;
        this.msgParams = msgParams;
    }

    public CommonResult(boolean success,
                        String resultCode,
                        T data,
                        String resultMsg,
                        String[] msgParams,
                        Long total) {
        this.success = success;
        this.resultCode = resultCode;
        this.data = data;
        this.resultMsg = resultMsg;
        this.msgParams = msgParams;
        this.total = total;
    }

    public CommonResult(boolean success,
                        String resultCode,
                        T data,
                        String resultMsg,
                        String[] msgParams,
                        Long total,
                        String requestId) {
        this.success = success;
        this.resultCode = resultCode;
        this.data = data;
        this.resultMsg = resultMsg;
        this.msgParams = msgParams;
        this.total = total;
        this.requestId = requestId;
    }
}
