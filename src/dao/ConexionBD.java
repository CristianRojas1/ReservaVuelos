/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=Reservas;encrypt=false;trustServerCertificate=true;";
    private static final String USUARIO = "CristianRA";
    private static final String CONTRASEÑA = "123456";

    /**
     * Establece y devuelve una conexión a la base de datos SQL Server.
     * 
     * @return Objeto Connection si la conexión es exitosa.
     * @throws SQLException si ocurre un error al conectarse.
     */
    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
    }
}