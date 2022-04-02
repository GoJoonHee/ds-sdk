package com.bluecloud.vnet.sdk.java.entity.req.workflow.deploy;

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
public class CreateProcessRequest {

    @NotEmpty
    private List<@Valid CreateSequenceFlowRequest> sequenceFlows;

    @NotEmpty
    private List<@Valid CreateFlowNodeRequest> flowNodes;

    public List<CreateSequenceFlowRequest> getSequenceFlows() {
        return sequenceFlows;
    }

    public void setSequenceFlows(List<CreateSequenceFlowRequest> sequenceFlows) {
        this.sequenceFlows = sequenceFlows;
    }

    public List<CreateFlowNodeRequest> getFlowNodes() {
        return flowNodes;
    }

    public void setFlowNodes(List<CreateFlowNodeRequest> flowNodes) {
        this.flowNodes = flowNodes;
    }
}
