package com.demo456.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface PrimeTableInfoMapper {
    //产生并得到主键
    int generateNextPrimeKey(String tableName);//update
    int getPrimeKey(String tableName);//select

}
