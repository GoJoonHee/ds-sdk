package com.bluecloud.vnet.sdk.java.common;

/**
 * @author dong.liping3
 * @version 1.0
 * @description TODO
 * @date 2022/3/23
 * @see
 */
public interface SDKConstant {

    //任务类型
    interface ServiceTaskAction {
        //新增数据
        String SAVE_DATA = "SaveFormDataServiceTask";
        //修改数据
        String UPDATE_DATA = "UpdateFormDataServiceTask";
        //查询数据
        String SELECT_DATA = "SelectFormDataServiceTask";
    }
}
