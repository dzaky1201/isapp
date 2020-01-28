package com.dzaky.fixisapp.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dzaky.fixisapp.R;
import com.dzaky.fixisapp.instansi.Instansi;
import com.dzaky.fixisapp.profile.Profile;
import com.dzaky.fixisapp.sekolah.Sekolah;
import com.dzaky.fixisapp.masjid.Masjid;
import com.dzaky.fixisapp.toko.Toko;

public class MainActivity extends AppCompatActivity {
    TextView tvResultNama;
    String resultNama;
    ImageView btnLogout, moveMasjid, moveToko, moveJasa, moveInstansi, user;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.user);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Profile.class));
            }
        });

        //move instansi

        moveInstansi =findViewById(R.id.moveInstansi);
        moveInstansi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Instansi.class));
            }
        });

        //move jasa

        moveJasa = findViewById(R.id.moveJasa);
        moveJasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Sekolah.class));
            }
        });

        //move masjid
        moveMasjid = findViewById(R.id.moveMasjid);
        moveMasjid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Masjid.class));
            }
        });

        moveToko = findViewById(R.id.moveToko);
        moveToko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Toko.class));
            }
        });
        initComponents();
        // untuk mendapatkan data dari activity sebelumnya, yaitu activity login.
        Bundle extras = getIntent().getExtras();
        if (extras != null)
            resultNama = extras.getString("result_nama");
        tvResultNama.setText(resultNama);
        sharedPrefManager = new SharedPrefManager(this);

        tvResultNama.setText(sharedPrefManager.getSPNama());
    }

    private void initComponents() {

        tvResultNama = (TextView) findViewById(R.id.tvResultNama);
        btnLogout = (ImageView) findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
                startActivity(new Intent(MainActivity.this, LoginActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        });
    }
    }

