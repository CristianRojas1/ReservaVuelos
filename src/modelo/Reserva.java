/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Timestamp;

public class Reserva {
    private int idReserva;
    private int idUsuario;
    private int idVuelo;
    private int cantidadAsientos;
    private Timestamp fechaReserva;

    public Reserva(int idReserva, int idUsuario, int idVuelo, int cantidadAsientos, Timestamp fechaReserva) {
        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
        this.idVuelo = idVuelo;
        this.cantidadAsientos = cantidadAsientos;
        this.fechaReserva = fechaReserva;
    }

    public Reserva(int idUsuario, int idVuelo, int cantidadAsientos, Timestamp fechaReserva) {
        this(0, idUsuario, idVuelo, cantidadAsientos, fechaReserva);
    }

    // Getters y setters

    public int getIdReserva() { return idReserva; }
    public void setIdReserva(int idReserva) { this.idReserva = idReserva; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getIdVuelo() { return idVuelo; }
    public void setIdVuelo(int idVuelo) { this.idVuelo = idVuelo; }

    public int getCantidadAsientos() { return cantidadAsientos; }
    public void setCantidadAsientos(int cantidadAsientos) { this.cantidadAsientos = cantidadAsientos; }

    public Timestamp getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(Timestamp fechaReserva) { this.fechaReserva = fechaReserva; }
}