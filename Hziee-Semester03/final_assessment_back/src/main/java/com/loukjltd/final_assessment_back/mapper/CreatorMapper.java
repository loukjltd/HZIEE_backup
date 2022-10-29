package com.loukjltd.final_assessment_back.mapper;

import com.loukjltd.final_assessment_back.entity.Creator;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CreatorMapper {
	
	@Select("""
			SELECT
				uID,
				uNickName,
				uMotto,
				uAvatar,
				uGroup,
				tRead,
				tLike,
				tCoin,
				tComment,
				tCash,
				uIfLogged
			FROM
				USER
			WHERE
				uIfLogged = 1;
			""")
	List<Creator> getCreatorList();
	
	@Insert("""
			INSERT INTO Question (qTitle, qContent, uID)
			VALUES
				(#{qTitle}, #{qContent}, #{uID});
			""")
	void insertQuestionToDatabase(@Param("qTitle") String qTitle,
	                              @Param("qContent") String qContent,
	                              @Param("uID") int uID);
	
	@Insert("""
			INSERT INTO Paragraph (pTitle, pContent, uID)
			VALUES
				(#{pTitle}, #{pContent}, #{uID});
			""")
	void insertParagraphToDatabase(@Param("pTitle") String pTitle,
	                               @Param("pContent") String pContent,
	                               @Param("uID") int uID);
}
