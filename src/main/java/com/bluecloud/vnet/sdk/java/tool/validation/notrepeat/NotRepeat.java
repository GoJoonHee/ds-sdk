package com.bluecloud.vnet.sdk.java.tool.validation.notrepeat;

import org.springframework.core.annotation.AliasFor;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author hexinyu
 * @version 1.0
 * @description
 * 校验集合的或数组中指定的元素是否重复
 * @date 2021/08/12
 * @see
 */
@Documented
@Constraint(validatedBy = { NotRepeatValidatorForCollection.class, NotRepeatValidatorForArray.class,
        NotRepeatValidatorForArraysOfShort.class, NotRepeatValidatorForArraysOfInt.class, NotRepeatValidatorForArraysOfLong.class,
        NotRepeatValidatorForArraysOfFloat.class, NotRepeatValidatorForArraysOfDouble.class, NotRepeatValidatorForArraysOfChar.class
})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Repeatable(NotRepeat.List.class)
public @interface NotRepeat {

    @AliasFor("itemPath")
    String[] value() default "";

    /**
     * 匹配项路径
     * 可以为字段属性
     * @return
     */
    @AliasFor("value")
    String[] itemPath() default "";

    Class<? extends RepeatCandidateValueExtractor>[] extractor() default {};

    Class<? extends RepeatPredicate> repeatPredicate() default DefaultRepeatPredicate.class;

    /**
     * 约束不通过提示信息
     * @return
     */
    String message() default "{javax.validation.constraints.notRepeat.pathMessage}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    /**
     * Defines several {@code @NotEmpty} constraints on the same element.
     *
     * @see NotRepeat
     */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        NotRepeat[] value();
    }
}
