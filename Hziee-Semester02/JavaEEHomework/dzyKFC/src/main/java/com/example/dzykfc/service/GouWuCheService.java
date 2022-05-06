package com.example.dzykfc.service;


import com.example.dzykfc.entity.*;
import com.example.dzykfc.mapper.GouWuCheMapper;
import com.example.dzykfc.mapper.YongHuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class GouWuCheService {


    @Autowired
    private GouWuCheMapper gouWuCheMapper;
    @Autowired
    private YongHuMapper yongHuMapper;

    //这个方法是前端完成支付时调用的方法
    public void wanChengZF(){
        //首先获取用户表的信息，对用户表的用户的状态进行判断用户目前的状态
        List<YongHu> yongHuList = new ArrayList<YongHu>();
        yongHuList = yongHuMapper.yongHuShuJuXS();
        //for循环遍历所有的用户
        for (int i = 0;i < yongHuList.size();i++){
            YongHu YH = new YongHu();
            YH = yongHuList.get(i);
            if (YH.getYHZTID() == 1){
                //将这个用户的weiId找到weiId
                int weiId = yongHuMapper.dingGetWei(YH.getDingId());

                //将在线条的用户订单状态改为已支付1
                gouWuCheMapper.setdingdanWCZF(YH.getDingId());
                //同时还要将在线的用户的状态改为不在线0
                yongHuMapper.setYongHuZT(YH.getDingId());
                //并且将桌子的状态改回0
                yongHuMapper.weiIdGaiZT(weiId);
                //只执行一次
                break;
            }
        }

    }


    //这个方法用于放入购物车数据
    public void   gouWuCheChaRuList(int caiId){

        //获得数据库中现在登录的人的dingId直接将dingId传入方法中
        List<YongHu> yongHuList = new ArrayList<YongHu>();
        yongHuList = yongHuMapper.yongHuShuJuXS();
        for (int i = 0;i< yongHuList.size();i++){
            YongHu YH = new YongHu();
            YH = yongHuList.get(i);
            if (YH.getYHZTID() == 1){

                //判断数据库有没有出现过这个菜品
                List<GouWuChe> gouWuCheList = new ArrayList<GouWuChe>();
                gouWuCheList = gouWuCheMapper.DCIdCK(YH.getDingId(),caiId);

                if ( gouWuCheList.size() == 0){
                    //没有这个菜品进行插入
                    gouWuCheMapper.chaRuShuJuGouWuChe(YH.getDingId(),caiId);
                    break;//只执行一次
                }else {
                    //有则+1
                    gouWuCheMapper.shuliangADD(caiId);
                }
            }
        }

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
    public List<GouWuChe> gouWuCheShuJuXS(){
        return gouWuCheMapper.gouWuCheShuJuXS();
    }






    //供给前端的购物车数据
    public List<QDGouWuChe> qDGouWuCheXS(){
        List<YongHu> yongHus = new ArrayList<YongHu>();
        yongHus = yongHuMapper.yongHuShuJuXS();//获得用户信息用于判断用户是否在线
        YongHu zxID = new YongHu();
        //判断用户是否在线
        for (int j = 0; j < yongHus.size(); j++){
            YongHu yongHu = new YongHu();
            yongHu = yongHus.get(j);
            if (yongHu.getYHZTID() == 1){
                zxID.setDingId(yongHu.getDingId());
                break;
            }
        }

        //对总价进行一个计算
        List<QDGouWuChe> qdGouWuCheZhong = new ArrayList<QDGouWuChe>();
        qdGouWuCheZhong = gouWuCheMapper.qDGouWuCheXS(zxID.getDingId());

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
    public void shuLiang(int caiId,int status){//status表示商品增减状态
        if (status == 1){
            //菜品数量加1
            gouWuCheMapper.shuliangADD(caiId);
        }else {
            //但是当减的时候可能会减少为0，当为0时数据消失
            //查询购物车数据库符合caiId的目前数量
            List<GouWuChe> gouWuCheList = new ArrayList<GouWuChe>();
            gouWuCheList = gouWuCheMapper.gouWuCheShuJuXS();
            for (int i=0;i<gouWuCheList.size();i++){
                GouWuChe gouWuChe = new GouWuChe();
                gouWuChe = gouWuCheList.get(i);
                //如果菜品名相同，数量为1
                if (gouWuChe.getCaiId() == caiId && gouWuChe.getCaiPinShuLiang() == 1){
                    //删除购物车中符合的菜品记录
                    gouWuCheMapper.ifCaiIdCai(caiId);
                    break;
                }
            }
            //菜品数量减1
            gouWuCheMapper.shuliangSUB(caiId);
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