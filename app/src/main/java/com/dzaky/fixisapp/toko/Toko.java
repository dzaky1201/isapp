package com.dzaky.fixisapp.toko;

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
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Toko extends AppCompatActivity {

    private static final String URL_TOKO = "https://api.dzakyhdr.com/readtoko/view.php";
    List<TokoJSON> tokolist;

    TokoAdapter adapter;
    RecyclerView recyclerViewToko;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toko);

        tokolist = new ArrayList<>();
        recyclerViewToko =(RecyclerView) findViewById(R.id.recyclerViewToko);
        recyclerViewToko.setHasFixedSize(true);
        recyclerViewToko.setLayoutManager(new LinearLayoutManager(this));

        loadToko();
    }

    private void loadToko() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_TOKO,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray tokos = new JSONArray(response);

                            for (int i = 0; i < tokos.length(); i++) {
                                JSONObject tokoObject = tokos.getJSONObject(i);

                                int id = tokoObject.getInt("id");
                                String image = tokoObject.getString("image");
                                String namaToko = tokoObject.getString("nama_toko");
                                String jenis = tokoObject.getString("jenis");
                                String nomorHp = tokoObject.getString("nomor_hp");
                                String alamat = tokoObject.getString("alamat");

                                TokoJSON tokoJSON = new TokoJSON(namaToko, image, jenis, id, nomorHp, alamat);
                                tokolist.add(tokoJSON);
                            }

                            adapter = new TokoAdapter(Toko.this, tokolist);
                            recyclerViewToko.setAdapter(adapter);
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
