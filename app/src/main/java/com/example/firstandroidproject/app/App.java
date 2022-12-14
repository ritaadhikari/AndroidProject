package com.example.firstandroidproject.app;

import android.app.Application;

import com.example.firstandroidproject.database.AppDatabase;
import com.example.firstandroidproject.database.dao.FoodDao;

public class App extends Application {
    public static AppDatabase db;
    public static FoodDao foodDao;


    @Override
    public void onCreate() {
        super.onCreate();
        initDb();
    }

    private void initDb() {
        db = AppDatabase.getInstance(getApplicationContext());
        foodDao = db.foodDao();
    }

}
