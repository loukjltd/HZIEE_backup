package com.demo456.controller;

import com.demo456.entity.PdfScanParameter;
import com.demo456.service.PdfScanCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import com.demo456.entity.PdfTrayCode;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin//解决跨域，为前端做准备，已经比以前的配置简单很多了，直接用
public class PdfScanCodeController {
    @Autowired//自动装配
    private PdfScanCodeService pdfScanCodeService;

    //1:loadingScanCode(托码的数据)
    @RequestMapping("loadingPdfTrayCode")
    @ResponseBody
    public List<PdfTrayCode> loadingPdfTrayCode(HttpServletRequest request){
        //初始化PdfScanParameter对象，实际上如果不是为了测试，Map<String, Object>可以直接使用
        PdfScanParameter pdfScanParameter =new PdfScanParameter();
        pdfScanParameter.setFstId(Integer.parseInt(request.getParameter("fstId")));
        pdfScanParameter.setWhId(Integer.parseInt(request.getParameter("whId")));
        pdfScanParameter.setScanId(Integer.parseInt(request.getParameter("scanId")));
        pdfScanParameter.setCreatePerson(Integer.parseInt(request.getParameter("createPerson")));
        pdfScanParameter.setPdaCode(request.getParameter("pdaCode"));

        return pdfScanCodeService.loadingPdfTrayCode(pdfScanParameter);
    }


    @RequestMapping("loadingPdfTrayCodes")
    @ResponseBody
    public List<PdfTrayCode> loadingPdfTrayCodes(@RequestBody Map<String,Object> map){

        PdfScanParameter pdfScanParameter =new PdfScanParameter();
        pdfScanParameter.setFstId(Integer.parseInt(map.get("fstId").toString()));
        pdfScanParameter.setWhId(Integer.parseInt(map.get("whId").toString()));
        pdfScanParameter.setScanId(Integer.parseInt(map.get("scanId").toString()));
        pdfScanParameter.setCreatePerson(Integer.parseInt(map.get("createPerson").toString()));
        pdfScanParameter.setPdaCode(map.get("pdaCode").toString());

        System.out.println(map.get("fstId").toString() + "----" + map.get("scanId").toString());

        return pdfScanCodeService.loadingPdfTrayCode(pdfScanParameter);//调用
    }

    //2：扫码进入暂存表，分为测试请求和正式请求
    @RequestMapping("scanATrayCodeByTest")//测试
    @ResponseBody
    public PdfTrayCode scanATrayCodeByTest (HttpServletRequest request){
        PdfTrayCode pdfTrayCode = new PdfTrayCode();
        pdfTrayCode.setScanId(1006);
        pdfTrayCode.setTrayCode("ZT-0001-2");

        String trayCode = request.getParameter("trayCode");
        int currentWhId = Integer.parseInt(request.getParameter("currentWhId"));
        int currentFstId = Integer.parseInt(request.getParameter("currentFstId"));
        String currentPdaCode = request.getParameter("currentPdaCode");
        int loginId = Integer.parseInt(request.getParameter("loginId"));
        int scanId = Integer.parseInt(request.getParameter("scanId"));

        System.out.println(trayCode + "---" + currentWhId + "---" +currentFstId + "---" +
                currentPdaCode + "---" +loginId + "---" +scanId + "---");

        return pdfScanCodeService.scanATrayCode(currentPdaCode,trayCode,currentWhId,
                currentFstId,scanId,loginId);
    }
    @RequestMapping("scanATrayCode")//正式
    @ResponseBody
    public PdfTrayCode scanATrayCode (@RequestBody Map<String, Object> map){
        String trayCode = map.get("trayCode").toString();
        int currentWhId = Integer.parseInt(map.get("currentWhId").toString());
        int currentFstId = Integer.parseInt(map.get("currentFstId").toString());
        String currentPdaCode = map.get("currentPdaCode").toString();
        int loginId = Integer.parseInt(map.get("loginId").toString());
        int scanId = Integer.parseInt(map.get("scanId").toString());

        System.out.println(trayCode + "---" + currentWhId + "---" +currentFstId + "---" +
                currentPdaCode + "---" +loginId + "---" +scanId + "---");

        return pdfScanCodeService.scanATrayCode(currentPdaCode,trayCode,currentWhId,
                currentFstId,scanId,loginId);
    }

    @RequestMapping("commitTrayCodeList")
    @ResponseBody
    public String commitTrayCodeList(@RequestBody Map<String, Object> map){
        String retValue = "success";

        int currentWhId = Integer.parseInt(map.get("currentWhId").toString());
        int currentFstId = Integer.parseInt(map.get("currentFstId").toString());
        String currentPdaCode = map.get("currentPdaCode").toString();
        int loginId = Integer.parseInt(map.get("loginId").toString());
        int scanId = Integer.parseInt(map.get("scanId").toString());

        System.out.println(currentWhId + "---" +currentFstId + "---" +
                currentPdaCode + "---" +loginId + "---" +scanId + "---");

        retValue = pdfScanCodeService.commitTrayCodeList(currentWhId, currentFstId,
                currentPdaCode, loginId, scanId);

        return retValue;
    }
}


