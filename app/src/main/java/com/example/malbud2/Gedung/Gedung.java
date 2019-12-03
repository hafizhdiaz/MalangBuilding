package com.example.malbud2.Gedung;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Gedung {
    private String Name;
    private String Image;

    public Gedung(){

    }

    public Gedung(String name, String image){
        Name = name;
        Image = image;
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
        return result;
    }
}
