package com.demo456.service;

import com.demo456.entity.PackageItems;
import com.demo456.entity.PdfScanParameter;
import com.demo456.entity.PdfTrayCode;
import com.demo456.mapper.PdfScanMapper;
import com.demo456.mapper.PrimeTableInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class PdfScanCodeService {
    @Autowired
    private PdfScanMapper pdfScanMapper;

    @Autowired
    private PrimeTableInfoMapper primeTableInfoMapper;

    //定义,定义了才能被调用，调用的格式是对象.函数名(参数)
    public List<PdfTrayCode> loadingPdfTrayCode(PdfScanParameter pdfScanParameter){
        List<PdfTrayCode> pdfTraycodeList = new ArrayList<PdfTrayCode>();
        pdfTraycodeList = pdfScanMapper.loadingPdfTrayCode(pdfScanParameter);

        return pdfTraycodeList;
    }

    public PdfTrayCode scanATrayCode(String pdaCode, String trayCode, int currentWhId,
                                     int currentFstId, int scanId, int loginId){
        PdfTrayCode pdfTraycode = new PdfTrayCode();
        //1:对扫入的托码进行各种不同场景的分析和建议，如果通不过，都不能插入到数据库
        //检验代码很多，所以考虑写成一个建议函数，在这里调用。
        String msg = this.checkPdfTrayCode(pdaCode, trayCode, currentWhId, currentFstId,
                scanId, loginId);
        System.out.println(msg);
        if (!msg.equals("success"))
            return pdfTraycode;
        //2:如果以上检验都通过了，则进行托码插入和条码插入的操作。
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createDate = sdf.format(new java.util.Date());
        PdfTrayCode tray = pdfScanMapper.checkTrayCodeStatus(trayCode);
        int trayId = tray.getTrayId();
        int fstId = tray.getFstId();
        System.out.println(trayId + "---" + fstId);
        int iTray = pdfScanMapper.insertTrayCodeToStorageTray(pdaCode, trayId, trayCode,
                loginId, createDate, scanId, fstId);
        System.out.println("插入值：" + iTray);
        //2-1:插入托码对应的条码到storageBar
        List<PackageItems> packageItemsList = pdfScanMapper.getBarCodes(trayId);// 获取托码对应的所有条码
        int iBar = 0;
        for (int i = 0; i < packageItemsList.size(); i++){
            int stId = 0;
            int proId = packageItemsList.get(i).getProId();
            String barCode = packageItemsList.get(i).getBarCode();
            pdfScanMapper.insertBarToStorageBar(stId, proId, trayId, barCode);
            iBar++;
        }
        System.out.println("条码插入值:" + iBar);


        return pdfTraycode;
    }

    private String checkPdfTrayCode(String pdaCode, String trayCode, int currentWhId,
                                    int currentFstId, int scanId, int loginId){
        String msg = "success";
        //6:托码在本仓储系统内就不存在，也不能扫入
//        int existSums = pdfScanMapper.checkTrayCodeExist(trayCode);
//        if (existSums <= 0){
//            msg = "托码不是本系统的托码，请核实后重新扫入";
//            return msg;
//        }
        //1:托码状态不对，不是等待入库的状态
        PdfTrayCode pdfTrayCode = pdfScanMapper.checkTrayCodeStatus(trayCode);
        if (pdfTrayCode.getPkStatus() != 1){
            msg = "托码状态不是待入库状态，请核实后重新扫入";
            return msg;
        }
        //2:托码不属于该仓库
        if (pdfTrayCode.getWhId() != currentWhId) {
            msg = "托码不是本仓库的托码，请核实后重新扫入";
            return msg;
        }
        //3:托码不属于该公司
        if (pdfTrayCode.getFstId() != currentFstId){
            msg = "托码不是公司的托码，请核实后重新扫入";
            return msg;
        }

        //4:托码已经被扫入了，重复扫入

        //5:托码对应的条码有质量问题，不能扫入
        return msg;
    }

    public String commitTrayCodeList(int currentWhId, int currentFstId, String currentPdaCode, int loginId, int scanId) {
        String retValue = "success";
        //1:检验要提交的数据是否符合规定的数量
        //2:生成wbId和wbCode,好让3张表WhProBolloters,WhProBolloterItems,WhProbolloterBarCodes都能使用wbId.
        int wbId = this.getPrimeKey("WhProBolloters");
        //尝试完成wbCode的生成，和完成下面3,4,5三个函数功能

        //3:通过WhProBollotersMapper插入表头数据
        //4:通过WhProBolloterItemsMapper插入明细汇总数据
        //5:通过WhProBolloterBarCodesMapper插入条码明细数据
        //6:更新库存
        //7:更新Packages的状态值
        //8:更新productItems里面的status状态值
        //9:假删除StorageTray和StorageBar的数据。把actFlag置为0.

        return retValue;
    }

    private int getPrimeKey(String tableName) {
        int wbId = primeTableInfoMapper.getPrimeKey(tableName);
        primeTableInfoMapper.generateNextPrimeKey(tableName);

        return wbId;
    }
}
