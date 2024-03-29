package com.example.malbud2.Gedung;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Gedung {
    private String Name, Alamat, Fasilitas, Kapasitas, Harga;
    private String Image;

    public Gedung(){

    }

    public Gedung(String name, String alamat, String fasilitas, String kapasitas, String harga, String image) {
        Name = name;
        Alamat = alamat;
        Fasilitas = fasilitas;
        Kapasitas = kapasitas;
        Harga = harga;
        Image = image;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getFasilitas() {
        return Fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        Fasilitas = fasilitas;
    }

    public String getKapasitas() {
        return Kapasitas;
    }

    public void setKapasitas(String kapasitas) {
        Kapasitas = kapasitas;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Name", Name);
        result.put("Image", Image);
        result.put("Alamat", Alamat);
        result.put("Harga", Harga);
        result.put("Fasilitas", Fasilitas);
        result.put("Kapasitas", Kapasitas);
        return result;
    }
}
