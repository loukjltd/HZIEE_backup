package com.loukjltd.final_assessment_back.entity;

public class Answer {
	private int aID;
	private int uID;
	private int qID;
	private String aContent;
	private int aLike;
	private int aStatus;
	private String uNickName;
	private String uMotto;
	private String uAvatar;
	
	public int getaID() {
		return aID;
	}
	
	public void setaID(int aID) {
		this.aID = aID;
	}
	
	public int getuID() {
		return uID;
	}
	
	public void setuID(int uID) {
		this.uID = uID;
	}
	
	public int getqID() {
		return qID;
	}
	
	public void setqID(int qID) {
		this.qID = qID;
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
