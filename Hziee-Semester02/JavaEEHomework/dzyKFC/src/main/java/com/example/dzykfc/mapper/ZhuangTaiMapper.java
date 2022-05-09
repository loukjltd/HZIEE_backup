package com.example.dzykfc.mapper;


import com.example.dzykfc.entity.ZhuangTai;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface ZhuangTaiMapper {

    //用户信息写入ZhuangTai表
    @Insert("insert into ZhuangTai( DingId, WeiId, DingTime) values (#{dingId}, #{weiId}, #{dingTime})")
    int zhuangTaiShuJuShuR( @Param("dingId") String dingId,
                            @Param("weiId") int weiId,
                            @Param("dingTime") String dingTime);


    //将已经使用的位置状态转为1
    @Update("update WeiHao set WeiZhuangTai = 1 where WeiId = #{weiId}")
    int setWeiZhuangTai(@Param("weiId") int weiId);

    //查找为完成支付的zhuangtai表信息
    @Select("select * from ZhuangTai where ZhuangTaiId = 2")
    List<ZhuangTai> wzfandcsZhuangTai();
    //将状态转为0
    @Update("update ZhuangTai set ZhuangTaiId = 0 where dingId = #{dingId}")
    int zTW0(@Param("dingId") String dingId);
    //通过dingId查找ZhuangTaiId的信息
    @Select("select * from ZhuangTai where dingId = #{dingId}")
    List<ZhuangTai> chaoShiJC(@Param("dingId") String dingId);

}
