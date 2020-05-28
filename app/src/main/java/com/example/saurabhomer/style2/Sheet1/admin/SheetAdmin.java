package com.example.saurabhomer.style2.Sheet1.admin;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabhomer.style2.R;
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

public class SheetAdmin extends AppCompatActivity {

    LinearLayout layout;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheet_admin);

        layout = findViewById(R.id.dailyLayout);

        if (!NetworkUtils.isNetworkConnected(SheetAdmin.this))
        {
            return;
        }
        progressDialog = new ProgressDialog(SheetAdmin.this);
        progressDialog.setMessage("Verificating...");
        progressDialog.show();
        FirebaseDatabase.getInstance().getReference("sheetone")
                .child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                SheetOneModel sheetOneModel = dataSnapshot.getValue(SheetOneModel.class);

                if(sheetOneModel!=null) {
                    setLayout("Total Man Power", sheetOneModel.getTotalman());
                    setLayout("Remaining Quantity", sheetOneModel.getRemainingquantity());
                    setLayout("Total Line Output", sheetOneModel.getTotallineoutput());
                    setLayout("Date", sheetOneModel.getDate());
                    setLayout("No of Runs Days", sheetOneModel.getRundays());
                    setLayout("current time ", sheetOneModel.getCurrentTime());

                    TextView textView = new TextView(SheetAdmin.this);
                    textView.setText("_________________________________________________");
                    layout.addView(textView);


                    ArrayList<SheetTwoModel> list = sheetOneModel.getSheetTwoArrayList();
                    for (SheetTwoModel items : list) {
                        setLayout("Time", items.getTime());
                        setLayout("Lap", items.getLap());
                        setLayout("Output", items.getOutput());
                        setLayout("Target", items.getTarget());
                    }
                    progressDialog.hide();
                }
                else {
                    Toast.makeText(SheetAdmin.this, "Data is not found", Toast.LENGTH_SHORT).show();

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
            AdminResult textView = new AdminResult(SheetAdmin.this);
            String res = "";

            textView.setText(object, result);
            layout.addView(textView);
        }
    }
}
