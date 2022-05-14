package com.example.customviewsproject.customViews;

import android.app.Activity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.customviewsproject.CustomViewTypeDataClass;

public class MyRadioButton {

    private final Activity context;
    private final CustomViewTypeDataClass cfvm;

    public MyRadioButton(Activity context, CustomViewTypeDataClass cfvm) {
        this.context = context;
        this.cfvm = cfvm;
    }

    public FrameLayout createFieldView() {

        //**************PARENT LAYOUT******************
        FrameLayout layout = new FrameLayout(context);
        LinearLayout.LayoutParams p1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(p1);


        //**********Radio Group*************************
        final RadioGroup radioGroup = new RadioGroup(context);
        radioGroup.setOrientation(RadioGroup.VERTICAL);

        final RadioButton radioButton = new RadioButton(context);
        radioButton.setText(cfvm.getInputType());
        radioGroup.addView(radioButton);

        final RadioButton radioButton2 = new RadioButton(context);
        radioButton2.setText("Option 2");
        radioGroup.addView(radioButton2);

        layout.addView(radioGroup);

        return layout;



    }
}
