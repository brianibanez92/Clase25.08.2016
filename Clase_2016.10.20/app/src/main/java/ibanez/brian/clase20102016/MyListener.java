package ibanez.brian.clase20102016;

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
import android.widget.TextView;

import java.io.File;

/**
 * Created by brian.ibanez on 20/10/2016.
 */
public class MyListener implements View.OnClickListener {

    private MainActivity ma;
    private static ImageView iv;
    private static Uri uri;
    public static final int CAMARA = 0;
    public static final int CAMARA_PERSMISO = 0;

    public MyListener(MainActivity ma)
    {
        this.ma = ma;
        this.iv = (ImageView) ma.findViewById(R.id.IvImagen);
    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        File imagesFOlder = new File(Environment.getExternalStorageDirectory(), "Categories");
        imagesFOlder.mkdirs();

        File file = new File(imagesFOlder, "foto.jpg");
        uri = Uri.fromFile(file);
        i.putExtra(MediaStore.EXTRA_OUTPUT, uri);

        if(ContextCompat.checkSelfPermission(this.ma, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this.ma, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            TextView textView = (TextView) ma.findViewById(R.id.tvHello);
            textView.setText("Hola campeon!!!!");

            ActivityCompat.requestPermissions(this.ma, new String[]{Manifest.permission.CAMERA ,Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMARA_PERSMISO);
        }
        else
        {
            this.ma.startActivityForResult(i, CAMARA);

        }
    }

    public static void setImage()
    {
        iv.setImageURI(uri);
    }

}
