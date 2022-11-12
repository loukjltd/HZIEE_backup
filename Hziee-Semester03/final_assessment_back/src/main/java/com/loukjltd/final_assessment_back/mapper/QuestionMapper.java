package com.loukjltd.final_assessment_back.mapper;

import com.loukjltd.final_assessment_back.entity.Answer;
import com.loukjltd.final_assessment_back.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuestionMapper {
	
	@Select("""
			SELECT
				Question.qTitle,
				Question.qContent,
				Question.qID,
				USER.uNickName,
				USER.uMotto,
				USER.uAvatar,
				Question.uID
			FROM
				Question
			JOIN
				USER
			ON
				Question.uID = USER.uID
			""")
	List<Question> getQuestionList();
	
	@Select("""
			SELECT
				Question.uID,
				USER.uNickName,
				USER.uMotto,
				USER.uAvatar,
				Question.qTitle,
				Question.qContent,
				Question.qID
			FROM
				Question
				JOIN USER ON Question.uID = USER.uID
			WHERE
				Question.uID = #{uID}
				AND Question.qID = #{qID}
			""")
	List<Question> viewQuestionList(@Param("uID") int uID,
	                                @Param("qID") int qID);
	
	@Select("""
			SELECT
				Answer.aID,
				Answer.uID,
				Answer.qID,
				Answer.aContent,
				Answer.aLike,
				Answer.aStatus,
				USER.uAvatar,
				USER.uNickName,
				USER.uMotto
			FROM
				Answer
				JOIN USER ON Answer.uID = USER.uID
			WHERE
				qID = #{qID}
			ORDER BY
				Answer.aStatus DESC
			""")
	List<Answer> viewQuestionAnswerList(@Param("qID") int qID);
	
	@Select("""
			SELECT
				Answer.uID,
				USER.uNickName,
				USER.uMotto,
				USER.uAvatar,
				Answer.aContent,
				Answer.aLike,
				Answer.aID
				
			FROM
				Answer
				JOIN USER ON Answer.uID = USER.uID
			WHERE
				Answer.aID = #{aID}
			""")
	List<Answer> viewAnswerDetail(@Param("aID") int aID);
	
	@Select("""
			SELECT
				Answer.aID,
				Answer.uID,
				Answer.qID,
				Answer.aContent,
				Answer.aLike,
				Answer.aStatus,
				USER.uAvatar,
				USER.uNickName,
				USER.uMotto
			FROM
				Answer
				JOIN USER ON Answer.uID = USER.uID
			WHERE
				qID = #{qID}
			""")
	List<Answer> getSpecificAnswerList(@Param("qID") int qID);
	
	@Update("""
			UPDATE
				Answer
			SET
				aStatus = 2
			WHERE
				aID = #{aID}
			""")
	void updateAnswerStatus(@Param("aID") int aID);
	
	@Select("""
			SELECT
				uID
			FROM
				USER
			WHERE
				uIfLogged = 1 AND uGroup = 1;
			""")
	int getOnlineUserID();
	
	@Select("""
			SELECT
				uID
			FROM
				Question
			WHERE qID = #{qID}
			""")
	int getQuestionPosterID(@Param("qID") int qID);
	
	@Update("""
			UPDATE
				User
			SET
				tCoin = tCoin + 10
			WHERE
				uID = #{uID}
			""")
	void updateChooseBestAnswerCoin(@Param("uID") int uID);
}
