package com.example.exercise1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class ListAdapter extends BaseAdapter {
    private final ArrayList<Nama> arrayList;
    LayoutInflater inflater;
    Context context;

    public ListAdapter(Context c){
        context = c;
        inflater = LayoutInflater.from(context);
        arrayList = new ArrayList<Nama>();
        arrayList.addAll(Kontak.classNamaArrayList);
    }

    public void pencarianNama(String query) {
        Kontak.classNamaArrayList.clear();
        if(query.isEmpty()){
            Kontak.classNamaArrayList.addAll(arrayList);
        }else{
            query = query.toLowerCase();
            for (Nama cariData : arrayList){
                if (cariData.getNama().toLowerCase().contains(query)){
                    Kontak.classNamaArrayList.add(cariData);
                }
            }
        }
        notifyDataSetChanged();
    }

    public class ViewHolder{
        TextView name;
    }

    @Override
    public int getCount() {
        return Kontak.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int p) {
        return Kontak.classNamaArrayList.get(p);
    }

    @Override
    public long getItemId(int p) {
        return p;
    }

    @Override
    public View getView(int p, View v, ViewGroup vg) {
        final ViewHolder holder;

        if(v == null){
            holder = new ViewHolder();
            v = inflater.inflate(R.layout.activity_item_listview,null);
            holder.name = v.findViewById(R.id.tvNamaItem);
            v.setTag(holder);
        }else{
            holder = (ViewHolder) v.getTag();
        }
        holder.name.setText(Kontak.classNamaArrayList.get(p).getNama());
        return v;
    }
}


