package com.bluecloud.vnet.sdk.java.tool.validation.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chenchen
 * @version 1.0
 * @description 描述
 * @date 2021/8/20
 * @link
 * @see
 */
public abstract class AbstractInEnumClassValidator<T> extends AbstractEnumsValidator<InEnumClass, T> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractInEnumClassValidator.class);

    private Map<String, Object> extraMsgMap;

    private Class<? extends Enum> enumClazz;

    @Override
    protected Set<String> extractEnumsValue() {
        enumClazz = annotation.value();
        Field field = ReflectionUtils.findField(enumClazz, annotation.field());
        if(field == null){
            LOG.warn("annotation field [{}] not found in enum class[{}],  the default field [{}] will be use"
                    , annotation.field(), enumClazz, InEnumClass.DEFAULT_FIELD);
            field = ReflectionUtils.findField(enumClazz, InEnumClass.DEFAULT_FIELD);
        }
        Enum[] enumConstants = enumClazz.getEnumConstants();
        HashSet<String> enumSet = new HashSet<>(enumConstants.length);
        for (Enum enumConstant : enumConstants) {
            ReflectionUtils.makeAccessible(field);
            Object value = ReflectionUtils.getField(field, enumConstant);
            if(value != null) {
                enumSet.add(value.toString());
            }
        }
        if(extraMsgMap == null){
            extraMsgMap = new HashMap<>();
        }
        extraMsgMap.put("value", String.join(",", enumSet));
        return enumSet;
    }

    @Override
    protected String extractSplitter() {
        return annotation.split();
    }

    @Override
    protected Map<String, Object> extraMsgParameter(T content, ConstraintValidatorContext constraintValidatorContext) {
        return extraMsgMap;
    }
}
