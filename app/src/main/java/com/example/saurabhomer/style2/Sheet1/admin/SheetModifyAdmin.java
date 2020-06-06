package com.example.saurabhomer.style2.Sheet1.admin;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabhomer.style2.R;
import com.example.saurabhomer.style2.Sheet1.sheetmodel.SheetModifyModel;
import com.example.saurabhomer.style2.Sheet1.sheetmodel.SheetOneModel;
import com.example.saurabhomer.style2.Sheet1.sheetmodel.SheetTwoModel;
import com.example.saurabhomer.style2.customView.AdminResult;
import com.example.saurabhomer.style2.utils.NetworkUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.saurabhomer.style2.ui.home.HomeFragment.STYLE_NUMBER;

public class SheetModifyAdmin extends AppCompatActivity {
    LinearLayout layout;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheet_admin);
        layout = findViewById(R.id.dailyLayout);

        if (!NetworkUtils.isNetworkConnected(SheetModifyAdmin.this))
        {
            return;
        }
        progressDialog = new ProgressDialog(SheetModifyAdmin.this);
        progressDialog.setMessage("Verificating...");
        progressDialog.show();

        FirebaseDatabase.getInstance().getReference("sheetmodify")
                .child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                SheetModifyModel sheetModifyModel = dataSnapshot.getValue(SheetModifyModel.class);

                if(sheetModifyModel!=null) {
                    setLayout("Time", sheetModifyModel.getTime1());
                    setLayout("Lap",sheetModifyModel.getLap1());
                    setLayout("Output",sheetModifyModel.getOutput1());
                    setLayout("Target",sheetModifyModel.getTarget1());

                    TextView textView= new TextView(SheetModifyAdmin.this);
                    textView.setText("_________________________________________________");
                    layout.addView(textView);

                    setLayout("Time", sheetModifyModel.getTime2());
                    setLayout("Lap",sheetModifyModel.getLap2());
                    setLayout("Output",sheetModifyModel.getOutput2());
                    setLayout("Target",sheetModifyModel.getTarget2());

                    TextView textView1= new TextView(SheetModifyAdmin.this);
                    textView1.setText("_________________________________________________");
                    layout.addView(textView1);


                    setLayout("Time", sheetModifyModel.getTime3());
                    setLayout("Lap",sheetModifyModel.getLap3());
                    setLayout("Output",sheetModifyModel.getOutput3());
                    setLayout("Target",sheetModifyModel.getTarget3());

                    TextView textView2= new TextView(SheetModifyAdmin.this);
                    textView2.setText("_________________________________________________");
                    layout.addView(textView2);

                    setLayout("Time", sheetModifyModel.getTime4());
                    setLayout("Lap",sheetModifyModel.getLap4());
                    setLayout("Output",sheetModifyModel.getOutput4());
                    setLayout("Target",sheetModifyModel.getTarget4());

                    TextView textView3= new TextView(SheetModifyAdmin.this);
                    textView3.setText("_________________________________________________");
                    layout.addView(textView3);

                    setLayout("Time", sheetModifyModel.getTime5());
                    setLayout("Lap",sheetModifyModel.getLap5());
                    setLayout("Output",sheetModifyModel.getOutput5());
                    setLayout("Target",sheetModifyModel.getTarget5());

                    TextView textView4= new TextView(SheetModifyAdmin.this);
                    textView4.setText("_________________________________________________");
                    layout.addView(textView4);


                    setLayout("Time", sheetModifyModel.getTime6());
                    setLayout("Lap",sheetModifyModel.getLap6());
                    setLayout("Output",sheetModifyModel.getOutput6());
                    setLayout("Target",sheetModifyModel.getTarget6());

                    TextView textView5= new TextView(SheetModifyAdmin.this);
                    textView5.setText("_________________________________________________");
                    layout.addView(textView5);

                    setLayout("Time", sheetModifyModel.getTime7());
                    setLayout("Lap",sheetModifyModel.getLap7());
                    setLayout("Output",sheetModifyModel.getOutput7());
                    setLayout("Target",sheetModifyModel.getTarget7());

                    TextView textView6= new TextView(SheetModifyAdmin.this);
                    textView6.setText("_________________________________________________");
                    layout.addView(textView6);

                    setLayout("Time", sheetModifyModel.getTime8());
                    setLayout("Lap",sheetModifyModel.getLap8());
                    setLayout("Output",sheetModifyModel.getOutput8());
                    setLayout("Target",sheetModifyModel.getTarget8());

                    TextView textView7= new TextView(SheetModifyAdmin.this);
                    textView7.setText("_________________________________________________");
                    layout.addView(textView7);


                    setLayout("Time", sheetModifyModel.getTime9());
                    setLayout("Lap",sheetModifyModel.getLap9());
                    setLayout("Output",sheetModifyModel.getOutput9());
                    setLayout("Target",sheetModifyModel.getTarget9());

                    TextView textView8= new TextView(SheetModifyAdmin.this);
                    textView8.setText("_________________________________________________");
                    layout.addView(textView8);

                    setLayout("Time", sheetModifyModel.getTime9());
                    setLayout("Lap",sheetModifyModel.getLap9());
                    setLayout("Output",sheetModifyModel.getOutput9());
                    setLayout("Target",sheetModifyModel.getTarget9());

                    TextView textView9= new TextView(SheetModifyAdmin.this);
                    textView9.setText("_________________________________________________");
                    layout.addView(textView9);

                    setLayout("Time", sheetModifyModel.getTime10());
                    setLayout("Lap",sheetModifyModel.getLap10());
                    setLayout("Output",sheetModifyModel.getOutput10());
                    setLayout("Target",sheetModifyModel.getTarget10());

                    TextView textView10= new TextView(SheetModifyAdmin.this);
                    textView10.setText("_________________________________________________");
                    layout.addView(textView10);

                    setLayout("Time", sheetModifyModel.getTime11());
                    setLayout("Lap",sheetModifyModel.getLap11());
                    setLayout("Output",sheetModifyModel.getOutput11());
                    setLayout("Target",sheetModifyModel.getTarget11());

                    TextView textView11= new TextView(SheetModifyAdmin.this);
                    textView11.setText("_________________________________________________");
                    layout.addView(textView11);


                    setLayout("Time", sheetModifyModel.getTime12());
                    setLayout("Lap",sheetModifyModel.getLap12());
                    setLayout("Output",sheetModifyModel.getOutput12());
                    setLayout("Target",sheetModifyModel.getTarget12());

                    TextView textView12= new TextView(SheetModifyAdmin.this);
                    textView11.setText("_________________________________________________");
                    layout.addView(textView12);

                    setLayout("Total Output",sheetModifyModel.getTotalOutput());
                    setLayout("Total Target",sheetModifyModel.getTotaltarget());


                    progressDialog.hide();
                }
                else {
                    Toast.makeText(SheetModifyAdmin.this, "Data is not found", Toast.LENGTH_SHORT).show();

                    progressDialog.hide();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.hide();
            }
        });
    }


    private void setLayout(String object ,String result){
        if(result!=null) {
            AdminResult textView = new AdminResult(SheetModifyAdmin.this);
            String res = "";

            textView.setText(object, result);
            layout.addView(textView);
        }
    }

    private void setLayout(){

        AdminResult textView = new AdminResult(SheetModifyAdmin.this);
        String res = "";

        textView.setText();
        layout.addView(textView);

    }
}
