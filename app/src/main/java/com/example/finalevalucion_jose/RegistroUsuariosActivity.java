package com.example.finalevalucion_jose;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalevalucion_jose.utilidades.Utilidades;

public class RegistroUsuariosActivity extends AppCompatActivity {

    EditText campoID,campoNombre,campoTelefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        campoID=(EditText) findViewById(R.id.campoId);
        campoNombre=(EditText) findViewById(R.id.campoNombre);
        campoTelefono=(EditText) findViewById(R.id.campoTelefono);
    }

    public void onCLick(View view){
        registrarUsuarios();
    }
    private void registrarUsuarios(){
        ConexionSQLiteHelper con=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
        SQLiteDatabase db= con.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_ID,campoID.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);
        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }
}
