package com.example.fittnes_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar)findViewById(R.id.pb);
        btn = (Button)findViewById(R.id.btn);
        pb.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            new Task().execute();
            }
        });

        }


    class Task extends AsyncTask<String,Void,String>
    {

        @Override
        protected void onPreExecute() {
            pb.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {


            for(int i = 1; i<= 10; i++)
            {
                try {
                    Thread.sleep(1000);
                }
                catch (Exception e)
                {

                    e.printStackTrace();
                }
            }
            return null;
        }


        @Override
        protected void onPostExecute(String s) {
           Intent i = new Intent(getBaseContext(), Menu_act.class);
            startActivity(i);
        }
    }













}