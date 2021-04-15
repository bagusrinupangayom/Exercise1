package com.example.exercise1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailData extends AppCompatActivity {
    static TextView tvnama,tvnomor;
    String nama;
    public static String nomor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kontak);

        Bundle b = getIntent().getExtras();
        nama = b.getString("a");

        tvnama = findViewById(R.id.tvNmKontak);
        tvnomor = findViewById(R.id.tvNoTelp);

        switch (nama)
        {
            case "Inayah":
                tvnama.setText("Inayah M");
                tvnomor.setText("08122233344");
                nomor = tvnomor.getText().toString();
                break;
            case "Ilham":
                tvnama.setText("Ilham R");
                tvnomor.setText("08122233355");
                nomor = tvnomor.getText().toString();
                break;
            case "Eris":
                tvnama.setText("Eris J");
                tvnomor.setText("08125533344");
                nomor = tvnomor.getText().toString();
                break;
            case "Fikri":
                tvnama.setText("M Fikri");
                tvnomor.setText("08124533344");
                nomor = tvnomor.getText().toString();
                break;
            case "Maul":
                tvnama.setText("Maul M");
                tvnomor.setText("08126633344");
                nomor = tvnomor.getText().toString();
                break;
            case "Intan":
                tvnama.setText("Intan S");
                tvnomor.setText("08122555344");
                nomor = tvnomor.getText().toString();
                break;
            case "Vina":
                tvnama.setText("Vina R");
                tvnomor.setText("08125556344");
                nomor = tvnomor.getText().toString();
                break;
            case "Gita":
                tvnama.setText("Gita S");
                tvnomor.setText("08199233344");
                nomor = tvnomor.getText().toString();
                break;
            case "Luthfi":
                tvnama.setText("Lutfi M");
                tvnomor.setText("08122232344");
                nomor = tvnomor.getText().toString();
                break;
            case "Vian":
                tvnama.setText("Vian M");
                tvnomor.setText("08122969344");
                nomor = tvnomor.getText().toString();
                break;
        }
    }
}
