package com.loukjltd.final_assessment_back.service;

import com.loukjltd.final_assessment_back.entity.HomePageParagraph;
import com.loukjltd.final_assessment_back.entity.HomePageQuestion;
import com.loukjltd.final_assessment_back.mapper.HomePageMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomePageService {
	private final HomePageMapper homePageMapper;
	
	public HomePageService(HomePageMapper homePageMapper) {
		this.homePageMapper = homePageMapper;
	}
	
	public List<HomePageParagraph> getHomePageList() {
		return homePageMapper.getHomePageList();
	}
	
	public List<HomePageQuestion> getHomePageList2() {
		return homePageMapper.getHomePageList2();
	}
}
