package com.example.dzykfc.service;

import com.example.dzykfc.entity.WeiHao;
import com.example.dzykfc.mapper.WeiHaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeiHaoService {
    @Autowired
    private WeiHaoMapper weiHaoMapper;
    //-----------new------------
    //获得后端位置编号已经位置状态为1；已被使用
    public List<WeiHao> newWeiIs1(){
        return weiHaoMapper.newWeiIs1();
    }
    //获得后端位置编号已经位置状态为0；未被使用
    public List<WeiHao> newWeiIs0(){
        return weiHaoMapper.newWeiIs0();
    }
    //---------------old-------
}
