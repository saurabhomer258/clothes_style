package com.example.saurabhomer.style2.Sheet1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabhomer.style2.R;
import com.example.saurabhomer.style2.Sheet1.admin.SheetModifyAdmin;
import com.example.saurabhomer.style2.Sheet1.sheetmodel.SheetModifyModel;
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




            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
