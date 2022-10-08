package com.loukjltd.final_assessment_back.entity;

public class Mine {
    private int uID;
    private String uNickName;
    private String uPhone;
    private String uPassword;
    private String uMotto;
    private String uAvatar;
    private int uGroup;
    private int tRead;
    private int tLike;
    private int tCoin;
    private int tComment;
    private float tCash;
    private int uIfLogged;
    private String uLastLoggedTime;

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public String getuNickName() {
        return uNickName;
    }

    public void setuNickName(String uNickName) {
        this.uNickName = uNickName;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuMotto() {
        return uMotto;
    }

    public void setuMotto(String uMotto) {
        this.uMotto = uMotto;
    }

    public String getuAvatar() {
        return uAvatar;
    }

    public void setuAvatar(String uAvatar) {
        this.uAvatar = uAvatar;
    }

    public int getuGroup() {
        return uGroup;
    }

    public void setuGroup(int uGroup) {
        this.uGroup = uGroup;
    }

    public int gettRead() {
        return tRead;
    }

    public void settRead(int tRead) {
        this.tRead = tRead;
    }

    public int gettLike() {
        return tLike;
    }

    public void settLike(int tLike) {
        this.tLike = tLike;
    }

    public int gettCoin() {
        return tCoin;
    }

    public void settCoin(int tCoin) {
        this.tCoin = tCoin;
    }

    public int gettComment() {
        return tComment;
    }

    public void settComment(int tComment) {
        this.tComment = tComment;
    }

    public float gettCash() {
        return tCash;
    }

    public void settCash(float tCash) {
        this.tCash = tCash;
    }

    public int getuIfLogged() {
        return uIfLogged;
    }

    public void setuIfLogged(int uIfLogged) {
        this.uIfLogged = uIfLogged;
    }

    public String getuLastLoggedTime() {
        return uLastLoggedTime;
    }

    public void setuLastLoggedTime(String uLastLoggedTime) {
        this.uLastLoggedTime = uLastLoggedTime;
    }
}
