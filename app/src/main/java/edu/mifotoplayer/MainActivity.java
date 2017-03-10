package edu.mifotoplayer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    @Override
    public void onStart() {

        Log.d("MENSAJE","Entro onStart");
        super.onStart();
     
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MENSAJE","Entro onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("FotoActual",fotoActual);

    }

    private int []arrayPics={R.drawable.ic_tony_el_oso,R.drawable.ic_pepe_el_gato,R.drawable.ic_tony_el_panda};

    private static int fotoActual = 0;
    private static int longitudarray = 0;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);


        if (bundle == null)
        {
            Log.d("MENSAJE", "BUNDLE VACIO");
        }else
        {
            Log.d("MENSAJE", "BUNDLE CON COSAS");
            fotoActual = bundle.getInt("FotoActual");
        }

        View v = findViewById(R.id.no);
        Button boton = (Button) v;

        View v2 = findViewById(R.id.si);
        Button boton2 = (Button) v2;


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensajenegativo = getResources().getString(R.string.mensajenotoas);
                Toast toast = Toast.makeText(MainActivity.this, mensajenegativo, Toast.LENGTH_SHORT);

                ImageView imagen1 = (ImageView) findViewById(R.id.imageView);
                longitudarray = arrayPics.length ;

                imagen1.setImageResource(arrayPics [fotoActual]);

                fotoActual++;

                SharedPreferences sp =getSharedPreferences("Votaciones", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putBoolean("Votos"+fotoActual,false);
                String mensajefuera = String.valueOf(sp.getBoolean("Votos"+fotoActual,false));
                Log.d("MIMENSAJE", mensajefuera);
                ed.commit();

                if (longitudarray == fotoActual)
                {
                    //fotoActual = 0;
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }

                toast.show();

                Log.d("MIMENSAJE","BOTON NO");
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {

                String mensajeSi = getResources().getString(R.string.mensajesitoas);
                Toast toast = Toast.makeText(MainActivity.this, mensajeSi, Toast.LENGTH_SHORT);

                ImageView imagen1 = (ImageView) findViewById(R.id.imageView);
                longitudarray = arrayPics.length ;

                imagen1.setImageResource(arrayPics [fotoActual]);

                fotoActual++;

                SharedPreferences sp =getSharedPreferences("Votaciones", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putBoolean("Votos"+fotoActual,true);
                String mensajefuera = String.valueOf(sp.getBoolean("Votos"+fotoActual,true));
                Log.d("MIMENSAJE", mensajefuera);
                ed.commit();

                if (longitudarray == fotoActual)
                {
                    //fotoActual = 0;
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }

                toast.show();

                Log.d("MIMENSAJE","BOTON SI");


            }
        });


    }
}