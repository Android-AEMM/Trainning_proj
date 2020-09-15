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
    EditText et1_pass, et1_repass;
    ImageView show, show2;
    static Boolean check1 = false, check2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1_pass = findViewById(R.id.et1_pass);
        et1_repass = findViewById(R.id.et1_rePass);
        show = findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // to make password in password edit text show and hide
                if (check1 == false) {
                    et1_pass.setInputType(InputType.TYPE_CLASS_TEXT);
                    show.setImageResource(R.drawable.ic_baseline_visibility_24);
                    check1 = true;

                } else {
                    et1_pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    show.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                    check1 = false;
                }
            }
        });
        show2 = findViewById(R.id.show2);
        show2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // to make password in re-enter password  edit text show and hide

                if (check2 == false) {
                    et1_repass.setInputType(InputType.TYPE_CLASS_TEXT);
                    show2.setImageResource(R.drawable.ic_baseline_visibility_24);
                    check2 = true;

                } else {
                    et1_repass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    show2.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                    check2 = false;
                }
            }
        });


    }
}