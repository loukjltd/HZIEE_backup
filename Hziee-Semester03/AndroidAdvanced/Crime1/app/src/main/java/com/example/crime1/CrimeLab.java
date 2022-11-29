package com.example.crime1;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.crime1.databases.CrimeBaseHelper;
import com.example.crime1.databases.CrimeCursorWrapper;
import com.example.crime1.databases.CrimeDbSchema;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
	
	@SuppressLint("StaticFieldLeak")
	private static CrimeLab sCrimeLab;
	private final SQLiteDatabase mDatabase;
	private final Context mContext;
	
	
	private CrimeLab(Context context) {
		//	private List<Crime> mCrimes;
		mContext = context.getApplicationContext();
		mDatabase = new CrimeBaseHelper(mContext).getWritableDatabase();
	}
	
	public static CrimeLab get(Context context) {
		if (sCrimeLab == null) {
			sCrimeLab = new CrimeLab(context);
		}
		return sCrimeLab;
	}
	
	private static ContentValues getContentValues(Crime crime) {
		ContentValues values = new ContentValues();
		values.put(CrimeDbSchema.CrimeTable.Cols.UUID, crime.getId().toString());
		values.put(CrimeDbSchema.CrimeTable.Cols.TITLE, crime.getTitle());
		values.put(CrimeDbSchema.CrimeTable.Cols.DATE, crime.getDate().getTime());
		values.put(CrimeDbSchema.CrimeTable.Cols.SOLVED, crime.isSolved() ? 1 : 0);
		values.put(CrimeDbSchema.CrimeTable.Cols.SUSPECT, crime.getSuspect());
		return values;
	}
	
	public void addCrime(Crime crime) {
		ContentValues values = getContentValues(crime);
		mDatabase.insert(CrimeDbSchema.CrimeTable.NAME, null, values);
	}
	
	public void updateCrime(Crime crime) {
		String uuid = crime.getId().toString();
		ContentValues values = getContentValues(crime);
		mDatabase.update(
				CrimeDbSchema.CrimeTable.NAME,
				values,
				CrimeDbSchema.CrimeTable.Cols.UUID + " = ?",
				new String[]{uuid}
		);
	}
	
	//	private Cursor queryCrimes(String whereClause, String[] whereArgs) {
	private CrimeCursorWrapper queryCrime(String whereClause, String[] whereArgs) {
		Cursor cursor = mDatabase.query(
				CrimeDbSchema.CrimeTable.NAME,
				null,
				whereClause,
				whereArgs,
				null,
				null,
				null
		);
		return new CrimeCursorWrapper(cursor);
	}
	
	public void deleteCrime(Crime crime) {
		String uuid = crime.getId().toString();
		mDatabase.delete(
				CrimeDbSchema.CrimeTable.NAME,
				CrimeDbSchema.CrimeTable.Cols.UUID + " = ?",
				new String[]{uuid}
		);
	}
	
	public List<Crime> getCrimes() {
		List<Crime> crimes = new ArrayList<>();
		try (CrimeCursorWrapper cursor = queryCrime(null, null)) {
			cursor.moveToFirst();
			while (!cursor.isAfterLast()) {
				crimes.add(cursor.getCrime());
				cursor.moveToNext();
			}
		}
		return crimes;
	}
	
	public Crime getCrime(UUID id) {
		try (CrimeCursorWrapper cursor = queryCrime(
				CrimeDbSchema.CrimeTable.Cols.UUID + " = ?",
				new String[]{id.toString()}
		)) {
			if (cursor.getCount() == 0) {
				return null;
			}
			cursor.moveToFirst();
			return cursor.getCrime();
		}
	}
	
	public File getPhotoFile(Crime crime) {
		File fileDir = mContext.getFilesDir();
		return new File(fileDir, crime.getPhotoFilename());
	}
	
}
