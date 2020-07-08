package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckItem;
import com.itheima.service.impl.CheckService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : WoozieMu
 * @date : 2020/07/08 22:09
 **/
@RestController
@RequestMapping("check")
public class CheckController {
    @Reference
    private CheckService checkService;
    @RequestMapping("findAll")
    public Result findAllCheckItem() {
        try {
            List<CheckItem> dataList = checkService.findAll();
            return new Result(true, MessageConstant.EDIT_CHECKITEM_SUCCESS, dataList);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_CHECKITEM_FAIL);
        }

    }
}
