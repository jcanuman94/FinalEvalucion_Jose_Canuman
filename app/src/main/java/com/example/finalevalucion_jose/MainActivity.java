package com.example.finalevalucion_jose;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)
        ConexionSQLiteHelper con=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
    }
    public void onClick(View view){
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.BtnRegistro:
                miIntent=new Intent(MainActivity.this,RegistroUsuariosActivity.class);
                break;
            case R.id.BtnConsulta:
                miIntent=new Intent(MainActivity.this,ConsultaUsuarioActivity.class);
                break;
            case R.id.BtnListar:
                miIntent=new Intent(MainActivity.this,ListaUsuariosActivity.class);
            case R.id.BtnSensor:
                miIntent=new Intent(MainActivity.this,SensorLuzActivity.class);
        }
        if(miIntent!=null){
            startActivity(miIntent);
        }
    }
}
