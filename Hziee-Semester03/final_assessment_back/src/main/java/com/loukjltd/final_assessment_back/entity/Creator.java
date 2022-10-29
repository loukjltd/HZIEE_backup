package com.loukjltd.final_assessment_back.entity;

public class Creator {
	private int uID;
	private String uNickName;
	private String uMotto;
	private String uAvatar;
	private int uGroup;
	private int tRead;
	private int tLike;
	private int tCoin;
	private int tComment;
	private float tCash;
	private int uIfLogged;
	
	private int qID;
	private String qTitle;
	private String qContent;
	private int qStatus;
	private int pID;
	private String pTitle;
	private String pContent;
	private int pLike;
	private int pStatus;
	
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
}
