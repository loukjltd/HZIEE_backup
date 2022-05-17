package com.example.dzykfc.entity;
//用户表
public class YongHu {
    private int YongId;//用户表序号
    private String DingId;//订单编号
    private String UserName;//用户名字
    private int YongHuRS;//用户人数
    private int YHZTID;//用户状态id，1：在线，0：不在线

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getYHZTID() {
        return YHZTID;
    }

    public void setYHZTID(int YHZTID) {
        this.YHZTID = YHZTID;
    }

    public int getYongId() {
        return YongId;
    }

    public void setYongId(int yongId) {
        YongId = yongId;
    }

    public String getDingId() {
        return DingId;
    }

    public void setDingId(String dingId) {
        DingId = dingId;
    }

    public String getYongHuPhone() {
        return UserName;
    }

    public void setYongHuPhone(String yongHuPhone) {
        UserName = yongHuPhone;
    }

    public int getYongHuRS() {
        return YongHuRS;
    }

    public void setYongHuRS(int yongHuRS) {
        YongHuRS = yongHuRS;
    }
}
