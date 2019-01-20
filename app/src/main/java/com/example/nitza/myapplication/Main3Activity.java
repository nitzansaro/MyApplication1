package com.example.nitza.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String st = item.getTitle().toString();
        if (st.equals("Main page")) {
            Intent a = new Intent(this, MainActivity.class);
            startActivity(a);
        } else {
            if (st.equals("Tables")){
                Intent b = new Intent(this, Main2Activity.class);
                startActivity(b);}
        }
        return super.onOptionsItemSelected(item);
    }}

