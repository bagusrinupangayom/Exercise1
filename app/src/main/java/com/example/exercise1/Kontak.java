package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Kontak extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, SearchView.OnQueryTextListener {
    private ListAdapter adapter;
    private ListView list;
    private SearchView cari;
    String[] listNama,listNomor;
    String nama;
    public static ArrayList<Nama> classNamaArrayList = new ArrayList<Nama>();
    Bundle b = new Bundle();
    Intent i;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_kontak);
        SearchView cariData = findViewById(R.id.kataPencarian);

        listNama = new String[]{"Inayah","Ilham","Eris","Fikri",
                "Maul","Intan","Vina","Gita","Vian","Luthfi"};

        listNomor = new String[]{"08122233344","08122233355","08125533344","08124533344","08126633344","08122555344",
                "08125556344","08199233344","08122969344","08122232344"};
        list = findViewById(R.id.listKontakk);
        classNamaArrayList = new ArrayList<>();

        int x = 0;
        while(true){
            String[] strArray = listNama;
            if (x < strArray.length){
                classNamaArrayList.add(new Nama(strArray[x]));
                x++;
            }else{
                ListAdapter listAdapter = new ListAdapter(this);
                adapter = listAdapter;
                list.setAdapter(listAdapter);
                cari = cariData;
                cari.setOnQueryTextListener(this);

                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View v, int i, long id) {
                        nama = classNamaArrayList.get(i).getNama();
                        b.putString("a",nama.trim());

                        PopupMenu pm = new PopupMenu(getApplicationContext(),v);
                        pm.setOnMenuItemClickListener(Kontak.this);
                        pm.inflate(R.menu.popup_menu);
                        pm.show();
                    }
                });
                return;
            }
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menuView:
                i = new Intent(getApplicationContext(), DetailData.class);
                i.putExtras(b);
                startActivity(i);
                break;
            case R.id.menuNomor:
                Toast.makeText(getApplicationContext(), DetailData.nomor, Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
//        adapter.pencarianNama(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String cariNama) {
        adapter.pencarianNama(cariNama);
        return false;
    }
}
