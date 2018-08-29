package com.example.meng.restaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBasefood extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "FoodMenu1.db";
    public static final String TABLE_NAME = "Food_Table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SIZE";
    public static final String COL_4 = "QUALITY";
    public static final String COL_5 = "NAME1";
    public static final String COL_6 = "SIZE1";
    public static final String COL_7 = "QUALITY1";




    public DataBasefood(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" create table "+ TABLE_NAME +" (ID INTEGER PRiMARY KEY AUTOINCREMENT, NAME TEXT, SIZE TEXT, QUALITY INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public boolean InsertData(String name, String size, String quality,
                              String name1, String size1, String quality1){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, size);
        contentValues.put(COL_4, quality);
        contentValues.put(COL_5, name1);
        contentValues.put(COL_6, size1);
        contentValues.put(COL_7, quality1);
        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if(result==-1)
            return  false;
        else
            return true;

    }

    public boolean updateData(String id, String name, String size, String quality,
                              String name1, String size1, String quality1){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, size);
        contentValues.put(COL_4, quality);
        contentValues.put(COL_5, name1);
        contentValues.put(COL_6, size1);
        contentValues.put(COL_7, quality1);
        sqLiteDatabase.update(TABLE_NAME, contentValues, "ID=?", new String[]{id});
        return true;

    }

    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor res =sqLiteDatabase.rawQuery(" select * from "+TABLE_NAME, null);
        return  res;
    }

}
