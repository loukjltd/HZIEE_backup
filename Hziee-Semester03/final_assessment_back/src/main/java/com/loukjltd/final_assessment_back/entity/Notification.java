package com.loukjltd.final_assessment_back.entity;

public class Notification {
	private int nID;
	private int uID;
	private String nTitle;
	private String nContent;
	private int nFlag;
	private int nClass;
	
	public int getnID() {
		return nID;
	}
	
	public void setnID(int nID) {
		this.nID = nID;
	}
	
	public int getuID() {
		return uID;
	}
	
	public void setuID(int uID) {
		this.uID = uID;
	}
	
	public String getnTitle() {
		return nTitle;
	}
	
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	
	public String getnContent() {
		return nContent;
	}
	
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	
	public int getnFlag() {
		return nFlag;
	}
	
	public void setnFlag(int nFlag) {
		this.nFlag = nFlag;
	}
	
	public int getnClass() {
		return nClass;
	}
	
	public void setnClass(int nClass) {
		this.nClass = nClass;
	}
}
