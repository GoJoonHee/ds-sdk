package com.bluecloud.vnet.sdk.java.entity.req;

import com.bluecloud.vnet.sdk.java.enums.BizFlowNodeType;
import com.bluecloud.vnet.sdk.java.tool.validation.enums.InEnumClass;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.hibernate.validator.group.GroupSequenceProvider;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

import static com.bluecloud.vnet.sdk.java.common.SDKConstant.ServiceTaskAction.*;

/**
 * @author dong.liping3
 * @version 1.0
 * @description TODO
 * @date 2022/3/29
 * @see
 */
@GroupSequenceProvider(CreateAbstractSchemaServiceTask.AbstractSchemaServiceTaskVOProvider.class)

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "bizNodeType", visible =
        true)
@JsonSubTypes({@JsonSubTypes.Type(value = CreateReadyFormServiceTask.class, name = SELECT_DATA),
        @JsonSubTypes.Type(value = CreateWriteFormServiceTask.class, name = SAVE_DATA),
        @JsonSubTypes.Type(value = CreateWriteFormServiceTask.class, name = UPDATE_DATA)})
public class CreateAbstractSchemaServiceTask {

    interface SaveNode {
    }

    interface UpdateNode {
    }

    interface SelectNode {
    }

    //节点类型
    @NotBlank
    @InEnumClass(value = BizFlowNodeType.class, field = "code")
    private String bizNodeType;

    public String getBizNodeType() {
        return bizNodeType;
    }

    public void setBizNodeType(String bizNodeType) {
        this.bizNodeType = bizNodeType;
    }

    public static final class AbstractSchemaServiceTaskVOProvider implements DefaultGroupSequenceProvider<CreateAbstractSchemaServiceTask> {
        @Override
        public List<Class<?>> getValidationGroups(CreateAbstractSchemaServiceTask serviceTaskVO) {
            ArrayList<Class<?>> list = new ArrayList<>(2);
            list.add(CreateReadyFormServiceTask.class);
            if (serviceTaskVO != null && !StringUtils.isEmpty(serviceTaskVO.getBizNodeType())) {
                if (SELECT_DATA.equals(serviceTaskVO.getBizNodeType())) {
                    list.add(SelectNode.class);
                } else if (SAVE_DATA.equals(serviceTaskVO.getBizNodeType())) {
                    list.add(SaveNode.class);
                } else if (UPDATE_DATA.equals(serviceTaskVO.getBizNodeType())) {
                    list.add(UpdateNode.class);
                }
            }
            return list;
        }
    }
}
