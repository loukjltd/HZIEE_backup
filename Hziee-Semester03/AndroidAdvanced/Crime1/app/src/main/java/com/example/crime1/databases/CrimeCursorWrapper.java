package com.example.crime1.databases;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.crime1.Crime;

import java.util.Date;
import java.util.UUID;

public class CrimeCursorWrapper extends CursorWrapper {
	public CrimeCursorWrapper(Cursor cursor) {
		super(cursor);
	}
	
	public Crime getCrime() {
		String uuid = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.UUID));
		String title = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.TITLE));
		long date = getLong(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.DATE));
		int isSolved = getInt(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.SOLVED));
		String suspect = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.SUSPECT));
		
		Crime crime = new Crime(UUID.fromString(uuid));
		crime.setTitle(title);
		crime.setDate(new Date(date));
		crime.setSolved(isSolved != 0);
		crime.setSuspect(suspect);
		
		return crime;
	}
}
