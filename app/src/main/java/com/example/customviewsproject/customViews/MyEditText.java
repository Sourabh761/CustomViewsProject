package com.example.customviewsproject.customViews;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.text.InputType;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

import com.example.customviewsproject.CustomViewTypeDataClass;
import com.example.customviewsproject.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MyEditText {

    private final Activity context;
    private final CustomViewTypeDataClass cfvm;
    private TextInputLayout textInputLayout;

    public MyEditText(Activity context, CustomViewTypeDataClass customViewTypeDataClass){
        this.context = context;
        this.cfvm = customViewTypeDataClass;
    }


    public FrameLayout createFieldView(){

        //**************PARENT LAYOUT******************
        FrameLayout layout = new FrameLayout(context);
        LinearLayout.LayoutParams p1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(p1);



        //**************EDIT TEXT FOR TEXT INPUT LAYOUT*******************
        final TextInputEditText editText = new TextInputEditText(context);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        editText.setLayoutParams(p);
        editText.setMinimumHeight(56);
        editText.setSingleLine(false);
        editText.setTextColor(context.getResources().getColor(R.color.black));
        editText.setHintTextColor(ColorStateList.valueOf(context.getResources().getColor(R.color.purple_200)));
        editText.setTextSize(context.getResources().getDimension
                (R.dimen.default_text) / context.getResources().getDisplayMetrics().scaledDensity);
        editText.setBackground(null);
        editText.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);
        editText.setHint(cfvm.getInputType());
        editText.setPadding(22,48,22,22);
        editText.setText(cfvm.getInputType());
        editText.setInputType(InputType.TYPE_NULL);

        //*********************TEXT INPUT LAYOUT***********************
        textInputLayout = new TextInputLayout(context,null,R.style.MyDenseOutlined);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        textInputLayout.setLayoutParams(layoutParams);
        textInputLayout.setHintTextAppearance(R.style.TextSizeHint);
        textInputLayout.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
        textInputLayout.setBoxCornerRadii(16, 16, 16, 16);
        textInputLayout.setBoxBackgroundColor(ContextCompat.getColor(context,R.color.white));

        textInputLayout.addView(editText);

        //TextInputLayout added in Parent Layout
        layout.addView(textInputLayout);

        return layout;

    }


}
