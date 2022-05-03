package com.demo456.controller;


import com.demo456.entity.CaiPingFenLei;
import com.demo456.entity.PdfScanParameter;
import com.demo456.entity.PdfTrayCode;
import com.demo456.service.CaiPinService;
import com.demo456.service.PdfScanCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
/*
  用户点餐Controller
 */
public class YhdcController {
    //@Autowired//自动装配
    //private CaiPinService caiPinService;

    @RequestMapping("loadingCaiPinCodes")//将菜品传输到前端
    @ResponseBody
    public List<PdfTrayCode> loadingCaiPinCodes(@RequestBody Map<String,Object> map){

        CaiPingFenLei caiPingFenLei =  new CaiPingFenLei();
        caiPingFenLei.

        PdfScanParameter pdfScanParameter =new PdfScanParameter();
        pdfScanParameter.setFstId(Integer.parseInt(map.get("fstId").toString()));
        pdfScanParameter.setWhId(Integer.parseInt(map.get("whId").toString()));
        pdfScanParameter.setScanId(Integer.parseInt(map.get("scanId").toString()));
        pdfScanParameter.setCreatePerson(Integer.parseInt(map.get("createPerson").toString()));
        pdfScanParameter.setPdaCode(map.get("pdaCode").toString());

        System.out.println(map.get("fstId").toString() + "----" + map.get("scanId").toString());

        return pdfScanCodeService.loadingPdfTrayCode(pdfScanParameter);//调用
    }

//    @RequestMapping("caipinchuanshu")//菜品传输
//    @ResponseBody
//    public CaiPingFenLei scanATrayCode (@RequestBody Map<String, Object> map){
//
////        String trayCode = map.get("trayCode").toString();
////        int currentWhId = Integer.parseInt(map.get("currentWhId").toString());
////        int currentFstId = Integer.parseInt(map.get("currentFstId").toString());
////        String currentPdaCode = map.get("currentPdaCode").toString();
////        int loginId = Integer.parseInt(map.get("loginId").toString());
////        int scanId = Integer.parseInt(map.get("scanId").toString());
//
////        System.out.println(trayCode + "---" + currentWhId + "---" +currentFstId + "---" +
////                currentPdaCode + "---" +loginId + "---" +scanId + "---");
//
//        //return pdfScanCodeService.scanATrayCode(currentPdaCode,trayCode,currentWhId,
//        //        currentFstId,scanId,loginId);
//        return ;//调用方法
//    }
}
