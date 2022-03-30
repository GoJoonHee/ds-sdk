package com.bluecloud.vnet.sdk.java.util;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author hexinyu
 * @version 1.0
 * @description
 * @date 2021/04/22
 * @link
 * @see
 */
public final class SpringElUtils {

    private SpringElUtils() {
    }

    private static final Map<String, Expression> CACHE_EXP = new HashMap<>();

    public static Object evaluate(String varName, Object varObj, String expressionStr) {
        Expression exp = Optional.ofNullable(CACHE_EXP.get(expressionStr))
                .orElseGet(() -> {
                    ExpressionParser parser = new SpelExpressionParser();
                    Expression expression = parser.parseExpression(expressionStr);
                    CACHE_EXP.put(expressionStr, expression);
                    return expression;
                });
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable(varName, varObj);
        return exp.getValue(context);
    }
}
