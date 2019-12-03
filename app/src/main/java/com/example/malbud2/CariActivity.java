package com.example.malbud2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CariActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String[] spinner_array1 = {"< 5.000.000", "5.000.000 - 10.000.000", "Konghuchu", "Hindu", "Budha"};
    private String[] spinner_array2 = {"< 500", "500 - 1000", "10.000 - 20.000", "Hindu", "Budha"};
    private String Selected;

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari);

        Spinner spinner = (Spinner) findViewById(R.id.choose_harga);
        Spinner spinner2 = (Spinner) findViewById(R.id.choose_kap);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinner_array1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinner_array2);
        // mengeset Array Adapter tersebut ke Spinner
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
        Selected=spinner_array1[i];
        Selected=spinner_array2[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void back(View view) {
        Intent i = new Intent(CariActivity.this, HomeActivity.class);
        startActivity(i);
        finish();
    }
}
