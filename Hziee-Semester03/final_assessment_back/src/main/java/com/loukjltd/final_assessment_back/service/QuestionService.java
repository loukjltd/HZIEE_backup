package com.loukjltd.final_assessment_back.service;

import com.loukjltd.final_assessment_back.entity.Question;
import com.loukjltd.final_assessment_back.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    public List<Question> getQuestionList(){
        return questionMapper.getQuestionList();
    }
}
