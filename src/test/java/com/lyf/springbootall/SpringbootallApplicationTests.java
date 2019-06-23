package com.lyf.springbootall;

import com.lyf.springbootall.websocket.DemoWebSocketClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * 用springbootTest会启动整个Spring application context 但是没有启动server。这个时候自然websocket就会报错。
 */
@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest
public class SpringbootallApplicationTests {

    @Test
    public void contextLoads() {
    }

//    @Test
//    public void testWebSocketClient() throws URISyntaxException {
//        URI uri = new URI("ws://127.0.0.1:8888/websocket/1");
//        DemoWebSocketClient client = new DemoWebSocketClient(uri);
//        client.connect();
//        client.send("This is a test !");
//    }

}
