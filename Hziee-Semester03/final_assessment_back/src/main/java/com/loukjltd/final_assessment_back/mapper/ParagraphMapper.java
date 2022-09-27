package com.loukjltd.final_assessment_back.mapper;

import com.loukjltd.final_assessment_back.entity.Paragraph;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ParagraphMapper {

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
    List<Paragraph> getParagraphList();
}
