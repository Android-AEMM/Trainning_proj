package com.example.trainning_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.trainning_proj.Home.Home;

public class SignIn extends AppCompatActivity {
    Button btn_login,btn_signUp;
    EditText et2_pass;
    ImageView show;
    static Boolean check1 = false;
    Intent intent1 ,intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        et2_pass = findViewById(R.id.et2_pass);
        btn_login = findViewById(R.id.btn2_signIn);
        btn_signUp = findViewById(R.id.btn2_signUp);

        /// go to home activity
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent1 = new Intent(SignIn.this, Home.class);
                startActivity(intent1);
                finish();
            }
        });

        /// go to sign up activity
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2 = new Intent(SignIn.this, MainActivity.class);
                startActivity(intent2);
                finish();
            }
        });

        show = findViewById(R.id.show3);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // to make password in password edit text show and hide
                if (check1 == false) {
                    et2_pass.setInputType(InputType.TYPE_CLASS_TEXT);
                    show.setImageResource(R.drawable.ic_baseline_visibility_24);
                    check1 = true;


                } else {
                    et2_pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    show.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                    check1 = false;
                }
            }
        });
    }
}
