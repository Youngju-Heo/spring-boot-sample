package com.example.webjsp.model

open class SearchDefault(
    var searchCondition: String = "",

    /** 검색Keyword  */
    var searchKeyword: String = "",

    /** 검색사용여부  */
    var searchUseYn: String = "",

    /** 현재페이지  */
    var pageIndex: Int = 1,

    /** 페이지갯수  */
    var pageUnit: Int = 10,

    /** 페이지사이즈  */
    var pageSize: Int = 10,

    /** firstIndex  */
    var firstIndex: Int = 1,

    /** lastIndex  */
    var lastIndex: Int = 1,

    /** recordCountPerPage  */
    var recordCountPerPage: Int = 10
)
