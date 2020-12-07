package com.example.database_hotel_master;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Enoidentitas, Ecin, Ecout;
    private String Snama, Snoidentitas, Scin, Scout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Enoidentitas = (EditText) findViewById(R.id.create_no_identitas);
        Ecin = (EditText) findViewById(R.id.create_cin);
        Ecout = (EditText) findViewById(R.id.create_cout);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Snoidentitas = String.valueOf(Enoidentitas.getText());
                Scin = String.valueOf(Ecin.getText());
                Scout = String.valueOf(Ecout.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Nama Tamu",
                            Toast.LENGTH_SHORT).show();
                } else if (Snoidentitas.equals("")){
                    Enoidentitas.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan masukkan No Identitas Tamu",
                            Toast.LENGTH_SHORT).show();
                }else if (Scin.equals("")){
                    Ecin.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan Masukkan Tanggal Check-In",
                            Toast.LENGTH_SHORT).show();
                }else if (Scout.equals("")){
                    Ecout.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan Masukkan Tanggal Check-Out",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Enoidentitas.setText("");
                    Ecin.setText("");
                    Ecout.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateBarang(new Hotel(null, Snama, Snoidentitas, Scin, Scout));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}