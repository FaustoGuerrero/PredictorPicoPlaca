package com.stackbuilders.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author fausto
 */
public class HorarioCirculacionVehiculos {
    private String fecha;
    private String hora;
    private String diaSemana;

    public HorarioCirculacionVehiculos(String fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;       
        obtenerDiaSemana(this.fecha);
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    private void obtenerDiaSemana(String fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechaParseada = formatoFecha.parse(fecha);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaParseada);
            String diaXSemana = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("es", "ES"));
            this.setDiaSemana(diaXSemana.toUpperCase());
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha " + e.getMessage());
        }
    }
    
}
