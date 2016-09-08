package com.example.alumno.clase_4;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by alumno on 08/09/2016.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView tvNombre;
    public TextView tvApellido;

    public MyViewHolder(View v) {
        super(v);
        tvNombre=(TextView)v.findViewById(R.id.txtNombre);
        tvApellido=(TextView)v.findViewById(R.id.txtApellido);
    }
}
