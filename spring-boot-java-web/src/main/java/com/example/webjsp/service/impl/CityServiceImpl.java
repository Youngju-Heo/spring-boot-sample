package com.example.webjsp.service.impl;

import com.example.webjsp.mapper.CityMapper;
import com.example.webjsp.model.City;
import com.example.webjsp.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@Transactional
public class CityServiceImpl implements CityService {

    private final CityMapper cityMapper;

    public CityServiceImpl(@Autowired CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    @Override
    public City selectCity(UUID id) {
        City city = cityMapper.selectCity(id);
        log.debug("select-city: {}", city);
        return city;
    }

    @Override
    public List<HashMap<String, Object>> selectAll() {
        List<HashMap<String, Object>> rslt = cityMapper.selectAll();
        log.debug("select-all dump: {}", rslt);

        return rslt;
    }

    @Override
    public int selectCount() {
        int cnt = cityMapper.selectCount();
        log.debug("select-count: {}",cnt);
        return cnt;
    }
}
