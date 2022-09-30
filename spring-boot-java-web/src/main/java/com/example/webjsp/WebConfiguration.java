package com.example.webjsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

  @Bean
  public AppConfig appConfig() {
    return new AppConfig();
  }

  @Bean
  public LocaleResolver localeResolver(@Autowired AppConfig appConfig) {
    CookieLocaleResolver resolver = new CookieLocaleResolver();
    resolver.setDefaultLocale(new Locale(appConfig.defaultLocale));
    resolver.setCookiePath("/");
    resolver.setCookieName("user-locale");
    int ageInSeconds = 30 * 24 * 60 * 60;
    resolver.setCookieMaxAge(ageInSeconds);
    return resolver;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
    lci.setParamName("lang");
    registry.addInterceptor(lci);
  }

  @Bean
  @Order(Ordered.HIGHEST_PRECEDENCE)
  public FilterRegistrationBean<CharacterEncodingFilter> characterEncodingFilterRegistration() {
    CharacterEncodingFilter filter = new CharacterEncodingFilter();
    filter.setEncoding("UTF-8"); // use your preferred encoding
    filter.setForceEncoding(true); // force the encoding

    FilterRegistrationBean<CharacterEncodingFilter> registrationBean =
      new FilterRegistrationBean<>(filter); // register the filter
    registrationBean.addUrlPatterns("/*"); // set preferred url
    return registrationBean;
  }
}
