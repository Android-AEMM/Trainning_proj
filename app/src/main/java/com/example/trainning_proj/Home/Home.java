package com.example.trainning_proj.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

import com.example.trainning_proj.Place.Place;
import com.example.trainning_proj.R;
import com.example.trainning_proj.Setting.Setting;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    RecyclerView recyclerView_all_place  ,recyclerView_top_place ,recyclerView_by_from_egypt ;
    ArrayList<Data> arrayList = new ArrayList<>();
    DataAdapter adapter ;
    ImageButton imageButton_setting ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView_all_place = findViewById(R.id.recycle_view_all_place);
        recyclerView_top_place = findViewById(R.id.recycle_view_top_place);
        recyclerView_by_from_egypt = findViewById(R.id.recycle_view_by_from_Egypt);

        imageButton_setting = findViewById(R.id.img_btn_setting);

        /// function imageButton setting to open setting
        open_setting();



        /// functin set data in recycle view
        set_data_recycle();

    }

    private void open_setting() {

        imageButton_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // open setting
                Intent intent = new Intent(Home.this, Setting.class);
                startActivity(intent);

            }
        });
    }

    private void set_data_recycle() {

        // add item
        arrayList.add(new Data(R.drawable.backgrond, "Pyramids", "The pyramids of Egypt Giza in Cairo is located on the Giza plateau in the Giza governorate i.e. on the western bank of the Nile River. It includes three pyramids of Khufu, Khafre, and Menkaure which were built around 25 centuries BC and are royal tombs, each of which bears the name of the king who built it and who was buried in it and the building The hierarchy here is the stage of development of tomb architecture in ancient Egypt. The pyramids are one of the most important places of tourism in Egypt The three pyramids of Egypt are characterized as one of the most important seven wonders of the world, one of the largest gases, ancient and modern history, and the most important tourist places in Cairo","Giza"));
        arrayList.add(new Data(R.drawable.ic_launcher_background, "item2", "desc2"));
        arrayList.add(new Data(R.drawable.ic_launcher_background, "item3", "desc3"));
        arrayList.add(new Data(R.drawable.ic_launcher_background, "item1", "desc1"));
        arrayList.add(new Data(R.drawable.ic_launcher_background, "item2", "desc2"));
        arrayList.add(new Data(R.drawable.ic_launcher_background, "item3", "desc3"));
        arrayList.add(new Data(R.drawable.ic_launcher_background, "item1", "desc1"));
        arrayList.add(new Data(R.drawable.ic_launcher_background, "item2", "desc2"));
        arrayList.add(new Data(R.drawable.ic_launcher_background, "item3", "desc3"));

        // object from DataAdapter send (context , array from data)
        adapter = new DataAdapter(Home.this, arrayList);
        //recyclerView.setHasFixedSize(true);

        recyclerView_all_place.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView_all_place.setAdapter(adapter);

        recyclerView_top_place.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView_top_place.setAdapter(adapter);

        recyclerView_by_from_egypt.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView_by_from_egypt.setAdapter(adapter);

    }

}