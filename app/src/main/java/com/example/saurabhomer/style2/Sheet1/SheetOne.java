package com.example.saurabhomer.style2.Sheet1;

import android.app.DatePickerDialog;
import android.content.Intent;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.saurabhomer.style2.R;
import com.example.saurabhomer.style2.Sheet1.sheetmodel.SheetOneModel;
import com.example.saurabhomer.style2.Sheet1.sheetmodel.SheetTwoModel;
import com.example.saurabhomer.style2.utils.CommonStyleData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.example.saurabhomer.style2.ui.home.HomeFragment.date_in_globler;

public class SheetOne extends AppCompatActivity implements
        View.OnClickListener {

    static SheetOneModel sheetOneModel = new SheetOneModel();
    static ArrayList<SheetTwoModel> sheetTwoModels = new ArrayList<>();
    private int mYear, mMonth, mDay, mHour, mMinute;
    Button info_btn;
    ImageButton btnDatePicker;
    EditText txtDate;
    TextView rundays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheet_one);
        btnDatePicker = (ImageButton) findViewById(R.id.btn_date);
        txtDate = (EditText) findViewById(R.id.in_date);
        btnDatePicker.setOnClickListener(this);

        info_btn = (Button) findViewById(R.id.info_daily);
        final EditText totalman = findViewById(R.id.edt_totalman).findViewById(R.id.atvCommon);
        final EditText remainingquantity = findViewById(R.id.edt_remaining).findViewById(R.id.atvCommon);
        final EditText totallineoutput = findViewById(R.id.edt_totallineoutput).findViewById(R.id.atvCommon);
        rundays = findViewById(R.id.edt_no_rundays);

        Button next = findViewById(R.id.bt_next).findViewById(R.id.btnNext);

        txtDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().trim().isEmpty()) {
                   // String defferenceDate = getDefferenceDate(s.toString(), date_in_globler);
                    //rundays.setText(defferenceDate);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sheetOneModel.setDate(txtDate.getText().toString());
                sheetOneModel.setTotalman(totalman.getText().toString());
                sheetOneModel.setRemainingquantity(remainingquantity.getText().toString());
                sheetOneModel.setTotallineoutput(totallineoutput.getText().toString());
                sheetOneModel.setRundays(rundays.getText().toString());
                String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
                sheetOneModel.setCurrentTime(currentTime.toString());
                Intent intent = new Intent(SheetOne.this, SheetTwo.class);
                startActivity(intent);
                finish();
            }
        });

        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SheetOne.this, CommonStyleData.class);
                startActivity(intent);
            }
        });
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
                            txtDate.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                            String defferenceDate = getDefferenceDate(dayOfMonth + "-" + (month + 1) + "-" + year, date_in_globler);
                            rundays.setText(defferenceDate);
                        }

                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }


    public String getDefferenceDate(String CurrentDate, String FinalDate) {
        if(FinalDate==null ||  FinalDate.isEmpty() || CurrentDate==null || CurrentDate.isEmpty() ) return "..";

        Date date1  = new Date();
        Date date2 =  new Date();

        SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");
        Log.d("eeeeee1", CurrentDate  + "");
        String[] a = CurrentDate.split("-");
        String day = a[0];
        String day1 = a[1];
        String day2 = a[2];
        String d1 = day1 + "/" + day + "/" + day2;
        //Setting dates
        try {
            date1 = dates.parse(d1);
        } catch (ParseException e) {
            Log.d("eeeeee", e.getMessage().toString() + "");
            e.printStackTrace();
        }

        String[] a1 = FinalDate.split("-");
        String day11 = a1[0];
        String day12 = a1[1];
        String day13 = a1[2];
        String d2 = day12 + "/" + day11 + "/" + day13;
        try {
            date2 = dates.parse(d2);
        } catch (ParseException e) {
            Log.d("eeeeee1", e.getMessage().toString() + "");
            e.printStackTrace();
        }


        //Comparing dates
        long difference = Math.abs(date1.getTime() - date2.getTime());
        long differenceDates = difference / (24 * 60 * 60 * 1000);

        //Convert long to String


        return differenceDates + "";


    }


}
