package com.example.dzykfc.entity;
//购物车表gouwuche
public class GouWuChe {
    private int GouId;//购物车序号
    private String DingId;//订单序号
    private int CaiId;//菜品Id
    private int CaiPinShuLiang;//菜品数量

    public int getGouId() {
        return GouId;
    }

    public void setGouId(int gouId) {
        GouId = gouId;
    }

    public String getDingId() {
        return DingId;
    }

    public void setDingId(String dingId) {
        DingId = dingId;
    }

    public int getCaiId() {
        return CaiId;
    }

    public void setCaiId(int caiId) {
        CaiId = caiId;
    }

    public int getCaiPinShuLiang() {
        return CaiPinShuLiang;
    }

    public void setCaiPinShuLiang(int caiPinShuLiang) {
        CaiPinShuLiang = caiPinShuLiang;
    }
}
