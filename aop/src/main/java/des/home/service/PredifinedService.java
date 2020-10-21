package des.home.service;

import des.home.aspect.MeasureMethod;
import org.springframework.stereotype.Service;

@Service
public class PredifinedService {
    @MeasureMethod
    public String getString(){
        System.out.println("call Predifined Service method get String");
        return "predifined des.home.service";
    }

    public void printString(){
        System.out.println("predifinedService method print string");
    }


}
