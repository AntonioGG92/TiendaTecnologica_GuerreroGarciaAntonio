package com.tienda;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TiendaTecnologica {

    private static JsonObject dataJson;
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static JFrame frame;

    public static void main(String[] args) {
        // Leer datos del archivo JSON
        inicializarDatosDesdeJSON();

        // Crear la interfaz gráfica principal
        frame = new JFrame("Mi Tienda Online");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel titleLabel = new JLabel("Bienvenido a Mi Tienda Online");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(titleLabel);

        JButton verProductosBtn = new JButton("Ver Productos");
        JButton realizarCompraBtn = new JButton("Realizar Compra");
        JButton verHistorialBtn = new JButton("Ver Historial de Compras");

        verProductosBtn.addActionListener(e -> verProductos());
        realizarCompraBtn.addActionListener(e -> realizarCompra());
        verHistorialBtn.addActionListener(e -> verHistorial());

        frame.add(verProductosBtn);
        frame.add(realizarCompraBtn);
        frame.add(verHistorialBtn);

        frame.setVisible(true);
    }

    // Inicializa los datos del archivo JSON
    private static void inicializarDatosDesdeJSON() {
        try {
            System.out.println("Intentando leer el archivo data.json...");
            FileReader reader = new FileReader("data.json");
            dataJson = gson.fromJson(reader, JsonObject.class);
            reader.close();
            System.out.println("Archivo JSON leído exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer el archivo JSON.");
        }
    }

    // Guarda los datos en el archivo JSON
    private static void guardarDatosEnJSON() {
        try {
            System.out.println("Intentando guardar en el archivo data.json...");
            FileWriter writer = new FileWriter("data.json");
            gson.toJson(dataJson, writer);
            writer.close();
            System.out.println("Datos guardados exitosamente en data.json.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar en el archivo JSON.");
        }
    }

    // Función para ver los productos disponibles
    private static void verProductos() {
        JFrame productosFrame = new JFrame("Productos Disponibles");
        productosFrame.setSize(600, 300);

        String[] columnas = {"ID", "Nombre", "Precio", "Inventario"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        JsonArray categoriasArray = dataJson.getAsJsonObject("tienda").getAsJsonArray("categorias");
        for (int i = 0; i < categoriasArray.size(); i++) {
            JsonObject categoria = categoriasArray.get(i).getAsJsonObject();
            JsonArray productosArray = categoria.getAsJsonArray("productos");
            for (int j = 0; j < productosArray.size(); j++) {
                JsonObject producto = productosArray.get(j).getAsJsonObject();

                // Validar los campos para asegurarse de que no son null
                if (producto.has("id") && !producto.get("id").isJsonNull()) {
                    int id = producto.get("id").getAsInt();
                    String nombre = producto.has("nombre") && !producto.get("nombre").isJsonNull() ? producto.get("nombre").getAsString() : "Sin Nombre";
                    double precio = producto.has("precio") && !producto.get("precio").isJsonNull() ? producto.get("precio").getAsDouble() : 0.0;
                    int inventario = producto.has("inventario") && !producto.get("inventario").isJsonNull() ? producto.get("inventario").getAsInt() : 0;

                    Object[] fila = {id, nombre, precio, inventario};
                    model.addRow(fila);
                } else {
                    // Producto sin ID o con datos faltantes
                    System.out.println("Producto sin ID o con datos faltantes. Verifique el archivo JSON.");
                }
            }
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        productosFrame.add(scrollPane);

        productosFrame.setVisible(true);
    }

    // Función para realizar una compra
    private static void realizarCompra() {
        JFrame compraFrame = new JFrame("Realizar Compra");
        compraFrame.setSize(400, 300);
        compraFrame.setLayout(new GridLayout(4, 2));

        JLabel usuarioLabel = new JLabel("Usuario ID:");
        JTextField usuarioField = new JTextField();
        JLabel productoLabel = new JLabel("Producto ID:");
        JTextField productoField = new JTextField();
        JLabel cantidadLabel = new JLabel("Cantidad:");
        JTextField cantidadField = new JTextField();
        JButton comprarBtn = new JButton("Comprar");

        compraFrame.add(usuarioLabel);
        compraFrame.add(usuarioField);
        compraFrame.add(productoLabel);
        compraFrame.add(productoField);
        compraFrame.add(cantidadLabel);
        compraFrame.add(cantidadField);
        compraFrame.add(comprarBtn);

        comprarBtn.addActionListener(e -> {
            try {
                int usuarioId = Integer.parseInt(usuarioField.getText());
                int productoId = Integer.parseInt(productoField.getText());
                int cantidad = Integer.parseInt(cantidadField.getText());

                // Buscar usuario y producto
                JsonObject usuario = obtenerUsuarioPorId(usuarioId);
                JsonObject producto = obtenerProductoPorId(productoId);

                if (usuario == null) {
                    JOptionPane.showMessageDialog(compraFrame, "Usuario no encontrado.");
                    return;
                }

                if (producto == null) {
                    JOptionPane.showMessageDialog(compraFrame, "Producto no encontrado.");
                    return;
                }

                // Verificar inventario
                int inventario = producto.get("inventario").getAsInt();
                if (inventario < cantidad) {
                    JOptionPane.showMessageDialog(compraFrame, "Inventario insuficiente.");
                    return;
                }

                // Actualizar inventario y agregar compra al historial
                producto.addProperty("inventario", inventario - cantidad);
                JsonArray historialCompras = usuario.getAsJsonArray("historialCompras");
                JsonObject nuevaCompra = new JsonObject();
                nuevaCompra.addProperty("productoId", productoId);
                nuevaCompra.addProperty("cantidad", cantidad);
                nuevaCompra.addProperty("fecha", java.time.LocalDate.now().toString());
                historialCompras.add(nuevaCompra);

                // Guardar datos en JSON
                guardarDatosEnJSON();

                JOptionPane.showMessageDialog(compraFrame, "Compra realizada con éxito.");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(compraFrame, "Por favor, ingresa valores válidos.");
            }
        });

        compraFrame.setVisible(true);
    }

    // Función para obtener usuario por ID
    private static JsonObject obtenerUsuarioPorId(int usuarioId) {
        JsonArray usuariosArray = dataJson.getAsJsonObject("tienda").getAsJsonArray("usuarios");
        for (int i = 0; i < usuariosArray.size(); i++) {
            JsonObject u = usuariosArray.get(i).getAsJsonObject();
            if (u.get("id").getAsInt() == usuarioId) {
                return u;
            }
        }
        return null;
    }

 // Función para obtener producto por ID
    private static JsonObject obtenerProductoPorId(int productoId) {
        JsonArray categoriasArray = dataJson.getAsJsonObject("tienda").getAsJsonArray("categorias");
        
        // Asegurarse de que el array de categorías no es nulo
        if (categoriasArray == null) {
            System.out.println("No se encontró el array de categorías en el archivo JSON.");
            return null;
        }

        for (int i = 0; i < categoriasArray.size(); i++) {
            JsonObject categoria = categoriasArray.get(i).getAsJsonObject();
            
            // Verificar si la categoría tiene el campo "productos" y que sea un array
            if (!categoria.has("productos") || !categoria.get("productos").isJsonArray()) {
                System.out.println("La categoría " + categoria.get("nombre").getAsString() + " no tiene productos o el formato es incorrecto.");
                continue; // Pasar a la siguiente categoría
            }

            JsonArray productosArray = categoria.getAsJsonArray("productos");
            
            for (int j = 0; j < productosArray.size(); j++) {
                JsonObject p = productosArray.get(j).getAsJsonObject();

                // Verificar si el producto tiene el campo "id" y que sea un número entero
                if (!p.has("id") || !p.get("id").isJsonPrimitive()) {
                    System.out.println("Producto con índice " + j + " en la categoría " + categoria.get("nombre").getAsString() + " tiene datos faltantes.");
                    continue; // Pasar al siguiente producto
                }

                if (p.get("id").getAsInt() == productoId) {
                    return p; // Devolver el producto si se encuentra
                }
            }
        }

        // Si no se encuentra el producto, se devuelve null
        return null;
    }

    // Función para ver el historial de compras
    private static void verHistorial() {
        JFrame historialFrame = new JFrame("Historial de Compras");
        historialFrame.setSize(400, 300);
        historialFrame.setLayout(new GridLayout(2, 1));

        JLabel usuarioLabel = new JLabel("Usuario ID:");
        JTextField usuarioField = new JTextField();
        JButton verHistorialBtn = new JButton("Ver Historial");

        historialFrame.add(usuarioLabel);
        historialFrame.add(usuarioField);
        historialFrame.add(verHistorialBtn);

        verHistorialBtn.addActionListener(e -> {
            try {
                int usuarioId = Integer.parseInt(usuarioField.getText());
                JsonObject usuario = obtenerUsuarioPorId(usuarioId);

                if (usuario == null) {
                    JOptionPane.showMessageDialog(historialFrame, "Usuario no encontrado.");
                    return;
                }

                JsonArray historialCompras = usuario.getAsJsonArray("historialCompras");
                StringBuilder historialText = new StringBuilder("Historial de Compras:\n");
                for (int i = 0; i < historialCompras.size(); i++) {
                    JsonObject compra = historialCompras.get(i).getAsJsonObject();
                    historialText.append("Producto ID: ").append(compra.get("productoId").getAsInt())
                            .append(", Cantidad: ").append(compra.get("cantidad").getAsInt())
                            .append(", Fecha: ").append(compra.get("fecha").getAsString()).append("\n");
                }

                JOptionPane.showMessageDialog(historialFrame, historialText.toString());

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(historialFrame, "Por favor, ingresa un valor válido para el ID de usuario.");
            }
        });

        historialFrame.setVisible(true);
    }
}
