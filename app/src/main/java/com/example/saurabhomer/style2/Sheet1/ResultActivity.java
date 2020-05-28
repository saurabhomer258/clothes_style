package com.example.saurabhomer.style2.Sheet1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saurabhomer.style2.R;
import com.example.saurabhomer.style2.Sheet1.sheetmodel.SheetTwoModel;
import com.example.saurabhomer.style2.cardviewmenu.CardMenuP;

import static com.example.saurabhomer.style2.Sheet1.SheetOne.sheetOneModel;

public class ResultActivity extends AppCompatActivity {

    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_total2);
        Button ok = (Button) findViewById(R.id.btn_ok);
        layout = findViewById(R.id.dailyLayout);

        setLayout("Total Man Power ", sheetOneModel.getTotalman());
        setLayout("Remaining Quantity ", sheetOneModel.getRemainingquantity());
        setLayout("Total Line Output ", sheetOneModel.getTotallineoutput());
        setLayout("Date", sheetOneModel.getDate());
        setLayout("No. Of Runs Days", sheetOneModel.getRundays());

        int sum = 0,sum2 =0;
        for (SheetTwoModel items : SheetOne.sheetTwoModels) {
            setLayout();
            setLayout("Time",items.getTime());
            setLayout("Lap",items.getLap());
            setLayout("Output",items.getOutput());
            setLayout("Target",items.getTarget());
            try {
                sum = sum + Integer.parseInt(items.getOutput());
            }
            catch (Exception e){

            }
            try {
                sum2 = sum2 + Integer.parseInt(items.getTarget());
            }
            catch (Exception e){

            }
        }
        setLayout();
        setLayout("Total Output ", ""+sum);
        setLayout("Total Target ", ""+sum2);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, CardMenuP.class);
                startActivity(intent);
            }
        });

    }


    private void setLayout(String object, String result) {
        if (result != null) {
            TextView textView = new TextView(ResultActivity.this);
            String res = "";

            textView.setText(object + " : " + result);
            textView.setTextColor(this.getResources().getColor(R.color.black));
            layout.addView(textView);
        }
    }

    private void setLayout() {

        TextView textView = new TextView(ResultActivity.this);


        textView.setText("______________________");
        layout.addView(textView);

    }
}
