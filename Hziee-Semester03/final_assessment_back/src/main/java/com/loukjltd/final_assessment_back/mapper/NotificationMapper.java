package com.loukjltd.final_assessment_back.mapper;

import com.loukjltd.final_assessment_back.entity.Notification;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NotificationMapper {
	@Select("""
			SELECT
				nID,
				uID,
				nTitle,
				nContent,
				nFlag,
				nClass
			FROM
				Notification
			WHERE
				uID = #{uID}
			""")
	List<Notification> getNotificationList(@Param("uID") int uID);
	
	@Delete("""
			DELETE FROM
				Notification
			WHERE
				uID = #{uID}
			AND
				nID = #{nID}
			""")
	void deleteNotification(@Param("uID") int uID, @Param("nID") int nID);
}
