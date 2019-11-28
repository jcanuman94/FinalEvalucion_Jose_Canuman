package com.example.finalevalucion_jose;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalevalucion_jose.utilidades.Utilidades;

public class ConsultaUsuarioActivity extends AppCompatActivity {
    EditText campoId,campoNombre,campoTelefono;

    ConexionSQLiteHelper con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_usuario);

        con=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);

        campoId=(EditText) findViewById(R.id.BusquedaId);
        campoNombre=(EditText)findViewById(R.id.campoNombreConsulta);
        campoTelefono=(EditText)findViewById(R.id.campoTelefonoConsulta);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.BtnBuscar:
                consultar();
                break;
            case R.id.BtnActualizar:
                actualizar();
                break;
            case R.id.BtnEliminar:
                eliminar();
                break;
        }
    }

    private void consultar(){
        SQLiteDatabase db=con.getReadableDatabase();
        String[] parametros={campoId.getText().toString()};
        String[] campos={Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_TELEFONO};

        try{
            Cursor cursor = db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_ID+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            campoNombre.setText(cursor.getString(0));
            campoTelefono.setText(cursor.getString(1));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El id no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }
    }

    private void limpiar(){
        campoNombre.setText("");
        campoTelefono.setText("");
    }

    private void actualizar(){
        SQLiteDatabase db=con.getWritableDatabase();
        String[] parametros={campoId.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());
        db.update(Utilidades.TABLA_USUARIO,values,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se actualizo el usuario",Toast.LENGTH_LONG).show();
        db.close();
    }

    private void eliminar(){
        SQLiteDatabase db=con.getWritableDatabase();
        String[] parametros={campoId.getText().toString()};
        db.delete(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se elimino el usuario",Toast.LENGTH_LONG).show();
        campoId.setText("");
        limpiar();
        db.close();
    }
}
