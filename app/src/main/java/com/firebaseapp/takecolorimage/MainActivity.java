package com.firebaseapp.takecolorimage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Deklarasi Variable
    //https://www.wildantechnoart.net/2018/09/cara-mengambil-warna-dari-gambar-menggunakan-android-palette.html
    private TextView Vibrant, VibrantDark, VibrantLight, Muted, MutedDark, MutedLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi
        Vibrant = findViewById(R.id.getVibrant);
        VibrantDark = findViewById(R.id.getVibrantDark);
        VibrantLight = findViewById(R.id.getVibrantLight);
        Muted = findViewById(R.id.getMuted);
        MutedDark = findViewById(R.id.getMutedDark);
        MutedLight = findViewById(R.id.getMutedLight);

        //Mengambil gambar dari Bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);

        //Menggunakan class Paletter untuk mengekstrak warna dari Gambar Bitmap
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@NonNull Palette palette) {
                //Mengambil Warna dari Gambar menggunakan Palette
                int defaultValue = 0x000000;
                int vibrant = palette.getVibrantColor(defaultValue);
                int vibrantLight = palette.getLightVibrantColor(defaultValue);
                int vibrantDark = palette.getDarkVibrantColor(defaultValue);
                int muted = palette.getMutedColor(defaultValue);
                int mutedLight = palette.getLightMutedColor(defaultValue);
                int mutedDark = palette.getDarkMutedColor(defaultValue);

                //Menerapkan Warna tersebut pada Background TextView
                Vibrant.setBackgroundColor(vibrant);
                VibrantLight.setBackgroundColor(vibrantLight);
                VibrantDark.setBackgroundColor(vibrantDark);
                Muted.setBackgroundColor(muted);
                MutedLight.setBackgroundColor(mutedLight);
                MutedDark.setBackgroundColor(mutedDark);
            }
        });
    }
}
