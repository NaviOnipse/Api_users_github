package com.estudio.pruebagit;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class Detalles extends AppCompatActivity {

    Bundle datos; //Recibiendo datos del Intent
    TextView recibejson;
    TextView recibejson2;
    TextView recibejson3;
    ImageView recibefoto;
    Context context;


    //***************************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        // Recibiendo datos del Intent

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
        //recibejson3.setText(reciavatar);

        //***************************************************



        /* utilizando la libreria picasso para la carga de fotos

        libreria picasso-transformaciones para crear circulos:*/

        Picasso.with(this).load(reciavatar).transform(new CropCircleTransformation()).into(recibefoto);

        //*******************************************************************************


    }
}
