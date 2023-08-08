/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.views;

import bd.CN_Connection;
import bd.CN_GetData;
import modelo.Servicio;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Persona;
import modelo.Finca;
import subviews.FincasSubView;
import subviews.ServicioSubView;

/**
 *
 * @author HP
 */
public class ContratarServicio extends javax.swing.JPanel {

    CN_GetData getdata = new CN_GetData();
    private final CN_Connection db_connection = new CN_Connection();

    ArrayList<Servicio> listaServicio = new ArrayList<>();
    ArrayList<Persona> listaPersona = new ArrayList<>();
    ArrayList<Finca> listaFinca = new ArrayList<>();

//    public void llenar() {
//        try {
//            ResultSet data = getdata.GetServicios();
//            ResultSetMetaData dataPropietarios = data.getMetaData();
//            DefaultTableModel model = (DefaultTableModel) tbl_servicio.getModel();
//
//            int cols = dataPropietarios.getColumnCount();
//            for (int columnIndex = 1; columnIndex <= cols; columnIndex++) {
//                model.addColumn(dataPropietarios.getColumnName(columnIndex));
//            }
//
//            while (data.next()) {
//                Object[] rowData = new Object[cols];
//                for (int columnIndex = 1; columnIndex <= cols; columnIndex++) {
//                    rowData[columnIndex - 1] = data.getObject(columnIndex);
//                }
//                model.addRow(rowData);
//            }
//            tbl_servicio.setModel(model);
//            db_connection.CloseConnection();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//
//    }
//
//    public void VaciarTabla() {
//        DefaultTableModel model = (DefaultTableModel) tbl_servicio.getModel();
//        model.setRowCount(0);
//        model.setColumnCount(0);
//    }
    /**
     * Creates new form Servicios
     */
    public ContratarServicio() {
        initComponents();
//        llenar();
        traerServicios();
        llenarServicios();
        traerPropietarios();
        llenarPropietarios();

    }

    public void traerServicios() {
        try {
            ResultSet data = getdata.GetServicios();
            while (data.next()) {
                Servicio serv = new Servicio();
                serv.setId_servicio(data.getInt("id_servicio"));
                serv.setTipos_servicio(data.getString("tipo_servicio"));
                serv.setDescripcion(data.getString("descripcion"));
                serv.setCosto(data.getInt("costo"));
                listaServicio.add(serv);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void llenarServicios() {
        cmbServicio.removeAllItems();
        for (int i = 0; i < listaServicio.size(); i++) {
            cmbServicio.addItem(new Servicio(listaServicio.get(i).getId_servicio(), listaServicio.get(i).getTipos_servicio(), listaServicio.get(i).getDescripcion(), listaServicio.get(i).getCosto()));
        }
    }

    public void traerPropietarios() {
        try {
            ResultSet data = getdata.GetPropietarios();
            while (data.next()) {
                Persona perso = new Persona();
                perso.setId_persona(data.getInt("id_persona"));
                perso.setCedula(data.getString("cedula"));
                perso.setNombre(data.getString("nombre"));
                perso.setApellido(data.getString("apellido"));
                perso.setCorreo(data.getString("correo"));
                perso.setDireccion(data.getString("direccion"));
                perso.setTelefono(data.getString("telefono"));
                perso.setSexo(data.getString("sexo"));

                listaPersona.add(perso);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void llenarPropietarios() {
        cmbPropietarios.removeAllItems();
        for (int i = 0; i < listaPersona.size(); i++) {
            int id = listaPersona.get(i).getId_persona();
            String nombre = listaPersona.get(i).getNombre();
            String apellido = listaPersona.get(i).getApellido();
            String cedula = listaPersona.get(i).getCedula();
            String telefono = listaPersona.get(i).getTelefono();
            String direccion = listaPersona.get(i).getDireccion();
            String sexo = listaPersona.get(i).getSexo();
            String correo = listaPersona.get(i).getCorreo();

            cmbPropietarios.addItem(new Persona(id, cedula, nombre, apellido, direccion, telefono, sexo, correo));
        }
    }

    public void traerFincas(int id) {
        try {
            listaFinca.clear();
            ResultSet data = getdata.GetFincasByPropietario(id);
            while (data.next()) {
                Finca finc = new Finca();
                finc.setId(data.getInt("id_finca"));
                finc.setNombre(data.getString("nombre_finca"));
                finc.setTamanio(data.getInt("tamanio_m2"));
                finc.setCodigo(data.getString("codigo_ref"));
                finc.setDireccion(data.getString("direccion"));

                listaFinca.add(finc);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void llenarFincas() {
        cmbFinca.removeAllItems();
        for (int i = 0; i < listaFinca.size(); i++) {
            int id = listaFinca.get(i).getId();
            String nombre = listaFinca.get(i).getNombre();
            int tamanio = listaFinca.get(i).getTamanio();
            String codigo = listaFinca.get(i).getCodigo();
            String direccion = listaFinca.get(i).getDireccion();

            cmbFinca.addItem(new Finca(id, nombre, tamanio, codigo, direccion));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        mensaje1 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbServicio = new javax.swing.JComboBox<>();
        cmbPropietarios = new javax.swing.JComboBox<>();
        cmbFinca = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(750, 43));

        mensaje1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        mensaje1.setText("Contratar Servicios");

        jLabel1.setText("Servicio:");

        jLabel2.setText("Propietario:");

        jLabel3.setText("Finca: ");

        cmbPropietarios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPropietariosItemStateChanged(evt);
            }
        });
        cmbPropietarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPropietariosActionPerformed(evt);
            }
        });

        cmbFinca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFincaActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 102, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Contratar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(66, 66, 66))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(48, 48, 48)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbPropietarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbFinca, 0, 303, Short.MAX_VALUE))
                                .addGap(74, 74, 74)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cmbServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 221, Short.MAX_VALUE))))
                    .addComponent(mensaje1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mensaje1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPropietarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbFinca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(242, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 735, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPropietariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPropietariosActionPerformed

        int codigo = cmbPropietarios.getItemAt(cmbPropietarios.getSelectedIndex()).getId_persona();
        traerFincas(codigo);
        llenarFincas();

       // JOptionPane.showMessageDialog(null, "codigo: " + codigo);

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPropietariosActionPerformed

    private void cmbPropietariosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPropietariosItemStateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPropietariosItemStateChanged

    private void cmbFincaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFincaActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFincaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            int idFinca = cmbFinca.getItemAt(cmbFinca.getSelectedIndex()).getId();
            int idPersona = cmbPropietarios.getItemAt(cmbPropietarios.getSelectedIndex()).getId_persona();
            String nombreServicio = cmbServicio.getItemAt(cmbServicio.getSelectedIndex()).getTipos_servicio();
            int idServicio = cmbServicio.getItemAt(cmbServicio.getSelectedIndex()).getId_servicio();
            //  String nose =cmbFinca.getSelectedItem().toString();
            int input = JOptionPane.showConfirmDialog(null,
                    "Seguro que desea contratar el servicio " + nombreServicio + " ?", "Pantalla de confirmacion!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            // 0=ok
            if (input == JOptionPane.YES_OPTION) {

                getdata.AddFincaServicio(idFinca, idServicio,idPersona);
            }

      
        
        //System.out.println(input);
    }
    catch(NullPointerException ex
){
           System.out.println("no llege");
    }

    // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Finca> cmbFinca;
    private javax.swing.JComboBox<Persona> cmbPropietarios;
    private javax.swing.JComboBox<Servicio> cmbServicio;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private java.awt.Label mensaje1;
    // End of variables declaration//GEN-END:variables
}
