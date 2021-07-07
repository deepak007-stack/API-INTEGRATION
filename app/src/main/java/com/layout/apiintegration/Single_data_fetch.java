package com.layout.apiintegration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class Single_data_fetch extends AppCompatActivity {

    private EditText email;
    private Button submit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_data_fetch);

        email = (EditText) findViewById(R.id.email);
        submit1 = (Button) findViewById(R.id.submit2);

        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email_id = email.getText().toString();

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                String url = "http://192.168.196.93/API-INTEGRATION/api_fetch_single.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url , new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(Single_data_fetch.this, response, Toast.LENGTH_SHORT).show();
//                        try {
//                            JSONArray jsonArray =new JSONArray(response);
//                            Toast.makeText(Data_Through.this, ""+ jsonArray, Toast.LENGTH_SHORT).show();
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(Single_data_fetch.this, error.toString() , Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        HashMap hm = new HashMap();

                        hm.put("variable", email_id);

                        return hm;
                    }
                };

                requestQueue.add(stringRequest);
            }
        });

    }
}