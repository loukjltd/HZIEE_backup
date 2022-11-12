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
	
	public int chooseThisAnswerAsBestAnswer(int qID, int aID, int answerPosterID) {
		List<Answer> answerList = questionMapper.getSpecificAnswerList(qID);
		boolean isBestAnswer = false;
		for (Answer answer : answerList) {
			if (answer.getaStatus() == 2) {
				isBestAnswer = true;
				break;
			}
		}
		System.out.println("questionPosterID " + questionMapper.getQuestionPosterID(qID));
		System.out.println("onlineID " + questionMapper.getOnlineUserID());
		if (questionMapper.getQuestionPosterID(qID) != questionMapper.getOnlineUserID()) {
			return 144;
		} else {
			if (!isBestAnswer) {
				questionMapper.updateAnswerStatus(aID);
				questionMapper.updateChooseBestAnswerCoin(answerPosterID);
				return 100;
			} else {
				return 122;
			}
		}
	}
}
