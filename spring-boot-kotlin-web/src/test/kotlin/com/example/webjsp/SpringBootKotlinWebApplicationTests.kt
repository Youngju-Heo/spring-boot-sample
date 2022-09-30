package com.example.webjsp

import com.example.webjsp.service.CityService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.UUID

@SpringBootTest
class SpringBootKotlinWebApplicationTests {

  @Autowired
  lateinit var cityService: CityService

  @Test
  fun contextLoads() {
  }

  @Test
  @DisplayName("전체조회")
  fun selectAll() {
    val rslt = cityService.selectAll()
    log.info("{}", rslt)
  }

  @Test
  @DisplayName("선택항목 조회")
  fun selectCity() {
    val rslt = cityService.selectCity(UUID.fromString("3013b1de-2bb7-429f-bc7e-dcc6605efb30"))
    log.info("{}", rslt)
  }

  @Test
  @DisplayName("전체 항목 갯수 조회")
  fun selectCount() {
    val rslt = cityService.selectCount()
    log.info("total: {}", rslt)
  }

  companion object {
    val log: Logger = LoggerFactory.getLogger(SpringBootKotlinWebApplicationTests::class.java)
  }
}
