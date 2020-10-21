package com.example.fittnes_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import Clases.Planes;

public class Clientes_act extends AppCompatActivity {

    private Spinner spin1,spin2;
    private TextView text;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        spin1 = (Spinner)findViewById(R.id.spin_clientes);
        spin2 = (Spinner)findViewById(R.id.spiner_planes);
        text = (TextView) findViewById(R.id.tv);
        edit = (EditText) findViewById(R.id.et1);

        ArrayList<String> listaClientes = (ArrayList<String>)getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaplanes = (ArrayList<String>)getIntent().getSerializableExtra("listaPlanes");


        ArrayAdapter<String> adap = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaClientes);
        ArrayAdapter<String> adaps = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaplanes);

        spin1.setAdapter(adap);
        spin2.setAdapter(adaps);
    }

    public void Calcular(View v)
    {
        String cliente = spin1.getSelectedItem().toString();
        String planes = spin2.getSelectedItem().toString();

        Planes plan = new Planes();  // Construir mi objeto.

        int saldo = Integer.parseInt(edit.getText().toString());

        int resultPremiun = saldo - plan.getPremiun();
        int resultNormal = saldo - plan.getNormal();



        if(cliente.equals("roberto") && planes.equals("normal"))
        {
            text.setText("El precio del plan es: " + resultNormal);

        }
        if(cliente.equals("roberto") && planes.equals("premiun"))
        {
            text.setText("El precio del plan es: " + resultPremiun);
        }

        if(cliente.equals("ivan") && planes.equals("normal"))
        {
            text.setText("El precio del plan es: " + resultNormal);

        }
        if(cliente.equals("ivan") && planes.equals("premiun"))
        {
            text.setText("El precio del plan es: " + resultPremiun);
        }


    }






}