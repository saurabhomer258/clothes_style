package com.example.saurabhomer.style2.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.example.saurabhomer.style2.R;

import java.util.ArrayList;
import java.util.List;

;

public class DropDownSelectLine extends RelativeLayout {
    Spinner spinner;
    public DropDownSelectLine(Context context) {
        super(context);
        init(context);
    }

    public DropDownSelectLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DropDownSelectLine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    void init(Context context) {
        LayoutInflater inflater =
                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            View view = inflater.inflate(R.layout.common_drop_down, this);
            spinner = (Spinner) findViewById(R.id.spinner);
            List<String> list = new ArrayList<String>();
            list.add("1");
            list.add("2");
            list.add("3");
            list.add("4");
            list.add("5");
            list.add("6");
            list.add("7");
            list.add("8");
            list.add("9");
            list.add("10");
            list.add("11");
            list.add("12");
            list.add("13");
            list.add("14");
            list.add("15");
            list.add("16");
            list.add("17");
            list.add("18");
            list.add("19");
            list.add("20");
            list.add("21");
            list.add("22");
            list.add("23");
            list.add("24");
            list.add("25");


            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(dataAdapter);

        }
    }
}
