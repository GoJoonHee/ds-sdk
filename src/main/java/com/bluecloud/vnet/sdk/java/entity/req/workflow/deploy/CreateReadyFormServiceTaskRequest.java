package com.bluecloud.vnet.sdk.java.entity.req.workflow.deploy;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author dong.liping3
 * @version 1.0
 * @description TODO
 * @date 2022/2/21
 * @see
 */
public class CreateReadyFormServiceTaskRequest extends CreateAbstractSchemaServiceTaskRequest {

    //排序字段
    @NotNull
    private String[] orderBy;

    //排序规则
    @NotNull
    private String orderType;

    //保留查询到的几条数据 默认一条
    private Integer number = 1;

    //查询条件（数组中套数组（每一组数组内的条件都是且关系，数组与数组是或的关系））
    private List<@Valid List<@Valid CreateReady4CriteriaFormServiceTaskRequest>> criterias;

    public String[] getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String[] orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<List<CreateReady4CriteriaFormServiceTaskRequest>> getCriterias() {
        return criterias;
    }

    public void setCriterias(List<List<CreateReady4CriteriaFormServiceTaskRequest>> criterias) {
        this.criterias = criterias;
    }

}
