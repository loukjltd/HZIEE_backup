package com.loukjltd.final_assessment_back.mapper;

import com.loukjltd.final_assessment_back.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuestionMapper {
	
	@Select("""
			SELECT
				Question.qTitle,
				Question.qContent,
				USER.uNickName,
				USER.uMotto,
				USER.uAvatar
			FROM
				Question
			JOIN
				USER
			ON
				Question.uID = USER.uID
			""")
	List<Question> getQuestionList();
}
