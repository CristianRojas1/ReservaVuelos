/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import dao.ReservaDAO;
import dao.UsuarioDAO;
import dao.VueloDAO;
import modelo.Reserva;
import modelo.Usuario;
import modelo.Vuelo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import java.awt.Dimension;
import java.awt.Color;

public class PanelReservas extends javax.swing.JPanel {
   private final ReservaDAO reservaDAO = new ReservaDAO();
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final VueloDAO vueloDAO = new VueloDAO();

    private List<Usuario> listaUsuarios;
    private List<Vuelo> listaVuelos;
    
    
 public PanelReservas() {
    initComponents();
    setPreferredSize(new Dimension(900, 600));
    cargarUsuarios();
    cargarVuelos();
    cargarReservas();

    txtFechaReserva.setToolTipText("Ingrese fecha y hora en formato yyyy-MM-dd HH:mm:ss");
 }
 
 private void cargarUsuarios() {
        cmbUsuarios.removeAllItems();
        listaUsuarios = usuarioDAO.listarUsuarios();
        for (Usuario u : listaUsuarios) {
            cmbUsuarios.addItem(u.getNombre());
        }
        cmbUsuarios.setSelectedIndex(-1);
    }

private void cargarVuelos() {
    cmbVuelos.removeAllItems();
   listaVuelos = vueloDAO.listarTodosVuelos(); // O algún método para listar todos
    for (Vuelo v : listaVuelos) {
        // Usa un texto descriptivo, porque no tienes getDescripcion()
        String descripcion = v.getAerolinea() + " " + v.getOrigen() + " -> " + v.getDestino();
        cmbVuelos.addItem(descripcion);
    }
    cmbVuelos.setSelectedIndex(-1);
}

    private void cargarReservas() {
        List<Reserva> reservas = reservaDAO.listarReservas();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"ID", "Usuario", "Vuelo", "Asientos", "Fecha"});

        for (Reserva r : reservas) {
            String nombreUsuario = obtenerNombreUsuarioPorId(r.getIdUsuario());
            String descripcionVuelo = obtenerDescripcionVueloPorId(r.getIdVuelo());
            modelo.addRow(new Object[]{r.getIdReserva(), nombreUsuario, descripcionVuelo, r.getCantidadAsientos(), r.getFechaReserva()});
        }
        tblReservas.setModel(modelo);
    }
    
    private String obtenerNombreUsuarioPorId(int idUsuario) {
        return listaUsuarios.stream()
                .filter(u -> u.getId() == idUsuario)
                .map(Usuario::getNombre)
                .findFirst()
                .orElse("Desconocido");
    }

private String obtenerDescripcionVueloPorId(int idVuelo) {
    return listaVuelos.stream()
            .filter(v -> v.getId() == idVuelo)
            .map(v -> v.getOrigen() + " -> " + v.getDestino() + " (" + v.getAerolinea() + ")")
            .findFirst()
            .orElse("Desconocido");
}

    private Reserva leerReserva() throws ParseException {
        int idxUsuario = cmbUsuarios.getSelectedIndex();
        int idxVuelo = cmbVuelos.getSelectedIndex();

        if (idxUsuario < 0) throw new IllegalArgumentException("Seleccione un usuario");
        if (idxVuelo < 0) throw new IllegalArgumentException("Seleccione un vuelo");

        Usuario usuario = listaUsuarios.get(idxUsuario);
        Vuelo vuelo = listaVuelos.get(idxVuelo);

        String fechaStr = txtFechaReserva.getText().trim();
        if (fechaStr.isEmpty()) throw new IllegalArgumentException("Ingrese la fecha (yyyy-MM-dd)");

          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          java.util.Date fechaUtil = sdf.parse(fechaStr);
           Timestamp fecha = new Timestamp(fechaUtil.getTime());

        int cantidadAsientos;
        try {
            cantidadAsientos = Integer.parseInt(txtCantidadAsiento.getText().trim());
            if (cantidadAsientos <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ingrese una cantidad válida de asientos");
        }

        return new Reserva(usuario.getId(), vuelo.getId(), cantidadAsientos, fecha);
    }

    private void limpiarCampos() {
        cmbUsuarios.setSelectedIndex(-1);
        cmbVuelos.setSelectedIndex(-1);
        txtFechaReserva.setText("");
        txtCantidadAsiento.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbVuelos = new javax.swing.JComboBox<>();
        txtCantidadAsiento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmbUsuarios = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtFechaReserva = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalleReserva = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnReservar = new javax.swing.JButton();
        btnCancelarReserva = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();

        cmbVuelos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbVuelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVuelosActionPerformed(evt);
            }
        });

        txtCantidadAsiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadAsientoActionPerformed(evt);
            }
        });

        jLabel1.setText("detalle reserva");

        cmbUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUsuariosActionPerformed(evt);
            }
        });

        jLabel2.setText("Asientos a Reservar");

        txtFechaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaReservaActionPerformed(evt);
            }
        });

        jLabel3.setText("Fehca y Hora aReserva");

        txtDetalleReserva.setColumns(20);
        txtDetalleReserva.setRows(5);
        txtDetalleReserva.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtDetalleReservaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(txtDetalleReserva);

        jLabel4.setText("Usuario y Vuelo a Selecionar");

        btnReservar.setText("Reservar");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        btnCancelarReserva.setText("Cancelar");
        btnCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarReservaActionPerformed(evt);
            }
        });

        tblReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblReservas.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblReservasAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(tblReservas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnReservar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelarReserva))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtFechaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidadAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbVuelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnReservar)
                        .addComponent(btnCancelarReserva))
                    .addComponent(txtCantidadAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbVuelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVuelosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbVuelosActionPerformed

    private void txtCantidadAsientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadAsientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadAsientoActionPerformed

    private void cmbUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUsuariosActionPerformed

    private void txtFechaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaReservaActionPerformed

    private void txtDetalleReservaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtDetalleReservaAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDetalleReservaAncestorAdded

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        try {
            Reserva r = leerReserva();
            if (reservaDAO.insertarReserva(r)) {
                JOptionPane.showMessageDialog(this, "Reserva agregada con éxito");
                cargarReservas();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al agregar reserva");
            }
        } catch (IllegalArgumentException | ParseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnReservarActionPerformed

    private void btnCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarReservaActionPerformed
        int fila = tblReservas.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una reserva para cancelar");
            return;
        }
        int idReserva = (int) tblReservas.getValueAt(fila, 0);
        if (reservaDAO.eliminarReserva(idReserva)) {
            JOptionPane.showMessageDialog(this, "Reserva cancelada");
            cargarReservas();
        } else {
            JOptionPane.showMessageDialog(this, "Error al cancelar reserva");
        }
    }//GEN-LAST:event_btnCancelarReservaActionPerformed

    private void tblReservasAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblReservasAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tblReservasAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarReserva;
    private javax.swing.JButton btnReservar;
    private javax.swing.JComboBox<String> cmbUsuarios;
    private javax.swing.JComboBox<String> cmbVuelos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblReservas;
    private javax.swing.JTextField txtCantidadAsiento;
    private javax.swing.JTextArea txtDetalleReserva;
    private javax.swing.JTextField txtFechaReserva;
    // End of variables declaration//GEN-END:variables
}
