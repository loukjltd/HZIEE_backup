package com.example.crime1;

import java.util.Date;
import java.util.UUID;

public class Crime {
	private final UUID mId;
	private String mTitle;
	private Date mDate;
	private boolean mSolved;
	private String mSuspect;
	
	
	public Crime() {
		this(UUID.randomUUID());
	}
	
	public Crime(UUID id) {
		mId = id;
		mDate = new Date();
	}
	
	public UUID getId() {
		return mId;
	}
	
	
	public String getTitle() {
		return mTitle;
	}
	
	public void setTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	
	public Date getDate() {
		return mDate;
	}
	
	public void setDate(Date mDate) {
		this.mDate = mDate;
	}
	
	public boolean isSolved() {
		return mSolved;
	}
	
	public void setSolved(boolean mSolved) {
		this.mSolved = mSolved;
	}
	
	public String getSuspect() {
		return mSuspect;
	}
	
	public void setSuspect(String mSuspect) {
		this.mSuspect = mSuspect;
	}
	
	public String getPhotoFilename() {
		return "IMG_" + getId().toString() + ".jpg";
	}
}
