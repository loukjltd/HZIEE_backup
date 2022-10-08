package com.loukjltd.final_assessment_back.entity;

public class Question {
	private int qID;
	private String qTitle;
	private String qContent;
	private String uNickName;
	private String uMotto;
	private String uAvatar;
	
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
