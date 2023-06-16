package com.nxy.excel_demo.controller;

import com.alibaba.excel.EasyExcel;
import com.nxy.excel_demo.entity.User;
import com.nxy.excel_demo.service.impl.TestServiceImpl;
import com.nxy.excel_demo.util.ExcelListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/6/16 10:31
 * @description
 **/
@RestController
public class TestController {

    @Resource
    private TestServiceImpl testService;

    @RequestMapping("/save")
    public String getExcel1() {
        String fileName = "F:\\today.xlsx";
        EasyExcel.read(fileName, User.class, new ExcelListener(testService)).sheet().doRead();
        return ExcelListener.Message.getMessage();
    }
}
