package com.example.customviewsproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.customviewsproject.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<CustomViewTypeDataClass> viewTypeList = new ArrayList<>();
        viewTypeList.add(new CustomViewTypeDataClass(1,"hello","random question"));
        viewTypeList.add(new CustomViewTypeDataClass(2,"dfadfa","kalkdfalkjfdlk jkladjlk jal;kjlkj"));
        viewTypeList.add(new CustomViewTypeDataClass(1,"dfadfaf","a;ldkfalkfjklj j lkjalkjlkjklj"));
        viewTypeList.add(new CustomViewTypeDataClass(2,"adfafdaf","Llklkjlkjlkjlkjlkjakldjfj"));
        viewTypeList.add(new CustomViewTypeDataClass(1,"afdafasd","kadjflkaj'" +
                "a;lfjl kjlkaj"));
        viewTypeList.add(new CustomViewTypeDataClass(2,"hello my nan e kjafkdjkl","lkkjkk"));
        viewTypeList.add(new CustomViewTypeDataClass(3,"heldjkl","a;lkdsjfalkjflkjk"));
        viewTypeList.add(new CustomViewTypeDataClass(3,"l","laksdfjlkajlkfj"));
        viewTypeList.add(new CustomViewTypeDataClass(3,"l","laksdfjlkajlkfj"));
        viewTypeList.add(new CustomViewTypeDataClass(4,"adfafl","adfaflkajlkfj"));
        viewTypeList.add(new CustomViewTypeDataClass(4,"ladaf","lakadfafffflkfj"));
        viewTypeList.add(new CustomViewTypeDataClass(4,"adfafdl","adkajlkfj"));

        ViewTypeAdapter viewTypeAdapter = new ViewTypeAdapter(this);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerview.setAdapter(viewTypeAdapter);

        viewTypeAdapter.setViewTypeList(viewTypeList);
    }
}