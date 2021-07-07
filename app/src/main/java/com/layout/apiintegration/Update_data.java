package com.layout.apiintegration;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Update_data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        AppCompatEditText edEmail = (AppCompatEditText) findViewById(R.id.ed_email);
        AppCompatEditText edAge = (AppCompatEditText) findViewById(R.id.ed_age);
        AppCompatButton updateBtn = (AppCompatButton) findViewById(R.id.update_btn);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = edEmail.getText().toString();
                String age = edAge.getText().toString();

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                String url = "http://192.168.196.93/API-INTEGRATION/api_update.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(Update_data.this, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(Update_data.this, "error", Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        HashMap hashMap = new HashMap();

                        hashMap.put("key_email", email);
                        hashMap.put("key_age", age);

                        return hashMap;
                    }
                };

                requestQueue.add(stringRequest);
            }
        });

    }
}