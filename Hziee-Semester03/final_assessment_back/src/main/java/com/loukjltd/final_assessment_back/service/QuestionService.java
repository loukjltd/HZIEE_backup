package com.loukjltd.final_assessment_back.service;

import com.loukjltd.final_assessment_back.entity.Answer;
import com.loukjltd.final_assessment_back.entity.Question;
import com.loukjltd.final_assessment_back.mapper.QuestionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
	private final QuestionMapper questionMapper;
	
	public QuestionService(QuestionMapper questionMapper) {
		this.questionMapper = questionMapper;
	}
	
	public List<Question> getQuestionList() {
		return questionMapper.getQuestionList();
	}
	
	public List<Question> viewQuestionList(int uID, int qID) {
		return questionMapper.viewQuestionList(uID, qID);
	}
	
	public List<Answer> viewQuestionAnswerList(int qID) {
		return questionMapper.viewQuestionAnswerList(qID);
	}
	
	public List<Answer> viewAnswerDetail(int aID) {
		return questionMapper.viewAnswerDetail(aID);
	}
}
