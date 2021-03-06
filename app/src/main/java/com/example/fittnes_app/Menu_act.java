package com.example.fittnes_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Menu_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int [] images ={R.drawable.a,R.drawable.b,R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        vf=(ViewFlipper)findViewById(R.id.slider);

        for (int i = 0; i< images.length; i++)
        {
            FLip_image(images[i]);


        }


    }

    public void FLip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);//
        vf.addView(view);          //añadimos las imagenes al fliper
        vf.setFlipInterval(2300);// cuanto dura el desplazamiento
        vf.setAutoStart(true);   // inicia de forma automatica

        //sentido del flippe
        vf.setInAnimation(this,android.R.anim.slide_in_left);
        vf.setOutAnimation(this,android.R.anim.slide_out_right);

    }


            public void Maps(View v)
            {

                Intent i = new Intent(this,Maps_act.class);
                startActivity(i);

            }
        public void Info(View v)
        {

            Intent i = new Intent(this,info_act.class);
            startActivity(i);

        }

    public void Base(View v)
    {
        Intent i = new Intent(this, Insumos_act.class);
        startActivity(i);
    }

    public void Clientes(View v)
    {

        ArrayList<String> clientes = new ArrayList<String>();
        ArrayList<String> planes = new ArrayList<String>();

        clientes.add("roberto");
        clientes.add("ivan");

        planes.add("premiun");
        planes.add("normal");


        Intent i = new Intent(this,Clientes_act.class);
        i.putExtra("listaClientes",clientes);
        i.putExtra("listaPlanes",planes);
        startActivity(i);

    }





}