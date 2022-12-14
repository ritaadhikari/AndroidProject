package com.example.firstandroidproject;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.firstandroidproject.app.App;
import com.example.firstandroidproject.database.AppDatabase;
import com.example.firstandroidproject.database.dao.FoodDao;
import com.example.firstandroidproject.database.model.FoodEntity;
import com.example.firstandroidproject.databinding.ActivityDatabaseBinding;

public class DatabaseActivity extends AppCompatActivity {
    private ActivityDatabaseBinding binding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatabaseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
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

    }
}

