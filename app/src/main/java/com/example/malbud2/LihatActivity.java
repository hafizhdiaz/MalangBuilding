package com.example.malbud2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class LihatActivity extends AppCompatActivity {

    TextView name, alamat, harga, fasilitas, kapasitas;
    ImageView gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);

        name = this.findViewById(R.id.category_name1);
        alamat = this.findViewById(R.id.category_name2);
        harga = this.findViewById(R.id.category_name3);
        fasilitas = this.findViewById(R.id.category_name4);
        kapasitas = this.findViewById(R.id.category_name5);
        gambar = this.findViewById(R.id.category_image1);

        Bundle bundle = getIntent().getExtras();
        String urlGambar = bundle.getString("image");
        String getNama = bundle.getString("nama");
        String getHarga = bundle.getString("harga");
        String getFasilitas = bundle.getString("fasilitas");
        String getAlamat = bundle.getString("alamat");
        String getKapasitas = bundle.getString("kapasitas");

        name.setText(getNama);
        alamat.setText(getAlamat);
        harga.setText(getHarga);
        fasilitas.setText(getFasilitas);
        kapasitas.setText(getKapasitas);
        Glide.with(this)
                .load(urlGambar)
                .into(gambar);
    }
}
