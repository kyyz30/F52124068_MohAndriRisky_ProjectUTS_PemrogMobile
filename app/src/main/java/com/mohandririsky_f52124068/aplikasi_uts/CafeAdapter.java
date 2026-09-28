
package com.mohandririsky_f52124068.aplikasi_uts;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CafeAdapter extends ArrayAdapter<Cafe> {

    private Activity context;
    private ArrayList<Cafe> daftarCafe;

    public CafeAdapter(Activity context, ArrayList<Cafe> daftarCafe) {
        super(context, R.layout.item_cafe, daftarCafe);
        this.context = context;
        this.daftarCafe = daftarCafe;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        if (row == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            row = inflater.inflate(R.layout.item_cafe, parent, false);
        }

        Cafe cafe = daftarCafe.get(position);

        ImageView imgCafe = row.findViewById(R.id.imgCafe);
        TextView tvNamaCafe = row.findViewById(R.id.tvNamaCafe);
        TextView tvLokasiCafe = row.findViewById(R.id.tvLokasiCafe);
        TextView tvHargaCafe = row.findViewById(R.id.tvHargaCafe);
        TextView tvDeskripsiCafe = row.findViewById(R.id.tvDeskripsiCafe);

        imgCafe.setImageResource(cafe.getGambar());
        tvNamaCafe.setText(cafe.getNama());
        tvLokasiCafe.setText(cafe.getLokasi());
        tvHargaCafe.setText(cafe.getHarga());
        tvDeskripsiCafe.setText(cafe.getDeskripsi());

        return row;
    }
}