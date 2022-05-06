package com.example.dzykfc.entity;
//座位号表
public class WeiHao {
    private int WeiId;//位置序号
    private String Wei;//位置名称
    private int WeiZhuangTai;//座位使用情况，1：正在使用，0：没有人在使用

    public int getWeiId() {
        return WeiId;
    }

    public void setWeiId(int weiId) {
        WeiId = weiId;
    }

    public String getWei() {
        return Wei;
    }

    public void setWei(String wei) {
        Wei = wei;
    }

    public int getWeiZhuangTai() {
        return WeiZhuangTai;
    }

    public void setWeiZhuangTai(int weiZhuangTai) {
        WeiZhuangTai = weiZhuangTai;
    }
}
