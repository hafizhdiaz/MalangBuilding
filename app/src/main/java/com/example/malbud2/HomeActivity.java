package com.example.malbud2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.malbud2.Gedung.Gedung;
import com.example.malbud2.Gedung.GedungViewHolder;
import com.example.malbud2.Gedung.ItemClickListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {
    RecyclerView listGedung;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<Gedung, GedungViewHolder> adapter;

    FirebaseDatabase database;
    DatabaseReference gedung;

    public static HomeActivity newInstances()
    {
        HomeActivity homeActivity = new HomeActivity();
        return homeActivity;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        database = FirebaseDatabase.getInstance();
        gedung = database.getReference("gedung");

        listGedung = findViewById(R.id.txtor);
        listGedung.setHasFixedSize(true);
        listGedung.setLayoutManager(new GridLayoutManager(this, 1));

        FirebaseRecyclerOptions<Gedung> options =
                new FirebaseRecyclerOptions.Builder<Gedung>()
                        .setQuery(gedung, Gedung.class)
                        .build();

        adapter = new FirebaseRecyclerAdapter<Gedung, GedungViewHolder>(options)
        {
            @NonNull
            @Override
            public GedungViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new GedungViewHolder(inflater.inflate(R.layout.list_gedung, parent, false));
            }

            @Override
            protected void onBindViewHolder(@NonNull GedungViewHolder viewHolder, int position, @NonNull final Gedung model) {
                viewHolder.category_name.setText(model.getName());
                Glide.with(viewHolder.itemView)
                        .load(model.getImage())
                        .into(viewHolder.category_image);

                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {

                        Intent startGame = new Intent(view.getContext() ,Start.class);
                        Common.categoryId = adapter.getRef(position).getKey();
                        Common.categoryName = model.getName();
                        startActivity(startGame);
                    }
                });
            }

        };
        adapter.notifyDataSetChanged();
        listGedung.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            // TODO: open settings here using openFragment()
            Intent i = new Intent(HomeActivity.this, CariActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (adapter != null) {
            adapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (adapter != null) {
            adapter.stopListening();
        }
    }
}
