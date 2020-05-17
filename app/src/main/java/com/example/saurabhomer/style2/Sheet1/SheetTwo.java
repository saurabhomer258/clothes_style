package com.example.saurabhomer.style2.Sheet1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.saurabhomer.style2.R;
import com.example.saurabhomer.style2.Sheet1.sheetmodel.SheetTwoModel;
import com.example.saurabhomer.style2.cardviewmenu.CardMenuP;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.saurabhomer.style2.Sheet1.SheetOne.sheetOneModel;
import static com.example.saurabhomer.style2.Sheet1.SheetOne.sheetTwoModels;
import static com.example.saurabhomer.style2.ui.home.HomeFragment.STYLE_NUMBER;

public class SheetTwo extends AppCompatActivity {
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheet_two);



        final EditText time = findViewById(R.id.edt_time).findViewById(R.id.atvCommon);
        final EditText lap = findViewById(R.id.edt_lap).findViewById(R.id.atvCommon);
        final EditText target = findViewById(R.id.edt_target).findViewById(R.id.atvCommon);
        final EditText output = findViewById(R.id.edt_output).findViewById(R.id.atvCommon);
        Button next =findViewById(R.id.btn_next).findViewById(R.id.btnNext);
        Button done =findViewById(R.id.btn_done).findViewById(R.id.btnNext);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SheetTwoModel sheetTwoModel = new SheetTwoModel();
                sheetTwoModel.setTime(time.getText().toString());
                sheetTwoModel.setLap(lap.getText().toString());
                sheetTwoModel.setOutput(output.getText().toString());
                sheetTwoModel.setTarget(target.getText().toString());
                sheetTwoModels.add(sheetTwoModel);
                Intent intent = new Intent(SheetTwo.this,SheetTwo.class);
                startActivity(intent);
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SheetTwoModel sheetTwoModel = new SheetTwoModel();
                sheetTwoModel.setTime(time.getText().toString());
                sheetTwoModel.setLap(lap.getText().toString());
                sheetTwoModel.setOutput(output.getText().toString());
                sheetTwoModel.setTarget(target.getText().toString());
                sheetTwoModels.add(sheetTwoModel);
                sheetOneModel.setSheetTwoArrayList(sheetTwoModels);
                FirebaseDatabase.getInstance().getReference("sheetone").child(STYLE_NUMBER).setValue(sheetOneModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (!task.isComplete()) {
                            Toast.makeText(SheetTwo.this, "opps ! some thing went wrong, please try again", Toast.LENGTH_SHORT).show();
                        }
//                        progressDialog.dismiss();
                        finish();
                    }
                });
                Intent intent = new Intent(SheetTwo.this, ResultActivity.class);
                startActivity(intent);
            }
        });
    }
}
