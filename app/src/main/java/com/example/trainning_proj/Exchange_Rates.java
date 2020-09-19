package com.example.trainning_proj;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Exchange_Rates extends AppCompatActivity {

    private ListView lv;
    private Button btn;
    private EditText txt;

    TextView item;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange__rates);

        lv=findViewById(R.id.listView);
        btn=findViewById(R.id.Enter);
        txt=findViewById(R.id.name);
        item=findViewById(R.id.list_item);
        final ArrayList<String> names =new ArrayList<>();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String n=txt.getText().toString();

                Custom_Adapter adapter=new Custom_Adapter(Exchange_Rates.this,android.R.layout.simple_list_item_1,names);
                lv.setAdapter(adapter);

                names.add(n);



            }
        });





    }}