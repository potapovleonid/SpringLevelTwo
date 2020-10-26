package geekbrains.home.des.integration;

import geekbrains.home.des.domain.Purchase;
import geekbrains.home.des.domain.Sell;
import geekbrains.home.des.service.SellService;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class PurchaseActivator {

    private final SellService sellService;

    public PurchaseActivator(SellService sellService) {
        this.sellService = sellService;
    }

    @ServiceActivator(inputChannel = "purchaseChannel")
    public void listenPurchaseChannel(@Payload Purchase purchase, @Header Map<String, Object> headers){
        System.out.println("******************PURCHASE******************");
        System.out.println(purchase.toString());
        System.out.println("///////////////////HEADERS///////////////////");
        System.out.println(headers);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        List<Sell> sells = purchase.getSells();
        for (Sell s: sells) {
            sellService.save(s);
        }
    }
}
