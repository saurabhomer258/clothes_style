package com.example.saurabhomer.style2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.saurabhomer.style2.RegistrationActivity;
import com.example.saurabhomer.style2.pref.LoginPref;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(LoginPref.getInstance(this).getUserName().isEmpty())
        {
            Intent i = new Intent(this, RegistrationActivity.class);
            startActivity(i);
            finish();
        }
    }
}
