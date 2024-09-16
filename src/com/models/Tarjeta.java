package com.models;

public class Tarjeta {

    private double saldo;

    public Tarjeta(double saldo) {
        this.saldo = saldo;
    }


    public void comprar(double preProducto){

            saldo -= preProducto;
            System.out.println("Producto comprado");

    }

    public double getSaldo() {
        return saldo;
    }
}
