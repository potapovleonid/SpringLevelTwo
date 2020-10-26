package geekbrains.home.des.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;

@Configuration
@ImportResource("integration/http-sell-gateway.xml")
public class IntegrationConfig {

    @Bean
    public DirectChannel channel(){
        return new DirectChannel();
    }
}
