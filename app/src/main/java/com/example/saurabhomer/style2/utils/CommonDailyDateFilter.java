package com.example.saurabhomer.style2.utils;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.saurabhomer.style2.R;;


import java.util.Calendar;

public class CommonDailyDateFilter extends AppCompatActivity implements
        View.OnClickListener{
    ImageButton btnDatePicker, btnTimePicker;
    static EditText commontxtDate;
    Spinner finishing;
    private int mYear, mMonth, mDay, mHour, mMinute;
    String str,str1,str2;
    String test1 = "DialyInside";
    String testgetup ="DailyGetup";
    String testoutside = "DailyOutSide";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_daily_date_filter);
        btnDatePicker=(ImageButton)findViewById(R.id.btn_date);
        commontxtDate=(EditText)findViewById(R.id.in_date);
        btnDatePicker.setOnClickListener(this);
        finishing=(Spinner)    findViewById(R.id.edt_finishingcommon).findViewById(R.id.spinner);


        View btn_done = findViewById(R.id.btn_donedate);
        Button bt_done = btn_done.findViewById(R.id.btnNext);
//        bt_done.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                Intent intent=getIntent();
//                str = intent.getStringExtra("Name");
//                if(test1.equals(str))
//                {
//
//                    String strDate = commontxtDate.getText().toString();
//                    final String finish = finishing.getSelectedItem().toString();
//                    Intent i = new Intent(CommonDailyDateFilter.this, DailyfinishingAdmin.class);
//                    i.putExtra("insidedate",strDate);
//                    i.putExtra("insidefinishing",finish);
//                    startActivity(i);
//                }
//                else if(testoutside.equals(str))
//                {
//
//                    String strDate = commontxtDate.getText().toString();
//                    final String finish = finishing.getSelectedItem().toString();
//                    Intent i = new Intent(CommonDailyDateFilter.this, DailyfinishingOutsideAdmin.class);
//                    i.putExtra("outsidedate",strDate);
//                    i.putExtra("outsidefinishing",finish);
//                    startActivity(i);
//                }
//                else if(testgetup.equals(str))
//                {
//                    String strDate = commontxtDate.getText().toString();
//                    final String finish = finishing.getSelectedItem().toString();
//                    Intent i = new Intent(CommonDailyDateFilter.this, DailyfinishingGetUpAdmin.class);
//                    i.putExtra("getupdate",strDate);
//                    i.putExtra("getupfinishing",finish);
//                    startActivity(i);
//                }

          //  }
      //  });

    }

    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                            commontxtDate.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }
}
