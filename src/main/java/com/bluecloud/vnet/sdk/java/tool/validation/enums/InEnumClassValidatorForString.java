package com.bluecloud.vnet.sdk.java.tool.validation.enums;

/**
 * @author chenchen
 * @version 1.0
 * @description 描述
 * @date 2021/8/20
 * @link
 * @see
 */
public class InEnumClassValidatorForString extends AbstractInEnumClassValidator<String> {

    @Override
    protected String convertContent(String content) {
        return content;
    }
}
