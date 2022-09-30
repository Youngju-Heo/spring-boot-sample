package com.example.webjsp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDefault {
  /**
   * 검색조건
   */
  String searchCondition = "";

  /**
   * 검색Keyword
   */
  String searchKeyword = "";

  /**
   * 검색사용여부
   */
  String searchUseYn = "";

  /**
   * 현재페이지
   */
  int pageIndex = 1;

  /**
   * 페이지갯수
   */
  int pageUnit = 10;

  /**
   * 페이지사이즈
   */
  int pageSize = 10;

  /**
   * firstIndex
   */
  int firstIndex = 1;

  /**
   * lastIndex
   */
  int lastIndex = 1;

  /**
   * recordCountPerPage
   */
  int recordCountPerPage = 10;
}
