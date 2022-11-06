package com.loukjltd.final_assessment_back.service;

import com.loukjltd.final_assessment_back.entity.Administrator;
import com.loukjltd.final_assessment_back.mapper.AdministratorMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorService {
	private final AdministratorMapper administratorMapper;
	
	public AdministratorService(AdministratorMapper administratorMapper) {
		this.administratorMapper = administratorMapper;
	}
	
	public List<Administrator> getAllUserInfo() {
		return administratorMapper.getAllUserInfo();
	}
	
	public List<Administrator> getAllParagraphInfo() {
		return administratorMapper.getAllParagraphInfo();
	}
	
	public List<Administrator> getAllQuestionInfo() {
		return administratorMapper.getAllQuestionInfo();
	}
	
	public List<Administrator> getAllAnswerInfo() {
		return administratorMapper.getAllAnswerInfo();
	}
	
	public int adminDeleteUser(int uID) {
		administratorMapper.adminDeleteParagraphWithUser(uID);
		administratorMapper.adminDeleteQuestionWithUser(uID);
		administratorMapper.adminDeleteAnswerWithUser(uID);
		administratorMapper.adminDeleteParagraphCommentWithUser(uID);
		administratorMapper.adminDeleteAnswerCommentWithUser(uID);
		administratorMapper.adminDeleteUser(uID);
		return 100;
	}
	
	public int adminDeleteParagraph(int uID, int pID) {
		administratorMapper.adminDeleteParagraphComment(uID, pID);
		administratorMapper.adminDeleteParagraph(uID, pID);
		return 100;
	}
	
	public int adminDeleteQuestion(int uID, int qID) {
		administratorMapper.adminDeleteQuestion(uID, qID);
		administratorMapper.adminDeleteQuestionWithAnswer(qID);
		administratorMapper.adminDeleteAnswerCommentWithQuestion(qID);
		return 100;
	}
	
	public int adminDeleteAnswer(int uID, int qID, int aID) {
		administratorMapper.adminDeleteAnswerComment(uID, qID, aID);
		administratorMapper.adminDeleteAnswer(uID, qID, aID);
		return 100;
	}
}
