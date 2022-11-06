package com.loukjltd.final_assessment_back.mapper;

import com.loukjltd.final_assessment_back.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
	@Select("""
			SELECT
				ParagraphComment.pcID,
				ParagraphComment.pID,
				ParagraphComment.uID,
				ParagraphComment.pcContent,
				ParagraphComment.pcLike,
				ParagraphComment.pcStatus,
				ParagraphComment.pcTime,
				User.uNickName,
				User.uMotto,
				User.uAvatar
			FROM
				ParagraphComment
			JOIN
				User
			ON
				ParagraphComment.uID = User.uID
			WHERE
				pID = #{pID}
			""")
	List<Comment> getParagraphCommentList(@Param("pID") int pID);
	
	@Insert("""
			INSERT INTO ParagraphComment ( pID, uID, pcContent, pcTime )
			VALUES
				( #{pID}, #{uID}, #{pcContent}, #{pcTime} );
			""")
	void insertNewCommentToDatabase(@Param("pID") int pID,
	                                @Param("uID") int uID,
	                                @Param("pcContent") String pcContent,
	                                @Param("pcTime") Date pcTime);
	
	@Select("""
			SELECT
				AnswerComment.acID,
				AnswerComment.qID,
				AnswerComment.aID,
				AnswerComment.uID,
				AnswerComment.acContent,
				AnswerComment.acLike,
				AnswerComment.acStatus,
				AnswerComment.acTime,
				User.uNickName,
				User.uMotto,
				User.uAvatar
			FROM
				AnswerComment
			JOIN
				User
			ON
				AnswerComment.uID = User.uID
			WHERE
				aID = #{aID}
			""")
	List<Comment> getAnswerCommentList(@Param("aID") int aID);
	
	@Insert("""
			INSERT INTO AnswerComment ( aID, uID, qID, acContent, acTime )
			VALUES
				( #{aID}, #{uID}, #{qID}, #{acContent}, #{acTime} );
			""")
	void insertNewCommentToDatabase2(@Param("aID") int aID,
	                                 @Param("uID") int uID,
	                                 @Param("qID") int qID,
	                                 @Param("acContent") String acContent,
	                                 @Param("acTime") Date acTime);
}
