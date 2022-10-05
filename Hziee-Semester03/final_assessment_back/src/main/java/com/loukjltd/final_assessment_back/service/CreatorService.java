package com.loukjltd.final_assessment_back.service;

import com.loukjltd.final_assessment_back.entity.Creator;
import com.loukjltd.final_assessment_back.mapper.CreatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatorService {
    @Autowired
    private CreatorMapper creatorMapper;

    public List<Creator> getCreatorList(){
        return creatorMapper.getCreatorList();
    }
}
