package com.loukjltd.final_assessment_back.controller;

import com.loukjltd.final_assessment_back.entity.Answer;
import com.loukjltd.final_assessment_back.entity.Question;
import com.loukjltd.final_assessment_back.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class QuestionController {
	private final QuestionService questionService;
	
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	@RequestMapping("Question")
	@ResponseBody
	public List<Question> getQuestion() {
		return questionService.getQuestionList();
	}
	
	@RequestMapping("ViewQuestionList")
	@ResponseBody
	public List<Question> viewQuestionList(@RequestBody Map<String, Object> map) {
		int uID = Integer.parseInt(map.get("uID").toString());
		int qID = Integer.parseInt(map.get("qID").toString());
		return questionService.viewQuestionList(uID, qID);
	}
	
	@RequestMapping("ViewQuestionAnswerList")
	@ResponseBody
	public List<Answer> viewQuestionAnswerList(@RequestBody Map<String, Object> map) {
		int qID = Integer.parseInt(map.get("qID").toString());
		return questionService.viewQuestionAnswerList(qID);
	}
	
	@RequestMapping("ViewAnswerDetail")
	@ResponseBody
	public List<Answer> viewAnswerDetail(@RequestBody Map<String, Object> map) {
		int aID = Integer.parseInt(map.get("aID").toString());
		return questionService.viewAnswerDetail(aID);
	}
	
	@RequestMapping("ChooseThisAnswerAsBestAnswer")
	@ResponseBody
	public int chooseThisAnswerAsBestAnswer(@RequestBody Map<String, Object> map) {
		int qID = Integer.parseInt(map.get("qID").toString());
		int aID = Integer.parseInt(map.get("aID").toString());
		int answerPosterID = Integer.parseInt(map.get("answerPosterID").toString());
		return questionService.chooseThisAnswerAsBestAnswer(qID, aID, answerPosterID);
	}
}
