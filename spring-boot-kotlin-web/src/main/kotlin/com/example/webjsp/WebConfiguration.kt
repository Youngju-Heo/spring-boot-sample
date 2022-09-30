package com.example.webjsp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.i18n.CookieLocaleResolver
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor
import java.util.*

@Configuration
class WebConfiguration: WebMvcConfigurer {

    @Bean
    fun appConfig():AppConfig {
        return AppConfig()
    }

    @Bean
    fun localeResolver(@Autowired appConfig: AppConfig): LocaleResolver? {
        val resolver = CookieLocaleResolver()
        resolver.setDefaultLocale(Locale(appConfig.defaultLocale))
        resolver.cookiePath = "/"
        resolver.cookieName = "user-locale"
        val ageInSeconds = 30 * 24 * 60 * 60
        resolver.cookieMaxAge = ageInSeconds
        return resolver
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        val lci = LocaleChangeInterceptor()
        lci.paramName = "lang"
        registry.addInterceptor(lci)
    }
}