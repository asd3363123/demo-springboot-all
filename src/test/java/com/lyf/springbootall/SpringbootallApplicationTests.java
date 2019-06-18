package com.lyf.springbootall;

import com.lyf.springbootall.websocket.DemoWebSocketClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;


@RunWith(SpringRunner.class)
@SpringBootTest
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
