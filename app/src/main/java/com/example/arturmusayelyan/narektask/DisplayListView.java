package com.example.arturmusayelyan.narektask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {
    ListView listView;

    String valueFromRequest;
    JSONArray jsonArray;

    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_listview_layout);
        listView = (ListView) findViewById(R.id.listView1);
        contactAdapter = new ContactAdapter(this, R.layout.row_layout);
        listView.setAdapter(contactAdapter);

        valueFromRequest = getIntent().getExtras().getString("json_data");

        try {
            jsonArray = new JSONArray(valueFromRequest);
            String id, name, image;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject JO = jsonArray.getJSONObject(i);
                id = JO.getString("category_id");
                name = JO.getString("category_name");
                image = JO.getString("category_image");
                Contacts contacts = new Contacts(id, name, image);
                contactAdapter.add(contacts);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
