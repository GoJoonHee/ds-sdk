package com.bluecloud.vnet.sdk.java.entity.req.workflow.deploy;


import com.bluecloud.vnet.sdk.java.enums.FlowNodeType;
import org.hibernate.validator.group.GroupSequenceProvider;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.bluecloud.vnet.sdk.java.enums.BizFlowNodeType.UPDATE_FORM_DATA_SERVICE_TASK;

/**
 * @author dong.liping3
 * @version 1.0
 * @description TODO
 * @date 2022/3/29
 * @see
 */
@GroupSequenceProvider(CreateFlowNodeRequest.CreateFlowNodeProvider.class)
public class CreateFlowNodeRequest {
    public interface SaveUserTask {
    }

    public interface Task {
    }

    public interface ServiceTaskBindForm {
    }

    public interface ServiceTask4BindNode {
    }

    @NotBlank
    private String id;

    //@Pattern(regexp = "^[a-z][\\w]+$", message = "只能以小写字母开头，且其他只能由为大小写字母和下划线组成")
    private String varPoolKey;

    @NotBlank
    private String name;

    @NotBlank
    private String nodeType;

    @NotBlank(groups = Task.class)
    private String bizNodeType;

    //UserTask专属属性 start
    /**
     * 是否使用动态审批人
     */
    private boolean userDynamicUser;

    /**
     * 候选审批人
     */
    @NotEmpty(groups = SaveUserTask.class)
    private List<String> candidateUsers;

    /**
     * 任务待办人的视图Id
     */
    @NotBlank(groups = SaveUserTask.class)
    private String todoTaskViewId;

    /**
     * 任务发起人的视图Id
     */
    @NotBlank(groups = SaveUserTask.class)
    private String ownerTaskViewId;
    //UserTask专属属性 end

    private Map<String, String> extraData;

    //绑定表单id
    @NotBlank(groups = ServiceTaskBindForm.class)
    private String formId;

    //绑定节点id
    @NotBlank(groups = ServiceTask4BindNode.class)
    private String nodeId;

    private List<@Valid CreateAbstractSchemaServiceTaskRequest> customProperties;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVarPoolKey() {
        return varPoolKey;
    }

    public void setVarPoolKey(String varPoolKey) {
        this.varPoolKey = varPoolKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getBizNodeType() {
        return bizNodeType;
    }

    public void setBizNodeType(String bizNodeType) {
        this.bizNodeType = bizNodeType;
    }

    public boolean isUserDynamicUser() {
        return userDynamicUser;
    }

    public void setUserDynamicUser(boolean userDynamicUser) {
        this.userDynamicUser = userDynamicUser;
    }

    public List<String> getCandidateUsers() {
        return candidateUsers;
    }

    public void setCandidateUsers(List<String> candidateUsers) {
        this.candidateUsers = candidateUsers;
    }

    public String getTodoTaskViewId() {
        return todoTaskViewId;
    }

    public void setTodoTaskViewId(String todoTaskViewId) {
        this.todoTaskViewId = todoTaskViewId;
    }

    public String getOwnerTaskViewId() {
        return ownerTaskViewId;
    }

    public void setOwnerTaskViewId(String ownerTaskViewId) {
        this.ownerTaskViewId = ownerTaskViewId;
    }

    public Map<String, String> getExtraData() {
        return extraData;
    }

    public void setExtraData(Map<String, String> extraData) {
        this.extraData = extraData;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public List<CreateAbstractSchemaServiceTaskRequest> getCustomProperties() {
        return customProperties;
    }

    public void setCustomProperties(List<CreateAbstractSchemaServiceTaskRequest> customProperties) {
        this.customProperties = customProperties;
    }

    public static final class CreateFlowNodeProvider implements DefaultGroupSequenceProvider<CreateFlowNodeRequest> {

        @Override
        public List<Class<?>> getValidationGroups(CreateFlowNodeRequest flowNode) {
            ArrayList<Class<?>> list = new ArrayList<>(4);
            list.add(CreateFlowNodeRequest.class);
            if (flowNode != null) {
                if (FlowNodeType.USER_TASK.getCode().equals(flowNode.getNodeType())) {
                    list.add(SaveUserTask.class);
                } else if (FlowNodeType.SERVICE_TASK.getCode().equals(flowNode.getNodeType())) {
                    list.add(ServiceTaskBindForm.class);
                }
                if (UPDATE_FORM_DATA_SERVICE_TASK.getCode().equals(flowNode.getBizNodeType())) {
                    list.add(ServiceTask4BindNode.class);
                }
                if(FlowNodeType.USER_TASK.getCode().equals(flowNode.getNodeType()) || FlowNodeType.SERVICE_TASK.getCode().equals(flowNode.getNodeType())){
                    list.add(Task.class);
                }
            }
            return list;
        }
    }
}
