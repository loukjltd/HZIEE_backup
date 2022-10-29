package com.loukjltd.final_assessment_back.service;

import com.loukjltd.final_assessment_back.entity.Paragraph;
import com.loukjltd.final_assessment_back.mapper.ParagraphMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParagraphService {
	private final ParagraphMapper paragraphMapper;
	
	public ParagraphService(ParagraphMapper paragraphMapper) {
		this.paragraphMapper = paragraphMapper;
	}
	
	public List<Paragraph> getParagraphList() {
		return paragraphMapper.getParagraphList();
	}
	
	public List<Paragraph> viewParagraphDetail(int uID, String pTitle) {
		return paragraphMapper.viewParagraphDetail(uID, pTitle);
	}
}
