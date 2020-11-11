package org.rising.eurekaservice3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaService3Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaService3Application.class, args);
    }

}
