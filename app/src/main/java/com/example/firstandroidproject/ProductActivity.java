package com.example.firstandroidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.firstandroidproject.adapter.ProductAdapter;
import com.example.firstandroidproject.model.Product;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    //importing rvProduct from the recycler view
    private RecyclerView rvProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        rvProduct = findViewById(R.id.rvProduct);
        initData(); //network api call garera tanna parxa
    }

    private void initData() {
        //initializing the data of Product,Product.java,ProductActivity.java and activity_product.xml are linked
        Product product = new Product();
        product.setId(1);
        product.setName("Mac Book 13 Inch");
        product.setCategory("Laptop");
        product.setPrice(2500.00);

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Mac Book 14 Inch");
        product2.setCategory("Laptop");
        product2.setPrice(2600.00);

        Product product3 = new Product();
        product3.setId(3);
        product3.setName("Mac Book 15 Inch");
        product3.setCategory("Laptop");
        product3.setPrice(2800.00);

        Product product4 = new Product();
        product4.setId(4);
        product4.setName("Dell");
        product4.setCategory("Laptop");
        product4.setPrice(1500.00);

        Product product5 = new Product();
        product5.setId(5);
        product5.setName("Lenovo");
        product5.setCategory("Laptop");
        product5.setPrice(2600.00);

        //creating product array list
        ArrayList<Product> productArrayList=new ArrayList<>(); //initializing empty array list
        productArrayList.add(product);
        productArrayList.add(product2);
        productArrayList.add(product3);
        productArrayList.add(product4);
        productArrayList.add(product5);

        ProductAdapter adapter = new ProductAdapter(ProductActivity.this,productArrayList);//passing product array list
        //passing adapter to recycler view
        rvProduct.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvProduct.setAdapter(adapter);

    }
}