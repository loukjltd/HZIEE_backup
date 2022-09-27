package com.loukjltd.final_assessment_back.controller;

import com.loukjltd.final_assessment_back.entity.Question;
import com.loukjltd.final_assessment_back.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping("Question")
    @ResponseBody
    public List<Question> getQuestion() {
        return questionService.getQuestionList();
    }
}
