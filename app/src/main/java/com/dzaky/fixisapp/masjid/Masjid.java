package com.dzaky.fixisapp.masjid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.textclassifier.TextLinks;

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

public class Masjid extends AppCompatActivity {

    private static final String URL_MASJID = "https://api.dzakyhdr.com/readmasjid/view.php";
    List<MasjidJSON> masjidlist;

    MasjidAdapter adapter;

    RecyclerView recyclerViewMasjid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masjid);

        masjidlist= new ArrayList<>();
        recyclerViewMasjid = (RecyclerView) findViewById(R.id.recyclerViewMasjid);
        recyclerViewMasjid.setHasFixedSize(true);
        recyclerViewMasjid.setLayoutManager(new LinearLayoutManager(this));

        loadMasjid();
    }

    private void loadMasjid(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_MASJID,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray masjids = new JSONArray(response);

                            for (int i = 0; i < masjids.length(); i++) {
                                JSONObject masjidObject = masjids.getJSONObject(i);

                                int id = masjidObject.getInt("id");
                                String nama_masjid = masjidObject.getString("nama_masjid");
                                String alamat = masjidObject.getString("alamat");
                                String image = masjidObject.getString("image");

                                MasjidJSON masjidJSON = new MasjidJSON(image, nama_masjid, id, alamat);
                                masjidlist.add(masjidJSON);

                            }

                            adapter = new MasjidAdapter(Masjid.this, masjidlist);
                            recyclerViewMasjid.setAdapter(adapter);
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
