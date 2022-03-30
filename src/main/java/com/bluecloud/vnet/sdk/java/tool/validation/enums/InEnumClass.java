package com.bluecloud.vnet.sdk.java.tool.validation.enums;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author chenchen
 * @version 1.0
 * @description 描述
 * @date 2021/8/20
 * @link
 * @see
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = {InEnumClassValidatorForString.class, InEnumClassValidatorForInteger.class })
public @interface InEnumClass {

    Class<? extends Enum> value();

    /**
     * 需要枚举中作比较的字段
     * @return
     */
    String field() default DEFAULT_FIELD;

    /**
     * 需要校验的对象有多个值，并且以某个字符进行分割，如"a,b"
     * @return
     */
    String split() default "";

    String message() default "{javax.validation.constraints.inEnums}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String DEFAULT_FIELD = "name";
}
