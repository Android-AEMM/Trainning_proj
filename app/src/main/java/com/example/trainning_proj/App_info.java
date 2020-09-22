package com.example.trainning_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class App_info extends AppCompatActivity {

    TextView name_gamal,name_ehab,name_aya,name_eman,info_gamal,info_ehab,info_aya,info_eman,desc_app;
    ImageView img_gamal, img_ehabe,img_aya,img_eman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);

        name_gamal = findViewById(R.id.name_gamal);
        name_ehab = findViewById(R.id.name_ehab);
        name_aya = findViewById(R.id.name_aya);
        name_eman = findViewById(R.id.name_eman);
        info_aya = findViewById(R.id.info_aya);
        info_ehab = findViewById(R.id.info_ehab);
        info_eman = findViewById(R.id.info_eman);
        info_gamal = findViewById(R.id.inf_gamal);
        desc_app = findViewById(R.id.desc_app);
        img_aya = findViewById(R.id.img_aya);
        img_ehabe = findViewById(R.id.img_ehab);
        img_eman = findViewById(R.id.img_eman);
        img_gamal = findViewById(R.id.img_gamal);




    }
}