package com.example.dzykfc.mapper;


import com.example.dzykfc.entity.WeiHao;
import com.example.dzykfc.entity.YongHu;
import com.example.dzykfc.entity.ZhuangTai;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface YongHuMapper {
    //用户表信息传输
    @Select("select * from YongHu")
    List<YongHu> yongHuShuJuXS();

    //用户信息写入YongHu表
    @Insert("insert into YongHu( DingId, UserName, YongHuRs) values (#{dingId}, #{userName}, #{yongHuRS})")
    int yongHuShuJuShuR(@Param("dingId") String dingId,
                        @Param("userName") String userName,
                        @Param("yongHuRS") int yongHuRS);



    //显示位置表的信息
    @Select("select * from WeiHao")
    List<WeiHao> weiHaoXS();

    //传入用户dingId，得到weiId
    @Select("select weiId from ZhuangTai " +
            " join YongHu on ZhuangTai.dingId = YongHu.dingId")
    int dingGetWei(@Param("dingId") String dingId);

    //传入固定weiId，将位置状态改为0
    @Update("update weihao set weiZhuangTai = 0 where weiId = #{weiId}")
    int weiIdGaiZT(@Param("weiId") int weiId);

    //显示状态表的数据
    @Select("select * from zhuangtai")
    List<ZhuangTai> zhuangTaiXS();


    //提供dingId将用户表中的状态改为0离线
    @Update("update yongHu set YHZTID = 0 where dingId = #{dingId}")
    int setYongHuZT(@Param("dingId") String dingId);

}
