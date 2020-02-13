package com.stackbuilders.vista;

import com.stackbuilders.modelo.ValidacionDatos;
import java.util.Scanner;

/**
 *
 * @author fausto
 */
public class Presentacion {
    
    public static void presentarMenu() {
        System.out.println("\t*** MENU ***" + "\n");
        System.out.println("Ingrese el numero de placa del vehiculo. Ejemplo: ABC-1234 ");
        Scanner scanner = new Scanner(System.in);
        String placa = scanner.nextLine();
        System.out.println("Ingrese la fecha en formato \"dd/MM/yyyy\". Ejemplo: 10/01/2020 ");
        String fecha = scanner.nextLine();
        System.out.println("Ingrese la hora en formato \"HH:mm\" (24 horas). Ejemplo: 23:59");
        String hora = scanner.nextLine();        
        ValidacionDatos validacionDatos = new ValidacionDatos(placa, fecha, hora);   
    }
}
