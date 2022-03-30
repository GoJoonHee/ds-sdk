package com.bluecloud.vnet.sdk.java.tool.validation.notrepeat;


import com.bluecloud.vnet.sdk.java.common.exception.ValidationErrorException;
import com.bluecloud.vnet.sdk.java.util.HibernateValidationUtils;
import com.bluecloud.vnet.sdk.java.util.ReflectUtil;
import com.bluecloud.vnet.sdk.java.util.SpringElUtils;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author hexinyu
 * @version 1.0
 * @description
 * @date 2021/08/12
 * @see
 */
@SuppressWarnings("rawtypes")
public abstract class NotRepeatValidator<T> implements ConstraintValidator<NotRepeat, T> {

    protected static final String OBJ_ROOT = "r";
    protected static final String SPRING_EL_PREFIX = "#";
    protected static final String PREFIX = SPRING_EL_PREFIX + OBJ_ROOT + ".";

    /**
     * 是否匹配整个对象
     */
    protected boolean equalObjectWhole = false;

    protected boolean useExtractor = false;
    protected List<RepeatCandidateValueExtractor> extractors;
    protected String[] equalPaths;

    private RepeatPredicate repeatPredicate;

    @Override
    public void initialize(NotRepeat constraintAnnotation) {
        constraintAnnotation = AnnotationUtils.synthesizeAnnotation(constraintAnnotation, null);
        repeatPredicate = ReflectUtil.newInstance(constraintAnnotation.repeatPredicate());
        if (constraintAnnotation.extractor().length > 0) {
            useExtractor = true;
            extractors = Arrays.stream(constraintAnnotation.extractor()).map(ReflectUtil::newInstance)
                    .collect(Collectors.toList());
        } else {
            String[] itemPaths = constraintAnnotation.itemPath();
            if (itemPaths.length == 1 && StringUtils.isEmpty(itemPaths[0])) {
                equalObjectWhole = true;
            } else {
                equalPaths = new String[itemPaths.length];
                for (int i = 0; i < itemPaths.length; i++) {
                    equalPaths[i] = PREFIX + itemPaths[i];
                }
            }
        }
    }

    @Override
    public boolean isValid(T value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        Integer size = sizeGetter().apply(value);
        Set<Object> compareSet = new HashSet<>(size > 0 ? size : 0);
        Iterable<Object> iterator = iterator(value);
        for (Object item : iterator) {
            Object evaluateValue;
            if (equalObjectWhole) {
                //直接匹配整个对象
                evaluateValue = item;
            } else if (useExtractor) {
                //自定义
                RepeatCandidateValueExtractor valueExtractor = extractors.stream().filter(extractor -> extractor.support(item))
                        .findFirst()
                        .orElseThrow(() -> new ValidationErrorException("can't find a RepeatCandidateValueExtractor for extract Class:" + item.getClass()));
                evaluateValue = valueExtractor.extract(item);
            } else if (equalPaths.length == 1) {
                //匹配一个属性
                evaluateValue = evaluate(item, equalPaths[0]);
            } else {
                //多个属性联合匹配
                EqualSet<Object> set = new EqualSet<>();
                for (String equalPath : equalPaths) {
                    set.add(evaluate(item, equalPath));
                }
                evaluateValue = set;
            }
            if (evaluateValue == null) {
                continue;
            }
            if (repeatPredicate.judge(compareSet, evaluateValue)) {
                constructErrorMsg(context, useExtractor || equalObjectWhole ? null : constructErrorMsgPaths(equalPaths)
                        , evaluateValue);
                return false;
            }
            compareSet.add(evaluateValue);
        }
        return true;
    }

    /**
     * @param equalPaths
     * @return java.lang.String
     * @throws
     * @description 构造约束不通过提示信息的path
     * @author hexinyu
     * @date 8/13/2021
     * @todo
     */
    private String constructErrorMsgPaths(String[] equalPaths) {
        return Arrays.stream(equalPaths).map(this::unwrapEqualPath)
                .collect(Collectors.joining(","));
    }

    private Object evaluate(Object item, String equalPath) {
        Object evaluate;
        try {
            evaluate = SpringElUtils.evaluate(OBJ_ROOT, item, equalPath);
        } catch (Exception e) {
            throw new IllegalArgumentException("The value of the property [itemPath] of the annotation [@NotRepeat] is invalid", e);
        }
        return evaluate;
    }

    /**
     * @param context
     * @param equalPaths
     * @param evaluate
     * @return void
     * @throws
     * @description 构造校验不通过提示信息
     * @author hexinyu
     * @date 8/12/2021
     * @todo
     */
    private void constructErrorMsg(ConstraintValidatorContext context, String equalPaths, Object evaluate) {
        HibernateConstraintValidatorContext validatorContext = context.unwrap(HibernateConstraintValidatorContext.class);
        validatorContext.addMessageParameter("dpValue", evaluate);
        HibernateValidationUtils.setValidatorParameter(validatorContext, "dpValue", evaluate);
        if (equalPaths == null) {
            HibernateValidationUtils.setValidatorParameter(validatorContext, "fieldPath", null);
        } else {
            HibernateValidationUtils.setValidatorParameter(validatorContext, "fieldPath", equalPaths);
        }
    }

    private String unwrapEqualPath(String parameter) {
        return parameter.substring(3);
    }

    protected abstract Function<T, Integer> sizeGetter();

    protected abstract Iterable<Object> iterator(T value);

    public static class EqualSet<E> extends HashSet<E> {

        @Override
        public boolean equals(Object o) {
            if (o instanceof Collection) {
                Collection target = ((Collection<?>) o);
                return size() == target.size() && containsAll(target);
            }
            return super.equals(o);
        }
    }
}
