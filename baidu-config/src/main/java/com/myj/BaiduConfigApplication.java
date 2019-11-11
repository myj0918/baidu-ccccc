package com.myj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class BaiduConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaiduConfigApplication.class, args);
    }

}
