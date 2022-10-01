package com.example.webjsp.model

import java.sql.Timestamp
import java.util.UUID

/**
 * Data VO of City
 *
 * City 정보를 담는 data 클래스
 *
 */
data class City(
  // ID
  var id: UUID,
  // 시/군/구 명
  var name: String,
  // 시/도 명
  var state: String,
  // 국가명
  var country: String,
  // 등록일시
  var insTime: Timestamp
)
