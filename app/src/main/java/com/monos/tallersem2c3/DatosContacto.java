package com.monos.tallersem2c3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DatosContacto extends AppCompatActivity {

    Button btnRegresar;
    TextView tvNombre,tvTelefono,tvFecha,tvMail,tvDescripc;
    String nombre,telefono,fecha,mail,descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_contacto);

        btnRegresar = (Button)findViewById(R.id.btnRegresar);
        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvTelefono = (TextView)findViewById(R.id.tvTelefono);
        tvFecha = (TextView)findViewById(R.id.tvFecha);
        tvMail = (TextView)findViewById(R.id.tvEmail);
        tvDescripc = (TextView)findViewById(R.id.tvDescripcion);

        Bundle bundle = this.getIntent().getExtras();

        nombre = bundle.getString("Nom");
        telefono = bundle.getString("Tel");
        fecha = bundle.getString("Fecha");
        mail = bundle.getString("Mail");
        descripcion = bundle.getString("Desc");


        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvFecha.setText(fecha);
        tvMail.setText(mail);
        tvDescripc.setText(descripcion);



        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar = new Intent(DatosContacto.this,MainActivity.class);
                onBackPressed();

                finish();
            }
        });
    }
}
