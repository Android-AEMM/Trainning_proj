package com.example.trainning_proj.Product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trainning_proj.R;

public class Product_buy extends AppCompatActivity {

    TextView name ,price ,desc,titel;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_buy);

        name = findViewById(R.id.txt2_product_name);
        price = findViewById(R.id.txt2_product_price);
        desc = findViewById(R.id.txt2_product_desc);
        image = findViewById(R.id.image2_product);
        titel = findViewById(R.id.titel_product);


        titel.setText(getIntent().getStringExtra("name_product"));
        name.setText(getIntent().getStringExtra("name_product"));
        price.setText(getIntent().getStringExtra("price"));
        desc.setText(getIntent().getStringExtra("desc_product"));
        image.setImageResource( getIntent().getIntExtra("image_product",1));
    }
}