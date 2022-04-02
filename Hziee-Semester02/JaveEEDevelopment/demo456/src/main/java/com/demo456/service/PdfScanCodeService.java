package com.demo456.service;


import com.demo456.entity.PdfScanParameter;
import com.demo456.entity.PdfTrayCode;
import com.demo456.mapper.PdfScanMapper;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class PdfScanCodeService {
    //定义，定义了才能被调用，调用的格式是对象，函数名（参数）
    @Autowired
    private PdfScanMapper pdfScanMapper;
    public List<PdfTrayCode> loadingPdfTrayCode(PdfScanParameter pdfScanParameter){
        List<PdfTrayCode> pdfTrayCodeList = new ArrayList<PdfTrayCode>();
        pdfTrayCodeList = pdfScanMapper.loadingPdfTrayCode(pdfScanParameter);

        return pdfTrayCodeList;
    }

    public PdfTrayCode scanATrayCode(String pdaCode,String trayCode,int currentWhId,
                                     int currentFstId,int scanId,int loginId){
        PdfTrayCode pdfTrayCode = new PdfTrayCode();




        return pdfTrayCode;
    }
}