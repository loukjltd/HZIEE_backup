package com.example.dzykfc.controller;


import com.example.dzykfc.entity.*;
import com.example.dzykfc.service.CaiPinBiaoService;
import com.example.dzykfc.service.GouWuCheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

//购物车控制端
@Controller
@CrossOrigin//？？？？？
public class GouWuCheController {
    @Autowired
    private GouWuCheService gouWuCheService;
    //创建一个dingId，将前端的dingId进行后端存储
    private String dingId=null;

    public String getDingId() {
        return dingId;
    }

    public void setDingId(String dingId) {
        this.dingId = dingId;
    }

    //这个方法用于将前端传过来dingId进行存储
    @RequestMapping("GouWuCheDingId")
    @ResponseBody
    public void gouWuCheDingId(@RequestBody Map<String,Object> map){
        String dingId = map.get("dingId").toString();
        setDingId(dingId);
    }



    //这个方法用于放入购物车数据
    @RequestMapping("gouWuCheChaRuList")//正式
    @ResponseBody
    public void gouWuCheChaRuList (@RequestBody Map<String, Object> map){
        int caiId = Integer.parseInt(map.get("caiId").toString());
//        String dingId = map.get("dingId").toString();

        gouWuCheService.gouWuCheChaRuList(caiId,getDingId());
    }



    //购物车数据获取
    @RequestMapping("gouWuCheShuJuXS")
    @ResponseBody
    public List<GouWuChe> gouWuCheShuJuXS(@RequestBody Map<String,Object> map){
//        String dingId  = map.get("dingId").toString();
        return gouWuCheService.gouWuCheShuJuXS(getDingId());
    }



//    //这个方法用于放入状态表数据
//    @RequestMapping("zhuangTaiChaRuList")
//    @ResponseBody
//    public void zhuangTaiChaRuList(@RequestBody Map<String, Object> map){
//        String dinId = map.get("dingId").toString();
//        int weiId = Integer.parseInt(map.get("weiId").toString());
//
//        gouWuCheService.ZhuangTaiChaRuList(dinId,weiId);
//    }


//    //状态数据获取
//    @RequestMapping("zhuangTaiShuJuXS")
//    @ResponseBody
//    public List<ZhuangTai> zhuangTaiShuJuXS(){
//        return gouWuCheService.zhuangTaiShuJuXS();
//    }
//




    //获得购物车的DingId，CaiPinShuLiang，状态表的ZhuangTai，DingTime，座位表的Wei。
    @RequestMapping("qDGouWuCheXS")//前端购物显示需要的数据
    @ResponseBody
    public List<QDGouWuChe> qDGouWuCheXS(@RequestBody Map<String,Object> map){
//        String dingId  = map.get("dingId").toString();

        return gouWuCheService.qDGouWuCheXS(getDingId());
    }
    @RequestMapping("qD2GouWuCheXS")//前端购物显示需要的数据，已经完成支付的数据
    @ResponseBody
    public List<QDGouWuChe> qD2GouWuCheXS(@RequestBody Map<String,Object> map){
//        String dingId  = map.get("dingId").toString();
        return gouWuCheService.qD2GouWuCheXS(getDingId());
    }
    @RequestMapping("qD3GouWuCheXS")//前端购物显示需要的数据，超时的数据
    @ResponseBody
    public List<QDGouWuChe> qD3GouWuCheXS(@RequestBody Map<String,Object> map){
//        String dingId  = map.get("dingId").toString();
        return gouWuCheService.qD3GouWuCheXS(getDingId());
    }



    //结账完成提供菜品数量总数和总价格
    @RequestMapping("wcDingDaiShuJuXS")
    @ResponseBody
    public List<WCDingDaiShuJuXS> wcDingDaiShuJuXS(@RequestBody Map<String,Object> map){
//        String dingId  = map.get("dingId").toString();
        return gouWuCheService.wcDingDaiShuJuXS(getDingId());
    }


    //对数据进行判断，判断是0还1，1商品数量+1，0商品数量-1
    //status表示商品增减状态
    @RequestMapping("shuLiang")
    @ResponseBody
    public void shuLiang(@RequestBody Map<String, Object> map){
        int caiId = Integer.parseInt(map.get("caiId").toString());
        int status = Integer.parseInt(map.get("status").toString());
//        String dingId  = map.get("dingId").toString();

        gouWuCheService.shuLiang(caiId,status,getDingId());
    }


    //完成支付后调用的方法
    @RequestMapping("wanChengZF")
    @ResponseBody
    public void wanChengZF(){
        gouWuCheService.wanChengZF(getDingId());
    }

    //释放dingId
    @RequestMapping("wCGouWuCheNotDingId")
    @ResponseBody
    public void wCGouWuCheNotDingId(){
        setDingId(null);
    }
}
