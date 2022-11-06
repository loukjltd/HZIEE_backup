package com.loukjltd.final_assessment_back.mapper;

import com.loukjltd.final_assessment_back.entity.HomePageParagraph;
import com.loukjltd.final_assessment_back.entity.HomePageQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HomePageMapper {
	
	@Select("""
			SELECT
				Paragraph.pTitle,
				Paragraph.pContent,
				Paragraph.pLike,
				User.uNickName,
				User.uMotto,
				User.uAvatar,
				Paragraph.uID,
				Paragraph.pID
			FROM
				Paragraph
			JOIN
				User
			ON
				Paragraph.uID = User.uID
			""")
	List<HomePageParagraph> getHomePageList();
	
	@Select("""
			SELECT
				Question.qTitle,
				Question.qContent,
				USER.uNickName,
				USER.uMotto,
				USER.uAvatar,
				Question.uID,
				Question.qID
			FROM
				Question
			JOIN
				USER
			ON
				Question.uID = USER.uID
			""")
	List<HomePageQuestion> getHomePageList2();
}
