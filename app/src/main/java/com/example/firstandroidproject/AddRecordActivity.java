package com.example.firstandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.firstandroidproject.app.App;
import com.example.firstandroidproject.database.dao.FoodDao;
import com.example.firstandroidproject.database.model.FoodEntity;
import com.example.firstandroidproject.databinding.ActivityAddRecord2Binding;

public class AddRecordActivity extends AppCompatActivity {

    private FoodDao dao;
    private ActivityAddRecord2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddRecord2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setAppBar();

        binding.btnAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                

                    FoodEntity food = new FoodEntity();
                    food.setFood_id(Integer.parseInt(binding.etFoodId.getText().toString()));
                    food.setName(binding.etName.getText().toString());
                    food.setPrice(String.valueOf(Double.parseDouble(binding.etPrice.getText().toString())));

                    App.foodDao.insertItem(food);

            }
        });
    }

    private void setAppBar() {
        if(getSupportActionBar() != null){
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.txtAddRecord);
        }
    }
}