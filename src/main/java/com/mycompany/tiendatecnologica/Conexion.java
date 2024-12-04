/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendatecnologica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Datos de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/TiendaTecnologica?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root"; // Cambia este valor por el nombre de usuario de tu base de datos
    private static final String PASSWORD = ""; // Cambia este valor por la contraseña de tu base de datos

    // Método para obtener la conexión a la base de datos
    public static Connection getConnection() {
        Connection connection = null;

        try {
            // Registrar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos TiendaTecnologica.");

        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se pudo cargar el driver de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error: No se pudo conectar a la base de datos TiendaTecnologica.");
            e.printStackTrace();
        }

        return connection;
    }

    // Método para cerrar la conexión (opcional, recomendado)
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada exitosamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión a la base de datos.");
            e.printStackTrace();
        }
    }
}


