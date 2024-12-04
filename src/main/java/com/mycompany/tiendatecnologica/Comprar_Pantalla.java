/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tiendatecnologica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class Comprar_Pantalla extends javax.swing.JFrame {

    /**
     * Creates new form Comprar_Pantalla
     */
    public Comprar_Pantalla() {
        initComponents();
        cargarUsuarios();
        cargarCategorias();
        cargarProductos();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        label6 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jPanel2.setBackground(new java.awt.Color(0, 51, 255));

        label1.setFont(new java.awt.Font("Dialog", 2, 36)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 255, 255));
        label1.setText("Compras");

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

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        label2.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        label2.setForeground(new java.awt.Color(0, 255, 255));
        label2.setText("Selecciona Un Usuario :");

        label3.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        label3.setForeground(new java.awt.Color(0, 255, 255));
        label3.setText("Selecciona Una Categoria :");

        label4.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        label4.setForeground(new java.awt.Color(0, 255, 255));
        label4.setText("Selecciona Un Producto :");

        label5.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        label5.setForeground(new java.awt.Color(0, 255, 255));
        label5.setText("Introduzca Una Cantidad :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 201, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setText("Comprar Producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        label6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label6.setForeground(new java.awt.Color(0, 255, 255));
        label6.setText("Compra Realizada :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
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
        String usuarioSeleccionado = (String) jComboBox1.getSelectedItem();
    if (usuarioSeleccionado != null && !usuarioSeleccionado.equals("Seleccione un Usuario")) {
        // Puedes agregar alguna lógica si es necesario cuando el usuario cambia
        System.out.println("Usuario seleccionado: " + usuarioSeleccionado);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        String categoriaSeleccionada = (String) jComboBox2.getSelectedItem();
        if (categoriaSeleccionada != null && !categoriaSeleccionada.equals("Seleccione una Categoría")) {
            cargarProductosPorCategoria(categoriaSeleccionada);
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String usuario = (String) jComboBox1.getSelectedItem();
    String producto = (String) jComboBox3.getSelectedItem();
    int cantidad;

    try {
        cantidad = Integer.parseInt(jTextField1.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor ingrese una cantidad válida.");
        return;
    }

    Connection connection = null;
    try {
        connection = Conexion.getConnection();

        // Obtener el usuario_id a partir del nombre del usuario seleccionado
        String queryUsuario = "SELECT id FROM usuarios WHERE nombre = ?";
        PreparedStatement stmtUsuario = connection.prepareStatement(queryUsuario);
        stmtUsuario.setString(1, usuario);
        ResultSet rsUsuario = stmtUsuario.executeQuery();

        int usuarioId = -1;
        if (rsUsuario.next()) {
            usuarioId = rsUsuario.getInt("id");
        }

        if (usuarioId == -1) {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado.");
            return;
        }

        // Obtener el producto_id a partir del nombre del producto seleccionado
        String queryProducto = "SELECT id FROM productos WHERE nombre = ?";
        PreparedStatement stmtProducto = connection.prepareStatement(queryProducto);
        stmtProducto.setString(1, producto);
        ResultSet rsProducto = stmtProducto.executeQuery();

        int productoId = -1;
        if (rsProducto.next()) {
            productoId = rsProducto.getInt("id");
        }

        if (productoId == -1) {
            JOptionPane.showMessageDialog(this, "Producto no encontrado.");
            return;
        }

        // Insertar la compra en el historial de compras
        String queryInsert = "INSERT INTO historial_compras (usuario_id, producto_id, cantidad, fecha) VALUES (?, ?, ?, CURDATE())";
        PreparedStatement stmtInsert = connection.prepareStatement(queryInsert);
        stmtInsert.setInt(1, usuarioId);
        stmtInsert.setInt(2, productoId);
        stmtInsert.setInt(3, cantidad);

        int rowsInserted = stmtInsert.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Compra realizada exitosamente.");

            // Mostrar información en el área de texto
            String detalleCompra = "Compra realizada:\n"
                    + "Usuario: " + usuario + "\n"
                    + "Producto: " + producto + "\n"
                    + "Cantidad: " + cantidad + "\n"
                    + "Fecha: " + java.time.LocalDate.now() + "\n";
            
            jTextArea1.setText(detalleCompra);
        }

    } catch (SQLException e) {
        System.err.println("Error al insertar en el historial de compras: " + e.getMessage());
    } finally {
        Conexion.closeConnection(connection);
    }

    }//GEN-LAST:event_jButton1ActionPerformed

     private void cargarUsuarios() {
    Connection connection = null;
    try {
        // Establecer la conexión con la base de datos
        connection = Conexion.getConnection();

        // Verificar si la conexión fue exitosa
        if (connection == null) {
            System.err.println("No se pudo establecer la conexión con la base de datos.");
            JOptionPane.showMessageDialog(this, "Error al conectarse a la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Consulta para obtener los usuarios
        String query = "SELECT nombre FROM usuarios";
        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        // Crear un modelo para el JComboBox con un elemento predeterminado
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Seleccione un Usuario");

        // Agregar todos los nombres de usuarios al modelo
        boolean usuariosEncontrados = false;
        while (rs.next()) {
            String nombreUsuario = rs.getString("nombre");
            usuariosEncontrados = true;
            model.addElement(nombreUsuario);
        }

        // Asignar el modelo al JComboBox
        jComboBox1.setModel(model);

        // Si no se encontraron usuarios, mostrar un mensaje
        if (!usuariosEncontrados) {
            System.out.println("No se encontraron usuarios en la base de datos.");
            JOptionPane.showMessageDialog(this, "No se encontraron usuarios en la base de datos.", "Sin Usuarios", JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        // Mostrar un mensaje en caso de que ocurra un error al realizar la consulta
        System.err.println("Error al obtener los usuarios de la base de datos: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Error al obtener los usuarios de la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Cerrar la conexión con la base de datos
        Conexion.closeConnection(connection);
    }
}



    private void cargarCategorias() {
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
            String query = "SELECT nombre FROM categorias";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            while (rs.next()) {
                model.addElement(rs.getString("nombre"));
            }
            jComboBox2.setModel(model);

        } catch (SQLException e) {
            System.err.println("Error al obtener las categorias de la base de datos: " + e.getMessage());
        } finally {
            Conexion.closeConnection(connection);
        }
    }
    private void cargarProductos() {
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
            String query = "SELECT nombre FROM productos";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            while (rs.next()) {
                model.addElement(rs.getString("nombre"));
            }
            jComboBox3.setModel(model);

        } catch (SQLException e) {
            System.err.println("Error al obtener los productos de la base de datos: " + e.getMessage());
        } finally {
            Conexion.closeConnection(connection);
        }
    }
    private void cargarProductosPorCategoria(String categoriaSeleccionada) {
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
            String query = "SELECT p.nombre FROM productos p JOIN categorias c ON p.categoria_id = c.id WHERE c.nombre = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, categoriaSeleccionada);
            ResultSet rs = stmt.executeQuery();

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            model.addElement("Seleccione un Producto");
            while (rs.next()) {
                model.addElement(rs.getString("nombre"));
            }
            jComboBox3.setModel(model);

        } catch (SQLException e) {
            System.err.println("Error al cargar los productos de la base de datos: " + e.getMessage());
        } finally {
            Conexion.closeConnection(connection);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    // End of variables declaration//GEN-END:variables
}
