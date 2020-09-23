package com.example.trainning_proj.Setting;

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
import android.widget.TextView;
import android.widget.Toast;
import com.example.trainning_proj.DataBaseHelper;
import com.example.trainning_proj.Forget_password;
import com.example.trainning_proj.Home.Home;
import com.example.trainning_proj.R;
import com.example.trainning_proj.SignIn;
import com.example.trainning_proj.SignUp;

import static com.example.trainning_proj.R.id.show_current_pass;

public class Setting extends AppCompatActivity {

    EditText edt_old_pass, edt_current_pass, edt_current_repass, edt_mail;
    ImageView show_old_pass, show_current_pass, show_current_repass;
    Button btn_confirm;
    Animation animation;

    DataBaseHelper db;
    static Boolean check1 = false, check2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        //  edt_old_pass=findViewById(R.id.et1_old_pass);
        // show_old_pass = findViewById(R.id.show2_old_pass);
        //  edt_mail=findViewById(R.id.et1_mail_change);

        animation = AnimationUtils.loadAnimation(Setting.this, R.anim.blink_anim);


        edt_mail = findViewById(R.id.et1_mail_change);
        edt_current_pass = findViewById(R.id.et1_pass_change);
        edt_current_repass = findViewById(R.id.et1_rePass_change);

        show_current_pass = findViewById(R.id.show_current_pass);
        show_current_repass = findViewById(R.id.show2_current_pass);
        btn_confirm = findViewById(R.id.btn1_confirm_change);
         db = new DataBaseHelper(this);


    /*    if (getIntent() != null) {
            tv.setText(getIntent().getStringExtra("email"));
        }*/


        show_current_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // to make password in re-enter password  edit text show and hide

                if (check2 == false) {
                    edt_current_repass.setInputType(InputType.TYPE_CLASS_TEXT);
                    show_current_pass.setImageResource(R.drawable.ic_baseline_visibility_24);
                    check2 = true;

                } else {
                    edt_current_repass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    show_current_pass.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                    check2 = false;
                }
            }
        });

        show_current_repass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // to make password in re-enter password  edit text show and hide

                if (check2 == false) {
                    edt_current_pass.setInputType(InputType.TYPE_CLASS_TEXT);
                    show_current_repass.setImageResource(R.drawable.ic_baseline_visibility_24);
                    check2 = true;

                } else {
                    edt_current_pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    show_current_repass.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                    check2 = false;
                }
            }
        });


        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btn_confirm.startAnimation(animation);

                String email = edt_mail.getText().toString().trim();
                String new_pass = edt_current_pass.getText().toString().trim();
                String re_new_pass = edt_current_repass.getText().toString().trim();
                //Intent intent = new Intent(Setting.this, Home.class);
                //startActivity(intent);

                if ( TextUtils.isEmpty(email) || TextUtils.isEmpty(new_pass) || TextUtils.isEmpty(re_new_pass)) {
                    Toast.makeText(Setting.this, "There's an empty field!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (new_pass.equals(re_new_pass)) {
                    if (db.change(email, new_pass) )
                        Toast.makeText(getBaseContext(), "Update Failed !", Toast.LENGTH_SHORT).show();

                    else {
                        Toast.makeText(getBaseContext(), "Update Done !", Toast.LENGTH_SHORT).show();
                        edt_current_repass.setText("");
                        edt_current_pass.setText("");
                        edt_current_repass.setText("");
                        Intent intent = new Intent(Setting.this, Home.class);
                        startActivity(intent);
                    }

                }
                else
                    Toast.makeText(Setting.this, "The password don't match ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}