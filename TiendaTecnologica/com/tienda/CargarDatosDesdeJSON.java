package com.tienda;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.FileReader;

public class CargarDatosDesdeJSON {

    private static final String URL = "jdbc:mysql://localhost:3306/TiendaTecnologica";
    private static final String USER = "root";
    private static final String PASSWORD = ""; 

    public static void main(String[] args) {
        Gson gson = new Gson();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Leer datos del archivo JSON
            FileReader reader = new FileReader("data.json");
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            // Leer categorías y productos
            JsonArray categoriasArray = jsonObject.getAsJsonObject("tienda").getAsJsonArray("categorias");
            String insertCategoria = "INSERT INTO categorias (nombre) VALUES (?)";
            String insertProducto = "INSERT INTO productos (nombre, precio, descripcion, pantalla, camara, bateria, inventario, categoria_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement categoriaStmt = conn.prepareStatement(insertCategoria, PreparedStatement.RETURN_GENERATED_KEYS);
            PreparedStatement productoStmt = conn.prepareStatement(insertProducto, PreparedStatement.RETURN_GENERATED_KEYS);

            for (int i = 0; i < categoriasArray.size(); i++) {
                JsonObject categoriaJson = categoriasArray.get(i).getAsJsonObject();
                if (categoriaJson == null || !categoriaJson.has("nombre")) {
                    System.out.println("Categoría sin nombre. Verifique el archivo JSON.");
                    continue;
                }

                String nombreCategoria = categoriaJson.get("nombre").getAsString();

                // Verificar si la categoría ya existe
                int categoriaId = obtenerCategoriaId(conn, nombreCategoria);
                if (categoriaId == -1) {
                    // Insertar categoría si no existe
                    categoriaStmt.setString(1, nombreCategoria);
                    categoriaStmt.executeUpdate();

                    var generatedKeys = categoriaStmt.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        categoriaId = generatedKeys.getInt(1);
                    }
                }

                // Insertar productos asociados a la categoría
                if (categoriaJson.has("productos")) {
                    JsonArray productosArray = categoriaJson.getAsJsonArray("productos");
                    for (int j = 0; j < productosArray.size(); j++) {
                        JsonObject productoJson = productosArray.get(j).getAsJsonObject();
                        if (productoJson == null || !productoJson.has("nombre") || !productoJson.has("precio") || !productoJson.has("descripcion") || !productoJson.has("inventario")) {
                            System.out.println("Producto sin datos completos. Verifique el archivo JSON.");
                            continue;
                        }

                        String nombreProducto = productoJson.get("nombre").getAsString();

                        // Verificar si el producto ya existe
                        if (!productoExiste(conn, nombreProducto)) {
                            productoStmt.setString(1, nombreProducto);
                            productoStmt.setDouble(2, productoJson.get("precio").getAsDouble());
                            productoStmt.setString(3, productoJson.get("descripcion").getAsString());

                            // Verificar las características del producto
                            JsonObject caracteristicas = productoJson.has("caracteristicas") ? productoJson.getAsJsonObject("caracteristicas") : null;
                            if (caracteristicas != null) {
                                productoStmt.setString(4, caracteristicas.has("pantalla") ? caracteristicas.get("pantalla").getAsString() : null);
                                productoStmt.setString(5, caracteristicas.has("camara") ? caracteristicas.get("camara").getAsString() : null);
                                productoStmt.setString(6, caracteristicas.has("bateria") ? caracteristicas.get("bateria").getAsString() : null);
                            } else {
                                productoStmt.setString(4, null);
                                productoStmt.setString(5, null);
                                productoStmt.setString(6, null);
                            }

                            productoStmt.setInt(7, productoJson.get("inventario").getAsInt());
                            productoStmt.setInt(8, categoriaId);

                            productoStmt.executeUpdate();
                        }
                    }
                }
            }

            // Leer usuarios
            JsonArray usuariosArray = jsonObject.getAsJsonObject("tienda").getAsJsonArray("usuarios");
            String insertUsuario = "INSERT INTO usuarios (nombre, email, calle, numero, ciudad, pais) VALUES (?, ?, ?, ?, ?, ?)";
            String insertHistorial = "INSERT INTO historial_compras (usuario_id, producto_id, cantidad, fecha) VALUES (?, ?, ?, ?)";
            PreparedStatement usuarioStmt = conn.prepareStatement(insertUsuario, PreparedStatement.RETURN_GENERATED_KEYS);
            PreparedStatement historialStmt = conn.prepareStatement(insertHistorial);

            for (int i = 0; i < usuariosArray.size(); i++) {
                JsonObject usuarioJson = usuariosArray.get(i).getAsJsonObject();
                if (usuarioJson == null || !usuarioJson.has("nombre") || !usuarioJson.has("email")) {
                    System.out.println("Usuario sin datos completos. Verifique el archivo JSON.");
                    continue;
                }

                String emailUsuario = usuarioJson.get("email").getAsString();

                // Verificar si el usuario ya existe
                int usuarioId = obtenerUsuarioId(conn, emailUsuario);
                if (usuarioId == -1) {
                    usuarioStmt.setString(1, usuarioJson.get("nombre").getAsString());
                    usuarioStmt.setString(2, emailUsuario);

                    JsonObject direccion = usuarioJson.has("direccion") ? usuarioJson.getAsJsonObject("direccion") : null;
                    if (direccion != null) {
                        usuarioStmt.setString(3, direccion.has("calle") ? direccion.get("calle").getAsString() : null);
                        usuarioStmt.setInt(4, direccion.has("numero") ? direccion.get("numero").getAsInt() : 0);
                        usuarioStmt.setString(5, direccion.has("ciudad") ? direccion.get("ciudad").getAsString() : null);
                        usuarioStmt.setString(6, direccion.has("pais") ? direccion.get("pais").getAsString() : null);
                    } else {
                        usuarioStmt.setString(3, null);
                        usuarioStmt.setInt(4, 0);
                        usuarioStmt.setString(5, null);
                        usuarioStmt.setString(6, null);
                    }

                    usuarioStmt.executeUpdate();

                    var userGeneratedKeys = usuarioStmt.getGeneratedKeys();
                    if (userGeneratedKeys.next()) {
                        usuarioId = userGeneratedKeys.getInt(1);
                    }
                }

                // Insertar historial de compras
                if (usuarioJson.has("historialCompras")) {
                    JsonArray historialCompras = usuarioJson.getAsJsonArray("historialCompras");
                    for (int k = 0; k < historialCompras.size(); k++) {
                        JsonObject compraJson = historialCompras.get(k).getAsJsonObject();
                        if (compraJson == null || !compraJson.has("productoId") || !compraJson.has("cantidad") || !compraJson.has("fecha")) {
                            System.out.println("Compra sin datos completos. Verifique el archivo JSON.");
                            continue;
                        }
                        historialStmt.setInt(1, usuarioId);
                        historialStmt.setInt(2, compraJson.get("productoId").getAsInt());
                        historialStmt.setInt(3, compraJson.get("cantidad").getAsInt());
                        historialStmt.setString(4, compraJson.get("fecha").getAsString());

                        try {
                            historialStmt.executeUpdate();
                        } catch (SQLException e) {
                            System.out.println("No se pudo insertar la compra: " + e.getMessage());
                        }
                    }
                }
            }

            System.out.println("Datos cargados exitosamente desde el archivo JSON.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int obtenerCategoriaId(Connection conn, String nombreCategoria) throws SQLException {
        String selectCategoria = "SELECT id FROM categorias WHERE nombre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(selectCategoria)) {
            stmt.setString(1, nombreCategoria);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        return -1;
    }

    private static boolean productoExiste(Connection conn, String nombreProducto) throws SQLException {
        String selectProducto = "SELECT id FROM productos WHERE nombre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(selectProducto)) {
            stmt.setString(1, nombreProducto);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }

    private static int obtenerUsuarioId(Connection conn, String email) throws SQLException {
        String selectUsuario = "SELECT id FROM usuarios WHERE email = ?";
        try (PreparedStatement stmt = conn.prepareStatement(selectUsuario)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        return -1;
    }
}
