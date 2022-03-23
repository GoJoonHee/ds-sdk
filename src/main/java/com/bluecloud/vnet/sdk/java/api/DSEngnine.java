package com.bluecloud.vnet.sdk.java.dssdk;

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
    private FormApi formApi;

    @Autowired
    private WorkFlowApi workFlowApi;

    @Autowired
    private PubApi pubApi;

    @Autowired
    private PlatformApi platformApi;

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
    public FormApi form() {
        return formApi;
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

    /**
     * @author chenchen
     * @description 描述
     * @date 2022/3/23
     * @param
     * @return
     * @throws
     * @todo
     */
    public PubApi pub() {
        return null;
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
    public PlatformApi platform() {
        return null;
    }
}
