package com.dzaky.fixisapp.sekolah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dzaky.fixisapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Sekolah extends AppCompatActivity {

    private static final String URL_SEKOLAH = "https://api.dzakyhdr.com/readsekolah/view.php";
    List<SekolahJSON> sekolahlist;

    SekolahAdapter adapter;
    RecyclerView recyclerViewSekolah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sekolah);

        sekolahlist= new ArrayList<>();
        recyclerViewSekolah = findViewById(R.id.recyclerViewSekolah);
        recyclerViewSekolah.setHasFixedSize(true);
        recyclerViewSekolah.setLayoutManager(new LinearLayoutManager(this));

        loadSekolah();
    }

    private void loadSekolah() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_SEKOLAH,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jasas = new JSONArray(response);

                            for (int i = 0; i < jasas.length(); i++) {
                                JSONObject jasaObject = jasas.getJSONObject(i);

                                int id = jasaObject.getInt("id");
                                String nama_sekolah = jasaObject.getString("nama_sekolah");
                                String nomor_hp = jasaObject.getString("nomor_hp");
                                String alamat = jasaObject.getString("alamat");
                                String images = jasaObject.getString("images");

                                SekolahJSON sekolahJSON = new SekolahJSON(id, nama_sekolah, nomor_hp, alamat, images);
                                sekolahlist.add(sekolahJSON);

                            }
                            adapter = new SekolahAdapter(Sekolah.this, sekolahlist);
                            recyclerViewSekolah.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        setContentView(R.layout.error);
                    }
                });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
