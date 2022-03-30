package com.bluecloud.vnet.sdk.java.common;

/**
 * @author dong.liping3
 * @version 1.0
 * @description TODO
 * @date 2022/3/23
 * @see
 */
public interface SDKConstant {

    interface ExpressionOperatorCode {
        String EQ = "eq";
        String NE = "ne";
        String GT = "gt";   //大于
        String GE = "ge";   //大于等于
        String LT = "lt";   //小于
        String LE = "le";   //小于等于
        String NO_DATA = "no_data";//有数据
        String HAVE_DATA = "have_data";//无数据
    }

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
