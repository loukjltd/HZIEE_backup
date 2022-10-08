package com.loukjltd.final_assessment_back.controller;

import com.loukjltd.final_assessment_back.entity.Creator;
import com.loukjltd.final_assessment_back.service.CreatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class CreatorController {
	private final CreatorService creatorService;
	
	public CreatorController(CreatorService creatorService) {
		this.creatorService = creatorService;
	}
	
	@RequestMapping("Creator")
	@ResponseBody
	public List<Creator> getCreator() {
		return creatorService.getCreatorList();
	}
	
}
