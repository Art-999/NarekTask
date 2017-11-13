package com.example.arturmusayelyan.narektask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {
    ListView listView;
    String JSON_STRING_ARRAY;
    JSONObject jsonObject;
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_listview_layout);
        listView = (ListView) findViewById(R.id.listView1);

        JSON_STRING_ARRAY = getIntent().getExtras().getString("json_data");

        try {
            jsonObject=new JSONObject(JSON_STRING_ARRAY);
            int count;

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
