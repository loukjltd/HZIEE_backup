package com.example.dzykfc.controller;

import com.example.dzykfc.entity.QDGouWuChe;
import com.example.dzykfc.entity.YongHu;
import com.example.dzykfc.mapper.YongHuMapper;
import com.example.dzykfc.service.YongHuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

//用户表控制器
@Controller
@CrossOrigin//？？？？？
public class YongHuController {

    @Autowired
    private YongHuService yongHuService;

    @RequestMapping("yongHuShuJuXS")//前端用户信息显示需要的数据
    @ResponseBody
    public List<YongHu> yongHuShuJuXS(){
        return yongHuService.yongHuShuJuXS();
    }

    //这个方法用于放入用户表数据
    @RequestMapping("yongHuShuJuShuR")
    @ResponseBody
    public void zhuangTaiChaRuList(@RequestBody Map<String, Object> map){
        String dingId = map.get("dingId").toString();
        String userName = map.get("userName").toString();
        int yongHuRS = Integer.parseInt(map.get("yongHuRS").toString());

        yongHuService.yongHuShuJuShuR(dingId,userName,yongHuRS);
    }
}
