package com.example.dltkl.mysqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandler extends SQLiteOpenHelper{

    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "products.db";
    private static String TABLE_PRODUCTS = "products";
    private static String COLUMN_ID = "_id";
    private static String COLUMN_PRODUCTS = "name";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_PRODUCTS +  "(" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT " + COLUMN_PRODUCTS + " TEXT );";
            db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int  newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_PRODUCTS);
        onCreate(db);
    }

    public void addProduct(Products product){
        ContentValues v = new ContentValues();
        v.put(COLUMN_PRODUCTS, product.getName());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, v);
        db.close();
    }

    public void deleteProduct(String name){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTS + "=\"" + name + "\";");
        db.close();
    }

    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query  = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE 1;";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while(!(c.isAfterLast()))
            if(c.getString(c.getColumnIndex("name"))!=null){
                dbString += c.getString(c.getColumnIndex("name"));
                dbString += "\n";
            }
        db.close();
        return dbString;
    }
}
