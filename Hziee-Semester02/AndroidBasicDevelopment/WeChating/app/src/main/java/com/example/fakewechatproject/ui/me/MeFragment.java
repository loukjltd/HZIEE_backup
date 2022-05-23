package com.example.fakewechatproject.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.fakewechatproject.EmptyContentPage;
import com.example.fakewechatproject.R;

public class MeFragment extends Fragment implements View.OnClickListener {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MeViewModel mineViewModel = new ViewModelProvider(this).get(MeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_me, container, false);
        mineViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), EmptyContentPage.class);
        startActivity(intent);
    }
}