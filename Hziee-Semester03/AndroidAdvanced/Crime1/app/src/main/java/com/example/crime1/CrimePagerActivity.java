package com.example.crime1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

public class CrimePagerActivity extends AppCompatActivity {
	private static final String EXTRA_CRIME_ID = "com.example.crime1.crime_id";
	
	private ViewPager mViewPager;
	private List<Crime> mCrimes;
	
	public static Intent newIntent(Context context, UUID crimeId) {
		Intent intent = new Intent(context, CrimePagerActivity.class);
		intent.putExtra(EXTRA_CRIME_ID, crimeId);
		return intent;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crime_pager);
		
		UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
		
		mViewPager = findViewById(R.id.activity_crime_view_pager);
		mCrimes = CrimeLab.get(this).getCrimes();
		
		FragmentManager fm = getSupportFragmentManager();
		mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
			@Override
			public Fragment getItem(int i) {
				Crime crime = mCrimes.get(i);
				return CrimeFragment.newInstance(crime.getId());
			}
			
			@Override
			public int getCount() {
				return mCrimes.size();
			}
		});
		
		for (int i = 0; i < mCrimes.size(); i++) {
			if (mCrimes.get(i).getId().equals(crimeId)) {
				mViewPager.setCurrentItem(i);
				break;
			}
		}
		
	}
}
