/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import dao.ItinerarioDAO;
import modelo.Itinerario;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class PanelItinerarios extends javax.swing.JPanel {
    
    private final ItinerarioDAO itinDAO = new ItinerarioDAO();  // ÚNICO DAO
    private int idActual = -1;
    
    
    public PanelItinerarios() {
        initComponents();
    }
    private void limpiarCampos() {
        txtOrigen.setText("");
        txtDestino.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        idActual = -1;
    }
    private Itinerario leerItinerario() throws ParseException {
        String origen   = txtOrigen.getText().trim();
        String destino  = txtDestino.getText().trim();
        String fStr     = txtFecha.getText().trim();   // yyyy-MM-dd
        String hStr     = txtHora.getText().trim();    // HH:mm:ss

        if (origen.isEmpty() || destino.isEmpty() || fStr.isEmpty() || hStr.isEmpty())
            throw new IllegalArgumentException("Complete todos los campos");

        Date fecha = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(fStr).getTime());
        Time hora  = new Time(new SimpleDateFormat("HH:mm:ss").parse(hStr).getTime());

        return (idActual == -1)
               ? new Itinerario(origen, destino, fecha, hora)
               : new Itinerario(idActual, origen, destino, fecha, hora);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtOrigen = new javax.swing.JTextField();
        txtDestino = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        btnAgregarItinerario = new javax.swing.JButton();
        btnModificarItinerario = new javax.swing.JButton();
        btnEliminarItinerario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        txtOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrigenActionPerformed(evt);
            }
        });

        txtDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestinoActionPerformed(evt);
            }
        });

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        txtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraActionPerformed(evt);
            }
        });

        btnAgregarItinerario.setText("Agregar");
        btnAgregarItinerario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarItinerarioActionPerformed(evt);
            }
        });

        btnModificarItinerario.setText("Modificar");
        btnModificarItinerario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarItinerarioActionPerformed(evt);
            }
        });

        btnEliminarItinerario.setText("Eliminar");
        btnEliminarItinerario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarItinerarioActionPerformed(evt);
            }
        });

        jLabel1.setText("Modificar: Origen, Destino, Fecha,Hora");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregarItinerario)
                    .addComponent(btnModificarItinerario)
                    .addComponent(btnEliminarItinerario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(txtFecha)
                    .addComponent(txtHora)
                    .addComponent(txtOrigen))
                .addGap(129, 129, 129))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnAgregarItinerario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarItinerario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarItinerario)))
                .addGap(18, 18, 18)
                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrigenActionPerformed

    }//GEN-LAST:event_txtOrigenActionPerformed

    private void txtDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinoActionPerformed

    }//GEN-LAST:event_txtDestinoActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed

    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraActionPerformed

    }//GEN-LAST:event_txtHoraActionPerformed

    private void btnAgregarItinerarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarItinerarioActionPerformed
        try {
            Itinerario it = leerItinerario();
            if (itinDAO.agregarItinerario(it)) {
                JOptionPane.showMessageDialog(this, "Itinerario agregado");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al agregar");
            }
        } catch (IllegalArgumentException | ParseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnAgregarItinerarioActionPerformed

    private void btnModificarItinerarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarItinerarioActionPerformed
        if (idActual == -1) { JOptionPane.showMessageDialog(this,"Seleccione un itinerario"); return; }
        try {
            Itinerario it = leerItinerario();
            if (itinDAO.modificar(it)) {
                JOptionPane.showMessageDialog(this, "Modificado");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al modificar");
            }
        } catch (IllegalArgumentException | ParseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnModificarItinerarioActionPerformed

    private void btnEliminarItinerarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarItinerarioActionPerformed
        if (idActual == -1) { JOptionPane.showMessageDialog(this,"Seleccione un itinerario"); return; }
        if (itinDAO.eliminar(idActual)) {
            JOptionPane.showMessageDialog(this, "Eliminado");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar");
        }

    }//GEN-LAST:event_btnEliminarItinerarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarItinerario;
    private javax.swing.JButton btnEliminarItinerario;
    private javax.swing.JButton btnModificarItinerario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtOrigen;
    // End of variables declaration//GEN-END:variables
}
