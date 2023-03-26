package com.example.dzykfc.service;


import com.example.dzykfc.entity.ZhuangTai;
import com.example.dzykfc.mapper.WeiHaoMapper;
import com.example.dzykfc.mapper.YongHuMapper;
import com.example.dzykfc.mapper.ZhuangTaiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

@Service
public class ZhuangTaiService {
    @Autowired
    private ZhuangTaiMapper zhuangTaiMapper;
    @Autowired
    private YongHuMapper yongHuMapper;
    @Autowired
    private WeiHaoMapper weiHaoMapper;

    //dingId超时检测
    public List<ZhuangTai> chaoShiJC(String dingId){
        return zhuangTaiMapper.chaoShiJC(dingId);
    }

    //对订单时间进行检查
    public void chaoShiXG(){
        List<ZhuangTai> zhuangTaiList = new ArrayList<ZhuangTai>();
        zhuangTaiList = zhuangTaiMapper.wzfandcsZhuangTai();

        for (int i = 0; i<zhuangTaiList.size();i++){
            ZhuangTai zhuangTai = new ZhuangTai();
            zhuangTai = zhuangTaiList.get(i);
            String time = zhuangTai.getDingTime();

            long fen = timeIf(time);

            if (fen>30){
                //如果时间超过30分钟，将状态转为0
                zhuangTaiMapper.zTW0(zhuangTai.getDingId());
                yongHuMapper.setYongHuZT(zhuangTai.getDingId());

                weiHaoMapper.getdingIdsetweizhuangtai0(zhuangTai.getDingId());
            }


        }
    }


    //定义个方法判断距今多少分钟
    public long timeIf(String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createDate = sdf.format(new java.util.Date());


        Date nowDate = null;
        try {
            nowDate = sdf.parse(createDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date endDate = null;
        try {
            endDate = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long nowDateTime = nowDate.getTime();
        long endDateTime = endDate.getTime();



        long fen = (nowDateTime - endDateTime)/(60*1000);
        return fen;
    }
}
