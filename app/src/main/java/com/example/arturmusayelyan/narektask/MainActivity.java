package com.example.arturmusayelyan.narektask;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    String JSON_STRING;

    String valueFromRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        if(view.getId()==R.id.getJson_button) {
            new BackgroundTask().execute();
        }
        else if(view.getId()==R.id.parseJson_button){
                if(valueFromRequest ==null){
                    Toast.makeText(this,"First Get JSON",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent=new Intent(this,DisplayListView.class);
                    intent.putExtra("json_data", valueFromRequest);
                    startActivity(intent);
                }
        }
    }

    class BackgroundTask extends AsyncTask<Void, Void, String> {

        String json_url;

        @Override
        protected void onPreExecute() {
            //http-ov url e grac linum
            //json_url = "{ \"user\": [ { \"id\": \"001\", \"name\": \"Raj Amal\", \"email\": \"raj.amalw@gmail.com\" } ] }";
            json_url="https://freemegalist.com/api.php/?action=categories";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine()) != null) {
                    stringBuilder.append(JSON_STRING + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            TextView textView = (TextView) findViewById(R.id.json_textView);
            textView.setText(result);

            valueFromRequest =result;
        }
    }
}
