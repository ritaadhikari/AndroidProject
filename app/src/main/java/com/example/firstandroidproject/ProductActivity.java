package com.example.firstandroidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.firstandroidproject.adapter.ProductAdapter;
import com.example.firstandroidproject.api.ApiClient;
import com.example.firstandroidproject.api.ApiInterface;
import com.example.firstandroidproject.model.Product;
import com.example.firstandroidproject.response.FoodResponse;

import java.util.ArrayList;

//yo call vayena vane error aauxa
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
//        Product product = new Product();
//        product.setId(1);
//        product.setName("Mac Book 13 Inch");
//        product.setCategory("Laptop");
//        product.setPrice(2500.00);
//
//        Product product2 = new Product();
//        product2.setId(2);
//        product2.setName("Mac Book 14 Inch");
//        product2.setCategory("Laptop");
//        product2.setPrice(2600.00);
//
//        Product product3 = new Product();
//        product3.setId(3);
//        product3.setName("Mac Book 15 Inch");
//        product3.setCategory("Laptop");
//        product3.setPrice(2800.00);
//
//        Product product4 = new Product();
//        product4.setId(4);
//        product4.setName("Dell");
//        product4.setCategory("Laptop");
//        product4.setPrice(1500.00);
//
//        Product product5 = new Product();
//        product5.setId(5);
//        product5.setName("Lenovo");
//        product5.setCategory("Laptop");
//        product5.setPrice(2600.00);

        ApiInterface  apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<FoodResponse> call = apiInterface.getFood();
        call.enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(Call<FoodResponse> call, Response<FoodResponse> response) {
                FoodResponse rs = response.body();
                if(rs.isSuccess()){
                    ProductAdapter adapter = new ProductAdapter(ProductActivity.this,rs.getData());//passing product array list
                    //passing adapter to recycler view
//                    callback bhitra this lea kam gardaina ani freagment bhitra pani
                    rvProduct.setLayoutManager(new LinearLayoutManager(ProductActivity.this,LinearLayoutManager.VERTICAL,false));
                    rvProduct.setAdapter(adapter);

                }else{
                    Toast.makeText(ProductActivity.this, rs.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
//server connect nai nahuni
            @Override
            public void onFailure(Call<FoodResponse> call, Throwable t) {
//                failure ma t hunxa  as throw reponse not rs
                Toast.makeText(ProductActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


//
//        //creating product array list
//        ArrayList<Product> productArrayList=new ArrayList<>(); //initializing empty array list
//        productArrayList.add(product);
//        productArrayList.add(product2);
//        productArrayList.add(product3);
//        productArrayList.add(product4);
//        productArrayList.add(product5);



    }
}