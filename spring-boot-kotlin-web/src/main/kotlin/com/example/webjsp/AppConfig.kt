package com.example.webjsp

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("app.config")
class AppConfig {
    lateinit var defaultLocale: String
}