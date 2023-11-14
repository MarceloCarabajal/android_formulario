package com.marce.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GuardarActivity extends AppCompatActivity {

    EditText etNom, etDat;
    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar);

        etNom = findViewById(R.id.etNombres);
        etDat = findViewById(R.id.etDatos);
        btnRegresar = findViewById(R.id.btnVolver);

        String datosMostrar = "Correo: " + getIntent().getStringExtra("correo") + "\nDirección: " + getIntent().getStringExtra("direccion") +
                "\nSexo: " + getIntent().getStringExtra("sexo") + "\nOcupación: " + getIntent().getStringExtra("ocupacion");

        String nombresYape = getIntent().getStringExtra("nombres");

        etNom.setText(nombresYape);
        etDat.setText(datosMostrar);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              volver();
            }
        });

    }

    public void volver(){
        finish();
    }
}