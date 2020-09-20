package com.example.trainning_proj;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class CurrencyLoader extends AsyncTaskLoader<ArrayList<String>> {
    String url = null;
    ArrayList<String> currency = new ArrayList<>();
    public CurrencyLoader( Context context,String url) {
        super(context);
        this.url = url;

    }
    private String getHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        HttpsURLConnection urlConnection = null;

        InputStream inputStream = null;

        try {
            urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(20000);
            urlConnection.connect();
            inputStream = urlConnection.getInputStream();
            jsonResponse = readFromStream(inputStream);

        } catch (Exception e) {
            return "No Internet Connection 1 ";
        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();

            if (inputStream != null)
                inputStream.close();
        }


        return jsonResponse;
    }
    private String readFromStream(InputStream inputStream) throws IOException {

        StringBuilder result = new StringBuilder();

        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));

            BufferedReader reader = new BufferedReader(inputStreamReader);

            String line = reader.readLine();

            while (line != null) {
                result.append(line);
                line = reader.readLine();
            }

        }
        return result.toString();
    }

    @Nullable
    @Override
    public ArrayList<String> loadInBackground() {
        JSONObject jsonRoot = null;



        try {
            jsonRoot = new JSONObject(getHttpRequest(new URL(url)));
            JSONArray jsonArray = jsonRoot.getJSONArray("Currency ");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject temp = jsonArray.getJSONObject(i);

                String Foreign_currency = temp.getString("Foreign currency");
                String value = temp.getString("Value");


                currency.add("Foreign currency : " + Foreign_currency + "\nValue: " + value);

            }
        } catch (JSONException | MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currency;
    }
}