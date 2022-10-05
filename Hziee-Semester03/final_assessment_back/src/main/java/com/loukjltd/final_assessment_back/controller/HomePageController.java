package com.loukjltd.final_assessment_back.controller;

import com.loukjltd.final_assessment_back.entity.HomePageParagraph;
import com.loukjltd.final_assessment_back.entity.HomePageQuestion;
import com.loukjltd.final_assessment_back.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class HomePageController {
    @Autowired
    private HomePageService homePageService;

    @RequestMapping("HomePageParagraph")
    @ResponseBody
    public List<HomePageParagraph> getHomePage() {
        return homePageService.getHomePageList();
    }

    @RequestMapping("HomePageQuestion")
    @ResponseBody
    public List<HomePageQuestion> getHomePage2() {
        return homePageService.getHomePageList2();
    }
}
