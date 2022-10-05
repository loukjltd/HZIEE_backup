package com.loukjltd.final_assessment_back.service;

import com.loukjltd.final_assessment_back.entity.Mine;
import com.loukjltd.final_assessment_back.mapper.MineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MineService {
    @Autowired
    private MineMapper mineMapper;

    public List<Mine> getMineList(){
        return mineMapper.getMineList();
    }

    public void MineLogIn(String uPhone) {
        mineMapper.updateStatusToIn(uPhone);
    }

    public void MineLogOut(String uNickName) {
        mineMapper.updateStatusToOut(uNickName);
    }
}
