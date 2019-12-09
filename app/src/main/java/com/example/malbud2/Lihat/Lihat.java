package com.example.malbud2.Lihat;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Lihat {
    private String Name, Image, Alamat, Fasilitas, Kapasitas, Harga;


    public Lihat(){

    }

    public Lihat(String name, String image, String alamat, String fasilitas, String kapasitas, String harga) {
        Name = name;
        Image = image;
        Alamat = alamat;
        Fasilitas = fasilitas;
        Kapasitas = kapasitas;
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
