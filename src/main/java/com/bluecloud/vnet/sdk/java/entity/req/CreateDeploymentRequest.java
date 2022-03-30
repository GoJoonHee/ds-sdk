package com.bluecloud.vnet.sdk.java.entity.req;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author dong.liping3
 * @version 1.0
 * @description TODO
 * @date 2022/3/23
 * @see
 */
public class CreateDeploymentRequest {

    @NotNull
    private String id;

    @NotNull
    @Valid
    private CreateProcess model;

    public CreateProcess getModel() {
        return model;
    }

    public void setModel(CreateProcess model) {
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
