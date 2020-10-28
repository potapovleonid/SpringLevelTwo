package geekbrains.home.des;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SellSpringApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(SellSpringApplication.class, args);
    }
}
