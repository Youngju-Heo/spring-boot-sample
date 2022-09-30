package com.example.webjsp.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {
  @GetMapping("/")
  fun index(model: Model): String {
    val userLocale = LocaleContextHolder.getLocale().language;
    log.info("current lang: {}", userLocale)
    model.addAttribute("message", "Welcome to Simple Solution home page!")
    return "index"
  }

  @GetMapping("/user/list")
  fun userList(model: Model): String {
    val userLocale = LocaleContextHolder.getLocale().language;
    log.info("current lang: {}", userLocale)
    if (model == null) {
      log.warn("model not be null")
    }
    return "user/list"
  }

  companion object {
    val log: Logger = LoggerFactory.getLogger(HomeController::class.java)
  }
}
