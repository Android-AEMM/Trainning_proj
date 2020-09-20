package com.example.trainning_proj;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import java.util.ArrayList;

public class Exchange_Rates extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<String>> {

     ListView lv;

    ProgressBar progressBar;

    TextView item;
    static ArrayList<String> currency =new ArrayList<>();
    private static String CURRENCY_URL = "https://jsonware.com/json/6b73abddc0812d1ef8e3632f5d79c6c2.json";




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange__rates);

        lv=findViewById(R.id.listView);

        item=findViewById(R.id.list_item);
        progressBar = findViewById(R.id.pb_progress);


        LoaderManager loaderManager = getSupportLoaderManager();
        loaderManager.initLoader(0, null, Exchange_Rates.this).forceLoad();








    }

    @NonNull
    @Override
    public Loader<ArrayList<String>> onCreateLoader(int id, @Nullable Bundle args) {
        progressBar.setVisibility(View.VISIBLE);
        return new CurrencyLoader(this, CURRENCY_URL);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<String>> loader, ArrayList<String> currency) {
        progressBar.setVisibility(View.GONE);
        if (currency.size() == 0)
            Toast.makeText(getApplicationContext(), "No Internet Connection size", Toast.LENGTH_SHORT).show();

        ArrayAdapter<String> currencyAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.listitem, currency);


        lv.setAdapter(currencyAdapter);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<String>> loader) {

    }
}