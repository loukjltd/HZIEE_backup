package com.loukjltd.final_assessment_back.mapper;

import com.loukjltd.final_assessment_back.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
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
				uID,
				tUpdateTime,
				tIfRefreshToday,
				tRefreshTime
			FROM
				Task
			WHERE
				uID = #{uID}
			""")
	List<Task> getTaskList(@Param("uID") int uID);
	
	@Update("""
			UPDATE Task
				SET tProgress = 0,
					tStatus = 0
			WHERE
				tID = #{tID} AND uID = #{uID}
			""")
	void taskCheckDaily(@Param("tID") int tID,
	                    @Param("uID") int uID);
	
	@Update("""
			UPDATE Task
				SET tIfRefreshToday = 1
			WHERE
				tID = #{tID} AND uID = #{uID}
			""")
	void taskUpdateRefreshTodayDone(@Param("tID") int tID,
	                                @Param("uID") int uID);
	
	@Update("""
			UPDATE Task
				SET tIfRefreshToday = 0
			WHERE
				tID = #{tID} AND uID = #{uID}
			""")
	void taskUpdateRefreshTodayUndone(@Param("tID") int tID,
	                                  @Param("uID") int uID);
	
	@Update("""
			UPDATE Task
				SET tStatus = 1,
					tUpdateTime = #{tUpdateTime}
			WHERE
				tContent = #{tContent}
				AND uID = #{uID};
			""")
	void taskUpdateStatus(@Param("tUpdateTime") Date tUpdateTime,
	                      @Param("tContent") String tContent,
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
	
	@Update("""
			UPDATE Task
				SET tRefreshTime = #{tRefreshTime}
			WHERE
				tID = #{tID} AND uID = #{uID}
			""")
	void taskUpdateRefreshTime(@Param("tRefreshTime") Date tRefreshTime,
	                           @Param("tID") int tID,
	                           @Param("uID") int uID);
	
	@Update("""
			UPDATE Task
			    SET tProgress = tProgress + 1
			WHERE
			    tContent = '浏览文章/回答' AND uID = #{uID}
			""")
	void taskUpdateReadDetailTimes(@Param("uID") int uID);
	
	@Update("""
			UPDATE Task
			    SET tProgress = tProgress + 1
			WHERE
			    tContent = '发表专栏/回答问题' AND uID = #{uID}
			""")
	void taskUpdatePostDetailTimes(@Param("uID") int uID);
	
	@Update("""
			UPDATE User
			    SET tCoin = tCoin - 10
			WHERE
			    uID = #{uID}
			""")
	void taskUpdatePostQuestionCostCoin(@Param("uID") int uID);
	
	@Select("""
			SELECT tCoin FROM User WHERE uID = #{uID}
			""")
	int taskCheckUserCoin(@Param("uID") int uID);
}
