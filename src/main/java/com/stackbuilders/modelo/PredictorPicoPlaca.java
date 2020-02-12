package com.stackbuilders.modelo;

import java.time.LocalTime;

/**
 *
 * @author fausto
 */
public class PredictorPicoPlaca {

    String mensajeError = "";
    Vehiculo vehiculo;
    HorarioCirculacionVehiculos horario;
    ValidacionDatos validacionDatos;

    public PredictorPicoPlaca() {
        if (validacionDatos.validarPlaca(vehiculo) && validacionDatos.validarFecha(horario) && validacionDatos.validarHora(horario)) {
            verificarPicoPlaca(vehiculo, horario);
        } else {
            System.out.println(mensajeError);
        }
    }

    private void verificarPicoPlaca(Vehiculo vehiculo, HorarioCirculacionVehiculos horarioCirculacionVehiculos) {
        LocalTime horaTransitaVehiculo = LocalTime.parse(horarioCirculacionVehiculos.getHora());
        char ultimoDigitoPlaca = vehiculo.getPlaca().charAt(7);
        String diaSemana = horarioCirculacionVehiculos.getDiaSemana();
        String digitosProhibidos = "";

        if ("SÁBADO".equals(diaSemana) || "DOMINGO".equals(diaSemana)) {
            System.out.println("NO EXISTEN RESTRICCIONES LOS FINES DE SEMANA");
        } else {
            for (int i = 0; i < Constantes.DIAS_SEMANA.length; i++) {
                if (Constantes.DIAS_SEMANA[i].equals(diaSemana)) {
                    digitosProhibidos = Constantes.DIGITOS[i];
                    break;
                }
            }
            System.out.println("Digitos prohibidos en este dia " + horarioCirculacionVehiculos.getDiaSemana().toLowerCase() + " son: " + digitosProhibidos);
            if (digitosProhibidos.contains(Character.toString(ultimoDigitoPlaca))
                    && horaTransitaVehiculo.isAfter(Constantes.HORARIO_MATUTINO_INICIAL) && horaTransitaVehiculo.isBefore(Constantes.HORARIO_MATUTINO_FINAL)
                    || horaTransitaVehiculo.isAfter(Constantes.HORARIO_VESPERTINO_INICIAL) && horaTransitaVehiculo.isBefore(Constantes.HORARIO_VESPERTINO_FINAL)) {
                System.out.println("PROHIBIDO circular en este horario. Ud tiene Pico y Placa");
            } else {
                System.out.println("Siga circulando con seguridad");
            }
        }
    }

}
