package com.demo456.mapper;

import com.demo456.entity.ErpOrgan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author loukj
 */
@Mapper
@Repository
public interface ErpOrganMapper {
    @Select("select * from erpOrgan")
    List<ErpOrgan> getErpOrganList();
}
