package com.demo456.mapper;

import com.demo456.entity.PdfScanParameter;
import com.demo456.entity.PdfTrayCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PdfScanMapper {
    @Select("select * from StorageTray")
    List<PdfTrayCode> loadingPdfTrayCode(PdfScanParameter pdfScanParameter);

    @Select("select count(*) as trayCodeSums from packages " + "where trayCode = #{trayCode} and actFlag = 1")
    int checkTrayCodeExist(@Param("trayCode") String trayCode);

    @Select("SELECT DISTINCT" +
            "ps.TrayId," +
            "ps.FstId," +
            "pts.WhId" +
            "ps.PkStatus" +
            "FROM" +
            "Packages ps" +
            "INNER JOIN PackageItems pks ON pks.TrayId = ps.TrayId" +
            "INNER JOIN ProductItems pts ON pts.ProId = pks.ProId" +
            "WHERE" +
            "ps.ActFlag = 1" +
            "AND ps.TrayCode = #{TrayCode}")
    PdfTrayCode checkTrayCodeStatus(@Param("trayCode") String trayCode);
}
