package com.example.crime1;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class CrimeListFragment extends Fragment {
	private static final String SAVED_VISIBLE = "subtitle";
	
	private RecyclerView mCrimeRecyclerView;
	private CrimeAdapter mAdapter;
	private boolean mSubtitleVisible;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancsState) {
		
		View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
		
		mCrimeRecyclerView = view.findViewById(R.id.crime_recycler_view);
		mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		
		if (savedInstancsState != null) {
			mSubtitleVisible = savedInstancsState.getBoolean(SAVED_VISIBLE);
		}
		
		updateUI();
		return view;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		updateUI();
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.fragment_crime_list, menu);
		
		MenuItem subtitleItem = menu.findItem(R.id.show_subtitle);
		if (mSubtitleVisible) {
			subtitleItem.setTitle(R.string.hide_subtitle);
		} else {
			subtitleItem.setTitle(R.string.show_subtitle);
		}
		
	}
	
	@SuppressLint("NonConstantResourceId")
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.new_crime:
				Crime crime = new Crime();
				CrimeLab.get(getActivity()).addCrime(crime);
				Intent intent = CrimePagerActivity.newIntent(getActivity(), crime.getId());
				startActivity(intent);
				return true;
			case R.id.show_subtitle:
				mSubtitleVisible = !mSubtitleVisible;
				Objects.requireNonNull(getActivity()).invalidateOptionsMenu();
				updateSubtitle();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	private void updateSubtitle() {
		CrimeLab crimeLab = CrimeLab.get(getActivity());
		int crimeNum = crimeLab.getCrimes().size();
		String subtitle = getString(R.string.subtitle_format, crimeNum);
		
		if (!mSubtitleVisible) {
			subtitle = null;
		}
		
		AppCompatActivity activity = (AppCompatActivity) getActivity();
		assert activity != null;
		Objects.requireNonNull(activity.getSupportActionBar()).setSubtitle(subtitle);
	}
	
	@SuppressLint("NotifyDataSetChanged")
	private void updateUI() {
		CrimeLab crimeLab = CrimeLab.get(getActivity());
		List<Crime> crimes = crimeLab.getCrimes();
		if (mAdapter == null) {
			mAdapter = new CrimeAdapter(crimes);
			mCrimeRecyclerView.setAdapter(mAdapter);
		} else {
			mAdapter.setCrimes(crimes);
			mAdapter.notifyDataSetChanged();
		}
		
		updateSubtitle();
	}
	
	@Override
	public void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putBoolean(SAVED_VISIBLE, mSubtitleVisible);
	}
	
	private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
		
		private final TextView mTitleTextView;
		private final TextView mDateTextView;
		private final ImageView mSolvedImageView;
		private Crime mCrime;
		
		
		public CrimeHolder(LayoutInflater inflater, ViewGroup parent) {
			super(inflater.inflate(R.layout.list_item_crime, parent, false));
			
			itemView.setOnClickListener(this);
			mTitleTextView = itemView.findViewById(R.id.crime_title);
			mDateTextView = itemView.findViewById(R.id.crime_date);
			mSolvedImageView = itemView.findViewById(R.id.crime_solved);
		}
		
		public void bind(Crime crime) {
			mCrime = crime;
			mTitleTextView.setText(mCrime.getTitle());
			Date date = mCrime.getDate();
			SimpleDateFormat testFormat = new SimpleDateFormat("E, MMMM  dd, yyyy", Locale.ENGLISH);
			mDateTextView.setText(testFormat.format(date));
			System.out.println(mCrime.getDate().toString());
			mSolvedImageView.setVisibility(crime.isSolved() ? View.VISIBLE : View.GONE);
		}
		
		@Override
		public void onClick(View view) {
//			Toast.makeText(getActivity(), mCrime.getTitle() + "clicked!", Toast.LENGTH_SHORT)
//					.show();
			Intent intent = CrimePagerActivity.newIntent(getActivity(), mCrime.getId());
			startActivity(intent);
		}
		
	}
	
	private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
		private List<Crime> mCrimes;
		
		public CrimeAdapter(List<Crime> Crimes) {
			mCrimes = Crimes;
		}
		
		@NonNull
		@Override
		public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
			LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
			return new CrimeHolder(layoutInflater, parent);
		}
		
		@Override
		public void onBindViewHolder(CrimeHolder crimeHolder, int i) {
			Crime crime = mCrimes.get(i);
			crimeHolder.bind(crime);
		}
		
		@Override
		public int getItemCount() {
			return mCrimes.size();
		}
		
		public void setCrimes(List<Crime> crimes) {
			mCrimes = crimes;
		}
	}
}
