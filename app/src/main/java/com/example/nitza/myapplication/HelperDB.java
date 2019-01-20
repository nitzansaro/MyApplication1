package com.example.nitza.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static com.example.nitza.myapplication.TableBasic.KEY_ID;
import static com.example.nitza.myapplication.TableBasic.STUDENT_ID;
import static com.example.nitza.myapplication.TableBasic.STUDENT_NAME;
import static com.example.nitza.myapplication.TableBasic.TABLE_BASIC;
import static com.example.nitza.myapplication.TablePERSONAL.KEY_ID1;
import static com.example.nitza.myapplication.TablePERSONAL.STUDENT_AGE;
import static com.example.nitza.myapplication.TablePERSONAL.STUDENT_CLASS;
import static com.example.nitza.myapplication.TablePERSONAL.STUDENT_GENDER;
import static com.example.nitza.myapplication.TablePERSONAL.TABLE_PERSONAL;

public class HelperDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbexam.db";
    private static final int DATA_VERSION = 1;
    String s1,s2;

    public HelperDB(Context context){
        super(context,DATABASE_NAME , null, DATA_VERSION );
        this.s1=s1;
        this.s2=s2;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        s1="CREATE TABLE "+TABLE_PERSONAL;
        s1+=" ("+KEY_ID1+" INTEGER PRIMARY KEY,";
        s1+=" "+STUDENT_AGE+" TEXT,";
        s1+=" "+STUDENT_CLASS+" TEXT,";
        s1+=" "+STUDENT_GENDER+" TEXT";
        s1+=");";
        db.execSQL(s1);
        s1="CREATE TABLE "+TABLE_BASIC;
        s1+= "("+KEY_ID+" INTEGER PRIMARY KEY,";
        s1+=" "+STUDENT_ID+" TEXT,";
        s1+=" "+ STUDENT_NAME+" TEXT";
        s1+=");";
        db.execSQL(s1); }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        s2 = "DROP TABLE IF EXISTS " + TABLE_PERSONAL;
        db.execSQL(s2);
        s2= "DROP TABLE IF EXISTS " + TABLE_BASIC;
        db.execSQL(s2);
        onCreate(db); }
}
