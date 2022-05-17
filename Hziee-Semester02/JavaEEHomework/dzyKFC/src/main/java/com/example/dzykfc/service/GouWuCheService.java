package com.example.dzykfc.service;


import com.example.dzykfc.entity.*;
import com.example.dzykfc.mapper.GouWuCheMapper;
import com.example.dzykfc.mapper.WeiHaoMapper;
import com.example.dzykfc.mapper.YongHuMapper;
import com.example.dzykfc.mapper.ZhuangTaiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GouWuCheService {


    @Autowired
    private GouWuCheMapper gouWuCheMapper;
    @Autowired
    private YongHuMapper yongHuMapper;
    @Autowired
    private WeiHaoMapper weiHaoMapper;
    @Autowired
    private ZhuangTaiMapper zhuangTaiMapper;
    //-----------------new------------------
    public void   newgouWuCheChaRuList(int caiId ,int weiId) {
        //判断这个座位是否已经被使用
        int weizhuangTai = weiHaoMapper.setWeiIdgetweiZhuangTai(weiId);
        //如果位置是在使用的
        if (weizhuangTai == 1){
            //判断数据库有没有出现过这个菜品
            List<GouWuChe> gouWuCheList = new ArrayList<GouWuChe>();
            gouWuCheList = gouWuCheMapper.newDCIdCK(weiId, caiId);
            //通过weiId查询dingId
            String dingId = zhuangTaiMapper.setWeiIdgetdingId2(weiId);
            if (gouWuCheList.size() == 0) {
                //没有这个菜品进行插入
                gouWuCheMapper.chaRuShuJuGouWuChe(dingId, caiId);
            } else {
                //有则+1
                gouWuCheMapper.shuliangADD(caiId, dingId);

            }
        }
    }


    //对数据进行判断，判断是0还1，1商品数量+1，0商品数量-1
    public void newshuLiang(int caiId,int status,int weiId){//status表示商品增减状态
        //通过weiId查询dingId
        String dingId = zhuangTaiMapper.setWeiIdgetdingId2(weiId);
        if (status == 1){
            //菜品数量加1
            gouWuCheMapper.shuliangADD(caiId,dingId);
        }else {
            //但是当减的时候可能会减少为0，当为0时数据消失
            //查询购物车数据库符合caiId的目前数量
            List<GouWuChe> gouWuCheList = new ArrayList<GouWuChe>();
            gouWuCheList = gouWuCheMapper.gouWuCheShuJuXS(dingId);
            for (int i=0;i<gouWuCheList.size();i++){
                GouWuChe gouWuChe = new GouWuChe();
                gouWuChe = gouWuCheList.get(i);
                //如果菜品名相同，数量为1
                if (gouWuChe.getCaiId() == caiId && gouWuChe.getCaiPinShuLiang() == 1){
                    //删除购物车中符合的菜品记录
                    gouWuCheMapper.ifCaiIdCai(caiId,dingId);
                    break;
                }
            }
            //菜品数量减1
            gouWuCheMapper.shuliangSUB(caiId,dingId);
        }

    }


    //------------------------new and old-----------------
    //供给前端的购物车数据
    public List<QDGouWuChe> qDGouWuCheXS(int weiId){

        String dingId = zhuangTaiMapper.setWeiIdgetdingId2(weiId);

        //对总价进行一个计算
        List<QDGouWuChe> qdGouWuCheZhong = new ArrayList<QDGouWuChe>();
        qdGouWuCheZhong = gouWuCheMapper.qDGouWuCheXS(dingId);

        for (int i = 0; i < qdGouWuCheZhong.size();i++){
            QDGouWuChe qdhqgg = new QDGouWuChe();
            qdhqgg = qdGouWuCheZhong.get(i);

            int caiPinShuLiang = qdhqgg.getCaiPinShuLiang();

            float caiJG = qdhqgg.getCaiJG();
            float zongJG = caiJG*caiPinShuLiang;
            qdhqgg.setZongJG(zongJG);
            qdGouWuCheZhong.set(i,qdhqgg);

        }
        return qdGouWuCheZhong;
    }

    //这个方法是前端完成支付时调用的方法,状态重置
    public void wanChengZF(int weiId){

        String dingId = zhuangTaiMapper.setWeiIdgetdingId2(weiId);

        //将在线条的用户订单状态改为已支付1
        gouWuCheMapper.setdingdanWCZF(dingId);
        //同时还要将在线的用户的状态改为不在线0
        yongHuMapper.setYongHuZT(dingId);
        //并且将桌子的状态改回0
        yongHuMapper.weiIdGaiZT(weiId);
    }

    //结账完成提供菜品数量总数和总价格
    public List<WCDingDaiShuJuXS> wcDingDaiShuJuXS(int weiId){
        List<WCDingDaiShuJuXS> a = new ArrayList<WCDingDaiShuJuXS>();

        WCDingDaiShuJuXS wcDingDaiShuJuXS = new WCDingDaiShuJuXS();

        int ShuLiangZhong=0;
        float JGZhong=0;
        String dingId = zhuangTaiMapper.setWeiIdgetdingId2(weiId);


        List<QDGouWuChe> qdGouWuCheZhong = new ArrayList<QDGouWuChe>();
        qdGouWuCheZhong = gouWuCheMapper.qDGouWuCheXS(dingId);

        for (int i = 0; i < qdGouWuCheZhong.size();i++){
            QDGouWuChe qdhqgg = new QDGouWuChe();
            qdhqgg = qdGouWuCheZhong.get(i);

            int caiPinShuLiang = qdhqgg.getCaiPinShuLiang();

            float caiJG = qdhqgg.getCaiJG();
            float zongJG = caiJG*caiPinShuLiang;

            ShuLiangZhong = ShuLiangZhong + caiPinShuLiang;
            JGZhong =JGZhong + zongJG;

        }

        wcDingDaiShuJuXS.setShuLiangZhong(ShuLiangZhong);
        wcDingDaiShuJuXS.setJingEZhong(JGZhong);

        a.add(wcDingDaiShuJuXS);

        return a;
    }
















    //-----------------old---------------------



    //这个方法用于放入购物车数据
    public void   gouWuCheChaRuList(int caiId ,String dingId){
        //判断数据库有没有出现过这个菜品
        List<GouWuChe> gouWuCheList = new ArrayList<GouWuChe>();
        gouWuCheList = gouWuCheMapper.DCIdCK(dingId,caiId);

        if ( gouWuCheList.size() == 0){
            //没有这个菜品进行插入
            gouWuCheMapper.chaRuShuJuGouWuChe(dingId,caiId);
        }else {
            //有则+1
            gouWuCheMapper.shuliangADD(caiId,dingId);
        }




//        //获得数据库中现在登录的人的dingId直接将dingId传入方法中
//        List<YongHu> yongHuList = new ArrayList<YongHu>();
//        yongHuList = yongHuMapper.yongHuShuJuXS();
//        for (int i = 0;i< yongHuList.size();i++){
//            YongHu YH = new YongHu();
//            YH = yongHuList.get(i);
//            if (YH.getYHZTID() == 1){
//
//                //判断数据库有没有出现过这个菜品
//                List<GouWuChe> gouWuCheList = new ArrayList<GouWuChe>();
//                gouWuCheList = gouWuCheMapper.DCIdCK(YH.getDingId(),caiId);
//
//                if ( gouWuCheList.size() == 0){
//                    //没有这个菜品进行插入
//                    gouWuCheMapper.chaRuShuJuGouWuChe(YH.getDingId(),caiId);
//                    break;//只执行一次
//                }else {
//                    //有则+1
//                    gouWuCheMapper.shuliangADD(caiId);
//                }
//            }
//        }

    }

//    //这个方法用于放入状态表数据
//    public void ZhuangTaiChaRuList(String dingId, int weiId){
//
//        //时间获取
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String createDate = sdf.format(new java.util.Date());
//
//        gouWuCheMapper.chaRuShuJuZhuangTai(dingId,weiId,createDate);
//    }

    //状态数据获取
    public List<ZhuangTai> zhuangTaiShuJuXS(){
        return gouWuCheMapper.zhuangTaiShuJuXS();
    }
    //购物车数据获取
    public List<GouWuChe> gouWuCheShuJuXS(String dingId){
        return gouWuCheMapper.gouWuCheShuJuXS(dingId);
    }








    //供给前端的购物车数据，已经完成支付的
    public List<QDGouWuChe> qD2GouWuCheXS(String dingId){

        //对总价进行一个计算
        List<QDGouWuChe> qdGouWuCheZhong = new ArrayList<QDGouWuChe>();
        qdGouWuCheZhong = gouWuCheMapper.qD2GouWuCheXS(dingId);

        for (int i = 0; i < qdGouWuCheZhong.size();i++){
            QDGouWuChe qdhqgg = new QDGouWuChe();
            qdhqgg = qdGouWuCheZhong.get(i);

            int caiPinShuLiang = qdhqgg.getCaiPinShuLiang();

            float caiJG = qdhqgg.getCaiJG();
            float zongJG = caiJG*caiPinShuLiang;
            qdhqgg.setZongJG(zongJG);
            qdGouWuCheZhong.set(i,qdhqgg);

        }
        return qdGouWuCheZhong;
    }
    //供给前端的购物车数据，超时的
    public List<QDGouWuChe> qD3GouWuCheXS(String dingId){

        //对总价进行一个计算
        List<QDGouWuChe> qdGouWuCheZhong = new ArrayList<QDGouWuChe>();
        qdGouWuCheZhong = gouWuCheMapper.qD3GouWuCheXS(dingId);

        for (int i = 0; i < qdGouWuCheZhong.size();i++){
            QDGouWuChe qdhqgg = new QDGouWuChe();
            qdhqgg = qdGouWuCheZhong.get(i);

            int caiPinShuLiang = qdhqgg.getCaiPinShuLiang();

            float caiJG = qdhqgg.getCaiJG();
            float zongJG = caiJG*caiPinShuLiang;
            qdhqgg.setZongJG(zongJG);
            qdGouWuCheZhong.set(i,qdhqgg);

        }
        return qdGouWuCheZhong;
    }














    //对数据进行判断，判断是0还1，1商品数量+1，0商品数量-1
    public void shuLiang(int caiId,int status,String dingId){//status表示商品增减状态
        if (status == 1){
            //菜品数量加1
            gouWuCheMapper.shuliangADD(caiId,dingId);
        }else {
            //但是当减的时候可能会减少为0，当为0时数据消失
            //查询购物车数据库符合caiId的目前数量
            List<GouWuChe> gouWuCheList = new ArrayList<GouWuChe>();
            gouWuCheList = gouWuCheMapper.gouWuCheShuJuXS(dingId);
            for (int i=0;i<gouWuCheList.size();i++){
                GouWuChe gouWuChe = new GouWuChe();
                gouWuChe = gouWuCheList.get(i);
                //如果菜品名相同，数量为1
                if (gouWuChe.getCaiId() == caiId && gouWuChe.getCaiPinShuLiang() == 1){
                    //删除购物车中符合的菜品记录
                    gouWuCheMapper.ifCaiIdCai(caiId,dingId);
                    break;
                }
            }
            //菜品数量减1
            gouWuCheMapper.shuliangSUB(caiId,dingId);
        }

    }

}
//    List<ZhuangTai> zhuangTaiList = new ArrayList<ZhuangTai>();
//        zhuangTaiList = yongHuMapper.zhuangTaiXS();
//                for (int i=0; i < zhuangTaiList.size() ; i++){
//        ZhuangTai ZT = new ZhuangTai();
//        ZT = zhuangTaiList.get(i);
//        if (ZT.getZhuangTai() == )
//        }