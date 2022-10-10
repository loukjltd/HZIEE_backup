package com.loukjltd.final_assessment_back.mapper;

import com.loukjltd.final_assessment_back.entity.Mine;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MineMapper {
	@Select("""
			SELECT
			\tuID,
			\tuNickName,
			\tuPhone,
			\tuPassword,
			\tuMotto,
			\tuAvatar,
			\tuGroup,
			\ttRead,
			\ttLike,
			\ttCoin,
			\ttComment,
			\ttCash,
			\tuIfLogged,
			\tuLastLoggedTime
			FROM
			USER""")
	List<Mine> getMineList();
	
	@Select("""
			SELECT
			\tuNickName,
			\tuPhone,
			\tuPassword,
			\tuIfLogged
			FROM
			USER
			WHERE
			uPhone = #{uPhone} & uPassword = #{uPassword}""")
	List<Mine> checkIfAccountExist(@Param("uPhone") String uPhone,
	                               @Param("uPassword") String uPassword);
	
	@Update("""
			UPDATE USER\s
			\tSET uIfLogged = 1\s
			WHERE
			\tuPhone = #{uPhone};""")
	void updateStatusToIn(@Param("uPhone") String uPhone);
	
	@Update("""
			UPDATE USER\s
			\tSET uIfLogged = 0\s
			WHERE
			\tuNickName = #{uNickName};""")
	void updateStatusToOut(@Param("uNickName") String uNickName);
	
	@Insert("INSERT INTO USER (uPhone, uPassword, uNickName, uMotto) VALUES (#{uPhone}, #{uPassword}, #{uNickName}, #{uMotto});")
	void insertNewAccount(@Param("uPhone") String uPhone,
	                      @Param("uPassword") String uPassword,
	                      @Param("uNickName") String uNickName,
	                      @Param("uMotto") String uMotto);
}
