package com.models;

import java.util.ArrayList;
import java.util.Collections;

public class CompraController {
    private Tarjeta tarjeta;
    private ArrayList<Producto> productos;
    private double sumaProductos;
    private int contadorCompras;

    public CompraController(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
        this.productos = new ArrayList<>();
        this.sumaProductos = 0;
        this.contadorCompras = 0;
    }

    public void realizarCompra(String nombre, double precio) {
        if (precio <= tarjeta.getSaldo()) {
            tarjeta.comprar(precio);
            productos.add(new Producto(nombre, precio));
            sumaProductos += precio;
            contadorCompras++;
        } else {
            System.out.println("Saldo insuficiente, producto no comprado");
        }
    }

    public void mostrarResumen() {
        System.out.println("Compras Realizadas :" + contadorCompras);
        System.out.println("Productos ordenados de forma ascendente");
        Collections.sort(productos);
        for (Producto producto : productos) {
            System.out.println(producto);
        }
        System.out.println("Suma total productos comprados : " + sumaProductos);
        System.out.println("Saldo restante : " + tarjeta.getSaldo());
    }

    public double getSaldo() {
        return tarjeta.getSaldo();
    }
}
