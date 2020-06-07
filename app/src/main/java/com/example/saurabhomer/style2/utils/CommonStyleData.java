package com.example.saurabhomer.style2.utils;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.saurabhomer.style2.Model.StyleModel.StyleSheetModel;
import com.example.saurabhomer.style2.R;;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.saurabhomer.style2.ui.home.HomeFragment.STYLE_NUMBER;


public class CommonStyleData extends AppCompatActivity
{
    Button Ok;
    LinearLayout layout;
    private ProgressDialog progressDialog;
    private String styleNu;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_style_data);
        layout = findViewById(R.id.dailyLayout);
        Ok = (Button)findViewById(R.id.ok);

        progressDialog = new ProgressDialog(this);
        if (!NetworkUtils.isNetworkConnected(CommonStyleData.this))
        {
            return;
        }
        progressDialog.setMessage("Verificating...");
        progressDialog.show();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference users = firebaseDatabase.getReference("styles");
        users.child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                if(dataSnapshot!=null)
                {
//                    this.sheetNumber = sheetNumber;
//                    BuyersName = buyersName;
//                    ProduectDetail = produectDetail;
//                    Description = description;
//                    this.totalQuality = totalQuality;
//                    ShipmentDate = shipmentDate;
//                    this.sum = sum;
//                    this.lineNumber = lineNumber;
//                    this.lineEfficiency = lineEfficiency;
//                    this.size = size;
                    StyleSheetModel styleSheetModel = dataSnapshot.getValue(StyleSheetModel.class);
                    if(styleSheetModel!=null) {
                        setLayout("Sheet Number", STYLE_NUMBER);
                        setLayout("Buyers Name", styleSheetModel.getBuyersName());
                        setLayout("Product detail", styleSheetModel.getProduectDetail());
                        setLayout("Shipment Date", styleSheetModel.getShipmentDate());
                        setLayout("Total order quanity ", styleSheetModel.getTotalQuality());
                        setLayout("sam ", styleSheetModel.getSum());
                        setLayout("size ", styleSheetModel.getSize());
                        setLayout("Total Man power ", styleSheetModel.getTotalManPower());

                    }
//                    setLayout("color",styleSheetModel.getColor());
//                    setLayout("size",styleSheetModel.getSize());


                    progressDialog.hide();
                }
                else
                {
                     progressDialog.hide();
                }
              
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }



        });



        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        if (progressDialog != null)
        {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
    private void setLayout(String object , String result)
    {
        TextView textView= new TextView(CommonStyleData.this);
        textView.setText(object + " : "+result);
        layout.addView(textView);
    }
}
