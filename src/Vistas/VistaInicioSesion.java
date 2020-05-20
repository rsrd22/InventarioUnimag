/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vistas;

import BaseDeDatos.gestorBD;
import Configuracion.ConfiguracionPropiedades;
import Control.ControlUsuarios;
import General.Utilidades;
import General.datosUsuario;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author MERRY
 */
public class VistaInicioSesion extends javax.swing.JFrame {
    VistaPrincipall vp;
    private final char MASCARA_CONTRASENIA = '●';
    private gestorBD gbd;
    boolean estadoContrasenia = false;
    private ArrayList<String[]> usuarios;
    ControlUsuarios usuario; 
    private int indice;
    /**
     * Creates new form VistaInicioSesion
     */
    public VistaInicioSesion() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        usuario = new ControlUsuarios();
        gbd = new gestorBD();
        usuarios = new ArrayList<>();
        vp = new VistaPrincipall();
        vp.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtcontrasena = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        btniniciarsesion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblmensaje = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(22, 108, 151));
        jLabel1.setText("Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(48, 207, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        txtusuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtusuario.setForeground(new java.awt.Color(22, 108, 151));
        txtusuario.setText("rsrd");
        txtusuario.setBorder(null);
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        txtusuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtusuarioFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 250;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 114, 0, 0);
        jPanel1.add(txtusuario, gridBagConstraints);

        jSeparator2.setForeground(new java.awt.Color(22, 108, 151));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 249;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 114, 0, 0);
        jPanel1.add(jSeparator2, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(22, 108, 151));
        jLabel2.setText("Contraseña");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 196, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        txtcontrasena.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtcontrasena.setForeground(new java.awt.Color(22, 108, 151));
        txtcontrasena.setBorder(null);
        txtcontrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontrasenaActionPerformed(evt);
            }
        });
        txtcontrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcontrasenaFocusLost(evt);
            }
        });
        txtcontrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcontrasenaKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 250;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 114, 0, 0);
        jPanel1.add(txtcontrasena, gridBagConstraints);

        jSeparator1.setForeground(new java.awt.Color(22, 108, 151));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 249;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 114, 0, 0);
        jPanel1.add(jSeparator1, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(22, 108, 151));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 123, 50)));

        btniniciarsesion.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btniniciarsesion.setForeground(new java.awt.Color(255, 255, 255));
        btniniciarsesion.setText("Iniciar Sesión");
        btniniciarsesion.setBorderPainted(false);
        btniniciarsesion.setContentAreaFilled(false);
        btniniciarsesion.setFocusPainted(false);
        btniniciarsesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btniniciarsesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btniniciarsesionMouseExited(evt);
            }
        });
        btniniciarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btniniciarsesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btniniciarsesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btniniciarsesion, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 162, 0, 0);
        jPanel1.add(jPanel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(22, 108, 151));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("He olvidado mi contraseña");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 39;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 132, 0, 0);
        jPanel1.add(jLabel3, gridBagConstraints);

        lblmensaje.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblmensaje.setForeground(new java.awt.Color(22, 108, 151));
        lblmensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 451;
        gridBagConstraints.ipady = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 10, 47, 20);
        jPanel1.add(lblmensaje, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/escudo.png"))); // NOI18N
        jLabel4.setToolTipText("LABORATORIO BIOLOGIA MOLECULAR");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel4.setAlignmentX(0.5F);
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = -9;
        gridBagConstraints.ipady = -4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 186, 0, 0);
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(22, 108, 151));
        jLabel5.setText("Laboratorio de Biologia Molecular");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 84, 0, 0);
        jPanel1.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(22, 108, 151));
        jLabel6.setText("Universidad del Magdalena");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 114, 0, 0);
        jPanel1.add(jLabel6, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txtusuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtusuarioFocusLost
        int bandera = 0;
        if (!txtusuario.getText().equals("")) {
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i)[1].toUpperCase().equals(txtusuario.getText().toUpperCase())) {
                    if (usuarios.get(i)[3].equals("Inactivo".toUpperCase())) {
                        bandera = 2;
                        indice = i;
                        break;
                    } else {
                        bandera = 1;
                        indice = i;
                        break;
                    }
                }
            }
            if (bandera == 0) {
                lblmensaje.setForeground(Color.red);
                lblmensaje.setText("<html><p align='center' color='#E67E22'>El usuario no existe.</p></html>");
                txtusuario.setText("");
                txtusuario.requestFocusInWindow();
            } else if (bandera == 2) {
                lblmensaje.setForeground(Color.red);
                lblmensaje.setText("<html><p align='center' color='#E67E22'>El usuario  se encuentra Inactivo, por favor comuniquese con el administrador del sistema.</p></html>");
                txtusuario.setText("");
                txtusuario.requestFocusInWindow();
            } else {
                lblmensaje.setText("");
                txtcontrasena.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_txtusuarioFocusLost

    private void txtcontrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontrasenaActionPerformed

    private void txtcontrasenaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcontrasenaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontrasenaFocusLost

    private void txtcontrasenaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontrasenaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Iniciarsesion();
        }
    }//GEN-LAST:event_txtcontrasenaKeyReleased

    private void btniniciarsesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btniniciarsesionMouseEntered
        Utilidades.establecerColorDeFondo(jPanel2, true);
    }//GEN-LAST:event_btniniciarsesionMouseEntered

    private void btniniciarsesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btniniciarsesionMouseExited
        Utilidades.establecerColorDeFondo(jPanel2, false);
    }//GEN-LAST:event_btniniciarsesionMouseExited

    private void btniniciarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniniciarsesionActionPerformed
        Iniciarsesion();
    }//GEN-LAST:event_btniniciarsesionActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        String user = txtusuario.getText();
        //new VistaRecuperarContrasenia(this).setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        getUsuario();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(VistaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    ConfiguracionPropiedades.cargarConfiguracion();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(VistaInicioSesion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(VistaInicioSesion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(VistaInicioSesion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(VistaInicioSesion.class.getName()).log(Level.SEVERE, null, ex);
                }
                VistaInicioSesion vistaInicioSesion = new VistaInicioSesion();
                vistaInicioSesion.setVisible(true);
            }
        });
    }
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btniniciarsesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblmensaje;
    private javax.swing.JPasswordField txtcontrasena;
    public javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables

    public void getUsuario() {
        //<editor-fold defaultstate="collapsed" desc="comment">
        System.out.println("getUsuario");
        //ID, USUARIO, CLAVE, ESTADO, CLAVE_DINAMICA
        usuarios = gbd.SELECT("SELECT id, usuario, clave, estado, clave_dinamica FROM usuarios");
        System.out.println("usuarios--->"+usuarios.size());
        //</editor-fold>
    }
    
    private void Iniciarsesion() {
        if (!txtcontrasena.getText().equals("")) {
            String clve = gbd.getClaveEncryptada(txtusuario.getText().toUpperCase(), txtcontrasena.getText());
            System.out.println("clve-->" + clve);
            if (!usuarios.get(indice)[2].equals(clve)) {
                lblmensaje.setForeground(Color.red);
                lblmensaje.setText("<html><p color='#E67E22'>La contraseña es incorrecta.</p></html>");
                txtcontrasena.setText("");
                txtcontrasena.requestFocusInWindow();
            } else {
                lblmensaje.setText("");
                //            control.getUsuarios(usuarios.get(indice)[0]);---
//                vprin.control = usuario.getUsuarios(usuarios.get(indice)[0]);  
                datosUsuario.datos = usuario.getUsuarios(usuarios.get(indice)[0]); 
//                vprin.passdin = usuarios.get(indice)[4]; 
                this.dispose();
                vp.setVisible(true);
                //vprin.IniciarComponentes();
                
            }
        }
    }
}
