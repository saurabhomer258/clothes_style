package com.example.saurabhomer.style2.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.example.saurabhomer.style2.R;;

import java.util.ArrayList;
import java.util.List;

public class DropDownSelectGernel extends RelativeLayout {
    Spinner spinner;
    public DropDownSelectGernel(Context context) {
        super(context);
        init(context);
    }

    public DropDownSelectGernel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DropDownSelectGernel(Context context, AttributeSet attrs, int defStyleAttr) {
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
            list.add("GENERAL1");
            list.add("GENERAL2");
            list.add("GENERAL3");



            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(dataAdapter);

        }
    }
}
