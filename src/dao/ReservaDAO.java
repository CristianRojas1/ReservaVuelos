/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Reserva;
import java.sql.*;
import java.util.ArrayList;

public class ReservaDAO {

    private Connection conn;

    public ReservaDAO() {
        try {
            conn = ConexionBD.getConexion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean insertarReserva(Reserva reserva) {
        String sql = "INSERT INTO Reservas (UsuarioId, VueloId, CantidadAsientos, FechaReserva) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, reserva.getIdUsuario());
            ps.setInt(2, reserva.getIdVuelo());
            ps.setInt(3, reserva.getCantidadAsientos());
            if (reserva.getFechaReserva() != null) {
                ps.setTimestamp(4, reserva.getFechaReserva());
            } else {
                ps.setTimestamp(4, new Timestamp(System.currentTimeMillis())); // fecha actual si no se pasa
            }
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}