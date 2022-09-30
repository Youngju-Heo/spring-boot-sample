package com.example.webjsp.mapper

import com.example.webjsp.model.City
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import java.util.*
import kotlin.collections.HashMap

@Mapper
interface CityMapper {
  fun selectCity(@Param("id") id: UUID): City
  fun selectAll(): List<HashMap<String, Any>>
  fun selectCount(): Int
}
