package com.example.webjsp;

import com.example.webjsp.model.City;
import com.example.webjsp.service.CityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;


@SpringBootTest
class SpringBootWebApplicationTests {
    static final Logger log = LoggerFactory.getLogger(SpringBootWebApplicationTests.class);
    private CityService cityService;

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @Test
    @DisplayName("전체조회")
    void selectAllCity() {
        List<HashMap<String, Object>> rslt = cityService.selectAll();
        log.info("{}", rslt);
    }

    @Test
    @DisplayName("선택항목 조회")
    void selectCity() {
        City rslt = cityService.selectCity(UUID.fromString("3013b1de-2bb7-429f-bc7e-dcc6605efb30"));

        log.info("select result: {}", rslt);
    }

    @Test
    @DisplayName("전체 항목 갯수 조회")
    void selectCount() throws Exception {
        int rslt = cityService.selectCount();
        ObjectMapper mapper = new ObjectMapper();
        log.info("total: {}", mapper.writeValueAsString(rslt));
    }

}
