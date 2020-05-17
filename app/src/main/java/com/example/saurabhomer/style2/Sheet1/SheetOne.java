package com.example.saurabhomer.style2.Sheet1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.saurabhomer.style2.R;
import com.example.saurabhomer.style2.Sheet1.sheetmodel.SheetOneModel;
import com.example.saurabhomer.style2.Sheet1.sheetmodel.SheetTwoModel;
import com.example.saurabhomer.style2.utils.CommonStyleData;

import java.util.ArrayList;
import java.util.Calendar;

public class SheetOne extends AppCompatActivity implements
        View.OnClickListener
{

    static SheetOneModel sheetOneModel = new SheetOneModel();
    static ArrayList<SheetTwoModel> sheetTwoModels = new ArrayList<>();
    private int mYear, mMonth, mDay, mHour, mMinute;
    Button info_btn;
    ImageButton btnDatePicker;
    EditText txtDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheet_one);
        btnDatePicker=(ImageButton)findViewById(R.id.btn_date);
        txtDate=(EditText)findViewById(R.id.in_date);
        btnDatePicker.setOnClickListener(this);

        info_btn = (Button)findViewById(R.id.info_daily);
        final EditText totalman = findViewById(R.id.edt_totalman).findViewById(R.id.atvCommon);
        final EditText remainingquantity = findViewById(R.id.edt_remaining).findViewById(R.id.atvCommon);
        final EditText totallineoutput = findViewById(R.id.edt_totallineoutput).findViewById(R.id.atvCommon);
        final EditText rundays = findViewById(R.id.edt_no_rundays).findViewById(R.id.atvCommon);

        Button next =findViewById(R.id.bt_next).findViewById(R.id.btnNext);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sheetOneModel.setDate(txtDate.getText().toString());
                sheetOneModel.setTotalman(totalman.getText().toString());
                sheetOneModel.setRemainingquantity(remainingquantity.getText().toString());
                sheetOneModel.setTotallineoutput(totallineoutput.getText().toString());
                sheetOneModel.setRundays(rundays.getText().toString());
                Intent intent = new Intent(SheetOne.this,SheetTwo.class);
                startActivity(intent);
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
                    new DatePickerDialog.OnDateSetListener()
                    {
                        @Override
                        public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth)
                        {
                            txtDate.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }


}