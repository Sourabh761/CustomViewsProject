package com.example.customviewsproject;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customviewsproject.customViews.MyCheckBox;
import com.example.customviewsproject.customViews.MyDropDown;
import com.example.customviewsproject.customViews.MyEditText;
import com.example.customviewsproject.customViews.MyRadioButton;
import com.example.customviewsproject.databinding.ListItemBinding;

import java.util.ArrayList;

public class ViewTypeAdapter extends RecyclerView.Adapter<ViewTypeAdapter.MyViewHolder> {

    ArrayList<CustomViewTypeDataClass> viewTypeList = new ArrayList<>();
    Activity context;

    public ViewTypeAdapter(Activity context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CustomViewTypeDataClass customViewTypeDataClass = viewTypeList.get(position);

        //adding question
        holder.binding.questionTv.setText(customViewTypeDataClass.getQuestion());
        holder.binding.frameLayout.removeAllViews();

        if (customViewTypeDataClass.getViewType() == 1){
            MyEditText myEditText = new MyEditText(context,customViewTypeDataClass);
            FrameLayout frameLayout = myEditText.createFieldView();
            holder.binding.frameLayout.addView(frameLayout);

        }else if (customViewTypeDataClass.getViewType() == 2){
            MyRadioButton myRadioButton = new MyRadioButton(context,customViewTypeDataClass);
            FrameLayout frameLayout = myRadioButton.createFieldView();
            holder.binding.frameLayout.addView(frameLayout);

        }else if (customViewTypeDataClass.getViewType() == 3){

            MyCheckBox myCheckBox = new MyCheckBox(context,customViewTypeDataClass);
            LinearLayout frameLayout = myCheckBox.createFieldView();
            holder.binding.frameLayout.addView(frameLayout);

        }else {
            MyDropDown myDropDown = new MyDropDown(context,customViewTypeDataClass);
            ConstraintLayout frameLayout = myDropDown.createFieldView();
            holder.binding.frameLayout.addView(frameLayout);

        }
    }

    @Override
    public int getItemCount() {
        return viewTypeList.size();
    }

    @Override
    public int getItemViewType(int position) {
                return viewTypeList.get(position).viewType;
    }

    public void setViewTypeList(ArrayList<CustomViewTypeDataClass> customViewTypeDataClasses){
        this.viewTypeList = customViewTypeDataClasses;
        notifyDataSetChanged();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        public ListItemBinding binding;

        public MyViewHolder(ListItemBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
