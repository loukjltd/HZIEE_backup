package com.example.dzykfc.entity;

import java.util.Date;

//订单状态表
public class ZhuangTai {
    private String DingId;//订单序号
    private int WeiId;//位置序号
    private int ZhuangTai;//状态  0：超时，2：未支付，1：订单已完成支付
    private String DingTime;//订单时间

    public String getDingId() {
        return DingId;
    }

    public void setDingId(String dingId) {
        DingId = dingId;
    }

    public int getWeiId() {
        return WeiId;
    }

    public void setWeiId(int weiId) {
        WeiId = weiId;
    }

    public int getZhuangTai() {
        return ZhuangTai;
    }

    public void setZhuangTai(int zhuangTai) {
        ZhuangTai = zhuangTai;
    }

    public String getDingTime() {
        return DingTime;
    }

    public void setDingTime(String dingTime) {
        DingTime = dingTime;
    }
}
