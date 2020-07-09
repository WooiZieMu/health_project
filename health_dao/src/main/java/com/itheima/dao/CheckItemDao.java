package com.itheima.dao;

import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : WoozieMu
 * @date : 2020/07/08 22:13
 **/
public interface CheckItemDao {
    /**
     * 添加一个检查项
     * @param checkItem
     */
    void add(CheckItem checkItem);

    /**
     * 根据搜索条件获取检查项集合
     * @param queryString
     * @return
     */
    List<CheckItem> selectByCondition(String queryString);

    /**
     * 根据id查找数据条数
     * @param id
     * @return
     */
    long findByCheckItemId(Integer id);

    /**
     * 根据id删除检查项
     * @param id
     */
    void delete(Integer id);

    void edit(CheckItem checkItem);
}
