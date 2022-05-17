package com.example.dzykfc.entity;


//获得购物车的DingId，CaiPinShuLiang，状态表的ZhuangTai，DingTime，座位表的Wei。
public class QDGouWuChe {
    private String DingId;//订单编号
    private int CaiPinShuLiang;//菜品数量
    private int ZhuangTaiId;//订单的状态
    private String Wei;//订单的位置
    private String cai;//菜品名
    private float CaiJG;//菜品价格
    private float ZongJG;//单行中的总价
    private int YHZTID;//用户状态id，1：在线，0：不在线
    private int CaiId;//菜品Id
    private int YongHuRS;//用菜人数

    public int getYongHuRS() {
        return YongHuRS;
    }

    public void setYongHuRS(int yongHuRS) {
        YongHuRS = yongHuRS;
    }

    public int getCaiId() {
        return CaiId;
    }

    public void setCaiId(int caiId) {
        CaiId = caiId;
    }

    public int getYHZTID() {
        return YHZTID;
    }

    public void setYHZTID(int YHZTID) {
        this.YHZTID = YHZTID;
    }

    public float getZongJG() {
        return ZongJG;
    }

    public void setZongJG(float zongJG) {
        ZongJG = zongJG;
    }

    public String getCai() {
        return cai;
    }

    public void setCai(String cai) {
        this.cai = cai;
    }

    public float getCaiJG() {
        return CaiJG;
    }

    public void setCaiJG(float caiJG) {
        CaiJG = caiJG;
    }

    public String getDingId() {
        return DingId;
    }

    public void setDingId(String dingId) {
        DingId = dingId;
    }

    public int getCaiPinShuLiang() {
        return CaiPinShuLiang;
    }

    public void setCaiPinShuLiang(int caiPinShuLiang) {
        CaiPinShuLiang = caiPinShuLiang;
    }

    public int getZhuangTaiId() {
        return ZhuangTaiId;
    }

    public void setZhuangTaiId(int zhuangTaiId) {
        ZhuangTaiId = zhuangTaiId;
    }

    public String getWei() {
        return Wei;
    }

    public void setWei(String wei) {
        Wei = wei;
    }
}
