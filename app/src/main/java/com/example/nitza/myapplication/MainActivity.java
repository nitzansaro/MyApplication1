package com.example.nitza.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    HelperDB hlp;
    EditText id1 , class1, name, age, gender;
    String id11 , class11, name1, age1, gender1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id1 = (EditText) findViewById(R.id.id1);
        class1 = (EditText) findViewById(R.id.class1);
        name = (EditText) findViewById(R.id.name);
        gender = (EditText) findViewById(R.id.gender);
        age = (EditText) findViewById(R.id.age);
        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String st = item.getTitle().toString();
        if (st.equals("Credits")) {
            Intent d = new Intent(this, Main3Activity.class);
            startActivity(d);
        } else {
            if (st.equals("Tables")){
                Intent b = new Intent(this, Main2Activity.class);
                startActivity(b);}
        }
        return super.onOptionsItemSelected(item);
    }

    public void first(View view) {
        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();
        id11 = id1.getText().toString();
        name1= name.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put(TableBasic.STUDENT_ID, id11);
        cv.put(TableBasic.STUDENT_NAME, name1);
        db.insert(TableBasic.TABLE_BASIC,null, cv);
        db.close();
    }

    public void second(View view) {
        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();
        ContentValues cv = new ContentValues();
        age1= age.getText().toString();
        class11= class1.getText().toString();
        gender1= gender.getText().toString();
        cv.put(TablePERSONAL.STUDENT_CLASS, class11);
        cv.put(TablePERSONAL.STUDENT_AGE, age1);
        cv.put(TablePERSONAL.STUDENT_GENDER, gender1);
        db.insert(TablePERSONAL.TABLE_PERSONAL,null, cv);
        db.close();


    }
}

