package com.example.saurabhomer.style2.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.saurabhomer.style2.R;;

public class DailyFinishingEditText extends RelativeLayout {
    EditText atvCommon;
    public DailyFinishingEditText(Context context) {
        super(context);
        init(context);
    }

    public DailyFinishingEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DailyFinishingEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    void init(Context context) {
        LayoutInflater inflater =
                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            View view = inflater.inflate(R.layout.daily_finishing_edit_text, this);
            atvCommon = view.findViewById(R.id.atvCommon);
        }
    }
    public String getText(){
      return atvCommon.getText().toString();
    }

}
