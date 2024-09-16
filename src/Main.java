import com.models.CompraController;
import com.models.Tarjeta;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double saldoInicial = 0;

        // Solicitar saldo hasta que sea válido
        while (saldoInicial <= 0) {
            System.out.println("Escriba el límite de la tarjeta (debe ser mayor que 0):");
            saldoInicial = teclado.nextDouble();
            teclado.nextLine();

            if (saldoInicial <= 0) {
                System.out.println("Saldo inválido. Inténtelo de nuevo.");
            }
        }

        Tarjeta tarjeta = new Tarjeta(saldoInicial); // Crear la tarjeta con un saldo válido
        CompraController controlador = new CompraController(tarjeta);

        System.out.println("Escriba la descripción de la compra:");
        String desProducto = teclado.nextLine();
        System.out.println("Ingresa el precio del producto:");
        double preProducto = teclado.nextDouble();
        teclado.nextLine();

        controlador.realizarCompra(desProducto, preProducto);

        while (true) {

            String menu = """
                    *********** Menú ***********

                    1.- Seguir comprando
                    2.- Salir
                    
                    Saldo  : """ + tarjeta.getSaldo() + """ 

                    *****************************
                    """;

            System.out.println(menu);
            int opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Escriba la descripción de la compra:");
                    desProducto = teclado.nextLine();
                    System.out.println("Ingresa el precio del producto:");
                    preProducto = teclado.nextDouble();
                    teclado.nextLine();

                    controlador.realizarCompra(desProducto, preProducto);
                    break;

                case 2:
                    System.out.println("\n************************");
                    controlador.mostrarResumen();
                    System.out.println("\n************************");
                    System.out.println("Hasta pronto");
                    teclado.close();
                    return;

                default:
                    System.out.println("Opción no válida, intente de nuevo.");
                    break;
            }
        }
    }
}


