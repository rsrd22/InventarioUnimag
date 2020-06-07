/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vistas;

import Control.*;
import General.Utilidades;
import Modelo.ModeloEntrada;
import Modelo.ModeloGestorBusqueda;
import Modelo.ModeloInventario;
import Tablas.TablaRender;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author MERRY
 */
public class VistaEntradas extends javax.swing.JFrame {
    public String[] EncabezadoTblEntradas; 
    public DefaultTableModel modeloTblEntradas;
    private ControlEntrada controlEntradas;
    private ArrayList<ModeloEntrada>  ListamodeloEntradas;
    public VistaSalidas vs;
    public VistaInventario vi;
    public int banAgregar = 0;
    public VistaAgregarEntrada vae;
    public VistaInformacionEntrada vie;
    public int banInformacion = 0;
    
    /**
     * Creates new form VistaPrincipall
     */
    public VistaEntradas() {
        initComponents();
        this.setLocationRelativeTo(null);
        EncabezadoTblEntradas = new String[]{
            "No","Codigo", "Descripción", "Lote", 
            "Fecha Vencimiento", "Cantidad", "Fecha Entrada", "Ver Mas","Acción"
        };
        InicializarTblInventario();
    }

    public void InicializarTblInventario() {
        tblEntradas.setDefaultRenderer(Object.class, new TablaRender());
        
        modeloTblEntradas = new DefaultTableModel(EncabezadoTblEntradas, 0) {
            Class[] types = new Class[]{
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class
            };

            public Class getColumnClass(int col) {
                return types[col];
            }

            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        tblEntradas.setModel(modeloTblEntradas);

        tblEntradas.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblEntradas.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblEntradas.getColumnModel().getColumn(2).setPreferredWidth(350);
        tblEntradas.getColumnModel().getColumn(3).setPreferredWidth(80);
        tblEntradas.getColumnModel().getColumn(4).setPreferredWidth(80);
        tblEntradas.getColumnModel().getColumn(5).setPreferredWidth(80);
        tblEntradas.getColumnModel().getColumn(6).setPreferredWidth(90);
        tblEntradas.getColumnModel().getColumn(7).setPreferredWidth(80);
        tblEntradas.getColumnModel().getColumn(8).setPreferredWidth(80);
        
        tblEntradas.getTableHeader().setReorderingAllowed(false);

        for (int i = 0; i < modeloTblEntradas.getColumnCount(); i++) {
            tblEntradas.getColumnModel().getColumn(i).setResizable(false);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setFont(new Font("Tahoma", 0, 12));
            
//            if(i == 3 ){
//                tcr.setHorizontalAlignment(SwingConstants.RIGHT);
//               
//            }else{
                tcr.setHorizontalAlignment(SwingConstants.CENTER);
                
//            }
            tcr.setForeground(new Color(22, 108, 151));
            tblEntradas.getColumnModel().getColumn(i).setCellRenderer(tcr);
            
        }
        JTableHeader header = tblEntradas.getTableHeader();

        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setPreferredSize(new Dimension(0, 35));
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setVerticalAlignment(JLabel.CENTER);
        
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
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEntradas = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        pnlInventario = new javax.swing.JPanel();
        btnInventario = new javax.swing.JButton();
        pnlSalida = new javax.swing.JPanel();
        btnSalida = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnAgregarEntrada = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMinimumSize(new java.awt.Dimension(817, 521));
        jPanel1.setPreferredSize(new java.awt.Dimension(1068, 905));
        jPanel1.setLayout(new java.awt.GridBagLayout());

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
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = -9;
        gridBagConstraints.ipady = -4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        jPanel1.add(jLabel4, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu 32.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -35;
        gridBagConstraints.ipady = -11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 9, 1, 10);
        jPanel1.add(jButton1, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(22, 108, 151));
        jLabel5.setText("Entradas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 500;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 41, 0, 0);
        jPanel1.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(22, 108, 151));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Universidad del Magdalena");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 22, 0, 0);
        jPanel1.add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(22, 108, 151));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Laboratorio de Biologia Molecular");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 23, 0, 0);
        jPanel1.add(jLabel7, gridBagConstraints);

        tblEntradas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEntradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblEntradasMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblEntradas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 303;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 41, 8, 0);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        jSeparator2.setForeground(new java.awt.Color(22, 108, 151));
        jSeparator2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 41, 0, 48);
        jPanel1.add(jSeparator2, gridBagConstraints);

        pnlInventario.setBackground(new java.awt.Color(22, 108, 151));
        pnlInventario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 123, 50)));

        btnInventario.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnInventario.setForeground(new java.awt.Color(255, 255, 255));
        btnInventario.setText("Inventario");
        btnInventario.setBorderPainted(false);
        btnInventario.setContentAreaFilled(false);
        btnInventario.setFocusPainted(false);
        btnInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInventarioMouseExited(evt);
            }
        });
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInventarioLayout = new javax.swing.GroupLayout(pnlInventario);
        pnlInventario.setLayout(pnlInventarioLayout);
        pnlInventarioLayout.setHorizontalGroup(
            pnlInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInventario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlInventarioLayout.setVerticalGroup(
            pnlInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 10);
        jPanel1.add(pnlInventario, gridBagConstraints);

        pnlSalida.setBackground(new java.awt.Color(22, 108, 151));
        pnlSalida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 123, 50)));

        btnSalida.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnSalida.setForeground(new java.awt.Color(255, 255, 255));
        btnSalida.setText("Salidas");
        btnSalida.setBorderPainted(false);
        btnSalida.setContentAreaFilled(false);
        btnSalida.setFocusPainted(false);
        btnSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalidaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalidaMouseExited(evt);
            }
        });
        btnSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSalidaLayout = new javax.swing.GroupLayout(pnlSalida);
        pnlSalida.setLayout(pnlSalidaLayout);
        pnlSalidaLayout.setHorizontalGroup(
            pnlSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSalida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlSalidaLayout.setVerticalGroup(
            pnlSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(30, 10, 0, 0);
        jPanel1.add(pnlSalida, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(22, 108, 151));
        jLabel1.setText("Filtro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 41, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(22, 108, 151));
        jTextField1.setPreferredSize(new java.awt.Dimension(59, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 0);
        jPanel1.add(jTextField1, gridBagConstraints);

        btnAgregarEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnAgregarEntrada.setBorderPainted(false);
        btnAgregarEntrada.setContentAreaFilled(false);
        btnAgregarEntrada.setMaximumSize(new java.awt.Dimension(30, 30));
        btnAgregarEntrada.setMinimumSize(new java.awt.Dimension(30, 30));
        btnAgregarEntrada.setPreferredSize(new java.awt.Dimension(30, 30));
        btnAgregarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEntradaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        jPanel1.add(btnAgregarEntrada, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventarioMouseEntered
        Utilidades.establecerColorDeFondo(pnlInventario, true);
    }//GEN-LAST:event_btnInventarioMouseEntered

    private void btnInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventarioMouseExited
        Utilidades.establecerColorDeFondo(pnlInventario, false);
    }//GEN-LAST:event_btnInventarioMouseExited

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        this.dispose();
        vi = new VistaInventario();
        vi.setVisible(true);
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnSalidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalidaMouseEntered
        Utilidades.establecerColorDeFondo(pnlSalida, true);
    }//GEN-LAST:event_btnSalidaMouseEntered

    private void btnSalidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalidaMouseExited
        Utilidades.establecerColorDeFondo(pnlSalida, false);
    }//GEN-LAST:event_btnSalidaMouseExited

    private void btnSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaActionPerformed
        this.dispose();
        vs = new VistaSalidas();
        vs.setVisible(true);
    }//GEN-LAST:event_btnSalidaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        controlEntradas = new ControlEntrada();
        
        CargarEntradas();
        
    }//GEN-LAST:event_formWindowOpened

    private void btnAgregarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEntradaActionPerformed
        if(banAgregar == 0){
            banAgregar = 1;
            vae = new VistaAgregarEntrada(this);
            vae.setVisible(true);
        }else{
            vae.requestFocus();
        }
    }//GEN-LAST:event_btnAgregarEntradaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(banAgregar == 1){
            vae.dispose();
        }
        if(banInformacion == 1){
            vie.dispose();
        }
        
    }//GEN-LAST:event_formWindowClosed

    private void tblEntradasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEntradasMouseReleased
        int fila = tblEntradas.getSelectedRow();
        int cola = tblEntradas.getSelectedColumn();
        System.out.println("cola-->"+cola);
        if(cola == 7){//}VER MAS
            if(banInformacion == 0){
                banInformacion = 1;
                vie = new VistaInformacionEntrada(this, ListamodeloEntradas.get(fila));
                vie.setVisible(true);
            }else{
                vie.requestFocusInWindow();
            }
        } else if(cola == 8){// Acción Modificar
            if(banAgregar == 0){
                try {
                    banAgregar = 1;
                    System.out.println("ListamodeloEntradas.get(fila)-->"+ListamodeloEntradas.get(fila));
                    vae = new VistaAgregarEntrada(this, ListamodeloEntradas.get(fila));
                    vae.setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(VistaEntradas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                vae.requestFocus();
            }
        }
    }//GEN-LAST:event_tblEntradasMouseReleased

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
            java.util.logging.Logger.getLogger(VistaEntradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaEntradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaEntradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaEntradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaEntradas();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarEntrada;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnSalida;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel pnlInventario;
    private javax.swing.JPanel pnlSalida;
    private javax.swing.JTable tblEntradas;
    // End of variables declaration//GEN-END:variables

    public void CargarEntradas(){
        Utilidades.LimpiarTabla(tblEntradas);
        ListamodeloEntradas = (ArrayList<ModeloEntrada>) controlEntradas.ObtenerDatos();
        if(ListamodeloEntradas.size()>0){
//            "No","Codigo", "Descripción", "Lote", 
//            "Fecha Vencimiento", "Cantidad", "Fecha Entrada", "Ver Mas","Acción"
            for(int i =0; i < ListamodeloEntradas.size(); i++){
                Utilidades.agregarFilaTabla(modeloTblEntradas, 
                        new Object[]{
                            tblEntradas.getRowCount()+1,
                            ListamodeloEntradas.get(i).getCodigo_elemento(),
                            ListamodeloEntradas.get(i).getDescripcion_elemento(),
                            ListamodeloEntradas.get(i).getLote(),
                            ListamodeloEntradas.get(i).getFecha_vencimiento(),
                            ListamodeloEntradas.get(i).getCantidad(),
                            ListamodeloEntradas.get(i).getFecha_entrada(),
                            "Ver Mas",
                            "Modificar"
                        });
            }
        }else{
            
            Utilidades.agregarFilaTabla(modeloTblEntradas, 
                        new Object[]{"","",
                            "No se encontraron registros"
                        });
        }
    }


    public void RespuestaAgregarEntrada() {
        CargarEntradas();
    }

    
    
    
}
