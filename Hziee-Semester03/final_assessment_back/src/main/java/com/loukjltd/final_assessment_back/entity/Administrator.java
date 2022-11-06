package com.loukjltd.final_assessment_back.entity;

import java.util.Date;

public class Administrator {
	private int uID;
	private String uNickName;
	private String uPhone;
	private String uPassword;
	private String uMotto;
	private String uAvatar;
	private int uIfLogged;
	private int uGroup;
	private int tRead;
	private int tLike;
	private int tCoin;
	private int tComment;
	private int tCash;
	private Date uLastLoggedTime;
	private int pID;
	private String pTitle;
	private String pContent;
	private int pLike;
	private int pStatus;
	private int pcID;
	private String pcContent;
	private int pcLike;
	private int pcStatus;
	private Date pcTime;
	private int qID;
	private String qTitle;
	private String qContent;
	private int qStatus;
	private int aID;
	private String aContent;
	private int aLike;
	private int aStatus;
	private int acID;
	private String acContent;
	private int acLike;
	private int acStatus;
	private Date acTime;
	
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
	
	public int getuIfLogged() {
		return uIfLogged;
	}
	
	public void setuIfLogged(int uIfLogged) {
		this.uIfLogged = uIfLogged;
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
	
	public int gettCash() {
		return tCash;
	}
	
	public void settCash(int tCash) {
		this.tCash = tCash;
	}
	
	public Date getuLastLoggedTime() {
		return uLastLoggedTime;
	}
	
	public void setuLastLoggedTime(Date uLastLoggedTime) {
		this.uLastLoggedTime = uLastLoggedTime;
	}
	
	public int getpID() {
		return pID;
	}
	
	public void setpID(int pID) {
		this.pID = pID;
	}
	
	public String getpTitle() {
		return pTitle;
	}
	
	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}
	
	public String getpContent() {
		return pContent;
	}
	
	public void setpContent(String pContent) {
		this.pContent = pContent;
	}
	
	public int getpLike() {
		return pLike;
	}
	
	public void setpLike(int pLike) {
		this.pLike = pLike;
	}
	
	public int getpStatus() {
		return pStatus;
	}
	
	public void setpStatus(int pStatus) {
		this.pStatus = pStatus;
	}
	
	public int getPcID() {
		return pcID;
	}
	
	public void setPcID(int pcID) {
		this.pcID = pcID;
	}
	
	public String getPcContent() {
		return pcContent;
	}
	
	public void setPcContent(String pcContent) {
		this.pcContent = pcContent;
	}
	
	public int getPcLike() {
		return pcLike;
	}
	
	public void setPcLike(int pcLike) {
		this.pcLike = pcLike;
	}
	
	public int getPcStatus() {
		return pcStatus;
	}
	
	public void setPcStatus(int pcStatus) {
		this.pcStatus = pcStatus;
	}
	
	public Date getPcTime() {
		return pcTime;
	}
	
	public void setPcTime(Date pcTime) {
		this.pcTime = pcTime;
	}
	
	public int getqID() {
		return qID;
	}
	
	public void setqID(int qID) {
		this.qID = qID;
	}
	
	public String getqTitle() {
		return qTitle;
	}
	
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	
	public String getqContent() {
		return qContent;
	}
	
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}
	
	public int getqStatus() {
		return qStatus;
	}
	
	public void setqStatus(int qStatus) {
		this.qStatus = qStatus;
	}
	
	public int getaID() {
		return aID;
	}
	
	public void setaID(int aID) {
		this.aID = aID;
	}
	
	public String getaContent() {
		return aContent;
	}
	
	public void setaContent(String aContent) {
		this.aContent = aContent;
	}
	
	public int getaLike() {
		return aLike;
	}
	
	public void setaLike(int aLike) {
		this.aLike = aLike;
	}
	
	public int getaStatus() {
		return aStatus;
	}
	
	public void setaStatus(int aStatus) {
		this.aStatus = aStatus;
	}
	
	public int getAcID() {
		return acID;
	}
	
	public void setAcID(int acID) {
		this.acID = acID;
	}
	
	public String getAcContent() {
		return acContent;
	}
	
	public void setAcContent(String acContent) {
		this.acContent = acContent;
	}
	
	public int getAcLike() {
		return acLike;
	}
	
	public void setAcLike(int acLike) {
		this.acLike = acLike;
	}
	
	public int getAcStatus() {
		return acStatus;
	}
	
	public void setAcStatus(int acStatus) {
		this.acStatus = acStatus;
	}
	
	public Date getAcTime() {
		return acTime;
	}
	
	public void setAcTime(Date acTime) {
		this.acTime = acTime;
	}
}
