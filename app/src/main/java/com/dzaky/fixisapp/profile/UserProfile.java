package com.dzaky.fixisapp.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dzaky.fixisapp.Login.LoginActivity;
import com.dzaky.fixisapp.Login.SharedPrefManager;
import com.dzaky.fixisapp.R;

public class UserProfile extends AppCompatActivity {

    TextView tvResultNama, btnLogout;
    String resultNama;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);



        //mendapatkan nama username
        Bundle extras = getIntent().getExtras();
        if (extras != null)
            resultNama = extras.getString("result_nama");
        tvResultNama.setText(resultNama);
        sharedPrefManager = new SharedPrefManager(this);

        tvResultNama.setText(sharedPrefManager.getSPNama());

        initComponents();
    }

    private void initComponents() {
        tvResultNama = findViewById(R.id.username);
        btnLogout = findViewById(R.id.keluar);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
                startActivity(new Intent(UserProfile.this, LoginActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        });
    }
}
