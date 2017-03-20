package com.devix.aplicacionbanco;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtNombre;
    private EditText edtCantidad;
    private Button btnDepositar;
    private Button btnRetirar;
    private TextView txtResultNombre;
    private TextView txtResultCantidad;
    //    cont = getApplicationContext();
    String myCantidad;
    String myCantidadRetirar;
    String myNombre;
    String miniNombre;
    int miniCantidad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtCantidad = (EditText) findViewById(R.id.edtCantidad);
        btnDepositar = (Button) findViewById(R.id.btnDeposito);
        btnRetirar = (Button) findViewById(R.id.btnRetirar);
        txtResultNombre = (TextView) findViewById(R.id.resultNombre);
        txtResultCantidad = (TextView) findViewById(R.id.resultCantidad);

        final Banco myBanco = new Banco();
//        btnRetirar.setVisibility(View.GONE);


        btnDepositar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myCantidad = edtCantidad.getText().toString();
                myBanco.setCantidad(Integer.parseInt(myCantidad));
                myNombre = edtNombre.getText().toString();
                myBanco.setNombre(myNombre);


                miniNombre = myBanco.getNombre();
                miniCantidad = myBanco.getCantidad();


                int dineroCantidad = Integer.parseInt(String.valueOf(myCantidad));
                myBanco.cantidadDepositar(dineroCantidad);
                txtResultCantidad.setText(String.valueOf(dineroCantidad));
                txtResultNombre.setText(miniNombre);

            }
        });

        btnRetirar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCantidadRetirar = edtCantidad.getText().toString();
                myBanco.cantidadRetirar(Integer.parseInt(myCantidadRetirar));


//                miniNombre = myBanco.getNombre();


//            miniCantidad = myBanco.getCantidad();
//                int cantidadActual = myBanco.getCantidad();
//                txtResultCantidad.setText((String.valueOf(cantidadActual)));

                Toast.makeText(MainActivity.this, "DEPOSITAR - El saldo que retiro es : " + myCantidadRetirar, Toast.LENGTH_SHORT).show();
                txtResultCantidad.setText(myCantidadRetirar);

            }
        });
    }
}
