package com.example.dzykfc.entity;

public class CaiPinBiao {
    //定义CaiPinBiao中的数据
    private int CaiId;//菜品Id
    private int LeiId;//菜品所属类别Id
    private String Cai;//菜品名称
    private float CaiJG;//菜品价格

    public int getCaiId() {
        return CaiId;
    }

    public void setCaiId(int caiId) {
        CaiId = caiId;
    }

    public int getLeiId() {
        return LeiId;
    }

    public void setLeiId(int leiId) {
        LeiId = leiId;
    }

    public String getCai() {
        return Cai;
    }

    public void setCai(String cai) {
        Cai = cai;
    }

    public float getCaiJG() {
        return CaiJG;
    }

    public void setCaiJG(float caiJG) {
        CaiJG = caiJG;
    }
}
