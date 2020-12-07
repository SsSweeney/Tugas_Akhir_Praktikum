package com.example.database_hotel_master;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_hotel";
    private static final String tb_barang = "tb_barang";
    private static final String tb_barang_id = "id";
    private static final String tb_barang_nama = "nama";
    private static final String tb_barang_no_identitas = "noidentitas";
    private static final String tb_barang_cin = "cin";
    private static final String tb_barang_cout = "cout";
    private static final String CREATE_TABLE_HOTEL = "CREATE TABLE " +
            tb_barang + "("
            + tb_barang_id + " INTEGER PRIMARY KEY ,"
            + tb_barang_nama + " TEXT,"
            + tb_barang_no_identitas + " INTEGER,"
            + tb_barang_cin + " TEXT,"
            + tb_barang_cout + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_HOTEL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateBarang (Hotel mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_barang_id, mdNotif.get_id());
        values.put(tb_barang_nama, mdNotif.get_nama());
        values.put(tb_barang_no_identitas, mdNotif.get_no_identitas());
        values.put(tb_barang_cin, mdNotif.get_cin());
        values.put(tb_barang_cout, mdNotif.get_cout());
        db.insert(tb_barang, null, values);
        db.close();
    }

    public List<Hotel> ReadHotel() {
        List<Hotel> judulModelList = new ArrayList<Hotel>();
        String selectQuery = "SELECT * FROM " + tb_barang;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Hotel mdKontak = new Hotel();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_no_identitas(cursor.getString(2));
                mdKontak.set_cin(cursor.getString(3));
                mdKontak.set_cout(cursor.getString(4));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateBarang (Hotel mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_barang_nama, mdNotif.get_nama());
        values.put(tb_barang_no_identitas, mdNotif.get_no_identitas());
        values.put(tb_barang_cin, mdNotif.get_cin());
        values.put(tb_barang_cout, mdNotif.get_cout());
        return db.update(tb_barang, values, tb_barang_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteBarang (Hotel mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_barang, tb_barang_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}

