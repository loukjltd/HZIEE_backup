package com.loukjltd.final_assessment_back.controller;

import com.loukjltd.final_assessment_back.entity.Paragraph;
import com.loukjltd.final_assessment_back.service.ParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class ParagraphController {
    @Autowired
    private ParagraphService paragraphService;

    @RequestMapping("Paragraph")
    @ResponseBody
    public List<Paragraph> getParagraph() {
        return paragraphService.getParagraphList();
    }
}
