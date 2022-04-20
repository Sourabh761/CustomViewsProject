package com.example.customviewsproject.customViews;

import android.app.Activity;
import android.text.InputType;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

import com.example.customviewsproject.CustomViewTypeDataClass;
import com.example.customviewsproject.R;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Arrays;
import java.util.List;

public class MyDropDown {

    private final Activity context;
    private final CustomViewTypeDataClass cfvm;

    public MyDropDown(Activity context, CustomViewTypeDataClass cfvm) {
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

        //*********************TEXT INPUT LAYOUT***********************
        TextInputLayout textInputLayout = new TextInputLayout(context,null,R.style.MyExposedOutlinedBox);

        MaterialAutoCompleteTextView autoCompleteTextView = new MaterialAutoCompleteTextView(context);
        autoCompleteTextView.setPadding(12,0,12,0);
        autoCompleteTextView.setInputType(InputType.TYPE_NULL);

        List<String> spinnerArray = Arrays.asList(context.getResources().getStringArray(R.array.expense_array));
        ArrayAdapter<String> arrayAdapter =  new ArrayAdapter<>
                (context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                        spinnerArray);

        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView.setText(spinnerArray.get(0),false);
        textInputLayout.addView(autoCompleteTextView);


        autoCompleteTextView.setOnItemClickListener((adapterView, view, i, l) -> {

            Log.i("uni","i "+ i);
        });




        layout.addView(textInputLayout);

        return layout;
    }


}
