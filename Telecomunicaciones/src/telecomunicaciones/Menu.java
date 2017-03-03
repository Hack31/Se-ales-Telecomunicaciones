package telecomunicaciones;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        fondo();   
    }
 
    public void Salir() {
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Estas seguro?", "Salir de la Aplicacion", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.OK_OPTION == confirmar) {
            System.out.println("Salida Confirmado");
            System.exit(0);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        MenuArchivo = new javax.swing.JMenu();
        Comenzar = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        Desarrolladores = new javax.swing.JMenu();
        DesarrolladoPor = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(890, 510));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        MenuArchivo.setText("Archivo");

        Comenzar.setText("Comenzar");
        Comenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComenzarActionPerformed(evt);
            }
        });
        MenuArchivo.add(Comenzar);

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        MenuArchivo.add(Salir);

        jMenuBar1.add(MenuArchivo);

        Desarrolladores.setText("Ver");
        Desarrolladores.setPreferredSize(new java.awt.Dimension(30, 19));

        DesarrolladoPor.setText("Desarrolladores");
        DesarrolladoPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesarrolladoPorActionPerformed(evt);
            }
        });
        Desarrolladores.add(DesarrolladoPor);

        jMenuBar1.add(Desarrolladores);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       Salir();
    }//GEN-LAST:event_formWindowClosing

    private void DesarrolladoPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesarrolladoPorActionPerformed
         String Desarrolladores = " Kender Correia\n Juliannys Margoy\n Rosibel Vicent"; //Nombre de los Desarrolladores
        JOptionPane.showMessageDialog(null, "Aplicacion Desarrollada Por:\n"+Desarrolladores, "Desarrolladores", JOptionPane.NO_OPTION);
    }//GEN-LAST:event_DesarrolladoPorActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        Salir();
    }//GEN-LAST:event_SalirActionPerformed

    private void ComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComenzarActionPerformed
        Graficas nueva = new Graficas();
        nueva.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ComenzarActionPerformed
    public void fondo(){ 
        setLocationRelativeTo(null);
        setResizable(false);
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Imagenes/FondoLautcom.png"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
        this.setTitle("Modulacion Angular FM - PM");
    }
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Comenzar;
    private javax.swing.JMenuItem DesarrolladoPor;
    private javax.swing.JMenu Desarrolladores;
    private javax.swing.JMenu MenuArchivo;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
