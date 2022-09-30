package com.example.webjsp.controller

import com.example.webjsp.service.CityService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/city")
class CityController {

  @Autowired
  lateinit var cityService: CityService

  @GetMapping("/list")
  fun list(model: Model): String {
    val items = cityService.selectAll()
    model.addAttribute("cityItems", items)
    log.trace("/city/list items: {}", items)
    return "city/list"
  }

  companion object {
    val log: Logger = LoggerFactory.getLogger(CityController::class.java)
  }
}
