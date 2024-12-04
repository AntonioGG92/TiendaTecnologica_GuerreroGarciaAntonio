/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tiendatecnologica;

import java.awt.Image;
import static java.awt.PageAttributes.MediaType.D;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;


public class Productos_Pantalla extends javax.swing.JFrame {


    public Productos_Pantalla() {
        initComponents();
        cargarCategorias();
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        label3 = new java.awt.Label();
        label2 = new java.awt.Label();
        label4 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jPanel2.setBackground(new java.awt.Color(0, 51, 255));

        label1.setFont(new java.awt.Font("Dialog", 2, 36)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 255, 255));
        label1.setText("Productos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(259, 259, 259))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        label3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label3.setForeground(new java.awt.Color(0, 255, 255));
        label3.setText("Selecciona una Categoria:");

        label2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label2.setForeground(new java.awt.Color(0, 255, 255));
        label2.setText("Selecciona un Producto:");

        label4.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        label4.setForeground(new java.awt.Color(0, 255, 255));
        label4.setText("Descripccion:");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String categoriaSeleccionada = (String) jComboBox1.getSelectedItem();
        if (categoriaSeleccionada != null && !categoriaSeleccionada.equals("Seleccione una categoría")) {
            cargarProductosPorCategoria(categoriaSeleccionada);
    }//GEN-LAST:event_jComboBox1ActionPerformed
    }
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
               String productoSeleccionado = (String) jComboBox2.getSelectedItem();
        if (productoSeleccionado != null && !productoSeleccionado.equals("Seleccione un producto")) {
            cargarDescripcionProducto(productoSeleccionado);
    }//GEN-LAST:event_jComboBox2ActionPerformed
    }
 private void cargarCategorias() {
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
            String query = "SELECT nombre FROM categorias";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            model.addElement("Seleccione una categoria");
            while (rs.next()) {
                model.addElement(rs.getString("nombre"));
            }
            jComboBox1.setModel(model);

        } catch (SQLException e) {
            System.err.println("Error al cargar categorias: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }

    private void cargarProductosPorCategoria(String categoriaSeleccionada) {
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
            String query = "SELECT p.nombre FROM productos p " +
                           "JOIN categorias c ON p.categoria_id = c.id " +
                           "WHERE c.nombre = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, categoriaSeleccionada);
            ResultSet rs = stmt.executeQuery();

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            model.addElement("Seleccione un producto");
            while (rs.next()) {
                model.addElement(rs.getString("nombre"));
            }
            jComboBox2.setModel(model);

        } catch (SQLException e) {
            System.err.println("Error al cargar productos: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }

 
    private void cargarDescripcionProducto(String productoSeleccionado) {
    Connection connection = null;
    try {
        connection = Conexion.getConnection();
        String query = "SELECT id, nombre, precio, descripcion, pantalla, camara, bateria, inventario, imagen_blob FROM productos WHERE nombre = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, productoSeleccionado);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            StringBuilder descripcion = new StringBuilder();
            descripcion.append("ID: ").append(rs.getInt("id")).append("\n");
            descripcion.append("Nombre: ").append(rs.getString("nombre")).append("\n");
            descripcion.append("Precio: €").append(rs.getBigDecimal("precio")).append("\n");
            descripcion.append("Descripción: ").append(rs.getString("descripcion")).append("\n");
            if (rs.getString("pantalla") != null) {
                descripcion.append("Pantalla: ").append(rs.getString("pantalla")).append("\n");
            }
            if (rs.getString("camara") != null) {
                descripcion.append("Camara: ").append(rs.getString("camara")).append("\n");
            }
            if (rs.getString("bateria") != null) {
                descripcion.append("Bateria: ").append(rs.getString("bateria")).append("\n");
            }
            descripcion.append("Inventario: ").append(rs.getInt("inventario")).append("\n");

            jTextArea2.setText(descripcion.toString());

            // Cargar la primera imagen (que termina en "1.jpg")
            String rutaImagen1 = rs.getString("imagen_blob");
            if (rutaImagen1 != null && !rutaImagen1.isEmpty()) {
                // Asumimos que la imagen original termina en "1.jpg"
                String rutaImagen2 = rutaImagen1.replace("1.jpg", "2.jpg"); // Cambiar "1.jpg" a "2.jpg" para la segunda imagen

                // Intentar cargar la primera imagen (terminada en "1.jpg")
                cargarImagenEnLabel(rutaImagen1, jLabel1, productoSeleccionado, "primera");

                // Intentar cargar la segunda imagen (terminada en "2.jpg")
                cargarImagenEnLabel(rutaImagen2, jLabel2, productoSeleccionado, "segunda");
            } else {
                jLabel1.setIcon(null);
                jLabel2.setIcon(null);
                System.out.println("No hay imagen disponible para el producto: " + productoSeleccionado);
            }
        } else {
            jTextArea2.setText("No se encontró información para el producto seleccionado.");
            jLabel1.setIcon(null);
            jLabel2.setIcon(null);
        }
    } catch (SQLException e) {
        System.err.println("Error al cargar la descripción del producto: " + e.getMessage());
        jTextArea2.setText("Error al cargar la descripción.");
        jLabel1.setIcon(null);
        jLabel2.setIcon(null);
    } finally {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}

/**
 * Método auxiliar para cargar una imagen en un JLabel.
 */
private void cargarImagenEnLabel(String rutaImagen, javax.swing.JLabel label, String productoSeleccionado, String tipoImagen) {
    try {
        File archivoImagen = new File(rutaImagen);
        if (archivoImagen.exists()) {
            Image imagen = ImageIO.read(archivoImagen);
            if (imagen != null) {
                ImageIcon icono = new ImageIcon(imagen.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
                label.setIcon(icono);
                System.out.println("Imagen " + tipoImagen + " cargada correctamente para el producto: " + productoSeleccionado);
            } else {
                System.out.println("No se pudo leer la imagen " + tipoImagen + " para el producto: " + productoSeleccionado);
                label.setIcon(null);
            }
        } else {
            System.out.println("No se encontró el archivo de imagen " + tipoImagen + " para el producto: " + productoSeleccionado + " en la ruta: " + archivoImagen.getAbsolutePath());
            label.setIcon(null);
        }
    } catch (Exception e) {
        System.err.println("Error al cargar la imagen " + tipoImagen + ": " + e.getMessage());
        e.printStackTrace();
        label.setIcon(null);
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    // End of variables declaration//GEN-END:variables
}
