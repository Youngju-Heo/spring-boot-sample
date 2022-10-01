package com.example.webjsp

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 *  Application 전역 설정을 위한 클래스
 *
 *  application.yml 에 app.config 섹션의 항목을 설정에 사용할 수 있도록 기능제공.
 */
@ConfigurationProperties("app.config")
class AppConfig {
  /**
   * 기본 언어 설정값
   */
  lateinit var defaultLocale: String
}
