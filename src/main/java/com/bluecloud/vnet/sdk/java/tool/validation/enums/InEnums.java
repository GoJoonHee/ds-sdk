package com.bluecloud.vnet.sdk.java.tool.validation.enums;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

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
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE_USE})
@Constraint(validatedBy = {InEnumsValidatorForString.class, InEnumsValidatorForInteger.class })
@Repeatable(InEnums.List.class)
public @interface InEnums {

    String[] value();

    /**
     * 需要校验的对象有多个值，并且以某个字符进行分割，如"a,b"
     * @return
     */
    String split() default "";

    String message() default "{javax.validation.constraints.inEnums}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        InEnums[] value();
    }
}
