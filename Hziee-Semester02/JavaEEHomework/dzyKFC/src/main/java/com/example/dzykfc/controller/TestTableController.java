package com.example.dzykfc.controller;


import com.example.dzykfc.entity.TestTable;
import com.example.dzykfc.service.TestTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestTableController {

    @Autowired
    private TestTableService testTableService;
    //取出数据库caipin表的数据
    @RequestMapping("SJMKFC")
    @ResponseBody
    public List<TestTable> getTestTableListKFC(){
        return testTableService.getTestTableList();
    }


    @RequestMapping("test_project")
    @ResponseBody
    public String TestPro(){
        return "this is SJM";
    }

    @RequestMapping("getErpOrgan")
    @ResponseBody
    public List<TestTable> getTestTable(HttpServletRequest request){



        List<TestTable> testTableList = new ArrayList<TestTable>();
        for (int i=0;i<3;i++){
            TestTable testTable = new TestTable();
            testTable.setCaiId(i+4);
            testTable.setCai("P" + (i+4));
            testTableList.add(testTable);

        }
        return testTableList;
    }

    //后端网页测试
    @RequestMapping("showLogin")
    public String showLogin(){
        return "login";
    }
}
