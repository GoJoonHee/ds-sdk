package com.bluecloud.vnet.sdk.java.entity.resp;

import java.time.ZonedDateTime;

/**
 * @author dong.liping3
 * @version 1.0
 * @description TODO
 * @date 2022/3/23
 * @see
 */
public class CreateDeploymentResponse {

    private String id;
    private String updaterId;
    private ZonedDateTime updateTime;
    private String deploymentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId;
    }

    public ZonedDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(ZonedDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }
}
