package com.lyf.springbootall.servlet;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletInitListener implements ServletContextListener, ServletContextAttributeListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(">>>>>>>>>>>>初始化开始 init");
        //[tomcat 9.0] source.class: org.apache.catalina.core.StandardContext$NoPluggabilityServletContext
        System.out.println("source.class: " + sce.getSource().getClass().getName());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println(">>>>>>>>>>>>关闭开始 close");
        System.out.println("source.class: " + sce.getSource().getClass().getName());
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println(">>>>>>>>>>>>添加属性开始 add");
        //[tomcat 9.0] source.class: org.apache.catalina.core.ApplicationContextFacade
        System.out.println("source.class: " + scae.getSource().getClass().getName());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println(">>>>>>>>>>>>删除属性开始 remove");
        System.out.println("source.class: " + scae.getSource().getClass().getName());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println(">>>>>>>>>>>>替换属性开始 replace");
        System.out.println("source.class: " + scae.getSource().getClass().getName());
    }
}
