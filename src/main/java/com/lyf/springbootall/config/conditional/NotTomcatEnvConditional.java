package com.lyf.springbootall.config.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断非Tomcat环境
 */
public class NotTomcatEnvConditional implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        System.out.println(">>>>>>>>>>>>>>>>判断是否处于Tomcat环境");
        //非Tomcat环境
        boolean b = true;
        try {
            Object o = System.getenv("CATALINA_BASE");
            if (o != null && !"".equals(o.toString().trim())) {
                //是在tomcat环境
                b = false;
            }
        } catch (Exception ignored) {
        }
        System.out.println(">>>>>>>>>>>>>>>>Tomcat环境判断结果：" + !b);
        return b;
    }
}
