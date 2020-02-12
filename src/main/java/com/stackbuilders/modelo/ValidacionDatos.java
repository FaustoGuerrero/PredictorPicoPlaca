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
        Pattern patron = Pattern.compile(Constantes.PATRON_PLACA);
        Matcher comparador = patron.matcher(vehiculo.getPlaca());
        return compararPatronDato(comparador);
    }
        
    public boolean validarFecha(HorarioCirculacionVehiculos horarioFecha) {        
        Pattern patron = Pattern.compile(Constantes.PATRON_FECHA);
        Matcher comparador = patron.matcher(horarioFecha.getFecha());
        return compararPatronDato(comparador);
    }

    public boolean validarHora(HorarioCirculacionVehiculos horarioHora) {        
        Pattern patron = Pattern.compile(Constantes.PATRON_HORA);
        Matcher comparador = patron.matcher(horarioHora.getHora());
        return compararPatronDato(comparador);
    }
    
    private boolean compararPatronDato(Matcher comparador){
        if (comparador.find()) {
            return true;
        } else {
            mensajeError += "Se encontraron errores. Revise por favor los datos ingresados \n";
            return false;
        }
    }
}
