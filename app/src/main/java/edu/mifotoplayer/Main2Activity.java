package edu.mifotoplayer;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView= (TextView)findViewById(R.id.textolikes);
        Boolean primerafoto = true;
        String mensaje = textView.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("Votaciones", Context.MODE_PRIVATE);

        for (int i = 1;i<=3;i++){

            if(sharedPreferences.getBoolean("Votos"+i,false))
            {
                if(primerafoto)
                {
                    mensaje = "Los likes han ido para la foto nº: "+i;
                }
                else
                {
                    mensaje = mensaje + ", la foto nº" + i;
                }

                primerafoto = false;
            }
        }

        if(primerafoto)
        {
            mensaje = "Muy mal";
        }

        textView.setText(mensaje);
    }

}
