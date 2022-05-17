package com.example.dzykfc.mapper;

import com.example.dzykfc.entity.CaiPinBiao;
import com.example.dzykfc.entity.FenLei;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CaiPinBiaoMapper {


    //查询caipinbiao数据
    @Select("select * from caipinbiao")
    List<CaiPinBiao> getCaiPinBiaoList();

    //查询fenlei数据
    @Select("select * from fenlei")
    List<FenLei> getFenLeiList();

}
