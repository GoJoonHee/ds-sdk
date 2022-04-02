package com.bluecloud.vnet.sdk.java.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author dong.liping3
 * @version 1.0
 * @description TODO
 * @date 2022/3/23
 * @see
 */
@Component
public class DSEngine {

    @Autowired
    private AuthApi authApi;


    @Autowired
    private WorkFlowApi workFlowApi;


  /**
   * @param 
   * @return com.bluecloud.vnet.sdk.java.api.AuthApi
   * @throws
   * @author dongliping
   * @description 
   * @date 2022/4/1
   * @todo
   */
    public AuthApi auth() {
        return authApi;
    }


    /**
     * @param 
     * @return com.bluecloud.vnet.sdk.java.api.WorkFlowApi
     * @throws
     * @author dongliping
     * @description 
     * @date 2022/4/1
     * @todo
     */
    public WorkFlowApi workflow() {
        return workFlowApi;
    }

}
