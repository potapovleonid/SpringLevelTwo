package des.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import des.home.service.PredifinedService;
import des.home.service.RmdService;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        System.out.println("*******************************************");
        RmdService rmdService = context.getBean(RmdService.class);
        rmdService.getString();
        System.out.println("*******************************************");
        PredifinedService preService = context.getBean(PredifinedService.class);
        preService.getString();
        preService.printString();
        System.out.println("*******************************************");

        System.out.println("*******************************************");
        System.out.println("*******************************************");
    }
}
