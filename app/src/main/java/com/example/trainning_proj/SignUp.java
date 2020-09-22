package com.example.trainning_proj;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trainning_proj.Home.Home;

public class SignUp extends AppCompatActivity {

    EditText et1_pass, et1_repass, et1_name, et1_mail, et1_phone;
    ImageView show, show2;
    Button btn_signUp;
    static Boolean check1 = false, check2 = false;
    // DataBaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        et1_phone = findViewById(R.id.et1_phone);
        et1_name = findViewById(R.id.et1_name);
        et1_mail = findViewById(R.id.et1_mail);
        et1_pass = findViewById(R.id.et1_pass);
        et1_repass = findViewById(R.id.et1_rePass);
        show = findViewById(R.id.show);
        show2 = findViewById(R.id.show2);
        btn_signUp = findViewById(R.id.btn_signUp);
        //  db = new DataBaseHelper(this);


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

        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = et1_mail.getText().toString();
                String name = et1_name.getText().toString();
                String repassword = et1_repass.getText().toString();
                String phone = et1_phone.getText().toString();
                String password = et1_pass.getText().toString();
                Intent intent = new Intent(SignUp.this, SignIn.class);
                startActivity(intent);

              /*  if(TextUtils.isEmpty(name)||TextUtils.isEmpty(email)||TextUtils.isEmpty(phone)||TextUtils.isEmpty(password)||TextUtils.isEmpty(repassword))
                {
                    Toast.makeText(SignUp.this, "There's an empty field!", Toast.LENGTH_LONG).show();
                    return ;
                }


               if (password.equals(repassword)) {

                    if(db.insertUser(name, email,phone,password)){
                        Toast.makeText(SignUp.this, "successfully registered", Toast.LENGTH_SHORT).show();
                        et1_name.setText("");
                        et1_mail.setText("");
                        et1_repass.setText("");
                        et1_phone.setText("");
                        et1_pass.setText("");
                      Intent  intent = new Intent(SignUp.this, SignIn.class);
                        startActivity(intent);

                    }
                    else{
                        Toast.makeText(SignUp.this, "an error occurred", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(SignUp.this, "The password don't match ", Toast.LENGTH_SHORT).show();

                }*/

            }
        });


    }
}