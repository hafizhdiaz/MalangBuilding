package com.example.malbud2.Lihat;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.malbud2.R;

public class LihatViewHolder extends RecyclerView.ViewHolder {
    public TextView category_name, catname1, catname2, catname3, catname4;
    public ImageView category_image;

    public LihatViewHolder(@NonNull View itemView) {
        super(itemView);
        category_image = (ImageView)itemView.findViewById(R.id.category_image1);
        category_name = (TextView)itemView.findViewById(R.id.category_name1);
        catname1 = (TextView)itemView.findViewById(R.id.category_name2);
        catname2 = (TextView)itemView.findViewById(R.id.category_name3);
        catname3 = (TextView)itemView.findViewById(R.id.category_name4);
        catname4 = (TextView)itemView.findViewById(R.id.category_name5);
    }
}
