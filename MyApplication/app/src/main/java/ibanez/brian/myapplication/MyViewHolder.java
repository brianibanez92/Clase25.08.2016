package ibanez.brian.myapplication;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

/**
 * Created by alumno on 08/09/2016.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView tvNombre;
    public TextView tvApellido;

    public MyViewHolder(View itemView) {

        super(itemView);
        this.tvApellido = (TextView)itemView.findViewById(R.id.txtApellido);
        this.tvNombre = (TextView)itemView.findViewById(R.id.txtNombre);

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
