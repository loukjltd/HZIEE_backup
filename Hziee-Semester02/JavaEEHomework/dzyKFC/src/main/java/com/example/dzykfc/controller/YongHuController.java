package com.example.dzykfc.controller;

import com.example.dzykfc.entity.QDGouWuChe;
import com.example.dzykfc.entity.WeiHao;
import com.example.dzykfc.entity.YongHu;
import com.example.dzykfc.mapper.YongHuMapper;
import com.example.dzykfc.service.WeiHaoService;
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
    @Autowired
    private WeiHaoService weiHaoService;
    //new
    //前端决定把用户名，用餐人数，位置编号给我
    @RequestMapping("newyongHuShuJuShuR")
    @ResponseBody
    public void newyongHuShuJuShuR(@RequestBody Map<String, Object> map){
        String dingId = map.get("dingId").toString();
        String userName = map.get("userName").toString();
        int yongHuRS = Integer.parseInt(map.get("yongHuRS").toString());
        int weiId = Integer.parseInt(map.get("weiId").toString());
        //将数据进行存入，同时返回0或桌号string类型。0：没有位置了
        yongHuService.newyongHuShuJuShuR(dingId,userName,yongHuRS,weiId);
    }
    //获得后端位置编号已经位置状态为1；已被使用
    @RequestMapping("newWeiIs1")
    @ResponseBody
    public List<WeiHao> newWeiIs1(){
        return weiHaoService.newWeiIs1();
    }


    //获得后端位置编号已经位置状态为0；未被使用
    @RequestMapping("newWeiIs0")
    @ResponseBody
    public List<WeiHao> newWeiIs0(){
        return weiHaoService.newWeiIs0();
    }





































    //old




    private String dingId=null;

    public String getDingId() {
        return dingId;
    }

    public void setDingId(String dingId) {
        this.dingId = dingId;
    }

    //这个方法用于将前端传过来dingId进行存储
    @RequestMapping("YongHuDingId")
    @ResponseBody
    public void YongHuDingId(@RequestBody Map<String,Object> map){
        String dingId = map.get("dingId").toString();
        setDingId(dingId);

    }


    //释放dingId
    @RequestMapping("wCYongHuNotDingId")
    @ResponseBody
    public void wCYongHuNotDingId(){
        setDingId(null);
    }














    @RequestMapping("yongHuShuJuXS")//前端用户信息显示需要的数据
    @ResponseBody
    public List<YongHu> yongHuShuJuXS(){
        return yongHuService.yongHuShuJuXS();
    }

    //这个方法用于放入用户表数据
    @RequestMapping("yongHuShuJuShuR")
    @ResponseBody
    public String zhuangTaiChaRuList(@RequestBody Map<String, Object> map){
//        String dingId = map.get("dingId").toString();
        String userName = map.get("userName").toString();
        int yongHuRS = Integer.parseInt(map.get("yongHuRS").toString());
        //将数据进行存入，同时返回0或桌号string类型。0：没有位置了
        return yongHuService.yongHuShuJuShuR(getDingId(),userName,yongHuRS);
    }
}
