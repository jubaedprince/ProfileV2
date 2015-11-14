package com.example.jubaed.profilev2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String NAME = "com.example.jubaed.NAME";
    public final static String ADDRESS = "com.example.jubaed.ADDRESS";
    public static final String MyPREFERENCES = "MyPrefs";
    SharedPreferences sharedPreferences;
    EditText nameField, addressField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainActivity", "ON create");
        Intent intent = getIntent();
        String comingBack = intent.getStringExtra(SecondActivity.COMINGBACK);
        Log.d("MainActivity", "COMING BACK: " +comingBack);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String v= sharedPreferences.getString("name", null);
        if(comingBack!=null){
            Log.d("MainActivity", "YES Intent");
            String v2= sharedPreferences.getString("name", null);
            String w= sharedPreferences.getString("address", null);
            nameField = (EditText) findViewById(R.id.nameField);
            addressField = (EditText) findViewById(R.id.addressField);
            nameField.setText(v2);
            addressField.setText(w);

        }else {
            if (v == null) {
                Log.d("MainActivity", "NULL");
                nameField = (EditText) findViewById(R.id.nameField);
                addressField = (EditText) findViewById(R.id.addressField);
                nameField.setText("");
                addressField.setText("");
            } else {
                Log.d("MainActivity", "ELSE");
                String w = sharedPreferences.getString("address", null);
                Intent intent2 = new Intent(this, SecondActivity.class);
                intent2.putExtra(NAME, v);
                intent2.putExtra(ADDRESS, w);
                startActivity(intent2);
                finish();
            }
        }

    }

    public void submitButtonClicked(View view){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", nameField.getText().toString());
        editor.putString("address", addressField.getText().toString());
        editor.commit();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(NAME, nameField.getText().toString());
        intent.putExtra(ADDRESS, addressField.getText().toString());
        startActivity(intent);
        finish();

    }
}
