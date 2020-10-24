package geeekbrains.home.des;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigCloudServer {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCloudServer.class, args);
    }
}
