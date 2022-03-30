package com.bluecloud.vnet.sdk.java.entity.req;

import com.bluecloud.vnet.sdk.java.tool.validation.enums.InEnums;

import javax.validation.constraints.NotBlank;

import static com.bluecloud.vnet.sdk.java.common.SDKConstant.ExpressionOperatorCode.*;


/**
 * @author dong.liping3
 * @version 1.0
 * @description TODO
 * @date 2022/3/29
 * @see
 */
public class CreateFlowConditionExp {

    @NotBlank
    private String varPoolRef;

    //@NotBlank
    private String propDefId;

    @InEnums(value = {EQ, NE, GT, GE, LT, LE, NO_DATA, HAVE_DATA})
    @NotBlank
    private String operatorCode;

    //@NotBlank
    private String value;
    //是否动态
    private Boolean isDynamic;
    //表达式动态节点
    private String valueVarPoolRef;
    //表达式动态字段
    private String valuePropDefkey;

    public String getVarPoolRef() {
        return varPoolRef;
    }

    public void setVarPoolRef(String varPoolRef) {
        this.varPoolRef = varPoolRef;
    }

    public String getPropDefId() {
        return propDefId;
    }

    public void setPropDefId(String propDefId) {
        this.propDefId = propDefId;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getIsDynamic() {
        return isDynamic;
    }

    public void setIsDynamic(Boolean isDynamic) {
        this.isDynamic = isDynamic;
    }

    public String getValueVarPoolRef() {
        return valueVarPoolRef;
    }

    public void setValueVarPoolRef(String valueVarPoolRef) {
        this.valueVarPoolRef = valueVarPoolRef;
    }

    public String getValuePropDefkey() {
        return valuePropDefkey;
    }

    public void setValuePropDefkey(String valuePropDefkey) {
        this.valuePropDefkey = valuePropDefkey;
    }
}
