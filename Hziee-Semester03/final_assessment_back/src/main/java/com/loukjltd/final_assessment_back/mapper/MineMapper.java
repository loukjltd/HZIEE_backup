package com.loukjltd.final_assessment_back.mapper;

import com.loukjltd.final_assessment_back.entity.Mine;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface MineMapper {
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
	List<Mine> getMineList();
	
	@Select("""
			SELECT
				uNickName,
				uPhone,
				uPassword,
				uIfLogged
			FROM
				USER
			WHERE
				uPhone = #{uPhone} &
				uPassword = #{uPassword}
			""")
	List<Mine> checkIfAccountExist(@Param("uPhone") String uPhone,
	                               @Param("uPassword") String uPassword);
	
	@Update("""
			UPDATE
				USER
			SET
				uIfLogged = 1,
				uLastLoggedTime = #{uLastLoggedTime}
			WHERE
				uPhone = #{uPhone};
			""")
	void updateStatusToIn(@Param("uPhone") String uPhone,
	                      @Param("uLastLoggedTime") Date uLastLoggedTime);
	
	@Update("""
			UPDATE
				USER
			SET
				uIfLogged = 0
			WHERE
				uNickName = #{uNickName};
			""")
	void updateStatusToOut(@Param("uNickName") String uNickName);
	
	@Insert("""
			INSERT INTO
			    USER (uID, uPhone, uPassword, uNickName, uMotto, uAvatar)
			    VALUES (#{uID}, #{uPhone}, #{uPassword}, #{uNickName}, #{uMotto}, #{uAvatar});
			""")
	void insertNewAccount(@Param("uID") int uID,
	                      @Param("uPhone") String uPhone,
	                      @Param("uPassword") String uPassword,
	                      @Param("uNickName") String uNickName,
	                      @Param("uMotto") String uMotto,
	                      @Param("uAvatar") String uAvatar);
	
	@Insert("""
			INSERT INTO Task ( tID, uID, tContent, tProgress, tFinish, tValue, tStatus )
			VALUES
				( 1, #{uID}, "每日签到", 0, 1, 5, 0 ),
				( 2, #{uID}, "浏览文章/回答", 0, 5, 2, 0 ),
				( 3, #{uID}, "发表专栏/回答问题", 0, 1, 3, 0 ),
			""")
	void insertRelatedTaskWithNewUser(@Param("uID") int uID);
	
	@Update("""
			UPDATE
				Task
			SET
				tProgress = 1
			WHERE
				uID = #{uID}
			AND
				tContent = '每日签到';
			""")
	void updateEverydaySignInProgress(@Param("uID") int uID);
}
