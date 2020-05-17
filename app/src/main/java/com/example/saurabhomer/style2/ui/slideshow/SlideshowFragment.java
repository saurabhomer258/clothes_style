package com.example.saurabhomer.style2.ui.slideshow;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabhomer.style2.R;;
import com.example.saurabhomer.style2.RegistrationActivity;
import com.example.saurabhomer.style2.pref.LoginPref;

import java.util.Objects;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LoginPref.getInstance(getContext()).setUsername("","");
        Toast.makeText(getContext(),"sucessfully logout", Toast.LENGTH_LONG).show();
        Intent i = new Intent(getContext(), RegistrationActivity.class);
        startActivity(i);
        Objects.requireNonNull(getActivity()).finish();
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
