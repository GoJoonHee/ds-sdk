package com.bluecloud.vnet.sdk.java.util;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import java.util.Map;

public class HibernateValidationUtils {

    public static void setValidatorParameter(HibernateConstraintValidatorContext validatorContext, String key, Object value){
        validatorContext.addMessageParameter(key, value);
        validatorContext.addExpressionVariable(key, value);
    }

    public static void setValidatorParameter(HibernateConstraintValidatorContext validatorContext, Map<String, Object> maps){
        for (Map.Entry<String, Object> entry : maps.entrySet()) {
            setValidatorParameter(validatorContext, entry.getKey(), entry.getValue());
        }
    }
}
