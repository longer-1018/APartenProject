package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient//此注解才能实现微服务注册到注册中心
public class AppStartApplication {

    public static void main(String[] args){

        SpringApplication.run(AppStartApplication.class,args);
    }

}
