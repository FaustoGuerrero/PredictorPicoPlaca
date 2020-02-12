package com.stackbuilders.vista;

import com.stackbuilders.modelo.HorarioCirculacionVehiculos;
import com.stackbuilders.modelo.Vehiculo;
import java.util.Scanner;

/**
 *
 * @author fausto
 */
public class PantallaPrincipal {
    public static void presentarMenu() {
        System.out.println("\t*** MENU ***" + "\n");
        System.out.println("Ingrese el numero de placa del vehiculo. Ejemplo: ABCD-123 ");
        Scanner scanner = new Scanner(System.in);
        String placa = scanner.nextLine();
        System.out.println("Ingrese la fecha en formato \"dd/MM/yyyy\". Ejemplo: 10/01/2020 ");
        String fecha = scanner.nextLine();
        System.out.println("Ingrese la hora en formato \"HH:mm\" (24 horas). Ejemplo: 23:59");
        String hora = scanner.nextLine();
        Vehiculo vehiculo = new Vehiculo(placa);
        HorarioCirculacionVehiculos horario = new HorarioCirculacionVehiculos(fecha, hora);
        //ValidadorPlaca validadorPlaca = new ValidadorPlaca(placa);
                
    }
}
