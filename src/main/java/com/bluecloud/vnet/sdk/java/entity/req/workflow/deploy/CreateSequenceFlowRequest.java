package com.bluecloud.vnet.sdk.java.entity.req.workflow.deploy;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * @author dong.liping3
 * @version 1.0
 * @description TODO
 * @date 2022/3/29
 * @see
 */
public class CreateSequenceFlowRequest {

    @NotBlank
    private String sourceRef;

    @NotBlank
    private String targetRef;

    private List<List<@Valid CreateFlowConditionExpRequest>> conditions;

    private String name;

    private Map<String, String> extraData;

    public Map<String, String> getExtraData() {
        return extraData;
    }

    public String getSourceRef() {
        return sourceRef;
    }

    public void setSourceRef(String sourceRef) {
        this.sourceRef = sourceRef;
    }

    public String getTargetRef() {
        return targetRef;
    }

    public void setTargetRef(String targetRef) {
        this.targetRef = targetRef;
    }

    public List<List<CreateFlowConditionExpRequest>> getConditions() {
        return conditions;
    }

    public void setConditions(List<List<CreateFlowConditionExpRequest>> conditions) {
        this.conditions = conditions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExtraData(Map<String, String> extraData) {
        this.extraData = extraData;
    }
}
