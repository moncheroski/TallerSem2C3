package com.monos.tallersem2c3;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText eFecha;
    private  int dia, mes, ano;
    EditText etNombre,etTelefono,eteFecha,etEmail,etDescripcion;
    Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eFecha=(EditText)findViewById(R.id.etFecha);
        eFecha.setOnClickListener(this);

        etNombre = (EditText)findViewById(R.id.etNombre);
        etTelefono =(EditText)findViewById(R.id.etTelefono);
        eteFecha = (EditText)findViewById(R.id.etFecha);
        etEmail = (EditText)findViewById(R.id.etMail);
        etDescripcion = (EditText)findViewById(R.id.etDescripcion);
        btnEnviar = (Button)findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EnviarDatos();
            }
        });

        }

        private void EnviarDatos(){

        String nombre, telefono, fecha, mail, descrip;
            nombre= etNombre.getText().toString();
            telefono= etTelefono.getText().toString();
            fecha= eteFecha.getText().toString();
            mail= etEmail.getText().toString();
            descrip= etDescripcion.getText().toString();
            Intent intent = new Intent(MainActivity.this, DatosContacto.class);
            intent.putExtra("Nom",nombre);
            intent.putExtra("Tel",telefono);
            intent.putExtra("Fecha",fecha);
            intent.putExtra("Mail",mail);
            intent.putExtra("Desc",descrip);

            startActivity(intent);


        }




    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        if(view ==eFecha){
            final Calendar c = Calendar.getInstance();

            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            ano=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    eFecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
            ,dia,mes,ano);
            datePickerDialog.show();
        }
    }
}
