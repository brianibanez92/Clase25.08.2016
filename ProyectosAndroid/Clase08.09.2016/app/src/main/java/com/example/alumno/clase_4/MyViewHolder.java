package com.example.alumno.clase_4;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by alumno on 08/09/2016.
 */
public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView tvNombre;
    public TextView tvApellido;
    public int index;

    public MyViewHolder(View v) {
        super(v);
        tvNombre=(TextView)v.findViewById(R.id.txtNombre);
        tvApellido=(TextView)v.findViewById(R.id.txtApellido);
        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("Se hizo click","Index: "+index);
    }
}
