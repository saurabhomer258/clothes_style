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

public class DropDownSelectTime extends RelativeLayout {
    Spinner spinner;
    public DropDownSelectTime(Context context) {
        super(context);
        init(context);
    }

    public DropDownSelectTime(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DropDownSelectTime(Context context, AttributeSet attrs, int defStyleAttr) {
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
            list.add("8:15 - 9:05");
            list.add("9:05 - 9:55");
            list.add("9:55 - 10:45");
            list.add("10:45 - 11:35");
            list.add("11:35 - 12:25");
            list.add("12:25 - 1:15");
            list.add("2:00 - 2:50");
            list.add("2:50 - 3:40");
            list.add("3:40 - 4:30");
            list.add("4:30 - 5:20");
            list.add("5:20 - 6:10");
            list.add("6:10 - 7:00");


            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(dataAdapter);

        }
    }
}
