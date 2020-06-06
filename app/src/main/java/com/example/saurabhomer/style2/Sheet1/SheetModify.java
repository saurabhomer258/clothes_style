package com.example.saurabhomer.style2.Sheet1;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabhomer.style2.R;
import com.example.saurabhomer.style2.Sheet1.sheetmodel.SheetModifyModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.saurabhomer.style2.cardviewmenu.CardMenuP.sheetOneModel;
import static com.example.saurabhomer.style2.ui.home.HomeFragment.STYLE_NUMBER;

public class SheetModify extends AppCompatActivity {

    private ProgressDialog progressDialog;
    TextView time1,time2,time3,time4,time5,time6,time7,time8,time9,time10,time11,time12;
    EditText lap1,lap2,lap3,lap4,lap5,lap6,lap7,lap8,lap9,lap10,lap11,lap12;
    EditText output1,output2,output3,output4,output5,output6,output7,output8,output9,output10,output11,output12;
    EditText target1,target2,target3,target4,target5,target6,target7,target8,target9,target10,target11,target12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheet_modify);

        progressDialog = new ProgressDialog(this);
        Button next =findViewById(R.id.btn_next).findViewById(R.id.btnNext);
        Button done =findViewById(R.id.btn_done).findViewById(R.id.btnNext);
        time1 = (TextView)findViewById(R.id.time1);
        time2 = (TextView)findViewById(R.id.time2);
        time3 = (TextView)findViewById(R.id.time3);
        time4 = (TextView)findViewById(R.id.time4);
        time5 = (TextView)findViewById(R.id.time5);
        time6 = (TextView)findViewById(R.id.time6);
        time7 = (TextView)findViewById(R.id.time7);
        time8 = (TextView)findViewById(R.id.time8);
        time9 = (TextView)findViewById(R.id.time9);
        time10 = (TextView)findViewById(R.id.time10);
        time11 = (TextView)findViewById(R.id.time11);
        time12 = (TextView)findViewById(R.id.time12);

        lap1 = (EditText)findViewById(R.id.lap1);
        lap2 = (EditText)findViewById(R.id.lap2);
        lap3 = (EditText)findViewById(R.id.lap3);
        lap4 = (EditText)findViewById(R.id.lap4);
        lap5 = (EditText)findViewById(R.id.lap5);
        lap6 = (EditText)findViewById(R.id.lap6);
        lap7 = (EditText)findViewById(R.id.lap7);
        lap8 = (EditText)findViewById(R.id.lap8);
        lap9= (EditText)findViewById(R.id.lap9);
        lap10 = (EditText)findViewById(R.id.lap10);
        lap11 = (EditText)findViewById(R.id.lap11);
        lap12 = (EditText)findViewById(R.id.lap12);

        output1 = (EditText)findViewById(R.id.output1);
        output2 = (EditText)findViewById(R.id.output2);
        output3 = (EditText)findViewById(R.id.output3);
        output4 = (EditText)findViewById(R.id.output4);
        output5 = (EditText)findViewById(R.id.output5);
        output6 = (EditText)findViewById(R.id.output6);
        output7 = (EditText)findViewById(R.id.output7);
        output8 = (EditText)findViewById(R.id.output8);
        output9 = (EditText)findViewById(R.id.output9);
        output10 = (EditText)findViewById(R.id.output10);
        output11 = (EditText)findViewById(R.id.output11);
        output12 = (EditText)findViewById(R.id.output12);

        target1 = (EditText) findViewById(R.id.target1);
        target2 = (EditText) findViewById(R.id.target2);
        target3 = (EditText) findViewById(R.id.target3);
        target4 = (EditText) findViewById(R.id.target4);
        target5 = (EditText) findViewById(R.id.target5);
        target6 = (EditText) findViewById(R.id.target6);
        target7 = (EditText) findViewById(R.id.target7);
        target8 = (EditText) findViewById(R.id.target8);
        target9 = (EditText) findViewById(R.id.target9);
        target10 = (EditText) findViewById(R.id.target10);
        target11 = (EditText) findViewById(R.id.target11);
        target12 = (EditText) findViewById(R.id.target12);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.setMessage("Verificating...");
                progressDialog.show();

                int outputsum =0;
                int targetsum =0;

                SheetModifyModel sheetModifyModel = new SheetModifyModel();
//                outputsum = outputsum+Integer.parseInt(sheetModifyModel.getOutput1())+Integer.parseInt(sheetModifyModel.getOutput2())
//                        +Integer.parseInt(sheetModifyModel.getOutput3())+Integer.parseInt(sheetModifyModel.getOutput4())
//                        +Integer.parseInt(sheetModifyModel.getOutput5())+Integer.parseInt(sheetModifyModel.getOutput6())
//                        +Integer.parseInt(sheetModifyModel.getOutput7())+Integer.parseInt(sheetModifyModel.getOutput8())
//                        +Integer.parseInt(sheetModifyModel.getOutput9())+Integer.parseInt(sheetModifyModel.getOutput10())
//                        +Integer.parseInt(sheetModifyModel.getOutput11())+Integer.parseInt(sheetModifyModel.getOutput12());
//
//                targetsum = targetsum + Integer.parseInt(sheetModifyModel.getTarget1())+Integer.parseInt(sheetModifyModel.getTarget2())
//                        +Integer.parseInt(sheetModifyModel.getTarget3())+Integer.parseInt(sheetModifyModel.getTarget4())
//                        +Integer.parseInt(sheetModifyModel.getTarget5())+Integer.parseInt(sheetModifyModel.getTarget6())
//                        +Integer.parseInt(sheetModifyModel.getTarget7())+Integer.parseInt(sheetModifyModel.getTarget8())
//                        +Integer.parseInt(sheetModifyModel.getTarget9())+Integer.parseInt(sheetModifyModel.getTarget10())
//                        +Integer.parseInt(sheetModifyModel.getTarget11())+Integer.parseInt(sheetModifyModel.getTarget12());




                sheetModifyModel.setTime1(time1.getText().toString());
                sheetModifyModel.setTime2(time2.getText().toString());
                sheetModifyModel.setTime3(time3.getText().toString());
                sheetModifyModel.setTime4(time4.getText().toString());
                sheetModifyModel.setTime5(time5.getText().toString());
                sheetModifyModel.setTime6(time6.getText().toString());
                sheetModifyModel.setTime7(time7.getText().toString());
                sheetModifyModel.setTime8(time8.getText().toString());
                sheetModifyModel.setTime9(time9.getText().toString());
                sheetModifyModel.setTime10(time10.getText().toString());
                sheetModifyModel.setTime11(time11.getText().toString());
                sheetModifyModel.setTime12(time12.getText().toString());
                sheetModifyModel.setLap1(lap1.getText().toString());
                sheetModifyModel.setLap2(lap2.getText().toString());
                sheetModifyModel.setLap3(lap3.getText().toString());
                sheetModifyModel.setLap4(lap4.getText().toString());
                sheetModifyModel.setLap5(lap5.getText().toString());
                sheetModifyModel.setLap6(lap6.getText().toString());
                sheetModifyModel.setLap7(lap7.getText().toString());
                sheetModifyModel.setLap8(lap8.getText().toString());
                sheetModifyModel.setLap9(lap9.getText().toString());
                sheetModifyModel.setLap10(lap10.getText().toString());
                sheetModifyModel.setLap11(lap11.getText().toString());
                sheetModifyModel.setLap12(lap12.getText().toString());
                sheetModifyModel.setOutput1(output1.getText().toString());
                sheetModifyModel.setOutput2(output2.getText().toString());
                sheetModifyModel.setOutput3(output3.getText().toString());
                sheetModifyModel.setOutput4(output4.getText().toString());
                sheetModifyModel.setOutput5(output5.getText().toString());
                sheetModifyModel.setOutput6(output6.getText().toString());
                sheetModifyModel.setOutput7(output7.getText().toString());
                sheetModifyModel.setOutput8(output8.getText().toString());
                sheetModifyModel.setOutput9(output9.getText().toString());
                sheetModifyModel.setOutput10(output10.getText().toString());
                sheetModifyModel.setOutput11(output11.getText().toString());
                sheetModifyModel.setOutput12(output12.getText().toString());
                sheetModifyModel.setTarget1(target1.getText().toString());
                sheetModifyModel.setTarget2(target2.getText().toString());
                sheetModifyModel.setTarget3(target3.getText().toString());
                sheetModifyModel.setTarget4(target4.getText().toString());
                sheetModifyModel.setTarget5(target5.getText().toString());
                sheetModifyModel.setTarget6(target6.getText().toString());
                sheetModifyModel.setTarget7(target7.getText().toString());
                sheetModifyModel.setTarget8(target8.getText().toString());
                sheetModifyModel.setTarget9(target9.getText().toString());
                sheetModifyModel.setTarget10(target10.getText().toString());
                sheetModifyModel.setTarget11(target11.getText().toString());
                sheetModifyModel.setTarget12(target12.getText().toString());


                outputsum = outputsum +Integer.parseInt(sheetModifyModel.getOutput1())+Integer.parseInt(sheetModifyModel.getOutput2())+Integer.parseInt(sheetModifyModel.getOutput3())+Integer.parseInt(sheetModifyModel.getOutput4())+Integer.parseInt(sheetModifyModel.getOutput5())+Integer.parseInt(sheetModifyModel.getOutput6())
                +Integer.parseInt(sheetModifyModel.getOutput7())+Integer.parseInt(sheetModifyModel.getOutput8())+Integer.parseInt(sheetModifyModel.getOutput9())+Integer.parseInt(sheetModifyModel.getOutput10())+Integer.parseInt(sheetModifyModel.getOutput11())+Integer.parseInt(sheetModifyModel.getOutput12());

                targetsum = targetsum + Integer.parseInt(sheetModifyModel.getTarget1())+Integer.parseInt(sheetModifyModel.getTarget2())+Integer.parseInt(sheetModifyModel.getTarget3())+Integer.parseInt(sheetModifyModel.getTarget4())+Integer.parseInt(sheetModifyModel.getTarget5())+Integer.parseInt(sheetModifyModel.getTarget6())+Integer.parseInt(sheetModifyModel.getTarget7())+Integer.parseInt(sheetModifyModel.getTarget8())+Integer.parseInt(sheetModifyModel.getTarget9())
                +Integer.parseInt(sheetModifyModel.getTarget10())+Integer.parseInt(sheetModifyModel.getTarget11())+Integer.parseInt(sheetModifyModel.getTarget12());

                sheetModifyModel.setTotalOutput(Integer.toString(outputsum));
                sheetModifyModel.setTotaltarget(Integer.toString(targetsum));
                Toast.makeText(SheetModify.this, ""+outputsum+""+targetsum, Toast.LENGTH_SHORT).show();

                FirebaseDatabase.getInstance().getReference("sheetmodify").child(STYLE_NUMBER).setValue(sheetModifyModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (!task.isComplete()) {
                            Toast.makeText(SheetModify.this, "opps ! some thing went wrong, please try again", Toast.LENGTH_SHORT).show();
                            progressDialog.hide();
                        }
                        // progressDialog.dismiss();
                        Intent intent = new Intent(SheetModify.this, Result.class);
                        startActivity(intent);
                        finish();
                        progressDialog.hide();

                    }
                });
            }
        });

    }
}
