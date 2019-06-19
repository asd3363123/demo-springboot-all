package com.lyf.springbootall.config;

import com.lyf.springbootall.servlet.MyServletInitListener;
import com.lyf.springbootall.servlet.MyWsContextListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {

    /**
     * 开启WebSocket支持
     * FIXME： 在idea里打开，打war包时要把这个bean注释掉
     */
//    @Bean
//    @Conditional(value = NotTomcatEnvConditional.class)
    public ServerEndpointExporter myServerEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Bean
    public ServletListenerRegistrationBean<MyServletInitListener> myServletInitListenerServletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<>(new MyServletInitListener());
    }

    @Bean
    public ServletListenerRegistrationBean<MyWsContextListener> myWsContextListener() {
        return new ServletListenerRegistrationBean<>(new MyWsContextListener());
    }
}
