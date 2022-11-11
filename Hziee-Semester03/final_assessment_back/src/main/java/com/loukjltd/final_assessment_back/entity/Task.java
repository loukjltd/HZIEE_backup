package com.loukjltd.final_assessment_back.entity;

import java.util.Date;

public class Task {
	int tID;
	String tContent;
	int tProgress;
	int tFinish;
	int tValue;
	int tStatus;
	int uID;
	Date tUpdateTime;
	int tIfRefreshToday;
	Date tRefreshTime;
	
	public int gettID() {
		return tID;
	}
	
	public void settID(int tID) {
		this.tID = tID;
	}
	
	public String gettContent() {
		return tContent;
	}
	
	public void settContent(String tContent) {
		this.tContent = tContent;
	}
	
	public int gettProgress() {
		return tProgress;
	}
	
	public void settProgress(int tProgress) {
		this.tProgress = tProgress;
	}
	
	public int gettFinish() {
		return tFinish;
	}
	
	public void settFinish(int tFinish) {
		this.tFinish = tFinish;
	}
	
	public int gettValue() {
		return tValue;
	}
	
	public void settValue(int tValue) {
		this.tValue = tValue;
	}
	
	public int gettStatus() {
		return tStatus;
	}
	
	public void settStatus(int tStatus) {
		this.tStatus = tStatus;
	}
	
	public int getuID() {
		return uID;
	}
	
	public void setuID(int uID) {
		this.uID = uID;
	}
	
	public Date gettUpdateTime() {
		return tUpdateTime;
	}
	
	public void settUpdateTime(Date tUpdateTime) {
		this.tUpdateTime = tUpdateTime;
	}
	
	public int gettIfRefreshToday() {
		return tIfRefreshToday;
	}
	
	public void settIfRefreshToday(int tIfRefreshToday) {
		this.tIfRefreshToday = tIfRefreshToday;
	}
	
	public Date gettRefreshTime() {
		return tRefreshTime;
	}
	
	public void settRefreshTime(Date tRefreshTime) {
		this.tRefreshTime = tRefreshTime;
	}
}
