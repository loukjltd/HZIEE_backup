package com.loukjltd.final_assessment_back.mapper;

import com.loukjltd.final_assessment_back.entity.Paragraph;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ParagraphMapper {
	
	@Select("""
			SELECT
				Paragraph.pTitle,
				Paragraph.pContent,
				Paragraph.pLike,
				Paragraph.pID,
				USER.uNickName,
				USER.uMotto,
				USER.uAvatar,
				Paragraph.uID
			FROM
				Paragraph
				JOIN USER ON Paragraph.uID = USER.uID
			""")
	List<Paragraph> getParagraphList();
	
	@Select("""
			SELECT
				Paragraph.uID,
				USER.uNickName,
				USER.uMotto,
				USER.uAvatar,
				Paragraph.pTitle,
				Paragraph.pContent,
				Paragraph.pLike,
				Paragraph.pID
			FROM
				Paragraph
				JOIN USER ON Paragraph.uID = USER.uID
			WHERE
				Paragraph.uID = #{uID}
				AND Paragraph.pID = #{pID}
			""")
	List<Paragraph> viewParagraphDetail(@Param("uID") int uID,
	                                    @Param("pID") int pID);
}
