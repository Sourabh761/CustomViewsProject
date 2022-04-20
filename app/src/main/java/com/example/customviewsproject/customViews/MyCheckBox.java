package com.example.customviewsproject.customViews;

import android.app.Activity;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.customviewsproject.CustomViewTypeDataClass;

public class MyCheckBox {

    private final Activity context;
    private final CustomViewTypeDataClass cfvm;

    public MyCheckBox(Activity context, CustomViewTypeDataClass cfvm) {
        this.context = context;
        this.cfvm = cfvm;
    }

    public LinearLayout createFieldView() {

        //**************PARENT LAYOUT******************
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams p1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(p1);



        //*************Check Box************************
        final CheckBox checkBox = new CheckBox(context);
        checkBox.setText(cfvm.getInputType());
        layout.addView(checkBox);

        final CheckBox checkBox1 = new CheckBox(context);
        checkBox1.setText("Option 2");
        layout.addView(checkBox1);

        return layout;



    }


}
