package com.example.webjsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableConfigurationProperties
@EnableZuulProxy
public class SpringBootWebApplication extends ServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootWebApplication.class, args);
  }

}
