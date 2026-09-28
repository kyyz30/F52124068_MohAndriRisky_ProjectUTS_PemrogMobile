
package com.mohandririsky_f52124068.aplikasi_uts;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etSearch;
    private ListView listViewCafe;
    private CafeAdapter cafeAdapter;

    private ArrayList<Cafe> daftarCafe;
    private ArrayList<Cafe> daftarCafeAsli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Menghubungkan komponen dari activity_main.xml
        etSearch = findViewById(R.id.etSearch);
        listViewCafe = findViewById(R.id.listViewCafe);

        // Menyiapkan data kafe
        daftarCafe = new ArrayList<>();
        daftarCafeAsli = new ArrayList<>();

        isiDataCafe();

        // Membuat adapter untuk ListView
        cafeAdapter = new CafeAdapter(this, daftarCafe);
        listViewCafe.setAdapter(cafeAdapter);

        // Fitur pencarian berdasarkan nama kafe
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {

                filterCafe(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    // Data kafe
    private void isiDataCafe() {

        daftarCafe.add(new Cafe(
                "Cafe Arobi",
                "Jl. Moh. Yamin",
                "Rp15.000 - Rp35.000",
                "Tempat nyaman untuk menikmati kopi bersama teman.",
                R.drawable.cafe_arobi
        ));

        daftarCafe.add(new Cafe(
                "Cafe Berkah",
                "Jl. Juanda",
                "Rp10.000 - Rp30.000",
                "Tempat santai dengan suasana yang hangat.",
                R.drawable.cafe_brkh
        ));

        daftarCafe.add(new Cafe(
                "Cafe Nostalgic",
                "Jl. Tombolotutu",
                "Rp20.000 - Rp50.000",
                "Kafe dengan suasana klasik dan nyaman.",
                R.drawable.cafe_nostalgic
        ));

        daftarCafe.add(new Cafe(
                "Cafe Senja",
                "Jl. Kampung Nelayan",
                "Rp15.000 - Rp35.000",
                "Tempat menikmati kopi sambil bersantai.",
                R.drawable.cafe_senja
        ));

        daftarCafe.add(new Cafe(
                "Cafe Sin",
                "Jl. Soekarno Hatta",
                "Rp10.000 - Rp30.000",
                "Tempat berkumpul dan menikmati minuman.",
                R.drawable.cafe_sin
        ));

        // Menyimpan salinan data asli untuk proses pencarian
        daftarCafeAsli.addAll(daftarCafe);
    }

    // Fungsi pencarian kafe
    private void filterCafe(String kataKunci) {

        daftarCafe.clear();

        String kata = kataKunci.toLowerCase().trim();

        for (Cafe cafe : daftarCafeAsli) {
            if (cafe.getNama().toLowerCase().contains(kata)) {
                daftarCafe.add(cafe);
            }
        }

        cafeAdapter.notifyDataSetChanged();
    }
}