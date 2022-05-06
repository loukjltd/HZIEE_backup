package com.example.dzykfc.service;


import com.example.dzykfc.entity.TestTable;
import com.example.dzykfc.mapper.TestTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestTableService {
    @Autowired
    private TestTableMapper testTableMapper;

    public List<TestTable> getTestTableList(){
        return testTableMapper.getTestTableList();
    }
}
