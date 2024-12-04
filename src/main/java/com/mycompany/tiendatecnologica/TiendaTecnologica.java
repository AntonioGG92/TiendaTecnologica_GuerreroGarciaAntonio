package com.mycompany.tiendatecnologica;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class TiendaTecnologica {

    private static final String RUTA_JSON = "src/main/resources/data.json";

    public static void main(String[] args) {
        // Leer datos del archivo JSON y mostrar información
        JsonObject jsonObject = leerDatosDesdeJSON();
        if (jsonObject != null) {
            System.out.println("Archivo JSON leído exitosamente.");
            mostrarDatos(jsonObject);
            insertarDatosEnBaseDeDatos(jsonObject);
        }

        // Llamar a la clase TiendaPrincipal para iniciar la interfaz gráfica
        java.awt.EventQueue.invokeLater(() -> new TiendaPrincipal().setVisible(true));
    }

    /**
     * Método para leer datos del archivo JSON.
     */
    public static JsonObject leerDatosDesdeJSON() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(RUTA_JSON)) {
            return gson.fromJson(reader, JsonObject.class);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
            return null;
        }
    }

    /**
     * Método para mostrar los datos del archivo JSON en la consola.
     */
    public static void mostrarDatos(JsonObject jsonObject) {
        if (jsonObject == null) {
            System.out.println("No hay datos para mostrar.");
            return;
        }

        JsonArray categorias = jsonObject.getAsJsonObject("tienda").getAsJsonArray("categorias");
        for (int i = 0; i < categorias.size(); i++) {
            JsonObject categoria = categorias.get(i).getAsJsonObject();
            System.out.println("Categoría: " + categoria.get("nombre").getAsString());

            JsonArray productos = categoria.getAsJsonArray("productos");
            for (int j = 0; j < productos.size(); j++) {
                JsonObject producto = productos.get(j).getAsJsonObject();
                System.out.println(" - Producto: " + producto.get("nombre").getAsString());
                System.out.println("   Precio: " + producto.get("precio").getAsDouble());
                System.out.println("   Descripción: " + producto.get("descripcion").getAsString());
            }
        }
    }

  
    public static void insertarDatosEnBaseDeDatos(JsonObject jsonObject) {
        String url = "jdbc:mysql://localhost:3306/TiendaTecnologica";
        String user = "root";
        String password = "";

        // Map para almacenar el nombre del producto y su id generado
        Map<Integer, Integer> productIdMap = new HashMap<>();
        Map<Integer, Integer> userIdMap = new HashMap<>(); // Para mapear ids originales de usuarios

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión a la base de datos establecida.");

            // Insertar categorías y productos
            JsonArray categorias = jsonObject.getAsJsonObject("tienda").getAsJsonArray("categorias");
            for (int i = 0; i < categorias.size(); i++) {
                JsonObject categoria = categorias.get(i).getAsJsonObject();
                String nombreCategoria = categoria.get("nombre").getAsString();

                // Insertar categoría
                String insertCategoriaSQL = "INSERT IGNORE INTO categorias (nombre) VALUES (?)";
                try (PreparedStatement categoriaStmt = connection.prepareStatement(insertCategoriaSQL, Statement.RETURN_GENERATED_KEYS)) {
                    categoriaStmt.setString(1, nombreCategoria);
                    categoriaStmt.executeUpdate();
                }

                // Obtener productos de la categoría
                JsonArray productos = categoria.getAsJsonArray("productos");
                for (int j = 0; j < productos.size(); j++) {
                    JsonObject producto = productos.get(j).getAsJsonObject();
                    int productoIdOriginal = producto.get("id").getAsInt();
                    String nombreProducto = producto.get("nombre").getAsString();
                    double precio = producto.get("precio").getAsDouble();
                    String descripcion = producto.get("descripcion").getAsString();
                    int inventario = producto.get("inventario").getAsInt();

                    // Obtener URL de la imagen principal del producto (asumo la primera imagen en el array)
                    JsonArray imagenes = producto.getAsJsonArray("imagenes");
                    String imagenBlob = imagenes.size() > 0 ? "D:/pen/Repositorios/Repositorio_netbeans/TiendaTecnologica/src/main/resources/imagenes/" + imagenes.get(0).getAsString() : null;

                    // Insertar producto, incluyendo la URL de la imagen
                    String insertProductoSQL = "INSERT INTO productos (nombre, precio, descripcion, inventario, categoria_id, imagen_blob) " +
                            "VALUES (?, ?, ?, ?, (SELECT id FROM categorias WHERE nombre = ?), ?) " +
                            "ON DUPLICATE KEY UPDATE id=LAST_INSERT_ID(id)";
                    try (PreparedStatement productoStmt = connection.prepareStatement(insertProductoSQL, Statement.RETURN_GENERATED_KEYS)) {
                        productoStmt.setString(1, nombreProducto);
                        productoStmt.setDouble(2, precio);
                        productoStmt.setString(3, descripcion);
                        productoStmt.setInt(4, inventario);
                        productoStmt.setString(5, nombreCategoria);
                        productoStmt.setString(6, imagenBlob);
                        productoStmt.executeUpdate();

                        try (ResultSet generatedKeys = productoStmt.getGeneratedKeys()) {
                            if (generatedKeys.next()) {
                                int productoIdGenerado = generatedKeys.getInt(1);
                                productIdMap.put(productoIdOriginal, productoIdGenerado);
                            } else {
                                System.err.println("No se pudo obtener el ID generado para el producto: " + nombreProducto);
                            }
                        }
                    }

                    // Insertar características del producto
                    JsonObject caracteristicas = producto.getAsJsonObject("caracteristicas");
                    for (String key : caracteristicas.keySet()) {
                        String valor = caracteristicas.get(key).getAsString();
                        String insertCaracteristicaSQL = "INSERT INTO caracteristicas (producto_id, caracteristica, valor) " +
                                "VALUES (?, ?, ?)";
                        try (PreparedStatement caracteristicaStmt = connection.prepareStatement(insertCaracteristicaSQL)) {
                            Integer productoId = productIdMap.get(productoIdOriginal);
                            if (productoId != null) {
                                caracteristicaStmt.setInt(1, productoId);
                                caracteristicaStmt.setString(2, key);
                                caracteristicaStmt.setString(3, valor);
                                caracteristicaStmt.executeUpdate();
                            } else {
                                System.err.println("No se encontró el producto para insertar características: " + nombreProducto);
                            }
                        }
                    }
                }
            }

            // Insertar usuarios
            JsonArray usuarios = jsonObject.getAsJsonObject("tienda").getAsJsonArray("usuarios");
            for (int i = 0; i < usuarios.size(); i++) {
                JsonObject usuario = usuarios.get(i).getAsJsonObject();
                int usuarioIdOriginal = usuario.get("id").getAsInt();
                String nombreUsuario = usuario.get("nombre").getAsString();
                String email = usuario.get("email").getAsString();

                JsonObject direccion = usuario.getAsJsonObject("direccion");
                String calle = direccion.get("calle").getAsString();
                int numero = direccion.get("numero").getAsInt();
                String ciudad = direccion.get("ciudad").getAsString();
                String pais = direccion.get("pais").getAsString();

                // Insertar usuario
                String insertUsuarioSQL = "INSERT INTO usuarios (nombre, email, calle, numero, ciudad, pais) " +
                        "VALUES (?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE id=LAST_INSERT_ID(id)";
                try (PreparedStatement usuarioStmt = connection.prepareStatement(insertUsuarioSQL, Statement.RETURN_GENERATED_KEYS)) {
                    usuarioStmt.setString(1, nombreUsuario);
                    usuarioStmt.setString(2, email);
                    usuarioStmt.setString(3, calle);
                    usuarioStmt.setInt(4, numero);
                    usuarioStmt.setString(5, ciudad);
                    usuarioStmt.setString(6, pais);
                    usuarioStmt.executeUpdate();

                    try (ResultSet generatedKeys = usuarioStmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            int usuarioIdGenerado = generatedKeys.getInt(1);
                            userIdMap.put(usuarioIdOriginal, usuarioIdGenerado);
                        } else {
                            System.err.println("No se pudo obtener el ID generado para el usuario: " + nombreUsuario);
                        }
                    }
                }
            }

            // Insertar historial de compras
            for (int i = 0; i < usuarios.size(); i++) {
                JsonObject usuario = usuarios.get(i).getAsJsonObject();
                int usuarioIdOriginal = usuario.get("id").getAsInt();
                Integer usuarioId = userIdMap.get(usuarioIdOriginal);

                if (usuarioId != null) {
                    JsonArray historialCompras = usuario.getAsJsonArray("historialCompras");
                    for (int j = 0; j < historialCompras.size(); j++) {
                        JsonObject compra = historialCompras.get(j).getAsJsonObject();
                        int productoIdOriginal = compra.get("productoId").getAsInt();
                        Integer productoId = productIdMap.get(productoIdOriginal);
                        int cantidad = compra.get("cantidad").getAsInt();
                        String fecha = compra.get("fecha").getAsString();

                        if (productoId != null) {
                            String insertCompraSQL = "INSERT INTO historial_compras (usuario_id, producto_id, cantidad, fecha) " +
                                    "VALUES (?, ?, ?, ?)";
                            try (PreparedStatement compraStmt = connection.prepareStatement(insertCompraSQL)) {
                                compraStmt.setInt(1, usuarioId);
                                compraStmt.setInt(2, productoId);
                                compraStmt.setInt(3, cantidad);
                                compraStmt.setString(4, fecha);
                                compraStmt.executeUpdate();
                            }
                        } else {
                            System.err.println("No se encontró el producto para insertar el historial de compras del usuario: " + usuarioId);
                        }
                    }
                } else {
                    System.err.println("No se encontró el usuario para insertar el historial de compras.");
                }
            }

            System.out.println("Datos insertados exitosamente en la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}