package com.example.trainning_proj;

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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trainning_proj.Home.Home;

public class SignIn extends AppCompatActivity {
    Button btn_login, btn_signUp;
    EditText et2_pass, et2_mail;
    ImageView show;
    static Boolean check1 = false;
    Intent intent1, intent2;
    Animation animation;
    TextView forget_pass;
     DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        et2_mail = findViewById(R.id.et2_mail);
        et2_pass = findViewById(R.id.et2_pass);
        btn_login = findViewById(R.id.btn2_signIn);
        btn_signUp = findViewById(R.id.btn2_signUp);
        forget_pass = findViewById(R.id.tv2_forgot_pass);

        animation = AnimationUtils.loadAnimation(SignIn.this, R.anim.blink_anim);
         db = new DataBaseHelper(this);

        forget_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SignIn.this, Forget_password.class);
                startActivity(intent);
            }
        });

        /// go to home activity
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btn_login.startAnimation(animation);
               String email = et2_mail.getText().toString();
              String password = et2_pass.getText().toString();

               if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(SignIn.this, "Email OR password field is empty!", Toast.LENGTH_LONG).show();
                    return;

                }


                if (db.isLoginUser(email,password)) {
                    Toast.makeText(SignIn.this, "Login Successful" , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignIn.this, Home.class);
                    intent.putExtra("email",email);
                    startActivity(intent);
                    et2_mail.setText("");
                    et2_pass.setText("");
                } else {
                    Toast.makeText(SignIn.this, "Login failed", Toast.LENGTH_SHORT).show();

                }
            }
        });

        /// go to sign up activity
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btn_signUp.startAnimation(animation);

                intent2 = new Intent(SignIn.this, SignUp.class);
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

    @Override
    protected void onDestroy() {
        finish();
        System.exit(0);
        super.onDestroy();
    }
}
