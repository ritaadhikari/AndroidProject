package com.example.firstandroidproject.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.firstandroidproject.database.model.FoodEntity;

import java.util.List;

@Dao
public interface FoodDao {
    @Insert
    void insertItem(FoodEntity foodEntity);

    @Delete
    void deleteItem(FoodEntity foodEntity);

    @Update
    void updateItem(FoodEntity foodEntity);
    @Query("SELECT* FROM FoodEntity")
    List<FoodEntity> getAllItems();
}
