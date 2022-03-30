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
     * @author chenchen
     * @description 描述
     * @date 2022/3/23
     * @param
     * @return
     * @throws
     * @todo
     */
    public AuthApi auth() {
        return authApi;
    }


    /**
     * @author chenchen
     * @description 描述
     * @date 2022/3/23
     * @param
     * @return
     * @throws
     * @todo
     */
    public WorkFlowApi workflow() {
        return workFlowApi;
    }

}
