package com.demo456.entity;

/**
 * @author loukj
 */
public class UserInfo {
    private String userName;
    private String password;
    private int fstId;
    private int funcId;
    private int userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFstId() {
        return fstId;
    }

    public void setFstId(int fstId) {
        this.fstId = fstId;
    }

    public int getFuncId() {
        return funcId;
    }

    public void setFuncId(int funcId) {
        this.funcId = funcId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
