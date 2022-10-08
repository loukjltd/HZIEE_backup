// HomePageParagraph.java用于获取数据库中专栏的数据

package com.loukjltd.final_assessment_back.entity;

public class HomePageParagraph {
	private int pID;
	private String pTitle;
	private String pContent;
	private int pLike;
	private String uNickName;
	private String uMotto;
	private String uAvatar;
	
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
