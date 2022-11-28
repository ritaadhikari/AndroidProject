package com.example.firstandroidproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstandroidproject.R;
import com.example.firstandroidproject.model.Product;

import java.util.ArrayList;

//ProductAdapter inherits recyclerView's adapter and productViewHolder class is created
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    //creating variables
    //context:
    private Context context;
    private ArrayList<Product> productArrayList;

    //creating constructor
    public ProductAdapter(Context context,ArrayList<Product>productArrayList){
        this.context = context;  //assigning value of parameter(context) to the variable created by us
        this.productArrayList=productArrayList;  //json chai product array list ma hunxa
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //attaching the layout
        View view= LayoutInflater.from(context).inflate(R.layout.row_product,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        //array list ma item tanne based on position and passing it
          Product item = productArrayList.get(position);  //getting every values of array in item
          holder.tvName.setText(item.getName()); //setting item name to tvName
          holder.tvPrice.setText(String.valueOf(item.getPrice())); //converting string to integer value
    }

    @Override
    public int getItemCount() {
        //returning the size of array list
        return productArrayList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivProduct;    //creating variables of imageview(class) and textview(class) here
        private TextView tvName,tvPrice;
        public ProductViewHolder(@NonNull View itemView) {

            super(itemView);
            ivProduct=itemView.findViewById(R.id.ivProduct);  //.ivProduct is value we had assigned earlier
            tvName=itemView.findViewById(R.id.tvName);
            tvPrice=itemView.findViewById(R.id.tvPrice);
        }
    }
}
