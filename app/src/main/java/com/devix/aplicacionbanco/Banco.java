package com.devix.aplicacionbanco;
/*
 *Created by Carlos Anguiano on 19/03/17.
 *For more info contact : c.joseanguiano@gmail.com
 */

import android.content.Context;
import android.widget.Toast;

public class Banco {
    private String nombre;
    private int cantidad;
    Context context;

    public Banco(String nombre, int cantidad) {
//        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Banco() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public void cantidadDepositar(int d) {
        if (d > 0) {
            this.cantidad += d;
//            Toast.makeText(context, "DEPOSITAR - El saldo de la cuenta es : ", Toast.LENGTH_SHORT).show();
        } else {

//            Toast.makeText(context, "No realizaste ningun valor : ", Toast.LENGTH_SHORT).show();
            return;
        }
    }


    public void cantidadRetirar(double d) {
        if (d <= 0) {
//            Toast.makeText(context, "No existe pesos negativos: ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (this.cantidad < d) {
//            Toast.makeText(context, "La cantidad a retirar es mayor que el saldo disponible... no se hizo nada", Toast.LENGTH_SHORT).show();
            return;
        }
        this.cantidad -= d;
//        Toast.makeText(context, "El saldo de la cuenta es ", Toast.LENGTH_SHORT).show();
    }
}
