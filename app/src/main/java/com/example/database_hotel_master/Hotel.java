package com.example.database_hotel_master;

public class Hotel {
    private String _id, _nama, _no_identitas, _cin, _cout;

    public Hotel (String id, String nama, String no_identitas, String cin, String cout) {
        this._id = id;
        this._nama = nama;
        this._no_identitas = no_identitas;
        this._cin= cin;
        this._cout= cout;
    }

    public Hotel() {
    }

    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }

    public String get_no_identitas( ) {
        return _no_identitas;
    }
    public void set_no_identitas(String _no_identitas) {
        this._no_identitas = _no_identitas;
    }

    public String get_cin() {
        return _cin;
    }
    public void set_cin(String _cin) {
        this._cin = _cin;
    }

    public String get_cout() {
        return _cout;
    }
    public void set_cout(String _cout) {
        this._cout = _cout;
    }
}
