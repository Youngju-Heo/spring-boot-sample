package com.example.webjsp.service;

import com.example.webjsp.model.City;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public interface CityService {
    City selectCity(UUID id);

    List<HashMap<String, Object>> selectAll();
    int selectCount();
}
