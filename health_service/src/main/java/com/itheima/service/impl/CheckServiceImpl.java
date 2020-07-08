package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.dao.CheckDao;
import com.itheima.pojo.CheckItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : WoozieMu
 * @date : 2020/07/08 22:12
 **/
@Service(interfaceClass = CheckService.class)
@Transactional
public class CheckServiceImpl implements CheckService {
    @Autowired
    private CheckDao checkDao;
    @Override
    public List<CheckItem> findAll() {
        return checkDao.findAll();
    }
}
