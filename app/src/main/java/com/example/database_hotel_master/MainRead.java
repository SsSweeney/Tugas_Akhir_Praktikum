package com.example.database_hotel_master;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Hotel> ListBarang = new ArrayList<Hotel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListBarang );
        mListView = (ListView) findViewById(R.id.list_barang);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListBarang.clear();
        List<Hotel> contacts = db.ReadHotel();
        for (Hotel cn : contacts) {
            Hotel judulModel = new Hotel();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_no_identitas(cn.get_no_identitas());
            judulModel.set_cin(cn.get_cin());
            judulModel.set_cout(cn.get_cout());
            ListBarang.add(judulModel);
            if ((ListBarang.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Hotel obj_itemDetails = (Hotel) o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Snoidentitas = obj_itemDetails.get_no_identitas();
        String Scin = obj_itemDetails.get_cin();
        String Scout = obj_itemDetails.get_cout();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Inoidentitas", Snoidentitas);
        goUpdel.putExtra("Icin", Scin);
        goUpdel.putExtra("Icout", Scout);
        startActivity(goUpdel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListBarang.clear();
        mListView.setAdapter(adapter_off);
        List<Hotel> contacts = db.ReadHotel();
        for (Hotel cn : contacts) {
            Hotel judulModel = new Hotel();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_no_identitas(cn.get_no_identitas());
            judulModel.set_cin(cn.get_cin());
            judulModel.set_cout(cn.get_cout());
            ListBarang.add(judulModel);
            if ((ListBarang.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
