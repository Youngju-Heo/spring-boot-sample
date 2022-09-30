package com.example.webjsp.controller

import com.example.webjsp.model.City
import com.example.webjsp.service.CityService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.collections.HashMap

@RestController
@RequestMapping("/api/city")
class ApiCityController {
    @Autowired
    lateinit var cityService: CityService

    @GetMapping("/select")
    fun select(): City {
        val city = cityService.selectCity(UUID.fromString("3013b1de-2bb7-429f-bc7e-dcc6605efb30"))
        log.debug("get /select")
        return city
    }

    @GetMapping("/select-all")
    fun selectAll(): List<HashMap<String, Any>> {
        val cities =cityService.selectAll();
        log.debug("get /select-all")
        return cities
    }

    @GetMapping("/select-count")
    fun selectCount(): Int {
        val cnt = cityService.selectCount()
        log.debug("get /select-count")
        return cnt
    }

    companion object{
        val log: Logger = LoggerFactory.getLogger(ApiCityController::class.java)
    }
}