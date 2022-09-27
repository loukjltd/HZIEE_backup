package com.loukjltd.final_assessment_back.service;

import com.loukjltd.final_assessment_back.entity.HomePage;
import com.loukjltd.final_assessment_back.entity.HomePage2;
import com.loukjltd.final_assessment_back.mapper.HomePageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HomePageService {
    @Autowired
    private HomePageMapper homePageMapper;

    public List<HomePage> getHomePageList(){
        return homePageMapper.getHomePageList();
    }

    public List<HomePage2> getHomePageList2() {
        return homePageMapper.getHomePageList2();
    }
}
