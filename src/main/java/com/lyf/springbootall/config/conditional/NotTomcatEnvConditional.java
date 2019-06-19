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
        System.out.println(">>>>>>>>>>>>>>>>进入这里了");
        boolean b = true;
        try {
            Object o = System.getProperty("CATALINA_BASE");
            System.out.println("dfsdf" + o);
            if (o != null && !"".equals(o.toString().trim())) {
                //是在tomcat环境
                b = false;
            }
        } catch (Exception ignored) {
        }
        //非Tomcat环境
        System.out.println(">>>>>>>>>>>>>>>>判断结果：" + b);
        return b;
    }
}
