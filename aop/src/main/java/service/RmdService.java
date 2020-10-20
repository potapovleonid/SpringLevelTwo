package service;

import aspect.MeasureMethod;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RmdService {
    @MeasureMethod
    public String getString(){
        System.out.println("call RNDService.getString");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return UUID.randomUUID().toString();
    }
}
