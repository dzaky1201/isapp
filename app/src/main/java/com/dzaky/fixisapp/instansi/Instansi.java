package com.dzaky.fixisapp.instansi;

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
import com.dzaky.fixisapp.masjid.Masjid;
import com.dzaky.fixisapp.masjid.MasjidAdapter;
import com.dzaky.fixisapp.masjid.MasjidJSON;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Instansi extends AppCompatActivity {


    private static final String URL_INSTANSI = "https://api.dzakyhdr.com/readinstansi/view.php";
    List<InstansiJSON> instansilist;

    InstansiAdapter adapter;

    RecyclerView recyclerViewInstansi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instansi);

        instansilist= new ArrayList<>();
        recyclerViewInstansi = (RecyclerView) findViewById(R.id.recyclerViewInstansi);
        recyclerViewInstansi.setHasFixedSize(true);
        recyclerViewInstansi.setLayoutManager(new LinearLayoutManager(this));

        loadInstansi();
    }

    private void loadInstansi(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_INSTANSI,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray instansis = new JSONArray(response);

                            for (int i = 0; i < instansis.length(); i++) {
                                JSONObject instansiObject = instansis.getJSONObject(i);

                                int id = instansiObject.getInt("id");
                                String nama_Instansi = instansiObject.getString("nama_Instansi");
                                String jenis_layanan = instansiObject.getString("jenis_layanan");
                                String lembaga = instansiObject.getString("lembaga");
                                String alamat = instansiObject.getString("alamat");
                                String image = instansiObject.getString("image");

                                InstansiJSON instansiJSON = new InstansiJSON(image, lembaga, nama_Instansi, jenis_layanan, id, alamat);
                                instansilist.add(instansiJSON);

                            }

                            adapter = new InstansiAdapter(Instansi.this, instansilist);
                            recyclerViewInstansi.setAdapter(adapter);
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
