package com.lyf.springbootall.servlet;

import org.apache.tomcat.websocket.server.WsContextListener;
import org.apache.tomcat.websocket.server.WsServerContainer;

import javax.servlet.ServletContextEvent;
import javax.websocket.Extension;
import java.lang.reflect.Field;
import java.util.Map;

public class MyWsContextListener extends WsContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(">>>>>>>>>> WebSocket 初始化");
        super.contextInitialized(sce);
        Object a = sce.getServletContext().getAttribute("javax.websocket.server.ServerContainer");
        if (a instanceof WsServerContainer) {
            WsServerContainer wsServerContainer = (WsServerContainer) a;

            System.out.println(">>>>>>>>>>>>>[Web Socket Extensions]");
            for (Extension extension : wsServerContainer.getInstalledExtensions()) {
                for (Extension.Parameter parameter : extension.getParameters()) {
                    System.out.println("[name]" + extension.getName() + ", [param]" + parameter.getName() + ", [value]" + parameter.getValue());
                }
            }

            //打印所有Endpoint
            try {
                //相对路径
                Field field = WsServerContainer.class.getDeclaredField("configTemplateMatchMap");
                field.setAccessible(true);
                Object o = field.get(wsServerContainer);
                if (o instanceof Map) {
                    //Fixme: 这种方式在非Tomcat环境下失效 total = 0
                    System.out.println(">>>>>>>>>>>>>>[Endpoint配置] total: " + ((Map) o).size());
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println(">>>>>>>>>> WebSocket 销毁");
        super.contextDestroyed(sce);
    }
}
