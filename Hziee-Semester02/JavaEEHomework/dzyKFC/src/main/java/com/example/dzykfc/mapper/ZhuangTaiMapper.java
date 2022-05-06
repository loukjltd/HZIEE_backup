package com.example.dzykfc.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

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


}
