package com.demo456.mapper;

import com.demo456.entity.PdfScanParameter;
import com.demo456.entity.PdfTrayCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author loukj
 */

@Mapper
@Repository
public interface PdfScanMapper {
    @Select("select * from StorageTray")
    List<PdfTrayCode> loadingPdfTrayCode(PdfScanParameter pdfScanParameter);
}
