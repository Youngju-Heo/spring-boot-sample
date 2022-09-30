package com.example.webjsp.controller;

import com.example.webjsp.model.City;
import com.example.webjsp.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/city")
public class ApiCityController {
  private final CityService cityService;

  public ApiCityController(@Autowired CityService cityService) {
    this.cityService = cityService;
  }

  @GetMapping("/select")
  public City select(@CookieValue(value = "user-locale", defaultValue = "ko", required = false) String userLocale) {
    log.debug("/select: locale={}", userLocale);
    return cityService.selectCity(UUID.fromString("3013b1de-2bb7-429f-bc7e-dcc6605efb30"));
  }

  @GetMapping("/select-all")
  public List<HashMap<String, Object>> selectAll() {
    return cityService.selectAll();
  }

  @GetMapping("/select-count")
  public int selectCount() {
    log.debug("/select-count");
    return cityService.selectCount();
  }
}
