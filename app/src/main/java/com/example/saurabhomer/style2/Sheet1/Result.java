package com.example.saurabhomer.style2.Sheet1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabhomer.style2.R;
import com.example.saurabhomer.style2.Sheet1.admin.SheetModifyAdmin;
import com.example.saurabhomer.style2.Sheet1.sheetmodel.SheetModifyModel;
import com.example.saurabhomer.style2.cardviewmenu.CardMenuP;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.saurabhomer.style2.ui.home.HomeFragment.STYLE_NUMBER;

public class Result extends AppCompatActivity {

    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_total2);
        Button ok = (Button) findViewById(R.id.btn_ok);
        layout = findViewById(R.id.dailyLayout);

        FirebaseDatabase.getInstance().getReference("sheetmodify")
                .child(STYLE_NUMBER).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                SheetModifyModel sheetModifyModel = dataSnapshot.getValue(SheetModifyModel.class);
                if(sheetModifyModel!=null)
                {
                    setLayout("Total Output", (sheetModifyModel.getTotalOutput()));
                    setLayout("Total Target",(sheetModifyModel.getTotaltarget()));
                }
                else
                {
                    setLayout("No data avaible","");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result.this, CardMenuP.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void setLayout(String object, String result) {
        if (result != null) {
            TextView textView = new TextView(Result.this);
            String res = "";

            textView.setText(object + " : " + result);
            textView.setTextColor(this.getResources().getColor(R.color.black));
            layout.addView(textView);
        }
    }

    private void setLayout() {

        TextView textView = new TextView(Result.this);
        textView.setText("______________________");
        layout.addView(textView);

    }
}
