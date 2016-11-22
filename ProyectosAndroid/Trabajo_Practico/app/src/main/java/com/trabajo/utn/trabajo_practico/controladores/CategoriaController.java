package com.trabajo.utn.trabajo_practico.controladores;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.trabajo.utn.trabajo_practico.CategoriaActivity;
import com.trabajo.utn.trabajo_practico.CategoriasActivity;
import com.trabajo.utn.trabajo_practico.R;
import com.trabajo.utn.trabajo_practico.utils.Utils;
import com.trabajo.utn.trabajo_practico.vistas.CategoriaView;
import com.trabajo.utn.trabajo_practico.modelos.CategoriaModel;
import java.io.File;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.Manifest.permission_group.CAMERA;
import static android.R.attr.path;
import static android.support.v4.app.ActivityCompat.requestPermissions;
import static android.support.v4.content.ContextCompat.checkSelfPermission;
import static com.trabajo.utn.trabajo_practico.CategoriasActivity.lst;

/**
 * Created by julian.moreno on 9/22/2016.
 */
public class CategoriaController implements View.OnClickListener{
    public static final int CAMARA=0;
    public static final int CAMARA_PERMISO=0;
    private Uri uri;
    private static String MEDIA_DIRECTORY = "Categorias";
    private String mPath;
    private CategoriaActivity activity;
    private CategoriaView view;

    public CategoriaController(CategoriaActivity a){
        this.activity=a;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnFotoCategoria){
            if(checkSelfPermission(activity, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            requestPermissions(activity,new String[]{CAMERA,WRITE_EXTERNAL_STORAGE},CAMARA_PERMISO);
            }else{
                openCamera();
            }
        }
        if(v.getId()==R.id.btnCrearCategoria){
            String nombre=view.getTxtNombre().getText().toString();
            String descripcion=view.getTxtDescripcion().getText().toString();
            Drawable drawable=view.getBtnFoto().getBackground();
            if(nombre.trim().equals("")) {
                view.getTxtNombre().setError("required!");
            }
            if(descripcion.trim().equals("")) {
                view.getTxtDescripcion().setError("required!");
            }
            lst.add(new CategoriaModel(nombre,descripcion,drawable));
            Utils.getLayout(v, CategoriasActivity.class);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void setImage(){
        File f = new File(mPath);
        Drawable d = Drawable.createFromPath(f.getAbsolutePath());
        view.getBtnFoto().setBackground(d);
    }

    private void openCamera() {
        File file = new File(Environment.getExternalStorageDirectory(), MEDIA_DIRECTORY);
        boolean isDirectoryCreated = file.exists();

        if(!isDirectoryCreated)
            isDirectoryCreated = file.mkdirs();

        if(isDirectoryCreated){
            Long timestamp = System.currentTimeMillis() / 1000;
            String imageName = timestamp.toString() + ".jpg";

            mPath = Environment.getExternalStorageDirectory() + File.separator + MEDIA_DIRECTORY + File.separator + imageName;

            File newFile = new File(mPath);
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(newFile));
            activity.startActivityForResult(intent, CAMARA);
        }
    }
    public CategoriaView getView() {
        return view;
    }

    public void setView(CategoriaView view) {
        this.view = view;
    }
}
