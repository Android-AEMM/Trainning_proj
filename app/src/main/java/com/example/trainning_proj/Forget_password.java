package com.example.trainning_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Forget_password extends AppCompatActivity {

    EditText et1_pass, et1_repass, et1_mail, et1_phone;
    ImageView show, show2;
    Button btn_confirm;
    static Boolean check1 = false, check2 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        et1_phone=findViewById(R.id.et1_phone__forget_pass);
        et1_mail=findViewById(R.id.et1_mail_forget_pass);
        et1_pass = findViewById(R.id.et1_pass_forget_pass);
        et1_repass = findViewById(R.id.et1_rePass_forget_pass);
        show = findViewById(R.id.show_pass);
        show2 = findViewById(R.id.show2_pass);
        btn_confirm=findViewById(R.id.btn_confirm);

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

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Forget_password.this, SignIn.class);
                startActivity(intent);
            }
        });
    }
}