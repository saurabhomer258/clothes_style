package com.example.saurabhomer.style2.Sheet1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.saurabhomer.style2.R;

public class SheetTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheet_two);



        final EditText time = findViewById(R.id.edt_time).findViewById(R.id.atvCommon);
        final EditText lap = findViewById(R.id.edt_lap).findViewById(R.id.atvCommon);
        final EditText target = findViewById(R.id.edt_target).findViewById(R.id.atvCommon);
        final EditText output = findViewById(R.id.edt_output).findViewById(R.id.atvCommon);
        Button next =findViewById(R.id.btn_next).findViewById(R.id.btnNext);
        Button done =findViewById(R.id.btn_done).findViewById(R.id.btnNext);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
