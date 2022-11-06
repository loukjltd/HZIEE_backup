package com.loukjltd.final_assessment_back.service;

import com.loukjltd.final_assessment_back.entity.Comment;
import com.loukjltd.final_assessment_back.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {
	private final CommentMapper commentMapper;
	
	public CommentService(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}
	
	public List<Comment> getParagraphCommentList(int pID) {
		return commentMapper.getParagraphCommentList(pID);
	}
	
	public int insertNewCommentToDatabase(int pID, int uID, String pcContent, Date pcTime) {
		commentMapper.insertNewCommentToDatabase(pID, uID, pcContent, pcTime);
		return 100;
	}
	
	public List<Comment> getAnswerCommentList(int aID) {
		return commentMapper.getAnswerCommentList(aID);
	}
	
	public int insertNewCommentToDatabase2(int aID, int uID, int qID, String acContent, Date acTime) {
		commentMapper.insertNewCommentToDatabase2(aID, uID, qID, acContent, acTime);
		return 100;
	}
}
