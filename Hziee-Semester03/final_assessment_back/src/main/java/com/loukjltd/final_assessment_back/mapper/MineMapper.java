package com.loukjltd.final_assessment_back.mapper;

import com.loukjltd.final_assessment_back.entity.Mine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MineMapper {
    @Select("SELECT\n" +
            "\tuID,\n" +
            "\tuNickName,\n" +
            "\tuMotto,\n" +
            "\tuAvatar,\n" +
            "\tuGroup,\n" +
            "\ttRead,\n" +
            "\ttLike,\n" +
            "\ttCoin,\n" +
            "\ttComment,\n" +
            "\ttCash,\n" +
            "\tuIfLogged,\n" +
            "\tuLastLoggedTime\n" +
            "FROM\n" +
            "USER")
    List<Mine> getMineList();
    
    @Update("UPDATE USER \n" +
            "\tSET uIfLogged = 1 \n" +
            "WHERE\n" +
            "\tuPhone = #{uPhone};")
    void updateStatusToIn(@Param("uPhone") String uPhone);

    @Update("UPDATE USER \n" +
            "\tSET uIfLogged = 0 \n" +
            "WHERE\n" +
            "\tuNickName = #{uNickName};")
    void updateStatusToOut(@Param("uNickName") String uNickName);



}
