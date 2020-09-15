package com.example.trainning_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    EditText ed1_pass;
    ImageView show;
    static Boolean check=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1_pass=findViewById(R.id.et1_pass);
        show=findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check==false)
                {
                    ed1_pass.setInputType(InputType.TYPE_CLASS_TEXT);
                    show.setImageResource(R.drawable.ic_baseline_visibility_24);
                    check=true;

                }
                else
                {
                    ed1_pass.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    show.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                    check=false;
                }
            }
        });


    }
}