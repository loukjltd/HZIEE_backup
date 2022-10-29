// HomePageQuestion.java用于获取数据库中提问的数据

package com.loukjltd.final_assessment_back.entity;

public class HomePageQuestion {
	private int uID;
	private String uNickName;
	private String uMotto;
	private String uAvatar;
	private int qID;
	private String qTitle;
	private String qContent;
	
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
}
