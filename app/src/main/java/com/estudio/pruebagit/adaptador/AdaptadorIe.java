package com.estudio.pruebagit.adaptador;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.estudio.pruebagit.Detalles;
import com.estudio.pruebagit.R;
import com.estudio.pruebagit.modelo.Getset;

import java.util.ArrayList;

public class AdaptadorIe extends RecyclerView.Adapter<AdaptadorIe.CamposView>{

    Context context;
    ArrayList<Getset> getsets;

    public AdaptadorIe(Context context, ArrayList<Getset> getsets){
        this.context = context;
        this.getsets = getsets;
    }

    View view;
    @Override
    public CamposView onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.from(parent.getContext()).inflate(R.layout.recyclercard,parent,false);
        CamposView camposview = new CamposView(view);
        return camposview;
    }

    @Override
    public void onBindViewHolder(final CamposView holder, final int position) {
        final Getset getset = getsets.get(position);
        holder.jsonlogin.setText(getset.getlogin());
        holder.jsonurl.setText(getset.geturl());

        // Datos del avatar por medio de la libreria Glide
        String imgUrl = getset.getavatar_url();
        Glide.with(context)
                .load(imgUrl)
                .thumbnail(0.5f)
                .into(holder.jsonavatar);
        //*********************************************************************
        final String logins = getset.login;
        final String urls = getset.html_url;
        final String avatar = getset.avatar_url;

        // Pulsa el boton cardview y pasamos los datos por medio de un Intent
        holder.botonintent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Detalles.class);

                // Aquí comienza el codigo del paso de datos por medio de un Intent
                Bundle bun = new Bundle();
                bun.putString("datoslogin",logins);
                bun.putString("datosurl",urls);
                bun.putString("datosavatar",avatar);
                //este codigo es para el recycler datos
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                // Aquí metemos los datos en el Intent
                intent.putExtras(bun);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getsets.size();
    }

    public class CamposView extends RecyclerView.ViewHolder {

        TextView jsonlogin;
        TextView jsonurl;
        ImageView jsonavatar;
        LinearLayout botonintent;

        public CamposView(View inyectView) {
            super(inyectView);

            jsonlogin = inyectView.findViewById(R.id.campologin);
            jsonurl = inyectView.findViewById(R.id.campourl);
            jsonavatar = inyectView.findViewById(R.id.avatarjson);
            botonintent = inyectView.findViewById(R.id.botonactivity);

        }
    }
}

