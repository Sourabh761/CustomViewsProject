package com.example.customviewsproject.customViews;

import android.app.Activity;
import android.text.InputType;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.example.customviewsproject.CustomViewTypeDataClass;
import com.example.customviewsproject.R;
import com.example.customviewsproject.databinding.MyDropDownBinding;
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

    public ConstraintLayout createFieldView() {

        MyDropDownBinding binding;
        binding = MyDropDownBinding.inflate(context.getLayoutInflater());
        //**************PARENT LAYOUT******************
//        FrameLayout layout = new FrameLayout(context);
//        LinearLayout.LayoutParams p1 = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT);
//        layout.setLayoutParams(p1);

        //*********************TEXT INPUT LAYOUT***********************
//        TextInputLayout textInputLayout = new TextInputLayout(context);
//
//        MaterialAutoCompleteTextView autoCompleteTextView = new MaterialAutoCompleteTextView(context);
//        autoCompleteTextView.setPadding(12,0,12,0);

        List<String> spinnerArray = Arrays.asList(context.getResources().getStringArray(R.array.expense_array));
        ArrayAdapter<String> arrayAdapter =  new ArrayAdapter<>
                (context, android.R.layout.simple_spinner_dropdown_item,
                        spinnerArray);

        binding.dropdownMenu.setAdapter(arrayAdapter);

        binding.dropdownMenu.setText(spinnerArray.get(0),false);


        binding.dropdownMenu.setOnItemClickListener((adapterView, view, i, l) -> Log.i("uni","i "+ i));




        return binding.getRoot();
    }


}
