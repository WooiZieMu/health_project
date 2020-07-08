package com.itheima.dao;

import com.itheima.pojo.CheckItem;

import java.util.List;

/**
 * @author : WoozieMu
 * @date : 2020/07/08 22:13
 **/
public interface CheckDao {
    List<CheckItem> findAll();
}
