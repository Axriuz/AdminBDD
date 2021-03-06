/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import conexiones.Conexion;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Acer
 */
public class Clientes extends javax.swing.JFrame {

    Connection conn;
    Conexion conexiones = new Conexion();
    static ResultSet res;

    /**
     * Creates new form Clientes
     */
    public Clientes() {
        initComponents();
        setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(800, 600));

        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/recursos/28.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
        //FECHA DEL SISTEMA
        Date sistFecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd MMMMM YYYY");
        fecha.setText(formato.format(sistFecha));

        //HORA DEL SISTEMA
        Timer tiempo = new Timer(100, new Clientes.horas());
        tiempo.start();
        Cargar();
        // ACTUALIZACIÓN DE CIUDADES
        actualizarCiudades();
    }

    public void actualizarCiudades() {
        try {
            ArrayList<String> arr = new ArrayList();
            Ciudades c = new Ciudades();
            arr = c.obtenerCiudades();
            if (!arr.isEmpty()) {
                for (int i = ciudades.getItemCount() - 1; i < arr.size(); i++) {
                    ciudades.addItem(arr.get(i));
                }
            }
        } catch (SQLException e) {
            System.out.println("No hay ciudades :c");
        }
    }

    public void Cargar() {
        DefaultTableCellRenderer alinearCentro = new DefaultTableCellRenderer();
        alinearCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Cliente");
        modelo.addColumn("Dirección");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Email");
        modelo.addColumn("RFC");
        tabla.setModel(modelo);
        try {
            conn = conexiones.Conexion();
            PreparedStatement pStm = conn.prepareStatement("SELECT * FROM VerClientes");
            res = pStm.executeQuery();
            while (res.next()) {
                Object vector[] = new Object[7];
                for (int i = 0; i < vector.length; i++) {
                    vector[i] = res.getObject(i + 1);
                    tabla.getColumnModel().getColumn(i).setCellRenderer(alinearCentro);
                }
                modelo.addRow(vector);
            }
            conexiones.cierraConexion();
        } catch (SQLException e) {
            System.out.println("Error SQL: ");
            e.printStackTrace(System.out);
            conexiones.cierraConexion();
        } catch (Exception e) {
            System.out.println("Error Genérico: ");
            e.printStackTrace(System.out);
            conexiones.cierraConexion();
        }
    }

    class horas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Date sistHora = new Date();
            String pmAm = "hh:mm:ss a";
            SimpleDateFormat format = new SimpleDateFormat(pmAm);
            Calendar hoy = Calendar.getInstance();
            hora.setText(String.format(format.format(sistHora), hoy));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ciudades = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        agregar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        marca = new javax.swing.JLabel();
        buscador = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        fecha = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        menu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        rfc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ciudades.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        ciudades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione ciudad" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Cliente::"));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Direccion", "Telefono", "Ciudad", "Email", "R.F.C"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jLabel1.setText("MÓDULO CLIENTES");

        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_Plus__Orange_34237.png"))); // NOI18N
        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_Line_ui_icons_Svg-03_1465842.png"))); // NOI18N
        eliminar.setText("Eliminar seleccionado");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_pencil_285638.png"))); // NOI18N
        modificar.setText("Modificar seleccionado");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_Cancel__Red_34208 (1).png"))); // NOI18N
        cancelar.setText("Limpiar selección");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        marca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/IMG-20190402-WA0002.jpg"))); // NOI18N
        marca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscadorKeyReleased(evt);
            }
        });

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconfinder_search_285651.png"))); // NOI18N
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Fecha:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Hora:");

        menu.setText("MENU");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("ID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Direccion:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setText("Telefono:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText("Ciudad:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setText("Email:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel11.setText("R.F.C");

        id.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(buscar)))
                        .addGap(371, 371, 371)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(eliminar)
                        .addGap(241, 241, 241)
                        .addComponent(agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ciudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rfc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel1))
                                    .addComponent(fecha))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buscar)
                                    .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 12, Short.MAX_VALUE)
                                        .addComponent(jLabel7))))
                            .addComponent(hora))
                        .addGap(132, 132, 132))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ciudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(agregar)
                    .addComponent(eliminar)
                    .addComponent(modificar)
                    .addComponent(menu))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        if (nombre.getText().isEmpty() || direccion.getText().isEmpty() || telefono.getText().isEmpty() || ciudades.getSelectedIndex() == 0 || email.getText().isEmpty() || rfc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa bien los datos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
        } else {
            try {
                boolean band = buscarCliente(nombre.getText());
                if (band == true) {
                    JOptionPane.showMessageDialog(this, "Este cliente ya existe", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    conn = conexiones.Conexion();
                    CallableStatement proc = conn.prepareCall("{call NuevoCliente(?,?,?,?,?,?)}");
                    proc.setString(1, nombre.getText());
                    proc.setString(2, direccion.getText());
                    proc.setInt(3, Integer.parseInt(telefono.getText()));
                    proc.setString(4, ciudades.getSelectedItem().toString());
                    proc.setString(5, email.getText());
                    proc.setString(6, rfc.getText());
                    int filasAfectadas = proc.executeUpdate();
                    System.out.println("Filas afectadas: " + filasAfectadas);
                    limpiar();
                    JOptionPane.showMessageDialog(this, "Datos almacenados correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    Cargar();
                }
            } catch (SQLException e) {
                System.out.println("Error SQL: ");
                e.printStackTrace(System.out);
                conexiones.cierraConexion();
            } catch (HeadlessException | NumberFormatException e) {
                System.out.println("Error Genérico: ");
                e.printStackTrace(System.out);
                conexiones.cierraConexion();
            }
        }
        conexiones.cierraConexion();
    }//GEN-LAST:event_agregarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        if (buscador.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "META BIEN SUS DATOS", "Error", JOptionPane.ERROR_MESSAGE);
            buscador.setText("");
            buscador.requestFocus();
        } else {
            try {
                conn = conexiones.Conexion();
                CallableStatement proc = conn.prepareCall("{call BuscarCliente(?)}");
                proc.setString(1, buscador.getText());
                res = proc.executeQuery();
                if (res.next()) {
                    JOptionPane.showMessageDialog(null, "DATOS ENCONTRADOS");
                } else {
                    JOptionPane.showMessageDialog(null, "DATOS NO ENCONTRADOS");
                }
            } catch (SQLException e) {
                System.out.println("Error SQL: ");
                e.printStackTrace(System.out);
                conexiones.cierraConexion();
            } catch (Exception e) {
                System.out.println("Error Genérico: ");
                e.printStackTrace(System.out);
                conexiones.cierraConexion();
            }
        }
        conexiones.cierraConexion();
    }//GEN-LAST:event_buscarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_cancelarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int opc = JOptionPane.showConfirmDialog(this, "¿ESTAS SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opc == JOptionPane.YES_OPTION) {
            try {
                conn = conexiones.Conexion();
                CallableStatement proc = conn.prepareCall("{call EliminarCliente(?)}");
                proc.setString(1, nombre.getText());
                int band = proc.executeUpdate();
                if (band != 0) {
                    JOptionPane.showMessageDialog(null, "Se eliminó correctamente al cliente.");
                    limpiar();
                    Cargar();
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un problema al intentar eliminar al cliente.");
                }
                limpiar();
                Cargar();
            } catch (SQLException e) {
                System.out.println("Error SQL: ");
                e.printStackTrace(System.out);
                conexiones.cierraConexion();
            } catch (Exception e) {
                System.out.println("Error Genérico: ");
                e.printStackTrace(System.out);
                conexiones.cierraConexion();
            }
        }
        conexiones.cierraConexion();
    }//GEN-LAST:event_eliminarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        try {
            conn = conexiones.Conexion();
            CallableStatement proc = conn.prepareCall("{call ModificarCliente(?,?,?,?,?,?,?)}");
            proc.setInt(1, Integer.parseInt(id.getText()));
            proc.setString(2, nombre.getText());
            proc.setString(3, direccion.getText());
            proc.setInt(4, Integer.parseInt(telefono.getText()));
            proc.setString(5, ciudades.getSelectedItem().toString());
            proc.setString(6, email.getText());
            proc.setString(7, rfc.getText());
            int band = proc.executeUpdate();
            if (band != 0) {
                JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO MODIFICADOS");
                limpiar();
                Cargar();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar los datos");
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: ");
            e.printStackTrace(System.out);
            conexiones.cierraConexion();
        } catch (Exception e) {
            System.out.println("Error Genérico: ");
            e.printStackTrace(System.out);
            conexiones.cierraConexion();
        }
        conexiones.cierraConexion();
    }//GEN-LAST:event_modificarActionPerformed

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        MenuPrincipal mp = new MenuPrincipal();
        mp.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuActionPerformed

    private void buscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorKeyReleased
        if (buscador.getText().equals("")) {
            Cargar();
        } else {
            buscando();
        }
    }//GEN-LAST:event_buscadorKeyReleased

    private void tablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMousePressed
        int fila = tabla.rowAtPoint(evt.getPoint());
        int columna = tabla.columnAtPoint(evt.getPoint());
        if ((fila > -1) && (columna > -1)) {
            id.setText(tabla.getValueAt(fila, 0).toString()); // Obtenemos el ID del usuario.
            nombre.setText(tabla.getValueAt(fila, 1).toString()); // Mostramos el nombre del usuario.
            direccion.setText(tabla.getValueAt(fila, 2).toString());
            telefono.setText(tabla.getValueAt(fila, 3).toString()); // Mostramos la telefono del usuario seleccionado.
            ciudades.setSelectedItem((tabla.getValueAt(fila, 4).toString())); // Obtenemos el nombre de la ciudad del usuario seleccionado.
            email.setText(tabla.getValueAt(fila, 5).toString());
            rfc.setText(tabla.getValueAt(fila, 6).toString());
        }
    }//GEN-LAST:event_tablaMousePressed

    public void buscando() {
        DefaultTableCellRenderer alinearCentro = new DefaultTableCellRenderer();
        alinearCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Cliente");
        modelo.addColumn("Dirección");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Email");
        modelo.addColumn("RFC");
        tabla.setModel(modelo);
        try {
            conn = conexiones.Conexion();
            CallableStatement proc = conn.prepareCall("{call BuscarClientes(?)}");
            proc.setString(1, buscador.getText());
            res = proc.executeQuery();
            while (res.next()) {
                Object vector[] = new Object[7];
                for (int i = 0; i < vector.length; i++) {
                    vector[i] = res.getObject(i + 1);
                    tabla.getColumnModel().getColumn(i).setCellRenderer(alinearCentro);
                }
                modelo.addRow(vector);
            }
            conexiones.cierraConexion();
        } catch (SQLException e) {

        } catch (Exception e) {

        }
    }

    public boolean buscarCliente(String name) {
        try {
            conn = conexiones.Conexion();
            CallableStatement proc = conn.prepareCall("{call BuscarCliente(?)}");
            proc.setString(1, nombre.getText());
            res = proc.executeQuery();
            if (res.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: ");
            e.printStackTrace(System.out);
            conexiones.cierraConexion();
        } catch (Exception e) {
//            System.out.println("Error Genérico: ");
//            e.printStackTrace(System.out);
//            conexiones.cierraConexion();
        }
        return false;
    }

    public void limpiar() {
        id.setText("");
        nombre.setText("");
        direccion.setText("");
        telefono.setText("");
        ciudades.setSelectedIndex(0);
        email.setText("");
        rfc.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JTextField buscador;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> ciudades;
    private javax.swing.JTextField direccion;
    private javax.swing.JButton eliminar;
    private javax.swing.JTextField email;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel hora;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel marca;
    private javax.swing.JButton menu;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField rfc;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
