/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Itinerario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItinerarioDAO {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:sqlserver://localhost:1433;databaseName=Reservas;encrypt=false;trustServerCertificate=true",
            "CristianRA",
            "123456"
        );
    }

    // AGREGAR
    public boolean agregarItinerario(Itinerario itin) {
    String sql = "INSERT INTO Itinerarios (Origen, Destino, Fecha, Hora) VALUES (?, ?, ?, ?)";

    try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, itin.getOrigen());
        ps.setString(2, itin.getDestino());
        ps.setDate(3, itin.getFecha()); // tipo java.sql.Date
        ps.setTime(4, itin.getHora());  // tipo java.sql.Time

        int filas = ps.executeUpdate();
        return filas > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    // LISTAR
    public List<Itinerario> listar() {
        List<Itinerario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Itinerarios";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Itinerario itin = new Itinerario();
                itin.setId(rs.getInt("Id"));
                itin.setOrigen(rs.getString("Origen"));
                itin.setDestino(rs.getString("Destino"));
                itin.setFecha(rs.getDate("Fecha"));
                itin.setHora(rs.getTime("Hora"));
                lista.add(itin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // MODIFICAR
    public boolean modificar(Itinerario itin) {
        String sql = "UPDATE Itinerarios SET Origen = ?, Destino = ?, Fecha = ?, Hora = ? WHERE Id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, itin.getOrigen());
            ps.setString(2, itin.getDestino());
            ps.setDate(3, itin.getFecha());
            ps.setTime(4, itin.getHora());
            ps.setInt(5, itin.getId());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ELIMINAR
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Itinerarios WHERE Id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}