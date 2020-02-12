package com.stackbuilders.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author fausto
 */
public class ValidacionDatos {
    public static String mensajeError= "";    
    
    public boolean validarPlaca(Vehiculo vehiculo) {
        String patronPlaca = "^[A-Z]{4}-[0-9]{3}";
        Pattern patron = Pattern.compile(patronPlaca);
        Matcher comparador = patron.matcher(vehiculo.getPlaca());
        if (comparador.find()) {
            return true;
        } else {
            mensajeError += "Placa incorrecta \n";
            return false;
        }
    }
    
    public boolean validarFecha(HorarioCirculacionVehiculos horarioFecha) {
        String patronFecha = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
        Pattern patron = Pattern.compile(patronFecha);
        Matcher comparador = patron.matcher(horarioFecha.getFecha());
        if (comparador.find()) {
            return true;
        } else {
            mensajeError += "Fecha o formato incorrecto. \n";
            return false;
        }
    }

    public boolean validarHora(HorarioCirculacionVehiculos horarioHora) {
        String patronFecha = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern patron = Pattern.compile(patronFecha);
        Matcher comparador = patron.matcher(horarioHora.getHora());
        if (comparador.find()) {
            return true;
        } else {
            mensajeError += "Hora/minutos o formato incorrecto.\n";
            return false;
        }
    }
    
}
