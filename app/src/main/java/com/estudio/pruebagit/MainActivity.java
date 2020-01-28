package com.estudio.pruebagit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.estudio.pruebagit.adaptador.AdaptadorIe;
import com.estudio.pruebagit.modelo.Getset;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<Getset> listarray = new ArrayList<Getset>();
    RecyclerView vercycler;
    AdaptadorIe adaptador;

    // ArrayList<Rvdata> rvdata = getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        vercycler = findViewById(R.id.vistactivi);
        vercycler.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        vercycler.setLayoutManager(layoutManager);

        getServerData();
    }
    //segundo cambio para Json con diferentes array y objeto con otro json en otra dirección " Ha sido un exito" ;)
    private void getServerData() {
        String urlGetServerData = "https://api.github.com/users";//https://api.github.com/users?since=2
        System.out.print(urlGetServerData);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlGetServerData,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        System.out.println(response);

                        try {
                            Gson gson = new Gson();

                            JSONObject objeto1 = response.getJSONObject(2);

                            for (int i=0; i<objeto1.length(); i++){
                                JSONObject objeto2 = response.getJSONObject(i);
                                Getset getset = gson.fromJson(String.valueOf(objeto2), Getset.class);
                                listarray.add(getset);
                            }
                            adaptador = new AdaptadorIe(getApplicationContext(), listarray);
                            vercycler.setAdapter(adaptador);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error.toString());
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonArrayRequest);
    }
}
