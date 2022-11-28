package com.example.firstandroidproject.model;
//creating a class Product
public class Product {
    private String name;   //creating variables
    private double price;
    private String category;
    private int id;
    private String imgPath;

    //using getter and setter method to access the values of class Product since it is private
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    public String getCategory() {

        return category;
    }

    public void setCategory(String category) {

        this.category = category;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getImgPath() {

        return imgPath;
    }

    public void setImgPath(String imgPath) {

        this.imgPath = imgPath;
    }
}
