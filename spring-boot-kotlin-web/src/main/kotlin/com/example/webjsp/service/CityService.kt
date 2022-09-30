package com.example.webjsp.service

import com.example.webjsp.model.City
import java.util.*

interface CityService {
    fun selectCity(id: UUID): City
    fun selectAll(): List<HashMap<String, Any>>
    fun selectCount(): Int
}