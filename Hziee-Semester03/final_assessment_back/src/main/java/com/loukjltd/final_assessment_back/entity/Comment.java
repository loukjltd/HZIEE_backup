package com.loukjltd.final_assessment_back.entity;

import java.util.Date;

public class Comment {
	private int pcID;
	private int pID;
	private int uID;
	private String pcContent;
	private int pcLike;
	private int pcStatus;
	private Date pcTime;
	private int acID;
	private int qID;
	private int aID;
	private String acContent;
	private int acLike;
	private int acStatus;
	private Date acTime;
	private String uNickName;
	private String uMotto;
	private String uAvatar;
	
	public int getPcID() {
		return pcID;
	}
	
	public void setPcID(int pcID) {
		this.pcID = pcID;
	}
	
	public int getpID() {
		return pID;
	}
	
	public void setpID(int pID) {
		this.pID = pID;
	}
	
	public int getuID() {
		return uID;
	}
	
	public void setuID(int uID) {
		this.uID = uID;
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
	
	public int getAcID() {
		return acID;
	}
	
	public void setAcID(int acID) {
		this.acID = acID;
	}
	
	public int getqID() {
		return qID;
	}
	
	public void setqID(int qID) {
		this.qID = qID;
	}
	
	public int getaID() {
		return aID;
	}
	
	public void setaID(int aID) {
		this.aID = aID;
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
	
	public String getuNickName() {
		return uNickName;
	}
	
	public void setuNickName(String uNickName) {
		this.uNickName = uNickName;
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
}
