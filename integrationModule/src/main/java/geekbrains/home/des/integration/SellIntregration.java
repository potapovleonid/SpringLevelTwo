package geekbrains.home.des.integration;

import geekbrains.home.des.domain.Sell;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SellIntregration {

    @ServiceActivator(inputChannel = "channel")
    public void listenChanel(@Payload List<Sell> sells, @Headers Map<String, Object> headers){
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        System.out.println("*************SELS*************");
        System.out.println(sells);
        System.out.println("*************HEADERS*************");
        headers.forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }

}
