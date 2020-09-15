package com.example.trainning_proj.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.trainning_proj.R;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    RecyclerView recyclerView ;
    ArrayList<Data> arrayList = new ArrayList<>();
    DataAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recycle_view);

        /// functin set data in recycle view
        set_data_recycle();

    }

    private void set_data_recycle() {

        // add item
        arrayList.add(new Data(R.drawable.ic_launcher_background, "item1", "desc1"));
        arrayList.add(new Data(R.drawable.ic_launcher_background, "item2", "desc2"));
        arrayList.add(new Data(R.drawable.ic_launcher_background, "item3", "desc3"));

        // object from DataAdapter send (context , array from data)
        adapter = new DataAdapter(Home.this, arrayList);
        //recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}