package com.layout.apiintegration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView name = (TextView) findViewById(R.id.name);
        TextView email = (TextView) findViewById(R.id.email);
        TextView password = (TextView) findViewById(R.id.password);

        Intent intent = getIntent();

        String my_data = intent.getStringExtra("key_response");

        try {
            JSONObject jsonObject = new JSONObject(my_data);

            JSONArray jsonArray = jsonObject.getJSONArray("data");

            JSONObject jsonObject1 = jsonArray.getJSONObject(1);

            String udale = jsonObject1.getString("name");
            String udall = jsonObject1.getString("email");
            String usage = jsonObject1.getString("age");

            name.setText(udale);
            email.setText(udall);
            password.setText(usage);


        } catch (JSONException e) {
            e.printStackTrace();
        }


//        Intent intent = getIntent();
//
//        String my_data = intent.getStringExtra("key_response");
//
//
//        try {
//            JSONObject jsonObject = new JSONObject(my_data);
//            JSONArray jsonArray = jsonObject.getJSONArray("data");
//            JSONObject jsonObject1= jsonArray.getJSONObject(0);
//            String udall = jsonObject1.getString("email");
//
//            detail.setText(udall);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


    }
}