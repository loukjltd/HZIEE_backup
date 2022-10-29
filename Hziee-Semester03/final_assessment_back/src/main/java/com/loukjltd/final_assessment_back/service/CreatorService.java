package com.loukjltd.final_assessment_back.service;

import com.loukjltd.final_assessment_back.entity.Creator;
import com.loukjltd.final_assessment_back.mapper.CreatorMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatorService {
	private final CreatorMapper creatorMapper;
	
	public CreatorService(CreatorMapper creatorMapper) {
		this.creatorMapper = creatorMapper;
	}
	
	public List<Creator> getCreatorList() {
		return creatorMapper.getCreatorList();
	}
	
	public int InsertQuestionToDatabase(String qTitle, String qContent, int uID) {
		creatorMapper.insertQuestionToDatabase(qTitle, qContent, uID);
		return 100;
	}
	
	public int InsertParagraphToDatabase(String pTitle, String pContent, int uID) {
		creatorMapper.insertParagraphToDatabase(pTitle, pContent, uID);
		return 100;
	}
}
