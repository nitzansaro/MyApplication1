package com.example.nitza.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class Main2Activity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{
    ListView lv;
    HelperDB hlp;
    SQLiteDatabase db;
    Cursor c;
    String [] whichTable = {"tableBASIC", "tablePERSONAL"};
    Spinner sp;
    ArrayAdapter<String> adp;
    ArrayList<String>data = new ArrayList<>();
   // ArrayList<String> tb1 = new ArrayList<>();
   // ArrayList<String> tb2 = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sp = (Spinner) findViewById(R.id.sp);
        lv = (ListView) findViewById(R.id.lv);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, whichTable);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adp);
        sp.setOnItemSelectedListener(this);
        hlp = new HelperDB(this);
        }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        db = hlp.getWritableDatabase();
        data.clear();
        if (position == 0) {
            //  Toast.makeText(this, "Basic ", Toast.LENGTH_LONG).show();

            c = db.query(TablePERSONAL.TABLE_PERSONAL, null, null, null, null, null, null);
            int[] col = new int[4];
            col[0] = c.getColumnIndex("_idPERSONAL");
            col[1] = c.getColumnIndex("AGE");
            col[2] = c.getColumnIndex("CLASS1");
            col[3] = c.getColumnIndex("GENDER");
            c.moveToFirst();

            while (!c.isAfterLast()) {
                //int pid = c.getInt( col[0]);
                String AGE = c.getString(col[1]);
                String CLASS1 = c.getString(col[2]);
                String GENDER = c.getString(col[3]);
                String temp = AGE + ", " + CLASS1 + ", " + GENDER;
                data.add(temp);
                c.moveToNext();
                adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, data);
                lv.setAdapter(adp);
            }
        }
            else{
            c = db.query(TableBasic.TABLE_BASIC, null, null, null, null, null, null);
            int[] col = new int[3];
            col[0] = c.getColumnIndex("_id");
            col[1] = c.getColumnIndex("ID_ST");
            col[2] = c.getColumnIndex("NAME");
            c.moveToFirst();

            while (!c.isAfterLast()) {
                //int  pid = c.getInt(col[0]);
                String ID = c.getString(col[1]);
                String NAME = c.getString(col[2]);
                String temp = ID + "," + NAME;
                data.add(temp);
                c.moveToNext();
                adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, data);
                lv.setAdapter(adp);
            }
            }
        c.close();

    }

        //if(position == 1){
          //  Toast.makeText(this, "Personal ", Toast.LENGTH_LONG).show();
           // adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tb2);
           // lv.setAdapter(adp);
        //}
  //  }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
            if (st.equals("Main page")){
                Intent a = new Intent(this, MainActivity.class);
                startActivity(a);}
        }
        return super.onOptionsItemSelected(item);
    }


}




