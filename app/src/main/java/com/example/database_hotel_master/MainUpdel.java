package com.example.database_hotel_master;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Snoidentitas, Scin, Scout;
    private EditText Enama, Enoidentitas, Ecin, Ecout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();

        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Snoidentitas = i.getStringExtra("Inoidentitas");
        Scin = i.getStringExtra("Icin");
        Scout = i.getStringExtra("Icout");

        Enama = (EditText) findViewById(R.id.updel_nama);
        Enoidentitas = (EditText) findViewById(R.id.updel_no_identitas);
        Ecin = (EditText) findViewById(R.id.updel_cin);
        Ecout = (EditText) findViewById(R.id.updel_cout);

        Enama.setText(Snama);
        Enoidentitas.setText(Snoidentitas);
        Ecin.setText(Scout);
        Ecout.setText(Scout);

        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Snoidentitas = String.valueOf(Enoidentitas.getText());
                Scin = String.valueOf(Ecin.getText());
                Scout = String.valueOf(Ecout.getText());

                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi Nama Tamu",
                            Toast.LENGTH_SHORT).show();
                } else if (Snoidentitas.equals("")){
                    Enoidentitas.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan masukkan Nomor Identitas",
                            Toast.LENGTH_SHORT).show();
                } else if (Scin.equals("")){
                    Ecin.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan Masukkan Tanggal Check-In",
                            Toast.LENGTH_SHORT).show();
                } else if (Scout.equals("")){
                    Ecout.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan Masukkan Tanggal Check-out",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateBarang(new Hotel(Sid, Snama, Snoidentitas, Scin, Scout));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteBarang(new Hotel(Sid, Snama, Snoidentitas, Scin, Scout));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

