package com.loukjltd.final_assessment_back.controller;

import com.loukjltd.final_assessment_back.entity.Creator;
import com.loukjltd.final_assessment_back.service.CreatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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
	
	@RequestMapping("InsertQuestionToDatabase")
	@ResponseBody
	public int insertQuestionToDatabase(@RequestBody Map<String, Object> map) {
		String qTitle = map.get("qTitle").toString();
		String qContent = map.get("qContent").toString();
		int uID = Integer.parseInt(map.get("uID").toString());
		return creatorService.InsertQuestionToDatabase(qTitle, qContent, uID);
	}
	
	@RequestMapping("InsertParagraphToDatabase")
	@ResponseBody
	public int insertParagraphToDatabase(@RequestBody Map<String, Object> map) {
		String pTitle = map.get("qTitle").toString();
		String pContent = map.get("qContent").toString();
		int uID = Integer.parseInt(map.get("uID").toString());
		return creatorService.InsertParagraphToDatabase(pTitle, pContent, uID);
	}
}
