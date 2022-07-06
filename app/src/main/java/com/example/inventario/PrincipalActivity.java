package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnReg , btnBu, btnLi,btnEl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnReg = (Button)findViewById(R.id.btnReg);
        btnBu = (Button)findViewById(R.id.btnBu);
        btnLi = (Button)findViewById(R.id.btnLi);
        btnEl = (Button)findViewById(R.id.btnEl);

        btnReg.setOnClickListener(this);
        btnBu.setOnClickListener(this);
        btnLi.setOnClickListener(this);
        btnEl.setOnClickListener(this);

        SQLUtilities conexion = new SQLUtilities(this, "Material", null,1);
    }

    //Metodo para mostrar y ocultar el menu
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    //Metodo para asignar las funciones correspondientes a las opciones
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.opRegistrar){
            Intent intent = new Intent( PrincipalActivity.this, RegistrarMateriales.class);
            startActivity(intent);

        }else if ( id == R.id.opMostrar ){
            Intent intent = new Intent( PrincipalActivity.this, MostrarMateriales.class);
            startActivity(intent);

        }else if(id == R.id.opListar){
            Intent intent = new Intent( PrincipalActivity.this, ListarMateriales.class);
            startActivity(intent);
        }
        else if(id == R.id.opEliminar){
        Intent intent = new Intent( PrincipalActivity.this, EliminarMateriales.class);
        startActivity(intent);
        }

        else{
            finish();
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnReg:
                Intent in = new Intent( PrincipalActivity.this, RegistrarMateriales.class);
                startActivity(in);
                break;
            case R.id.btnBu:
                Intent in2 = new Intent( PrincipalActivity.this, MostrarMateriales.class);
                startActivity(in2);
                break;
            case R.id.btnLi:
                Intent in3 = new Intent( PrincipalActivity.this, ListarMateriales.class);
                startActivity(in3);
                break;
            case R.id.btnEl:
                Intent in4 = new Intent( PrincipalActivity.this, EliminarMateriales.class);
                startActivity(in4);
                break;
        }

    }
}
