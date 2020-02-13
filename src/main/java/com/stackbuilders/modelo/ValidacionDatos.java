package com.stackbuilders.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author fausto
 */
public class ValidacionDatos {

    public static String mensajeError = "";   
    private boolean siDatosIngresadosCorrectos;
    Vehiculo vehiculo;
    HorarioCirculacionVehiculos horarioCirculacionVehiculos;
    PredictorPicoPlaca predictorPicoPlaca;
    
    public ValidacionDatos(String placa, String fecha, String hora) {
      siDatosIngresadosCorrectos = validarPlaca(placa) && validarFecha(fecha) && validarHora(hora);
      predictorPicoPlaca = new PredictorPicoPlaca();
      if(siDatosIngresadosCorrectos){
          vehiculo=new Vehiculo(placa);
          horarioCirculacionVehiculos= new HorarioCirculacionVehiculos(fecha,hora);            
          predictorPicoPlaca.verificarPicoPlaca(vehiculo, horarioCirculacionVehiculos);
      }else{
          System.out.println(mensajeError);
      }
    }

    private boolean validarPlaca(String placa) {
        Pattern patron = Pattern.compile(Constantes.PATRON_PLACA);
        Matcher comparador = patron.matcher(placa);
        return compararPatronDato(comparador);
    }

    private boolean validarFecha(String fecha) {
        Pattern patron = Pattern.compile(Constantes.PATRON_FECHA);
        Matcher comparador = patron.matcher(fecha);
        return compararPatronDato(comparador);
    }

    private boolean validarHora(String hora) {
        Pattern patron = Pattern.compile(Constantes.PATRON_HORA);
        Matcher comparador = patron.matcher(hora);
        return compararPatronDato(comparador);
    }

    private static boolean compararPatronDato(Matcher comparador) {
        if (comparador.find()) {
            return true;
        } else {
            mensajeError = "Se encontraron errores. Revise por favor los datos ingresados \n";
            return false;
        }
    }
}
