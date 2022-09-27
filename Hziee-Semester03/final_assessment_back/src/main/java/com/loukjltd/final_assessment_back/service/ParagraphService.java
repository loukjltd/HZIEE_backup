package com.loukjltd.final_assessment_back.service;

import com.loukjltd.final_assessment_back.entity.Paragraph;
import com.loukjltd.final_assessment_back.mapper.ParagraphMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParagraphService {
    @Autowired
    private ParagraphMapper paragraphMapper;

    public List<Paragraph> getParagraphList(){
        return paragraphMapper.getParagraphList();
    }
}
