package com.marce.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    EditText etNomApe, etEmail,etDir;
    Spinner spOcup;
    RadioGroup rgGenero;
    RadioButton rbMasc, rbFem;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNomApe = findViewById(R.id.etNombreApellido);
        etEmail = findViewById(R.id.etCorreo);
        etDir = findViewById(R.id.etDireccion);
        spOcup = findViewById(R.id.spOcupacion);
        rgGenero = findViewById(R.id.rgSexo);
        rbMasc = findViewById(R.id.rbMasculino);
        rbFem = findViewById(R.id.rbFemenino);
        btnSalvar = findViewById(R.id.btnGuardar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });

    }

    public void validar(){
        if(etNomApe.getText().toString().equals("") || etEmail.getText().toString().equals("")){
            Toast.makeText(MainActivity.this,"Ingrese nombre y correo", Toast.LENGTH_SHORT).show();
        }
        else {
            registrar();
            limpiar();
        }
    }

    public void registrar(){
        Toast.makeText(MainActivity.this,"Todo ok", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, GuardarActivity.class);
        intent.putExtra("nombres", etNomApe.getText().toString());
        intent.putExtra("correo", etEmail.getText().toString());
        intent.putExtra("ocupacion", spOcup.getSelectedItem().toString());
        intent.putExtra("direccion", etDir.getText().toString());
        String sexo = "";
        if(rbMasc.isChecked()){
            sexo = "Masculino";
        }
        else{
            sexo = "Femenino";
        }
        intent.putExtra("sexo", sexo);
        startActivity(intent);
    }

    public void limpiar(){
        etNomApe.setText("");
        etEmail.setText("");
        etDir.setText("");
        spOcup.setSelection(0);
        rgGenero.clearCheck();
        etNomApe.requestFocus();
    }


}