package com.example.jubaed.profilev2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView nameView, addressView;
    public final static String COMINGBACK = "com.example.jubaed.COMINGBACK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.NAME);
        String address = intent.getStringExtra(MainActivity.ADDRESS);
        nameView = (TextView) findViewById(R.id.nameView);
        addressView = (TextView) findViewById(R.id.addressView);
        nameView.setText(name);
        addressView.setText(address);

    }

    public void editButtonPressed(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(COMINGBACK, "YES");
        startActivity(intent);
        Log.d("SecondActivity", "Created Activity");
        finish();
    }
}
