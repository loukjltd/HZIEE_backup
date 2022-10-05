package com.loukjltd.final_assessment_back.mapper;

import com.loukjltd.final_assessment_back.entity.Creator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CreatorMapper {

    @Select("SELECT\n" +
            "\tuID,\n" +
            "\tuNickName,\n" +
            "\tuMotto,\n" +
            "\tuAvatar,\n" +
            "\tuGroup,\n" +
            "\ttRead,\n" +
            "\ttLike,\n" +
            "\ttCoin,\n" +
            "\ttComment, \n" +
            "\ttCash, \n" +
            "\tuIfLogged \n" +
            "FROM\n" +
            "USER \n" +
            "WHERE\n" +
            "\tuIfLogged = 1;")
    List<Creator> getCreatorList();
}
