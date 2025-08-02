/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Vuelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VueloDAO {

    // Cambia estos datos según tu configuración
    private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Reservas;encrypt=false;";
    private final String USER = "CristianRA";
    private final String PASS = "123456";

    public VueloDAO() {
        try {
            // Carga el driver de SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el driver JDBC.");
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // Listar orígenes únicos
    public List<String> listarOrigenes() {
        List<String> origenes = new ArrayList<>();
        String sql = "SELECT DISTINCT Origen FROM Vuelos ORDER BY Origen";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                origenes.add(rs.getString("Origen"));
            }

        } catch (SQLException e) {
            System.err.println("Error al listar orígenes.");
            e.printStackTrace();
        }
        return origenes;
    }

    // Listar destinos únicos
    public List<String> listarDestinos() {
        List<String> destinos = new ArrayList<>();
        String sql = "SELECT DISTINCT Destino FROM Vuelos ORDER BY Destino";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                destinos.add(rs.getString("Destino"));
            }

        } catch (SQLException e) {
            System.err.println("Error al listar destinos.");
            e.printStackTrace();
        }
        return destinos;
    }

    // Buscar vuelos por origen, destino y fecha (fecha opcional)
    public List<Vuelo> buscarVuelos(String origen, String destino, String fecha) {
        List<Vuelo> vuelos = new ArrayList<>();
        String sql = "SELECT * FROM Vuelos WHERE Origen = ? AND Destino = ?";

        if (fecha != null && !fecha.isEmpty()) {
            sql += " AND CONVERT(varchar, Fecha, 23) = ?"; // yyyy-MM-dd
        }

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, origen);
            ps.setString(2, destino);

            if (fecha != null && !fecha.isEmpty()) {
                ps.setString(3, fecha);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Vuelo vuelo = new Vuelo();
                    vuelo.setId(rs.getInt("Id"));
                    vuelo.setOrigen(rs.getString("Origen"));
                    vuelo.setDestino(rs.getString("Destino"));
                    vuelo.setAerolinea(rs.getString("Aerolinea"));
                    vuelo.setFecha(rs.getDate("Fecha"));
                    vuelo.setHora(rs.getTime("Hora"));
                    vuelo.setEspaciosDisponibles(rs.getInt("EspaciosDisponibles"));
                    vuelo.setPrecio(rs.getDouble("Precio"));

                    vuelos.add(vuelo);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar vuelos.");
            e.printStackTrace();
        }

        return vuelos;
    }
public List<Vuelo> listarTodosVuelos() {
    List<Vuelo> lista = new ArrayList<>();
    String sql = "SELECT * FROM Vuelos"; 
    try (Connection con = getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            Vuelo v = new Vuelo(
                rs.getInt("Id"),
                rs.getString("Origen"),
                rs.getString("Destino"),
                rs.getString("Aerolinea"),
                rs.getDate("Fecha"),
                rs.getTime("Hora"),
                rs.getInt("EspaciosDisponibles"),  // <--- este estaba mal
                rs.getDouble("Precio")
            );
            lista.add(v);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
}
}