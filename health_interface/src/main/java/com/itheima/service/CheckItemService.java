package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.pojo.CheckItem;


/**
 * @author : WoozieMu
 * @date : 2020/07/08 22:21
 **/
public interface CheckItemService {
    PageResult findByPage(Integer currentPage, Integer pageSize, String queryString);

    void add(CheckItem checkItem);

    void delete(Integer id);

    void edit(CheckItem checkItem);
}
