package com.example.crime1;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {
	private static final String EXTRA_CRIME_ID = "com.example.crime1.crime_id";
	
	public static Intent newIntent(Context context, UUID crimeId) {
		Intent intent = new Intent(context, CrimeActivity.class);
		intent.putExtra(EXTRA_CRIME_ID, crimeId);
		return intent;
	}
	
	@Override
	protected Fragment createFragment() {
//		return new CrimeFragment();
		UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
		return CrimeFragment.newInstance(crimeId);
	}
}