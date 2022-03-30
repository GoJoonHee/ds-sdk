package com.bluecloud.vnet.sdk.java.tool.validation.enums;

import org.hibernate.validator.cfg.ConstraintDef;

/**
 * @author hexinyu
 * @version 1.0
 * @description
 * @date 2021/09/15
 * @see
 */
public class InEnumsDef extends ConstraintDef<InEnumsDef, InEnums> {

    public InEnumsDef() {
        super(InEnums.class);
    }

    public InEnumsDef value(String [] value){
        addParameter("value", value);
        return this;
    }

    public InEnumsDef split(String split){
        addParameter("split", split);
        return this;
    }
}
