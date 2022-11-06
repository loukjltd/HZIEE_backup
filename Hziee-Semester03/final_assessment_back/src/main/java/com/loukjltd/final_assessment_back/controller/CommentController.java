package com.loukjltd.final_assessment_back.controller;

import com.loukjltd.final_assessment_back.entity.Comment;
import com.loukjltd.final_assessment_back.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class CommentController {
	private final CommentService commentService;
	
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@RequestMapping("ParagraphComment")
	@ResponseBody
	public List<Comment> getParagraphCommentList(@RequestBody Map<String, Object> map) {
		int pID = Integer.parseInt(map.get("pID").toString());
		return commentService.getParagraphCommentList(pID);
	}
	
	@RequestMapping("InsertNewCommentToDatabase")
	@ResponseBody
	public int insertNewCommentToDatabase(@RequestBody Map<String, Object> map) throws ParseException {
		int pID = Integer.parseInt(map.get("pID").toString());
		int uID = Integer.parseInt(map.get("uID").toString());
		String pcContent = map.get("pcContent").toString();
		String dateFormat = "yyyy/MM/dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String pcTime = map.get("pcTime").toString();
		Date convertedTime = sdf.parse(pcTime);
		return commentService.insertNewCommentToDatabase(pID, uID, pcContent, convertedTime);
	}
	
	@RequestMapping("AnswerComment")
	@ResponseBody
	public List<Comment> getAnswerCommentList(@RequestBody Map<String, Object> map) {
		int aID = Integer.parseInt(map.get("aID").toString());
		return commentService.getAnswerCommentList(aID);
	}
	
	@RequestMapping("InsertNewCommentToDatabase2")
	@ResponseBody
	public int insertNewCommentToDatabase2(@RequestBody Map<String, Object> map) throws ParseException {
		int aID = Integer.parseInt(map.get("aID").toString());
		int uID = Integer.parseInt(map.get("uID").toString());
		int qID = Integer.parseInt(map.get("qID").toString());
		String acContent = map.get("acContent").toString();
		String dateFormat = "yyyy/MM/dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String acTime = map.get("acTime").toString();
		Date convertedTime = sdf.parse(acTime);
		return commentService.insertNewCommentToDatabase2(aID, uID, qID, acContent, convertedTime);
	}
}
