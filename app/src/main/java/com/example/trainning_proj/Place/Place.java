package com.example.trainning_proj.Place;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trainning_proj.Home.Data;
import com.example.trainning_proj.R;

import java.util.ArrayList;

public class Place extends AppCompatActivity {

    TextView name ,address ,desc,titel;
    ImageView image,location;
    String name_location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);



        name = findViewById(R.id.txt2_place_name);
        address = findViewById(R.id.txt2_place_address);
        desc = findViewById(R.id.txt2_place_desc);
        image = findViewById(R.id.image2_place);
        location = findViewById(R.id.image_location);
        titel = findViewById(R.id.titel);


        name_location = getIntent().getStringExtra("location");

        titel.setText(getIntent().getStringExtra("name"));
        name.setText(getIntent().getStringExtra("name"));
        address.setText(getIntent().getStringExtra("address"));
        desc.setText(getIntent().getStringExtra("desc"));
        image.setImageResource( getIntent().getIntExtra("image",1));

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(name_location));
                startActivity(intent);
            }
        });


    }
}