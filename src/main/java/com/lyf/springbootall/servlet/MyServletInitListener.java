package com.lyf.springbootall.servlet;

import javax.servlet.*;
import java.util.Enumeration;

/**
 * look for javax.websocket.server.ServerApplicationConfig
 */
public class MyServletInitListener implements ServletContextListener, ServletContextAttributeListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(">>>>>>>>>>>>初始化开始 init");
        //[tomcat 9.0] source.class: org.apache.catalina.core.StandardContext$NoPluggabilityServletContext
        System.out.println("source.class: " + sce.getServletContext().getClass().getName());

        //初始化参数
        Enumeration<String> params = sce.getServletContext().getInitParameterNames();
        while (params.hasMoreElements()) {
            String name = params.nextElement();
            System.out.println("[init-param] " + name + ": " + sce.getServletContext().getInitParameter(name));
        }

        //初始化属性
        Enumeration<String> attributes = sce.getServletContext().getAttributeNames();
        while (attributes.hasMoreElements()) {
            String attribute = attributes.nextElement();
            System.out.println("[init-attribute] " + attribute + ": " + sce.getServletContext().getAttribute(attribute));
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println(">>>>>>>>>>>>关闭开始 close");
        System.out.println("source.class: " + sce.getServletContext().getClass().getName());
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println(">>>>>>>>>>>>[添加属性开始 add]" + scae.getName() + ": " + scae.getValue());
        //[tomcat 9.0] source.class: org.apache.catalina.core.ApplicationContextFacade
        ServletContext servletContext = scae.getServletContext();
        System.out.println("source.class: " + servletContext.getClass().getName());

        //打印所有servlet
        Enumeration<Servlet> servlets = servletContext.getServlets();
        while (servlets.hasMoreElements()) {
            Servlet servlet = servlets.nextElement();
            System.out.println(">>>>>>>>>>>>>>" + servlet.getServletInfo());
        }

//        if (servletContext instanceof ApplicationContextFacade) {
//            ApplicationContextFacade applicationContextFacade = (ApplicationContextFacade) scae.getSource();
//
//            //找endpoint
////            String servletContextName = applicationContextFacade.getServletContextName();
////            System.out.println(">>>>>>>>>>>> ServletContextName: " + servletContextName);
////            ServletContext servletContext = applicationContextFacade.getContext(servletContextName);
////            System.out.println(">>>>>>>>>>>> ServletContext type : " + servletContext.getClass().getName());
//        }

        //为了测试
//        try {
//            Class.forName("javax.websocket.server.ServerContainer");
//            Object a = servletContext.getAttribute("javax.websocket.server.ServerContainer");
//            Field field = a.getClass().getDeclaredField("configTemplateMatchMap");
//            field.setAccessible(true);
//            Object o = field.get(a);
//            if (o instanceof Map) {
//                System.out.println(">>>>>>>>>>>>>>[Endpoint配置] total: " + ((Map) o).size());
//            }
//        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println(">>>>>>>>>>>>[删除属性开始 remove]" + scae.getName() + ": " + scae.getValue());
        System.out.println("source.class: " + scae.getSource().getClass().getName());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println(">>>>>>>>>>>>[替换属性开始 replace]" + scae.getName() + ": " + scae.getValue());
        System.out.println("source.class: " + scae.getSource().getClass().getName());
    }
}
