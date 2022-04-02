package com.bluecloud.vnet.sdk.java.entity.req.workflow.deploy;

import org.hibernate.validator.group.GroupSequenceProvider;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author dong.liping3
 * @version 1.0
 * @description TODO
 * @date 2022/2/22
 * @see
 */
@GroupSequenceProvider(CreateReady4CriteriaFormServiceTaskRequest.Ready4CriteriaFormServiceTaskVOProvider.class)
public class CreateReady4CriteriaFormServiceTaskRequest {
    interface DynamicNode {
    }

    interface StaticNode {
    }
    //是否动态
    @NotNull
    private Boolean isDynamic;

    //设为动态值时选择的节点(-1 表示开始节点)
    @NotNull(groups = {DynamicNode.class})
    private String dynamicNodeId;

    //动态值
    @NotNull(groups = {DynamicNode.class})
    private String sourceValue;

    //额外的数据
    private Map<String,Object> additionalData;

    //查询条件key
    @NotNull(groups = {StaticNode.class})
    private String qbcKey;

    //查询条件运算符
    @NotNull
    private String qbcOperator;

    //静态值
    @NotNull(groups = {StaticNode.class})
    private String qbcValue;

    public String getQbcKey() {
        return qbcKey;
    }

    public void setQbcKey(String qbcKey) {
        this.qbcKey = qbcKey;
    }

    public String getQbcOperator() {
        return qbcOperator;
    }

    public void setQbcOperator(String qbcOperator) {
        this.qbcOperator = qbcOperator;
    }

    public String getQbcValue() {
        return qbcValue;
    }

    public void setQbcValue(String qbcValue) {
        this.qbcValue = qbcValue;
    }

    public Boolean getIsDynamic() {
        return this.isDynamic;
    }

    public void setIsDynamic(Boolean isDynamic) {
        this.isDynamic = isDynamic;
    }

    public String getDynamicNodeId() {
        return dynamicNodeId;
    }

    public void setDynamicNodeId(String dynamicNodeId) {
        this.dynamicNodeId = dynamicNodeId;
    }

    public String getSourceValue() {
        return sourceValue;
    }

    public void setSourceValue(String sourceValue) {
        this.sourceValue = sourceValue;
    }

    public Map<String, Object> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, Object> additionalData) {
        this.additionalData = additionalData;
    }

    public static final class Ready4CriteriaFormServiceTaskVOProvider implements DefaultGroupSequenceProvider<CreateReady4CriteriaFormServiceTaskRequest> {

        @Override
        public List<Class<?>> getValidationGroups(CreateReady4CriteriaFormServiceTaskRequest serviceTaskVO) {
            ArrayList<Class<?>> list = new ArrayList<>(2);
            list.add(CreateReady4CriteriaFormServiceTaskRequest.class);
            if (null != serviceTaskVO && null != serviceTaskVO.getIsDynamic()) {
                if (serviceTaskVO.getIsDynamic()) {
                    list.add(DynamicNode.class);
                } else {
                    list.add(StaticNode.class);
                }
            }
            return list;
        }
    }


}
