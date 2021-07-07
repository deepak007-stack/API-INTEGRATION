package com.layout.apiintegration;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

public class Insert_data extends AppCompatActivity {

    private AppCompatEditText name1;
    private AppCompatEditText age1;
    private AppCompatEditText email1;
    private AppCompatButton insertBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        name1 = (AppCompatEditText) findViewById(R.id.name1);
        age1 = (AppCompatEditText) findViewById(R.id.age1);
        email1 = (AppCompatEditText) findViewById(R.id.email1);
        insertBtn = (AppCompatButton) findViewById(R.id.insert_btn);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name2 = name1.getText().toString();
                String age2 = age1.getText().toString();
                String email2 = email1.getText().toString();

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                String url = "http://192.168.196.93/API-INTEGRATION/api_insert.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(Insert_data.this, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Insert_data.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        HashMap hashMap = new HashMap();

                        hashMap.put("key_name", name2);
                        hashMap.put("key_email1", email2);
                        hashMap.put("key_age1", age2);


                        return hashMap;
                    }
                };

                requestQueue.add(stringRequest);
            }
        });


    }
}