package com.demo456.mapper;

import com.demo456.entity.PackageItems;
import com.demo456.entity.PdfScanParameter;
import com.demo456.entity.PdfTrayCode;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PdfScanMapper {
    @Insert("insert into StorageBar(stId, proId, trayId, barCode, actFlag) " +
            " values(#{stId}, #{proId}, #{trayId}, #{barCode}, 1)")
    int insertBarToStorageBar(@Param("stId") int stId,
                              @Param("proId") int proId,
                              @Param("trayId") int trayId,
                              @Param("barCode") String barCode);

    @Select("select * from packageItems where trayId = #{trayId}")
    List<PackageItems> getBarCodes(@Param("trayId") int trayId);

    @Insert("insert into StorageTray(pdaCode, trayId, trayCode, createPerson, " +
            " createDate, actFlag, scanId, fstId) values(#{pdaCode}, #{trayId}, #{trayCode}, " +
            " #{createPerson}, #{createDate}, 1, #{scanId}, #{fstId})")
    int insertTrayCodeToStorageTray(@Param("pdaCode") String pdaCode,
                                    @Param("trayId") int trayId,
                                    @Param("trayCode") String trayCode,
                                    @Param("createPerson") int createPerson,
                                    @Param("createDate") String createDate,
                                    @Param("scanId") int scanId,
                                    @Param("fstId") int fstId);

    @Select("select * from StorageTray")
    List<PdfTrayCode> loadingPdfTrayCode(PdfScanParameter pdfScanParameter);

    @Select("select count(*) as trayCodeSums from packages " + "where trayCode = #{trayCode} and actFlag = 1")
    int checkTrayCodeExist(@Param("trayCode") String trayCode);

    @Select("SELECT DISTINCT ps.trayId,ps.fstId,pts.whId, ps.pkStatus FROM packages ps " +
            " INNER JOIN packageItems pks ON pks.trayId = ps.trayId " +
            " INNER JOIN productItems pts ON pts.ProId = pks.ProId " +
            " WHERE ps.actFlag = 1 AND ps.trayCode = #{trayCode}")
    PdfTrayCode checkTrayCodeStatus(@Param("trayCode") String trayCode);
}
