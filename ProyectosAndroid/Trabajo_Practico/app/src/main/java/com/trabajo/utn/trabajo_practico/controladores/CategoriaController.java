package com.trabajo.utn.trabajo_practico.controladores;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;

import com.trabajo.utn.trabajo_practico.CategoriaActivity;
import com.trabajo.utn.trabajo_practico.R;
import com.trabajo.utn.trabajo_practico.vistas.CategoriaView;

import java.io.File;

/**
 * Created by julian.moreno on 9/22/2016.
 */
public class CategoriaController implements View.OnClickListener{
    private CategoriaActivity activity;
    private CategoriaView view;
    final int CAMARA=0;
    final int CAMARA_PERMISO=0;
    private Uri uri;

    public CategoriaController(CategoriaActivity a){
        this.activity=a;
    }

    public void setImage(){
        ImageView iv=(ImageView) this.activity.findViewById(R.id.imgFoto);
        iv.setImageURI(uri);
    }
    @Override
    public void onClick(View v) {

        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File imagesFloder=new File(
        Environment.getExternalStorageDirectory(),"CategoriasAPP");
        imagesFloder.mkdirs();

        File img=new File(imagesFloder,"myImage.jpg");

        uri=Uri.fromFile(img);

        i.putExtra(MediaStore.EXTRA_OUTPUT,uri);

        if(ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA)!=
                PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)!=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.CAMERA},CAMARA_PERMISO);
        }else{
            this.activity.startActivityForResult(i, CAMARA);
        }

    }

    public CategoriaView getView() {
        return view;
    }

    public void setView(CategoriaView view) {
        this.view = view;
    }
}
