package com.bluecloud.vnet.sdk.java.tool.validation.enums;

/**
 * @author chenchen
 * @version 1.0
 * @description 描述
 * @date 2021/8/20
 * @link
 * @see
 */
public class InEnumClassValidatorForInteger extends AbstractInEnumClassValidator<Integer> {

    @Override
    protected String convertContent(Integer content) {
        return String.valueOf(content);
    }
}
