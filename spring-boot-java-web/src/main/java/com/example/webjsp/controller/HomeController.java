package com.example.webjsp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        String userLocale = LocaleContextHolder.getLocale().getLanguage();
        log.info("/index: {}\n{}", userLocale, LocaleContextHolder.getLocale());
        model.addAttribute("message", "Welcome to Simple Solution home page!");
        return "index";
    }

    @GetMapping("/user/list")
    public String userList(Model model) {
        String userLocale = LocaleContextHolder.getLocale().getLanguage();
        log.info("/user/list: {}", userLocale);
        if (model == null) {
            log.warn("model not be null");
        }
        return "user/list";
    }
}
