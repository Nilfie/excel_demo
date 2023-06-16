package com.nxy.excel_demo.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.nxy.excel_demo.entity.User;
import com.nxy.excel_demo.service.impl.TestServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/6/15 17:21
 * @description
 **/
public class ExcelListener extends AnalysisEventListener<User> {

    @Resource
    private TestServiceImpl testService;

    /**
     * 如果要存取数据库，service从监听器里面拿取list就需要有参构造，否则直接使用会报空指针异常
     */
    public ExcelListener(TestServiceImpl testService) {

        this.testService = testService;

    }


    @Override
    public void invoke(User user, AnalysisContext analysisContext) {
        //每20操作一次，分担服务器，浏览器的负担
        int i = testService.saveUser(user);
        if (i != 0) {
            Message.message = "success";
        } else {
            Message.message = "false";
        }
    }

    public static class Message {
        private static String message;

        public static String getMessage() {
            return Message.message;
        }

    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {}

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {}
}
