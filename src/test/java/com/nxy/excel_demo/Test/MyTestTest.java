package com.nxy.excel_demo.Test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.nxy.excel_demo.entity.User;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/6/15 15:56
 * @description 写入和读取excel的内容
 *
 **/
class MyTestTest {

    /**
     * 写入excel
     */

    //Method one
    @Test
    public void EasyExcelTest1() {
        /**
         * 实现excel写的操作
         * 设置文件地址和文件名称
         */
        String fileName = "F:\\today.xlsx";
        /**
         * 调用easyExcel的 写 方法
         * 第一个参数是文件路径，第二个参数是实体类
         * doWrite里面需要传入一个集合
         */
        EasyExcel.write(fileName, User.class).sheet("Student").doWrite(getData());
    }


    private static List<User> getData() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("Student" + i);
            user.setAge(i);
            list.add(user);
        }
        return list;
    }


    //Method two
    @Test
    public void EasyExcelTest2() {
        String fileName = "f:\\today2.xlsx";
        /**
         * 需要手动关闭数据流
         */
        //指定用那个class
        ExcelWriter excelWriter = EasyExcel.write(fileName, User.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("Student2").build();
        excelWriter.write(getData(), writeSheet);
        //close finish
        excelWriter.finish();
    }

    /**
     * 读取excel
     */
    class ExcelListener extends AnalysisEventListener<User>{

        @Override
        public void invoke(User user, AnalysisContext analysisContext) {
            System.out.println("***行内容***" + user);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext analysisContext) {
            System.out.println("******" + analysisContext);
        }

        @Override
        public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
            System.out.println("***表头***" + headMap);
        }
    }

    //Method one
    @Test
    public void getExcel1(){
        String fileName = "F:\\today.xlsx";
        EasyExcel.read(fileName, User.class, new ExcelListener()).sheet().doRead();
    }

    //Method two
    @Test
    public void getExcel2() throws Exception {
        String fileName = "f:\\today2.xlsx";
        /**
         * 需要手动关闭数据流
         */
        InputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
        ExcelReader excelReader = EasyExcel.read(inputStream, User.class, new ExcelListener()).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        //close finish
        excelReader.finish();

    }

}