package com.gyqstd.visualassets.common;

import lombok.Data;

/**
 * 分页请求包装类
 * 有了这个类以后，只要以后需要用到分页，就可以直接继承这个类，就默认有了这些字段
 */
@Data
public class QueryPageRequest {

    /**
     * 当前页号
     */
    private int current = 1;

    /**
     * 页面大小
     */
    private int pageSize = 10;

    /**
     * 排序字段
     */
    private String sortField;

    /**
     * 排序顺序（默认降序）
     */
    private String sortOrder = "descend";
}