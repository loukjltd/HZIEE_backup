package com.loukjltd.final_assessment_back.mapper;

import com.loukjltd.final_assessment_back.entity.HomePage;
import com.loukjltd.final_assessment_back.entity.HomePage2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HomePageMapper {

    @Select("SELECT\n" +
            "\tParagraph.pTitle,\n" +
            "\tParagraph.pContent,\n" +
            "\tParagraph.pLike,\n" +
            "\tUser.uNickName,\n" +
            "\tUser.uMotto,\n" +
            "\tUser.uAvatar \n" +
            "FROM\n" +
            "\tParagraph\n" +
            "JOIN User on Paragraph.uID = User.uID")
    List<HomePage> getHomePageList();

    @Select("SELECT\n" +
            "\tQuestion.qTitle,\n" +
            "\tQuestion.qContent,\n" +
            "\tUSER.uNickName,\n" +
            "\tUSER.uMotto,\n" +
            "\tUSER.uAvatar \n" +
            "FROM\n" +
            "\tQuestion\n" +
            "\tJOIN USER ON Question.uID = USER.uID")
    List<HomePage2> getHomePageList2();
}
