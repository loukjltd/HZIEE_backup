package com.example.dzykfc.service;

import com.example.dzykfc.entity.CaiPinBiao;
import com.example.dzykfc.entity.FenLei;
import com.example.dzykfc.mapper.CaiPinBiaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaiPinBiaoService {
    @Autowired
    private CaiPinBiaoMapper caiPinBiaoMapper;//定义后方便后面调用私有数据
    //caipinbiao数据获取
    public List<CaiPinBiao> getCaiPinBiaoList(){
        return caiPinBiaoMapper.getCaiPinBiaoList();
    }

    //fenlei数据获取
    public List<FenLei> getFenLeiList(){
        return caiPinBiaoMapper.getFenLeiList();
    }

}
