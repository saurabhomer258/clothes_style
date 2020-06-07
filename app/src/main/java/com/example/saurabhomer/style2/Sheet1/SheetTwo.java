package com.example.saurabhomer.style2.Sheet1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.saurabhomer.style2.R;
import com.example.saurabhomer.style2.Sheet1.sheetmodel.SheetTwoModel;
import com.example.saurabhomer.style2.cardviewmenu.CardMenuP;
import com.example.saurabhomer.style2.utils.CommonStyleData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



import static com.example.saurabhomer.style2.cardviewmenu.CardMenuP.sheetOneModel;
import static com.example.saurabhomer.style2.cardviewmenu.CardMenuP.sheetTwoModels;
import static com.example.saurabhomer.style2.ui.home.HomeFragment.STYLE_NUMBER;
import static com.example.saurabhomer.style2.ui.home.HomeFragment.date_in_globler;
import static com.example.saurabhomer.style2.ui.home.HomeFragment.total_order_qu;

public class SheetTwo extends AppCompatActivity {
    private ProgressDialog progressDialog;
    Button info_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheet_two);


        info_btn = (Button) findViewById(R.id.info_daily);
        final Spinner time = findViewById(R.id.edt_time).findViewById(R.id.spinner);
        final EditText lap = findViewById(R.id.edt_lap).findViewById(R.id.atvCommon);
        final EditText target = findViewById(R.id.edt_target).findViewById(R.id.atvCommon);
        final EditText output = findViewById(R.id.edt_output).findViewById(R.id.atvCommon);
        Button next =findViewById(R.id.btn_next).findViewById(R.id.btnNext);
        Button done =findViewById(R.id.btn_done).findViewById(R.id.btnNext);
        progressDialog = new ProgressDialog(this);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Verificating...");
                progressDialog.show();
                SheetTwoModel sheetTwoModel = new SheetTwoModel();
                sheetTwoModel.setTime(time.getSelectedItem().toString());
                sheetTwoModel.setLap(lap.getText().toString());
                sheetTwoModel.setOutput(output.getText().toString());
                sheetTwoModel.setTarget(target.getText().toString());
                sheetTwoModels.add(sheetTwoModel);
                Intent intent = new Intent(SheetTwo.this,SheetTwo.class);
                startActivity(intent);
                finish();
            }
        });
        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SheetTwo.this, CommonStyleData.class);
                startActivity(intent);
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Verificating...");
                progressDialog.show();
                SheetTwoModel sheetTwoModel = new SheetTwoModel();
                sheetTwoModel.setTime(time.getSelectedItem().toString());
                sheetTwoModel.setLap(lap.getText().toString());
                sheetTwoModel.setOutput(output.getText().toString());
                sheetTwoModel.setTarget(target.getText().toString());
                sheetTwoModels.add(sheetTwoModel);
               int  sum =0 ;
               int  sum1 =0 ;
               int sum2 = 0;
                for ( SheetTwoModel sheetTwoModel1 : sheetTwoModels  ){
                    try
                    {
                        sum  =  sum  + Integer.parseInt(sheetTwoModel1.getOutput().trim());
                    }
                    catch (Exception e){

                    }

                    try
                    {
                        sum1  =  sum1  + Integer.parseInt(sheetTwoModel1.getTarget().trim());
                    }
                    catch (Exception e){

                    }


                }
                sheetOneModel.setTotallineoutput(sum+"");

               // sheetOneModel.setTarget(sum1+"");
                try {
                    sheetOneModel.setRemainingquantity((Integer.parseInt(total_order_qu) - sum1) + "");
                }
                catch (Exception e){
                    sheetOneModel.setRemainingquantity(0+"");
                }
                SimpleDateFormat df =  new SimpleDateFormat("MM/dd/yyyy");
                Date c = Calendar.getInstance().getTime();
                String CurrentDate = df.format(c);
                sheetOneModel.setDate(CurrentDate);
                String defferenceDate = getDefferenceDate( date_in_globler);
                sheetOneModel.setRundays(defferenceDate);


                sheetOneModel.setSheetTwoArrayList(sheetTwoModels);
                FirebaseDatabase.getInstance().getReference("sheetone").child(STYLE_NUMBER).setValue(sheetOneModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (!task.isComplete()) {
                            Toast.makeText(SheetTwo.this, "opps ! some thing went wrong, please try again", Toast.LENGTH_SHORT).show();
                            progressDialog.hide();
                        }
                       // progressDialog.dismiss();
                        Intent intent = new Intent(SheetTwo.this, ResultActivity.class);
                        startActivity(intent);
                        finish();
                        progressDialog.hide();
                    }
                });

            }
        });
    }


    public String getDefferenceDate(String FinalDate) {
        try {
            Date c = Calendar.getInstance().getTime();


            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

            String CurrentDate = df.format(c);
            if (FinalDate == null || FinalDate.isEmpty() || CurrentDate == null || CurrentDate.isEmpty())
                return "..";

            Date date1 = new Date();
            Date date2 = new Date();

            SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");
            Log.d("eeeeee1", CurrentDate + "");

            String d1 = CurrentDate;
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
        catch (Exception e) {

        }
        return  0+"";


    }
}
