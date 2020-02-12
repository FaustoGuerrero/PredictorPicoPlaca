package com.stackbuilders.modelo;

import java.time.LocalTime;

/**
 *
 * @author fausto
 */
public class Constantes {

    static final String[] DIAS_SEMANA = {"LUNES", "MARTES", "MIÉRCOLES", "JUEVES", "VIERNES"};
    static final String[] DIGITOS = {"1-2", "3-4", "5-6", "7-8", "9-0"};
    static final LocalTime HORARIO_MATUTINO_INICIAL = LocalTime.parse("06:59");
    static final LocalTime HORARIO_MATUTINO_FINAL = LocalTime.parse("09:31");
    static final LocalTime HORARIO_VESPERTINO_INICIAL = LocalTime.parse("15:59");
    static final LocalTime HORARIO_VESPERTINO_FINAL = LocalTime.parse("19:31");
}
