package com.demo456.service;

import com.demo456.entity.ErpOrgan;
import com.demo456.mapper.ErpOrganMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author loukj
 */
@Service
public class ErpOrganService {
    @Autowired
    private ErpOrganMapper erpOrganMapper;

    public List<ErpOrgan> getErpOrganList() {
        return erpOrganMapper.getErpOrganList();
    }
}
