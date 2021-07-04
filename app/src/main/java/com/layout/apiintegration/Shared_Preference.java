package com.layout.apiintegration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Shared_Preference extends AppCompatActivity {

    private EditText name;
    private EditText lastName;
    private Button add,delete,view;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared__preference);

        name = (EditText) findViewById(R.id.name);
        lastName = (EditText) findViewById(R.id.last_name);
        add = (Button) findViewById(R.id.add);
        view = (Button) findViewById(R.id.view);
        delete = (Button) findViewById(R.id.delete);
        text = (TextView) findViewById(R.id.text);

    }

    public void add_data(View view) {

        String uname = name.getText().toString();
        String upass = lastName.getText().toString();

        SharedPreferences sharedPreferences=getSharedPreferences("user_data",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("user_first_name",uname);
        editor.putString("user_last_name",upass);
        editor.commit();

        name.setText("");
        lastName.setText("");

        Toast.makeText(getApplicationContext(), "data added successful", Toast.LENGTH_SHORT).show();

    }

    public void view_data(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("user_data",MODE_PRIVATE);

        if(sharedPreferences.contains("user_first_name"))
        {
            text.setText(sharedPreferences.getString("user_first_name",""));
        }
        else
        {
            Toast.makeText(getApplicationContext(), "data not found", Toast.LENGTH_SHORT).show();
        }

    }

    public void delete_data(View view) {

        SharedPreferences sharedPreferences= getSharedPreferences("user_data",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(sharedPreferences.contains("user_first_name"))
        {
            editor.remove("user_first_name");
            editor.remove("user_last_name");
            editor.commit();

            text.setText("");

            Toast.makeText(getApplicationContext(), "delete successfull", Toast.LENGTH_SHORT).show();
        }
    }

}