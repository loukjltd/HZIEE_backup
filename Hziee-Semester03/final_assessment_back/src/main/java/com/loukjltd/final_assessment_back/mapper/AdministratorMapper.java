package com.loukjltd.final_assessment_back.mapper;

import com.loukjltd.final_assessment_back.entity.Administrator;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdministratorMapper {
	@Select("""
			SELECT
				uID,
				uNickName,
				uPhone,
				uPassword,
				uMotto,
				uAvatar,
				uGroup,
				tRead,
				tLike,
				tCoin,
				tComment,
				tCash,
				uIfLogged,
				uLastLoggedTime
			FROM
				USER
			""")
	List<Administrator> getAllUserInfo();
	
	@Select("""
			SELECT
				Paragraph.pID,
				Paragraph.uID,
				Paragraph.pTitle,
				Paragraph.pContent,
				Paragraph.pLike,
				Paragraph.pStatus,
				User.uNickName,
				User.uPhone,
				User.uPassword,
				User.uMotto,
				User.uAvatar,
				User.uGroup,
				User.tRead,
				User.tLike,
				User.tCoin,
				User.tComment,
				User.tCash,
				User.uIfLogged,
				User.uLastLoggedTime
			FROM
				Paragraph
			JOIN
				User ON User.uID = Paragraph.uID
			""")
	List<Administrator> getAllParagraphInfo();
	
	@Select("""
			SELECT
				Question.qID,
				Question.uID,
				Question.qTitle,
				Question.qContent,
				Question.qStatus,
				User.uNickName,
				User.uPhone,
				User.uPassword,
				User.uMotto,
				User.uAvatar,
				User.uGroup,
				User.tRead,
				User.tLike,
				User.tCoin,
				User.tComment,
				User.tCash,
				User.uIfLogged,
				User.uLastLoggedTime
			FROM
				Question
			JOIN
				User ON User.uID = Question.uID
			""")
	List<Administrator> getAllQuestionInfo();
	
	@Select("""
			SELECT
				Answer.aID,
				Answer.uID,
				Answer.qID,
				Answer.aContent,
				Answer.aLike,
				Answer.aStatus,
				User.uNickName,
				User.uPhone,
				User.uPassword,
				User.uMotto,
				User.uAvatar,
				User.uGroup,
				User.tRead,
				User.tLike,
				User.tCoin,
				User.tComment,
				User.tCash,
				User.uIfLogged,
				User.uLastLoggedTime,
				Question.qID,
				Question.uID,
				Question.qTitle,
				Question.qContent,
				Question.qStatus
			FROM
				Answer
			JOIN
				User ON User.uID = Answer.uID
				JOIN Question ON Question.qID = Answer.qID
			""")
	List<Administrator> getAllAnswerInfo();
	
	@Delete("""
			DELETE
			FROM
			USER
			WHERE
				uID = #{uID}
			""")
	void adminDeleteUser(@Param("uID") int uID);
	
	@Delete("""
			DELETE
			FROM
			Paragraph
			WHERE
				uID = #{uID}
			""")
	void adminDeleteParagraphWithUser(@Param("uID") int uID);
	
	@Delete("""
			DELETE
			FROM
			Question
			WHERE
				uID = #{uID}
			""")
	void adminDeleteQuestionWithUser(@Param("uID") int uID);
	
	@Delete("""
			DELETE
			FROM
			Answer
			WHERE
				uID = #{uID}
			""")
	void adminDeleteAnswerWithUser(@Param("uID") int uID);
	
	@Delete("""
			DELETE
			FROM
			ParagraphComment
			WHERE
				uID = #{uID}
			""")
	void adminDeleteParagraphCommentWithUser(@Param("uID") int uID);
	
	@Delete("""
			DELETE
			FROM
			AnswerComment
			WHERE
				uID = #{uID}
			""")
	void adminDeleteAnswerCommentWithUser(@Param("uID") int uID);
	
	@Delete("""
			DELETE
			FROM
			QuestionComment
			WHERE
				uID = #{uID} AND pID = #{pID}
			""")
	void adminDeleteParagraphComment(@Param("uID") int uID,
	                                 @Param("pID") int pID);
	
	@Delete("""
			DELETE
			FROM
			Paragraph
			WHERE
				uID = #{uID} AND pID = #{pID}
			""")
	void adminDeleteParagraph(@Param("uID") int uID,
	                          @Param("pID") int pID);
	
	@Delete("""
			DELETE
			FROM
			Question
			WHERE
				uID = #{uID} AND qID = #{qID}
			""")
	void adminDeleteQuestion(@Param("uID") int uID,
	                         @Param("qID") int qID);
	
	@Delete("""
			DELETE
			FROM
			Answer
			WHERE
				qID = #{qID}
			""")
	void adminDeleteQuestionWithAnswer(@Param("qID") int qID);
	
	@Delete("""
			DELETE
			FROM
			AnswerComment
			WHERE
				qID = #{qID}
			""")
	void adminDeleteAnswerCommentWithQuestion(@Param("qID") int qID);
	
	@Delete("""
			DELETE
			FROM
			AnswerComment
			WHERE
				uID = #{uID} AND qID = #{qID} AND aID = #{aID}
			""")
	void adminDeleteAnswerComment(@Param("uID") int uID,
	                              @Param("qID") int qID,
	                              @Param("aID") int aID);
	
	@Delete("""
			DELETE
			FROM
			Answer
			WHERE
				uID = #{uID} AND qID = #{qID} AND aID = #{aID}
			""")
	void adminDeleteAnswer(@Param("uID") int uID,
	                       @Param("qID") int qID,
	                       @Param("aID") int aID);
	
	@Insert("""
			INSERT INTO Notification ( nID, uID, nTitle, nContent, nFlag, nClass )
			VALUES
			( NULL, #{uID}, #{nTitle}, #{nContent}, 0, #{nClass} );
			""")
	void adminSendNotification(@Param("uID") int uID,
	                           @Param("nTitle") String nTitle,
	                           @Param("nContent") String nContent,
	                           @Param("nClass") int nClass);
	
	@Select("""
			SELECT
				Paragraph.pID,
				Paragraph.uID,
				Paragraph.pTitle,
				Paragraph.pContent,
				Paragraph.pLike,
				Paragraph.pStatus,
				USER.uNickName,
				USER.uPhone,
				USER.uPassword,
				USER.uMotto,
				USER.uAvatar,
				USER.uGroup,
				USER.tRead,
				USER.tLike,
				USER.tCoin,
				USER.tComment,
				USER.tCash,
				USER.uIfLogged,
				USER.uLastLoggedTime
			FROM
				Paragraph
				JOIN USER ON USER.uID = Paragraph.uID
			WHERE
				Paragraph.pTitle LIKE #{srContent}
				OR Paragraph.pContent LIKE #{srContent}
			""")
	List<Administrator> searchDatabaseParagraph(@Param("srContent") String srContent);
	
	@Select("""
			SELECT
				Question.qID,
				Question.uID,
				Question.qTitle,
				Question.qContent,
				Question.qStatus,
				User.uNickName,
				User.uPhone,
				User.uPassword,
				User.uMotto,
				User.uAvatar,
				User.uGroup,
				User.tRead,
				User.tLike,
				User.tCoin,
				User.tComment,
				User.tCash,
				User.uIfLogged,
				User.uLastLoggedTime
			FROM
				Question
			JOIN
				User ON User.uID = Question.uID
			WHERE
				Question.qTitle LIKE #{srContent}
				OR Question.qContent LIKE #{srContent}
			""")
	List<Administrator> searchDatabaseQuestion(@Param("srContent") String srContent);
	
	@Select("""
			SELECT
				Answer.aID,
				Answer.uID,
				Answer.qID,
				Answer.aContent,
				Answer.aLike,
				Answer.aStatus,
				User.uNickName,
				User.uPhone,
				User.uPassword,
				User.uMotto,
				User.uAvatar,
				User.uGroup,
				User.tRead,
				User.tLike,
				User.tCoin,
				User.tComment,
				User.tCash,
				User.uIfLogged,
				User.uLastLoggedTime,
				Question.qID,
				Question.uID,
				Question.qTitle,
				Question.qContent,
				Question.qStatus
			FROM
				Answer
			JOIN
				User ON User.uID = Answer.uID
				JOIN Question ON Question.qID = Answer.qID
			WHERE
				Answer.aContent LIKE #{srContent}
			""")
	List<Administrator> searchDatabaseAnswer(@Param("srContent") String srContent);
}
