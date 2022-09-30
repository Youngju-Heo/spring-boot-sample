package com.example.webjsp.service.impl

import com.example.webjsp.mapper.CityMapper
import com.example.webjsp.model.City
import com.example.webjsp.service.CityService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class CityServiceImpl: CityService {

    @Autowired
    lateinit var cityMapper: CityMapper

    override fun selectCity(id: UUID): City {
        val v = cityMapper.selectCity(id)
        log.debug("select-city: {}", v)

        return v
    }

    override fun selectAll(): List<HashMap<String, Any>> {
        val src = cityMapper.selectAll()
        log.debug("select-all dump: {}", src)
        return src
    }

    override fun selectCount(): Int {
        val cnt = cityMapper.selectCount()
        log.debug("select-count: {}", cnt)
        return cnt
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(CityServiceImpl::class.java)
    }
}