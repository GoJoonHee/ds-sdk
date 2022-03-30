package com.bluecloud.vnet.sdk.java.entity.req;

import com.bluecloud.vnet.sdk.java.tool.validation.notrepeat.NotRepeat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author dong.liping3
 * @version 1.0
 * @description TODO
 * @date 2022/3/29
 * @see
 */
public class CreateProcess {

    @NotEmpty
    private List<@Valid CreateSequenceFlow> sequenceFlows;

    @NotEmpty
    @NotRepeat("id")
    private List<@Valid CreateFlowNode> flowNodes;

    public List<CreateSequenceFlow> getSequenceFlows() {
        return sequenceFlows;
    }

    public void setSequenceFlows(List<CreateSequenceFlow> sequenceFlows) {
        this.sequenceFlows = sequenceFlows;
    }

    public List<CreateFlowNode> getFlowNodes() {
        return flowNodes;
    }

    public void setFlowNodes(List<CreateFlowNode> flowNodes) {
        this.flowNodes = flowNodes;
    }
}
