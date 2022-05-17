package com.example.dzykfc.controller;


import com.example.dzykfc.entity.CaiPinBiao;
import com.example.dzykfc.entity.FenLei;
import com.example.dzykfc.service.CaiPinBiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

//菜品后端控制器
@Controller
@CrossOrigin//？？？？？
public class CaiPinController {
    @Autowired
    private CaiPinBiaoService caiPinBiaoService;

    private String dingId=null;

    public String getDingId() {
        return dingId;
    }

    public void setDingId(String dingId) {
        this.dingId = dingId;
    }

    //这个方法用于将前端传过来dingId进行存储
    @RequestMapping("CaiPinDingId")
    @ResponseBody
    public void CaiPinDingId(@RequestBody Map<String,Object> map){
        String dingId = map.get("dingId").toString();
        setDingId(dingId);
    }

    //释放dingId
    @RequestMapping("wCCaiPinNotDingId")
    @ResponseBody
    public void wCCaiPinNotDingId(){
        setDingId(null);
    }








    //取出数据库caipin表的数据
    @RequestMapping("caiPinBiao")
    @ResponseBody
    public List<CaiPinBiao> getCaiPinBiao(){
        return caiPinBiaoService.getCaiPinBiaoList();
    }

    @RequestMapping("fenLei")
    @ResponseBody
    public List<FenLei> getFenLei(){
        return caiPinBiaoService.getFenLeiList();
    }
}
