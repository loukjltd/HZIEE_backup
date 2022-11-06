package com.example.crime1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.crime1.databases.CrimeBaseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
	
	private static CrimeLab sCrimeLab;
	private List<Crime> mCrimes;
	private Context mContext;
	private SQLiteDatabase mDatabase;
	
	
	private CrimeLab(Context context) {
		mContext = context.getApplicationContext();
		mDatabase = new CrimeBaseHelper(mContext).getWritableDatabase();
		mCrimes = new ArrayList<>();
//		for (int i = 0; i < 100; i++) {
//			Crime crime = new Crime();
//			crime.setTitle("219350623 楼可嘉 " + i);
//			crime.setSolved(i % 2 == 0);
//			mCrimes.add(crime);
//		}
	
	}
	
	public static CrimeLab get(Context context) {
		if (sCrimeLab == null) {
			sCrimeLab = new CrimeLab(context);
		}
		return sCrimeLab;
	}
	
	public void addCrime(Crime crime) {
		mCrimes.add(crime);
	}
	
	public List<Crime> getCrimes() {
		return mCrimes;
	}
	
	public Crime getCrime(UUID id) {
		for (Crime crime : mCrimes) {
			if (crime.getId().equals(id)) {
				return crime;
			}
		}
		return null;
	}
	
	
}
