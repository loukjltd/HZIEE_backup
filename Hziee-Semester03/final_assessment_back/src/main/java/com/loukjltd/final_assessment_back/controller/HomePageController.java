package com.loukjltd.final_assessment_back.controller;

import com.loukjltd.final_assessment_back.entity.HomePage;
import com.loukjltd.final_assessment_back.entity.HomePage2;
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

    @RequestMapping("HomePage")
    @ResponseBody
    public List<HomePage> getHomePage() {
        return homePageService.getHomePageList();
    }

    @RequestMapping("HomePage2")
    @ResponseBody
    public List<HomePage2> getHomePage2() {
        return homePageService.getHomePageList2();
    }
}
