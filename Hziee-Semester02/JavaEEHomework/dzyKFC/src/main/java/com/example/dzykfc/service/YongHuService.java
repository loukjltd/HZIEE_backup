package com.example.dzykfc.service;

import com.example.dzykfc.entity.GouWuChe;
import com.example.dzykfc.entity.WeiHao;
import com.example.dzykfc.entity.YongHu;
import com.example.dzykfc.mapper.YongHuMapper;
import com.example.dzykfc.mapper.ZhuangTaiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class YongHuService {
    @Autowired
    private YongHuMapper yongHuMapper;
    @Autowired
    private ZhuangTaiMapper zhuangTaiMapper;
    //new
    //这个方法用于放入yonghu表数据
    public void newyongHuShuJuShuR(String dingId, String userName ,int yongHuRS,int weiId){


        //时间获取
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createDate = sdf.format(new java.util.Date());
        //1：weiId状态为1
        zhuangTaiMapper.setWeiZhuangTai(weiId);
        //将数据与没有人使用的桌子进行绑定，也就是将数据写入状态表
        zhuangTaiMapper.zhuangTaiShuJuShuR(dingId,weiId,createDate);
        //将用户信息写入用户表;
        yongHuMapper.yongHuShuJuShuR(dingId,userName,yongHuRS);
    }





















    //old
//    public YongHuService(ZhuangTaiMapper zhuangTaiMapper) {
//        this.zhuangTaiMapper = zhuangTaiMapper;
//    }

    //用户表信息传输
    public List<YongHu> yongHuShuJuXS(){
        return yongHuMapper.yongHuShuJuXS();
    }

    //这个方法用于放入yonghu表数据
    public String yongHuShuJuShuR(String dingId, String userName ,int yongHuRS){

        String fahuizhi = "0";//0:没有位置了，其余内容有位置

        //现在需要查询数据库中所有的座位的使用情况，如果有空位，加入用户信息
        List<WeiHao> weiHaoList = new ArrayList<WeiHao>();
        weiHaoList = yongHuMapper.weiHaoXS();

        for (int i = 0; i < weiHaoList.size(); i++){
            WeiHao weiHao = new WeiHao();
            weiHao = weiHaoList.get(i);

            if (weiHao.getWeiZhuangTai() == 0){

                //时间获取
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String createDate = sdf.format(new java.util.Date());

                //将数据与没有人使用的桌子进行绑定，也就是将数据写入状态表
                zhuangTaiMapper.zhuangTaiShuJuShuR(dingId,weiHao.getWeiId(),createDate);
                //将用户信息写入用户表;
                yongHuMapper.yongHuShuJuShuR(dingId,userName,yongHuRS);
                //完成上面的同时，我们需要将已经使用的位置状态转为1
                zhuangTaiMapper.setWeiZhuangTai(weiHao.getWeiId());
                //让反回值为桌号
                fahuizhi = weiHao.getWei();

                break;//只要一个桌子
            }

        }
        return fahuizhi;

    }

}
