package com.example.crime1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.FileProvider;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class CrimeFragment extends Fragment {
	private static final String ARG_CRIME_ID = "crime_id";
	private static final String DIALOG_DATE = "DialogDate";
	private static final int REQUEST_DATE = 0;
	private static final int REQUEST_CODE = 1;
	private static final int REQUEST_PHOTO = 2;
	
	private Crime mCrime;
	private Button mDateButton;
	private Button mSuspectButton;
	private ImageView mPhotoView;
	private File mPhotoFile;
	
	public static CrimeFragment newInstance(UUID crimeId) {
		Bundle args = new Bundle();
		args.putSerializable(ARG_CRIME_ID, crimeId);
		
		CrimeFragment fragment = new CrimeFragment();
		fragment.setArguments(args);
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		assert getArguments() != null;
		UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
		mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
		mPhotoFile = CrimeLab.get(getActivity()).getPhotoFile(mCrime);
	}
	
	@Override
	public void onPause() {
		super.onPause();
		
		CrimeLab.get(getActivity()).updateCrime(mCrime);
	}
	
	@SuppressLint("MissingInflatedId")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_crime, container, false);
		
		//名称
		EditText mTitleField = v.findViewById(R.id.crime_title);
		mTitleField.setText(mCrime.getTitle());
		mTitleField.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			
			}
			
			@Override
			public void onTextChanged(CharSequence s, int i, int i1, int i2) {
				mCrime.setTitle(s.toString());
			}
			
			@Override
			public void afterTextChanged(Editable editable) {
			
			}
		});
		
		mDateButton = v.findViewById(R.id.crime_date);
		mDateButton.setText(mCrime.getDate().toString());
		mDateButton.setOnClickListener(view -> {
			FragmentManager fm = getFragmentManager();
			DatePickerFragment dialog = DatePickerFragment.newInstance(mCrime.getDate());
			
			dialog.setTargetFragment(CrimeFragment.this, REQUEST_DATE);
			
			dialog.show(fm, DIALOG_DATE);
		});
		
		Button mDeleteButton = v.findViewById(R.id.crime_delete);
		mDeleteButton.setOnClickListener(view -> {
			CrimeLab.get(getActivity()).deleteCrime(mCrime);
			Objects.requireNonNull(getActivity()).finish();
		});
		
		//是否解决
		CheckBox mSolvedCheckBox = v.findViewById(R.id.crime_solved);
		mSolvedCheckBox.setChecked(mCrime.isSolved());
		mSolvedCheckBox.setOnCheckedChangeListener((compoundButton, b) -> mCrime.setSolved(b));
		
		Button mReportButton = v.findViewById(R.id.crime_report);
		mReportButton.setOnClickListener(view -> {
			Intent i = new Intent(Intent.ACTION_SEND);
			i.setType("text/plain");
			i.putExtra(Intent.EXTRA_TEXT, getCrimeReport());
			i.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.crime_report_subject));
			i = Intent.createChooser(i, getString(R.string.send_report));
			startActivity(i);
		});
		
		final Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.ContactsContract.Contacts.CONTENT_URI);
		mSuspectButton = v.findViewById(R.id.crime_suspect);
		mSuspectButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivityForResult(pickIntent, REQUEST_CODE);
			}
		});
		
		if (mCrime.getSuspect() != null) {
			mSuspectButton.setText(mCrime.getSuspect());
		}
		
		ImageButton mPhotoButton = v.findViewById(R.id.crime_camera);
		final Intent captureImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		
		mPhotoButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Uri uri = FileProvider.getUriForFile(Objects.requireNonNull(getActivity()), "com.example.crime1.fileprovider", mPhotoFile);
				captureImage.putExtra(MediaStore.EXTRA_OUTPUT, uri);
				
				@SuppressLint("QueryPermissionsNeeded") List<ResolveInfo> cameraActivities = getActivity().getPackageManager().queryIntentActivities(captureImage, PackageManager.MATCH_DEFAULT_ONLY);
				
				for (ResolveInfo activity : cameraActivities) {
					getActivity().grantUriPermission(activity.activityInfo.packageName, uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
				}
				
				startActivityForResult(captureImage, REQUEST_PHOTO);
			}
		});
		mPhotoView = v.findViewById(R.id.crime_photo);
		updatePhotoView();
		
		return v;
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode != Activity.RESULT_OK) {
			return;
		}
		
		if (requestCode == REQUEST_DATE) {
			Date date = (Date) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
			mCrime.setDate(date);
			mDateButton.setText(mCrime.getDate().toString());
		} else if (requestCode == REQUEST_CODE && data != null) {
			Uri contactUri = data.getData();
			String[] queryFields = new String[]{ContactsContract.Contacts.DISPLAY_NAME};
			
			try (Cursor c = Objects.requireNonNull(getActivity()).getContentResolver().query(
					contactUri, queryFields, null, null, null)) {
				if (c.getCount() == 0) {
					return;
				}
				
				c.moveToFirst();
				String suspect = c.getString(0);
				mCrime.setSuspect(suspect);
				mSuspectButton.setText(suspect);
			}
		} else if (requestCode == REQUEST_PHOTO) {
			Uri uri = FileProvider.getUriForFile(Objects.requireNonNull(getActivity()), "com.example.crime1.fileprovider", mPhotoFile);
			getActivity().revokeUriPermission(uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
			updatePhotoView();
		}
	}
	
	private String getCrimeReport() {
		String solvedString = null;
		if (mCrime.isSolved()) {
			solvedString = getString(R.string.crime_report_solved);
		} else {
			solvedString = getString(R.string.crime_report_unsolved);
		}
		
		String dateFormat = "EEE, MMM dd";
		String dateString = android.text.format.DateFormat.format(dateFormat, mCrime.getDate()).toString();
		
		String suspect = mCrime.getSuspect();
		if (suspect == null) {
			suspect = getString(R.string.crime_report_no_suspect);
		} else {
			suspect = getString(R.string.crime_report_suspect, suspect);
		}
		
		return getString(R.string.crime_report, mCrime.getTitle(), dateString, solvedString, suspect);
	}
	
	private void updatePhotoView() {
		if (mPhotoFile == null || !mPhotoFile.exists()) {
			mPhotoView.setImageDrawable(null);
		} else {
			Bitmap bitmap = PictureUtils.getScaleBitmap(mPhotoFile.getPath(), Objects.requireNonNull(getActivity()));
			mPhotoView.setImageBitmap(bitmap);
		}
	}
}