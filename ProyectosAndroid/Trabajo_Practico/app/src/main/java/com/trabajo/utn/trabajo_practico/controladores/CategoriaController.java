package com.trabajo.utn.trabajo_practico.controladores;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import com.trabajo.utn.trabajo_practico.CategoriaActivity;
import com.trabajo.utn.trabajo_practico.CategoriasActivity;
import com.trabajo.utn.trabajo_practico.R;
import com.trabajo.utn.trabajo_practico.modelos.CategoriaModel;
import com.trabajo.utn.trabajo_practico.utils.enumerados.Metodo;
import com.trabajo.utn.trabajo_practico.utils.enumerados.URLS;
import com.trabajo.utn.trabajo_practico.utils.hilos.HiloHttp;
import com.trabajo.utn.trabajo_practico.utils.http.HttpManager;
import com.trabajo.utn.trabajo_practico.vistas.CategoriaView;
import java.io.File;

import static android.support.v4.app.ActivityCompat.requestPermissions;
import static android.support.v4.content.ContextCompat.checkSelfPermission;

/**
 * Created by julian.moreno on 9/22/2016.
 */
public class CategoriaController implements View.OnClickListener{
    public static final int CAMARA=0;
    public static final int CAMARA_PERMISO=0;

    private static String MEDIA_DIRECTORY = "Categorias";
    private String mPath="Image";
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
                requestPermissions(activity,new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE},CAMARA_PERMISO);
            }else{
                openCamera();
            }
        }
        if(v.getId()==R.id.btnCrearCategoria){
            if(validarCampos(v)){
                String nombre=view.getTxtNombre().getText().toString();
                String descripcion=view.getTxtDescripcion().getText().toString();

                Uri.Builder params=new Uri.Builder();
                params.appendQueryParameter("titulo",nombre);
                params.appendQueryParameter("descripcion", descripcion);
                params.appendQueryParameter("url_foto",mPath);
                params.appendQueryParameter("categoria_id",String.valueOf(activity.getId_categoria()));


                if(activity.getId_categoria()==0) {
                    HttpManager manager = new HttpManager(Metodo.POST, URLS.CATEGORIAS, params, activity.getApiKey());
                    Handler handler = new Handler(activity);
                    HiloHttp hilo = new HiloHttp(handler, manager);
                    hilo.start();
                }else{
                    Log.d("PUT:", "api:" + activity.getApiKey() + "ID_CATEGORIA"+activity.getId_categoria());
                    HttpManager manager = new HttpManager(Metodo.PUT, URLS.CATEGORIAS, params, activity.getApiKey());
                    Handler handler = new Handler(activity);
                    HiloHttp hilo = new HiloHttp(handler, manager);
                    hilo.start();
                }
            }
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
            Log.d("FOTO","ABRIENDO FOTO");
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(newFile));
            activity.startActivityForResult(intent, CAMARA);
        }
    }
    private boolean validarCampos(View v){
        boolean result=true;
        String nombre=view.getTxtNombre().getText().toString();
        String descripcion=view.getTxtDescripcion().getText().toString();

        if(nombre.trim().equals("")) {view.getTxtNombre().setError("required!"); result=false;}
        if(descripcion.trim().equals("")) {view.getTxtDescripcion().setError("required!"); result=false;}
        return result;
    }
    public CategoriaView getView() {
        return view;
    }
    public void setView(CategoriaView view) {
        this.view = view;
    }
}
