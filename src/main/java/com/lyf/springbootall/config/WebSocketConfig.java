package com.lyf.springbootall.config;

import com.lyf.springbootall.config.conditional.NotTomcatEnvConditional;
import com.lyf.springbootall.servlet.MyServletInitListener;
import com.lyf.springbootall.servlet.MyWsContextListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {

    /**
     * 开启WebSocket支持
     */
    @Bean
    @Conditional(value = NotTomcatEnvConditional.class)
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

    @Bean
    public SystemLogger systemLogger() {
        return new SystemLogger();
    }
}
