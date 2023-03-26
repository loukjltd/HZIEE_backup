package com.example.dzykfc.controller;

import com.example.dzykfc.entity.ZhuangTai;
import com.example.dzykfc.service.ZhuangTaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

//状态表控制端
@Controller
@CrossOrigin//？？？？？
public class ZhuangTaiController {

    @Autowired
    private ZhuangTaiService zhuangTaiService;


    private String dingId=null;

    public String getDingId() {
        return dingId;
    }

    public void setDingId(String dingId) {
        this.dingId = dingId;
    }

    //这个方法用于将前端传过来dingId进行存储
    @RequestMapping("ZhuangTaiDingId")
    @ResponseBody
    public void ZhuangTaiDingId(@RequestBody Map<String,Object> map){
        String dingId = map.get("dingId").toString();
        setDingId(dingId);
    }

    //释放dingId
    @RequestMapping("wCZhuangTaiNotDingId")
    @ResponseBody
    public void wCZhuangTaiNotDingId(){
        setDingId(null);
    }







    //对订单时间进行检查
    @RequestMapping("chaoShiXG")
    @ResponseBody
    public void chaoShiXG(){
        zhuangTaiService.chaoShiXG();
    }
    //dingId超时检测
    @RequestMapping("choShiJC")
    @ResponseBody
    public List<ZhuangTai> chaoShiJC(@RequestBody Map<String, Object> map){
//        String dingId = map.get("dingId").toString();
        return zhuangTaiService.chaoShiJC(getDingId());
    }

}
