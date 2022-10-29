package com.loukjltd.final_assessment_back.mapper;

import com.loukjltd.final_assessment_back.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TaskMapper {
	@Select("""
			SELECT
				tID,
				tContent,
				tProgress,
				tFinish,
				tValue,
				tStatus,
				uID
			FROM
				Task
			WHERE
				uID = #{uID}
			""")
	List<Task> getTaskList(@Param("uID") int uID);
	
	@Update("""
			UPDATE Task
				SET tStatus = 1
			WHERE
				tContent = #{tContent}
				AND uID = #{uID};
			""")
	void taskUpdateStatus(@Param("tContent") String tContent,
	                      @Param("uID") int uID);
	
	@Select("""
			SELECT tValue FROM Task WHERE tContent = #{tContent} AND uID = #{uID};
			""")
	int taskCheckValue(@Param("tContent") String tContent,
	                   @Param("uID") int uID);
	
	@Update("""
			UPDATE User
				SET tCoin = tCoin + #{tValue}
			WHERE
				uID = #{uID};
			""")
	void taskUpdateUserCoin(@Param("uID") int uID,
	                        @Param("tValue") int tValue);
}
