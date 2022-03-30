package com.bluecloud.vnet.sdk.java.enums;


import com.bluecloud.vnet.sdk.java.util.EnumUtils;

/**
 * @author hexinyu
 * @version 1.0
 * @description 流程节点方向
 * @date 2021/10/29
 * @see
 */
public enum FlowNodeType {

    USER_TASK("task", "userTask"),
    SERVICE_TASK("task", "serviceTask"),
    INCLUSIVE_GATEWAY("gateway", "inclusiveGateway"),
    START_EVENT("event", "startEvent"),
    END_EVENT("event", "endEvent");

    private String group;

    private String code;

    private static final String SPLITTER = "_";

    FlowNodeType(String first, String code) {
        this.group = first;
        this.code = code;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static FlowNodeType initBy(String code) {
        return EnumUtils.initEnum(FlowNodeType.class, FlowNodeType::getCode, code);
    }
}
