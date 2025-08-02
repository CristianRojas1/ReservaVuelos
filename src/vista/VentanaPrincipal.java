/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;
import vista.PanelItinerarios;

import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class VentanaPrincipal extends javax.swing.JFrame {
    private CardLayout cardLayout;
    private JPanel contenedor;

    public VentanaPrincipal() {
        setTitle("Sistema de Reservas de Vuelos");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);

        // Crear instancias de los paneles
        PanelReservas panelReservas = new PanelReservas();
        PanelBusquedaVuelos panelBusqueda = new PanelBusquedaVuelos();
        PanelItinerarios panelItinerario = new PanelItinerarios();

        // Agregar paneles al contenedor
        contenedor.add(panelReservas, "reservas");
        contenedor.add(panelBusqueda, "busqueda");
        contenedor.add(panelItinerario, "itinerario");

        // Instanciar el panel con nombre en minúscula como está declarado
        vista.panelBotones panelBotones = new vista.panelBotones();

        // Asociar botones con cardLayout
        panelBotones.getBtnReservas().addActionListener(e -> cardLayout.show(contenedor, "reservas"));
        panelBotones.getBtnBusqueda().addActionListener(e -> cardLayout.show(contenedor, "busqueda"));
        panelBotones.getBtnItinerario().addActionListener(e -> cardLayout.show(contenedor, "itinerario"));

        // Agregar a la ventana
        setLayout(new BorderLayout());
        add(panelBotones, BorderLayout.NORTH);
        add(contenedor, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Mostrar la ventana
        EventQueue.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
