package com.demo456.entity;

/**
 * @author loukj
 */
public class PdfScanParameter {
    private int fstId;
    private String pdaCode;
    private int scanId;
    private int whId;
    private int createPerson;

    public int getFstId() {
        return fstId;
    }

    public void setFstId(int fstId) {
        this.fstId = fstId;
    }

    public String getPdaCode() {
        return pdaCode;
    }

    public void setPdaCode(String pdaCode) {
        this.pdaCode = pdaCode;
    }

    public int getScanId() {
        return scanId;
    }

    public void setScanId(int scanId) {
        this.scanId = scanId;
    }

    public int getWhId() {
        return whId;
    }

    public void setWhId(int whId) {
        this.whId = whId;
    }

    public int getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(int createPerson) {
        this.createPerson = createPerson;
    }
}
