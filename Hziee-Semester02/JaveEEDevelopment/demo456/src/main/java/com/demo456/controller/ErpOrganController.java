package com.demo456.controller;

import com.demo456.entity.ErpOrgan;
import com.demo456.service.ErpOrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author loukj
 */
@Controller
public class ErpOrganController {
    @Autowired
    private ErpOrganService erpOrganService;

    @RequestMapping("getErpOrganList")
    @ResponseBody
    public List<ErpOrgan> getErpOrganList() {
        return erpOrganService.getErpOrganList();
    }
}
