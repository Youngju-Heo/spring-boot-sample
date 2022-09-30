package com.example.webjsp.controller;

import com.example.webjsp.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
public class CityController {

    private final CityService cityService;
    public CityController(@Autowired CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/city/list")
    public String list(Model model) {
        List<HashMap<String, Object>> items = cityService.selectAll();
        model.addAttribute("cityItems", items);
        log.debug("/city/list items: {}",items);
        return "city/list";
    }
}
