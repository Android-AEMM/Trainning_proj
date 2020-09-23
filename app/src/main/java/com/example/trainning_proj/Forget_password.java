package com.example.trainning_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.trainning_proj.Home.Home;
import com.example.trainning_proj.Setting.Setting;

public class Forget_password extends AppCompatActivity {

    EditText et1_name, et1_mail, et1_phone;
    ImageView show, show2;
    Button btn_confirm;
    static Boolean check1 = false, check2 = false;
    Animation animation;
     DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        et1_phone = findViewById(R.id.et1_phone__forget_pass);
        et1_mail = findViewById(R.id.et1_mail_forget_pass);
        // et1_name = findViewById(R.id.et1_name_forget_pass);
        btn_confirm = findViewById(R.id.btn_confirm);
         db = new DataBaseHelper(this);

        animation = AnimationUtils.loadAnimation(Forget_password.this, R.anim.blink_anim);


        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_confirm.startAnimation(animation);

                String email = et1_mail.getText().toString();
                // String name = et1_name.getText().toString();
                String phone = et1_phone.getText().toString();

               // Intent intent = new Intent(Forget_password.this, Home.class);
                //startActivity(intent);
                if ( TextUtils.isEmpty(email) || TextUtils.isEmpty(phone)) {
                    Toast.makeText(Forget_password.this, "There's an empty field!", Toast.LENGTH_LONG).show();
                    return;
                }


                int check = db.forget_pass(email,  phone);
                if (check > 0) {
                    Toast.makeText(Forget_password.this, "Please,Remeber Change Password", Toast.LENGTH_SHORT).show();

                    et1_mail.setText("");
                    et1_phone.setText("");

                    Intent intent = new Intent(Forget_password.this, Setting.class);
                   // intent.putExtra("email",email);

                    startActivity(intent);


                } else {
                    Toast.makeText(Forget_password.this, "an error occurred", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}