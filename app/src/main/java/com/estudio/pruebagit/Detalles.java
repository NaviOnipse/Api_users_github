package com.estudio.pruebagit;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.estudio.pruebagit.adaptador.AdaptadorIe;
import com.estudio.pruebagit.modelo.Getset;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class Detalles extends AppCompatActivity {
    int position;
    //Context context;
    ArrayList<Getset> listarray;
    RecyclerView vercycler;
    AdaptadorIe adaptador;

    //public Detalles(Context context,ArrayList<Getset> listarray){
        //this.position = position;
       //this.context = context;
        //this.listarray = listarray;
    //}


    Bundle datos; //Recibiendo datos del Intent
    TextView recibejson;
    TextView recibejson2;
    TextView recibejson3;
    ImageView recibefoto;



    //***************************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        //getServerData();
        // Recibiendo datos del Intent
        //final Getset listarrays = listarray.get(position);
        datos = getIntent().getExtras();
        String recilogin = datos.getString("datoslogin");
        String reciurl = datos.getString("datosurl");
        String reciavatar = datos.getString("datosavatar");

        recibejson = (TextView) findViewById(R.id.enviajson);
        recibejson2 = (TextView) findViewById(R.id.enviajson2);
        recibejson3 = (TextView) findViewById(R.id.enviajson3);
        recibefoto = (ImageView) findViewById(R.id.fotousuario);

        recibejson.setText(recilogin);
        recibejson3.setText(reciurl);
        //recibejson2.setText(listarrays.getname());

        //***************************************************



        /* utilizando la libreria picasso para la carga de fotos

        libreria picasso-transformaciones para crear circulos:*/

        Picasso.with(this).load(reciavatar).transform(new CropCircleTransformation()).into(recibefoto);

        //*******************************************************************************


    }
  /*
    private void getServerData() {
        final Getset listarrays = listarray.get(position);
        final String loginbarra = listarrays.login;

             String loginbarras = "/" + loginbarra;
        String urlGetServerData = "https://api.github.com/users" + loginbarras;//https://api.github.com/users?since=2
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
*/

}
