package ibanez.brian.myapplication;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by alumno on 08/09/2016.
 */
public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tvNombre;
    public TextView tvApellido;
    public int indexPersona;
    private MainActivity ma;

    public MyViewHolder(View itemView, MainActivity ma) {

        super(itemView);
        this.tvApellido = (TextView)itemView.findViewById(R.id.txtApellido);
        this.tvNombre = (TextView)itemView.findViewById(R.id.txtNombre);
        this.ma = ma;
        itemView.setOnClickListener(this);

    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void onClick(View v) {

        this.ma.onClickMyViewHolder();
        Log.d("Se hizo click", " PERSONA" + this.indexPersona);

    }
}
