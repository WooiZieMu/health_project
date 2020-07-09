package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.CheckItemDao;
import com.itheima.entity.PageResult;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author : WoozieMu
 * @date : 2020/07/08 22:12
 **/
@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemDao checkItemDao;


    @Override
    public PageResult findByPage(Integer currentPage, Integer pageSize, String queryString) {
        // 1：完成对分页初始化工作
        PageHelper.startPage(currentPage, pageSize);
        // 2：查询
        List<CheckItem> list = checkItemDao.selectByCondition(queryString);
        // 3：后处理，PageHelper会根据查询的结果再封装成PageHealper对应的实体类
        PageInfo pageInfo = new PageInfo(list);
        // 组织PageResult
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 添加一个检查项
     * @param checkItem
     */
    @Override
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    /**
     * 根据id删除检查项,与检查组表存在关联则抛出运行时异常并友好提示
     * @param id
     */
    @Override
    public void delete(Integer id) {
        //1.查找t_checkgroup_checkitem表
        long count = checkItemDao.findByCheckItemId(id);
        //2.判断是否存在关联数据
        if (count>0) {
            throw new RuntimeException("关联检查组表不可删除");
        }
        //3.执行删除操作
        checkItemDao.delete(id);
    }

    /**
     * 修改checkItem检查项
     * @param checkItem
     */
    @Override
    public void edit(CheckItem checkItem) {
        checkItemDao.edit(checkItem);
    }
}
