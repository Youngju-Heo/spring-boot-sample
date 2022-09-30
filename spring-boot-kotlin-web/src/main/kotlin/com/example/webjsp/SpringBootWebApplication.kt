package com.example.webjsp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@SpringBootApplication
@EnableZuulProxy
@EnableConfigurationProperties
class SpringBootWebApplication

fun main(args: Array<String>) {
  runApplication<SpringBootWebApplication>(*args)
}
