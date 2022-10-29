package com.loukjltd.final_assessment_back.controller;

import com.loukjltd.final_assessment_back.entity.Paragraph;
import com.loukjltd.final_assessment_back.service.ParagraphService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class ParagraphController {
	private final ParagraphService paragraphService;
	
	public ParagraphController(ParagraphService paragraphService) {
		this.paragraphService = paragraphService;
	}
	
	@RequestMapping("Paragraph")
	@ResponseBody
	public List<Paragraph> getParagraph() {
		return paragraphService.getParagraphList();
	}
	
	@RequestMapping("ViewParagraphDetail")
	@ResponseBody
	public List<Paragraph> viewParagraphDetail(@RequestBody Map<String, Object> map) {
		int uID = Integer.parseInt(map.get("uID").toString());
		String pTitle = map.get("pTitle").toString();
		return paragraphService.viewParagraphDetail(uID, pTitle);
	}
}
