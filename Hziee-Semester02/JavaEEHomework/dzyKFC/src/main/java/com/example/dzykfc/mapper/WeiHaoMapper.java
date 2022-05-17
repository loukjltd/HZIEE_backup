package com.example.dzykfc.mapper;

import com.example.dzykfc.entity.WeiHao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WeiHaoMapper {
    //----------new--------
    //获得后端位置编号已经位置状态为1；已被使用
    @Select("select * from weihao where weizhuangtai = 1")
    List<WeiHao> newWeiIs1();
    //获得后端位置编号已经位置状态为0；未被使用
    @Select("select * from weihao where weizhuangtai = 0")
    List<WeiHao> newWeiIs0();

    //传入weiId，得到weizhuangtai
    @Select("select weizhuangtai from weihao where weiId = #{weiId}")
    int setWeiIdgetweiZhuangTai(@Param("weiId") int weiId);
    //传入dingId，将weizhaungtai为o
    @Select("update weiHao set weizhuangtai = 0 join zhuangtai on weihao.weiId = zhuangtai.weiId where dingId = #{dingId}")
    int getdingIdsetweizhuangtai0(@Param("dingId") String dingId);

    //---------old--------
}
