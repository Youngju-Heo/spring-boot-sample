package com.example.webjsp;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("app.config")
public class AppConfig {
  String defaultLocale;
}
