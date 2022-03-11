package com.demo456.controller;

import com.demo456.entity.ErpFunc;
import com.demo456.entity.ErpOrgan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author loukj
 */
@Controller
public class TestTableController {
    @RequestMapping("getErpOrgan")
    @ResponseBody
    public List<ErpOrgan> getErpOrgan(HttpServletRequest request) {
        List<ErpOrgan> erpOrganList = new ArrayList<ErpOrgan>();
        for (int i = 0; i < 3; i++) {
            ErpOrgan erpOrgan = new ErpOrgan();
            erpOrgan.setFstId(i + 4);
            erpOrgan.setFstName("P" + (i + 4));
            erpOrganList.add(erpOrgan);
        }
        return erpOrganList;
    }

    @RequestMapping("getErpFunc")
    @ResponseBody
    public List<ErpFunc> getErpFunc(HttpServletRequest request) {
        List<ErpFunc> erpFuncList = new ArrayList<ErpFunc>();
        for (int i = 0; i < 2; i++) {
            ErpFunc erpFunc = new ErpFunc();
            erpFunc.setFuncId(i + 1);
            erpFunc.setFuncName("P" + (i + 1));
            erpFuncList.add(erpFunc);
        }
        return erpFuncList;
    }

    @RequestMapping("showLogin")
    public String showLogin() {
        return "login";
    }
}


