package com.bluecloud.vnet.sdk.java.tool.validation.enums;


import com.bluecloud.vnet.sdk.java.util.HibernateValidationUtils;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.util.StringUtils;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
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
public abstract class AbstractEnumsValidator<A extends Annotation, T> implements ConstraintValidator<A , T> {

    private Set<String> values;
    private String splitor;
    protected A annotation;

    @Override
    public final void initialize(A annotation) {
        this.annotation = annotation;
        this.values = extractEnumsValue();
        String split = extractSplitter();
        if(!split.isEmpty()){
            this.splitor = split;
        }
    }


    @Override
    public boolean isValid(T content, ConstraintValidatorContext constraintValidatorContext) {
        //默认空的时候认为通过了校验
        if (content == null) {
            return true;
        }
        String contentStr = convertContent(content);
        boolean isValid;
        if(splitor == null) {
            //包含认为校验通过，不包含认为校验不通过
            isValid = values.contains(contentStr);
        }else {
            String[] splitContents = StringUtils.split(contentStr, this.splitor);
            if(splitContents == null){
                isValid = values.contains(contentStr);
            }else{
                // 校验根据 split切分的所有字符
                isValid = true;
                for (String splitContent : splitContents) {
                    if(!values.contains(splitContent)){
                        isValid = false;
                        break;
                    }
                }
            }
        }
        Map<String, Object> msgParameter;
        if(!isValid && (msgParameter = extraMsgParameter(content, constraintValidatorContext)) != null){
            HibernateConstraintValidatorContext hibernateContext = constraintValidatorContext.unwrap(HibernateConstraintValidatorContext.class);
            HibernateValidationUtils.setValidatorParameter(hibernateContext, msgParameter);
        }
        return isValid;
    }

    protected abstract String convertContent(T content);

    protected abstract Set<String> extractEnumsValue();

    protected abstract String extractSplitter();

    protected Map<String, Object> extraMsgParameter(T content, ConstraintValidatorContext constraintValidatorContext){
        return null;
    }
}
