package com.example.saurabhomer.style2.cardviewmenu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;


import com.example.saurabhomer.style2.R;

import com.example.saurabhomer.style2.Sheet1.SheetTwo;
import com.example.saurabhomer.style2.Sheet1.admin.SheetAdmin;
import com.example.saurabhomer.style2.Sheet1.sheetmodel.SheetOneModel;
import com.example.saurabhomer.style2.Sheet1.sheetmodel.SheetTwoModel;
import com.example.saurabhomer.style2.pref.LoginPref;

import java.util.ArrayList;

public class CardMenuP extends AppCompatActivity
{
    private ProgressDialog progressDialog;
    public static SheetOneModel sheetOneModel = new SheetOneModel();
   public static ArrayList<SheetTwoModel> sheetTwoModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        sheetTwoModels = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_menu_p);
        CardView style = findViewById(R.id.cardview_style);
//        CardView outside = findViewById(R.id.cardview_outside);
//        CardView getup = findViewById(R.id.cardview_getup);
//        CardView measurmentreport = findViewById(R.id.cardview_measurmentreport);
//        CardView hourlyreport = findViewById(R.id.cardview_hourlyreport);
//        CardView meteldetection = findViewById(R.id.cardview_meteldetecttion);
//        CardView skutest = findViewById(R.id.cardview_sku);
//        CardView cartoonaudit = findViewById(R.id.cardview_cartoon);
//        CardView inlinefinal = findViewById(R.id.cardview_inline);

        progressDialog = new ProgressDialog(this);
        if (getIntent() != null) {
            Intent i = getIntent();


        }

        style.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sheetTwoModels = new ArrayList<>();
                if (LoginPref.getInstance(getApplicationContext()).getAdmin().equals(1 + "")) {
                    Intent i =  new Intent(CardMenuP.this, SheetAdmin.class);
                    startActivity(i);
                }
                else {

                    Intent i = new Intent(CardMenuP.this, SheetTwo.class);
                    startActivity(i);
                }
                progressDialog.hide();
            }
        });
    }


    //        outside.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openDailyFinishingOutsidecheck();
//            }
//        });
//        getup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openDailyFinishingGetupcheck();
//            }
//        });
//        measurmentreport.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (LoginPref.getInstance(getApplicationContext()).getAdmin().equals(1 + "")) {
//                    Intent i =  new Intent(CardMenuP.this, MesurementAdmin.class);
//                    i.putExtra("Name","Skutest");
//                    startActivity(i);
//                }
//                else {
//                    Intent i = new Intent(CardMenuP.this, Measurment.class);
//                    startActivity(i);
//
//                }
//                progressDialog.hide();
//            }
//        });
//        hourlyreport.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        meteldetection.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (LoginPref.getInstance(getApplicationContext()).getAdmin().equals(1 + "")) {
//                    Intent i =  new Intent(CardMenuP.this, MetelDetectionAdmin.class);
//                    i.putExtra("Name","Metel");
//                    startActivity(i);
//                }
//                else {
//                    Intent i = new Intent(CardMenuP.this, MetelDetectionPage.class);
//                    startActivity(i);
//
//                }
//                progressDialog.hide();
//            }
//        });
//
//        skutest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (LoginPref.getInstance(getApplicationContext()).getAdmin().equals(1 + "")) {
//                    Intent i =  new Intent(CardMenuP.this, SkuAdmin.class);
//                    i.putExtra("Name","Skutest");
//                    startActivity(i);
//                }
//                else {
//                    Intent i = new Intent(CardMenuP.this, SkuCheckReport100Page1.class);
//                    startActivity(i);
//
//                }
//                progressDialog.hide();
//            }
//
//        });
//
//
//        cartoonaudit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (LoginPref.getInstance(getApplicationContext()).getAdmin().equals(1 + "")) {
//                    Intent i =  new Intent(CardMenuP.this, CartoonAuditAdmin.class);
//                    startActivity(i);
//                }
//                else {
//                    Intent i = new Intent(CardMenuP.this, CartoonAudit.class);
//                    startActivity(i);
//
//                }
//                progressDialog.hide();
//            }
//        });
//
//        inlinefinal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (LoginPref.getInstance(getApplicationContext()).getAdmin().equals(1 + "")) {
//                    Intent i =  new Intent(CardMenuP.this, InlineFinalPreLineAdmin.class);
//                    startActivity(i);
//                }
//                else {
//                    Intent i = new Intent(CardMenuP.this, InlinePrelineFinal.class);
//                    startActivity(i);
//
//                }
//                progressDialog.hide();
//            }
//        });
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        if (progressDialog != null) {
//            progressDialog.dismiss();
//            progressDialog = null;
//        }
//    }
//
//    void openDailyFinishingcheck(){
//        progressDialog.setMessage("Verificating...");
//        progressDialog.show();
//        if (LoginPref.getInstance(getApplicationContext()).getAdmin().equals(1 + "")) {
//            Intent i =  new Intent(CardMenuP.this, CommonDailyDateFilter.class);
//            i.putExtra("Name","DialyInside");
//            startActivity(i);
//        }
//        else {
//            Intent i = new Intent(CardMenuP.this, DailyFinishingDefectAnalysis.class);
//            startActivity(i);
//
//        }
//        progressDialog.hide();
//
//    }
//    void openDailyFinishingGetupcheck(){
//        progressDialog.setMessage("Verificating...");
//        progressDialog.show();
//
//        if (LoginPref.getInstance(getApplicationContext()).getAdmin().equals(1 + "")) {
//            Intent i =  new Intent(CardMenuP.this, CommonDailyDateFilter.class);
//            i.putExtra("Name","DailyGetup");
//            startActivity(i);
//        }
//        else {
//            Intent i = new Intent(CardMenuP.this, DailyFinishingDefectAnalysisGetup.class);
//            startActivity(i);
//
//        }
//        progressDialog.hide();
//    }
//
//    void openDailyFinishingOutsidecheck(){
//        progressDialog.setMessage("Verificating...");
//        progressDialog.show();
//        if (LoginPref.getInstance(getApplicationContext()).getAdmin().equals(1 + "")) {
//            Intent i =  new Intent(CardMenuP.this, CommonDailyDateFilter.class);
//            i.putExtra("Name","DailyOutSide");
//            startActivity(i);
//        }
//        else {
//            Intent i = new Intent(CardMenuP.this, DailyFinishingDefectAnalysisOutside.class);
//            startActivity(i);
//        }
//        progressDialog.hide();
//
//    }
}