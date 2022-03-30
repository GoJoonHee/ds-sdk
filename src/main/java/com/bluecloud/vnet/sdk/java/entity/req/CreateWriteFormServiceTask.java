package com.bluecloud.vnet.sdk.java.entity.req;

import org.hibernate.validator.group.GroupSequenceProvider;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.bluecloud.vnet.sdk.java.common.SDKConstant.ServiceTaskAction.SAVE_DATA;
import static com.bluecloud.vnet.sdk.java.common.SDKConstant.ServiceTaskAction.UPDATE_DATA;

/**
 * @author dong.liping3
 * @version 1.0
 * @description TODO
 * @date 2022/2/21
 * @see
 */
@GroupSequenceProvider(CreateWriteFormServiceTask.WriteFormServiceTaskVOProvider.class)
public class CreateWriteFormServiceTask extends CreateAbstractSchemaServiceTask {

    //绑定表单id
    @NotNull(groups = {WriteDynamicNode.class})
    private String sourceFormId;

    //运算符（设为/清空：= ，加、减、乘、除）
    @NotNull(groups = {WriteNode.class})
    private String operator;

    //是否动态
    @NotNull(groups = {WriteNode.class})
    private Boolean isDynamic;

    //设为动态值时选择的节点(-1 表示开始节点)
    @NotNull(groups = {WriteDynamicNode.class})
    private String dynamicNodeId;

    //来源key/固定值(可以为null)
    private Object sourceValue;

    //目标key
    @NotNull(groups = {WriteNode.class})
    private String targetId;

    //额外的数据
    private Map<String,Object> additionalData;

    public String getSourceFormId() {
        return sourceFormId;
    }

    public void setSourceFormId(String sourceFormId) {
        this.sourceFormId = sourceFormId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Boolean getIsDynamic() {
        return isDynamic;
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

    public Object getSourceValue() {
        return sourceValue;
    }

    public void setSourceValue(Object sourceValue) {
        this.sourceValue = sourceValue;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public Map<String, Object> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, Object> additionalData) {
        this.additionalData = additionalData;
    }

    public static final class WriteFormServiceTaskVOProvider implements DefaultGroupSequenceProvider<CreateWriteFormServiceTask> {
        @Override
        public List<Class<?>> getValidationGroups(CreateWriteFormServiceTask serviceTaskVO) {
            ArrayList<Class<?>> list = new ArrayList<>(2);
            list.add(CreateWriteFormServiceTask.class);
            if (serviceTaskVO != null && null != serviceTaskVO.getIsDynamic()) {
                if (serviceTaskVO.getIsDynamic()) {
                    list.add(WriteDynamicNode.class);
                }
                if (SAVE_DATA.equals(serviceTaskVO.getBizNodeType()) || UPDATE_DATA.equals(serviceTaskVO.getBizNodeType())) {
                    list.add(WriteNode.class);
                }
            }
            return list;
        }
    }

    interface WriteDynamicNode {
    }

    interface WriteNode {
    }
}
