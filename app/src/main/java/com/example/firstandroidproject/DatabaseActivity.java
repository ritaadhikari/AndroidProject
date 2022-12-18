package com.example.firstandroidproject;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.firstandroidproject.adapter.FoodEntityAdapter;
import com.example.firstandroidproject.app.App;
import com.example.firstandroidproject.database.AppDatabase;
import com.example.firstandroidproject.database.dao.FoodDao;
import com.example.firstandroidproject.database.model.FoodEntity;
import com.example.firstandroidproject.databinding.ActivityDatabaseBinding;

import java.util.AbstractCollection;
import java.util.ArrayList;

public class DatabaseActivity extends AppCompatActivity {

    private ActivityDatabaseBinding binding;
    private ArrayList<FoodEntity> foodEntityArrayList = new ArrayList<>();
    private FoodEntityAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatabaseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setAppBar();

        binding.btnAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DatabaseActivity.this ,AddRecordActivity.class);
                startActivity(intent);
            }
        });
        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DatabaseActivity.this,"Delete Button clicked",Toast.LENGTH_LONG).show();
            }
        });

        binding.rvRecords.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        foodEntityArrayList.addAll(App.foodDao.getAllItems());


        adapter = new FoodEntityAdapter(DatabaseActivity.this, foodEntityArrayList);
        binding.rvRecords.setAdapter(adapter);


        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                App.foodDao.deleteAll();
            }
        });

    }

    private void setAppBar() {
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle(R.string.txtAllFood);
        }
    }
}

