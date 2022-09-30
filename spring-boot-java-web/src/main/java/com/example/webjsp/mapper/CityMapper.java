package com.example.webjsp.mapper;

import com.example.webjsp.model.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Mapper
public interface CityMapper {
  City selectCity(@Param("id") UUID id);

  List<HashMap<String, Object>> selectAll();

  int selectCount();
}
