/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;


import javax.swing.JButton;
import javax.swing.JPanel;

public class panelBotones extends javax.swing.JPanel {

    public panelBotones() {
        initComponents();
    }



    // Métodos getter para que VentanaPrincipal pueda agregar listeners
    public JButton getBtnReservas() {
        return btnReservas;
    }

    public JButton getBtnBusqueda() {
        return btnBusqueda;
    }

public JButton getBtnItinerario() {
    return btnItinerario;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBusqueda = new javax.swing.JButton();
        btnItinerario = new javax.swing.JButton();
        btnReservas = new javax.swing.JButton();

        btnBusqueda.setText("Busqueda");
        btnBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaActionPerformed(evt);
            }
        });

        btnItinerario.setText("Itinerario");
        btnItinerario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItinerarioActionPerformed(evt);
            }
        });

        btnReservas.setText("Reservas");
        btnReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnReservas)
                .addGap(28, 28, 28)
                .addComponent(btnBusqueda)
                .addGap(52, 52, 52)
                .addComponent(btnItinerario)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReservas)
                    .addComponent(btnBusqueda)
                    .addComponent(btnItinerario))
                .addContainerGap(193, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void btnItinerarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItinerarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnItinerarioActionPerformed

    private void btnReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReservasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnItinerario;
    private javax.swing.JButton btnReservas;
    // End of variables declaration//GEN-END:variables
}
