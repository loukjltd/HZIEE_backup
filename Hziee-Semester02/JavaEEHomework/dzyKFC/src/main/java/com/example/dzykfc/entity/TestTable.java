package com.example.dzykfc.entity;

public class TestTable {
    private int CaiId;//菜品Id
    private int LeiId;//菜品所属类别
    private String Cai;//菜品名称
    private int CaiJG;//菜品价格

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

    public int getCaiJG() {
        return CaiJG;
    }

    public void setCaiJG(int caiJG) {
        CaiJG = caiJG;
    }
}
