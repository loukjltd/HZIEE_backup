package com.example.dzykfc.mapper;


import com.example.dzykfc.entity.TestTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestTableMapper {
    @Select("select * from caipinbiao")
    List<TestTable> getTestTableList();
}
