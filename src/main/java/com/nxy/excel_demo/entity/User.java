package com.nxy.excel_demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/6/15 16:02
 **/

@Data
public class User {

    @ExcelProperty(value = "StudentName", index = 0)
    private String name;

    @ExcelProperty(value = "StudentAge", index = 1)
    private int age;
}
