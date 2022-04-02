package com.bluecloud.vnet.sdk.java.enums;


/**
 * @author dong.liping3
 * @version 1.0
 * @description 流节点业务类型
 * @date 2021/10/29
 * @see
 */
public enum BizFlowNodeType {

    /**
     * 审批任务
     */
    EXAMINE_TASK("ExamineTask"),

    /**
     * 确认任务
     */
    CONFIRM_TASK("ConfirmTask"),

    /**
     * ServiceTask 新增表单数据任务
     */
    SAVE_FORM_DATA_SERVICE_TASK("SaveFormDataServiceTask"),

    /**
     * ServiceTask 修改表单数据任务
     */
    UPDATE_FORM_DATA_SERVICE_TASK("UpdateFormDataServiceTask"),

    /**
     * ServiceTask 读取表单数据任务
     */
    SELECT_FORM_DATA_SERVICE_TASK("SelectFormDataServiceTask");

    private String code;

    BizFlowNodeType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
