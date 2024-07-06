/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserSystem;

import PanelSystemAdmin.Form1;
//import PanelSystemAdmin.Form2;
import PanelSystemAdmin.Form2_1;
import PanelSystemAdmin.FormTransaksi;
import PanelSystemAdmin.Form3;
import PanelSystemAdmin.Form4;
//import PanelSystemAdmin.Form4_1;
import PanelSystemAdmin.Form5;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import raven.swing.EventNavigationBar;
import raven.swing.NavigationBackgroundColor;

/**
 *
 * @author ACER
 */
public class TestDesain extends javax.swing.JFrame {

    /**
     * Creates new form TestDesain
     */
    public TestDesain() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
         getContentPane().setBackground(new Color(240, 240, 240));
        navigationBar1.addItem(new ImageIcon(getClass().getResource("/icon/home.png")));
        navigationBar1.addItem(new ImageIcon(getClass().getResource("/icon/historyku.png")));
        navigationBar1.addItem(new ImageIcon(getClass().getResource("/icon/editbarang.png")));
        navigationBar1.addItem(new ImageIcon(getClass().getResource("/icon/pegawai.png")));
        navigationBar1.addItem(new ImageIcon(getClass().getResource("/icon/proses.png")));
        navigationBar1.addEvent(new EventNavigationBar() {
            @Override
            public void beforeSelected(int index) {
                if (index == 0) {
                   panelTransitions1.display(new Form1(), navigationBar1.getAnimator());
                } else if (index == 1) {
                    panelTransitions1.display(new Form2_1(), navigationBar1.getAnimator());
                } else if (index == 2) {
                    panelTransitions1.display(new Form3(), navigationBar1.getAnimator());
                } else if (index == 3) {
                    panelTransitions1.display(new Form4(), navigationBar1.getAnimator());
                } else if (index == 4) {
                    panelTransitions1.display(new Form5(), navigationBar1.getAnimator());
                }
            }

            @Override
            public void afterSelected(int index) {

            }
        });
        NavigationBackgroundColor nb = new NavigationBackgroundColor();
        nb.apply(getContentPane());
        nb.addColor(0, new Color(153, 153, 255));
        nb.addColor(1, new Color(153, 225, 255));
        nb.addColor(2, new Color(255, 153, 218));
        nb.addColor(3, new Color(126, 209, 132));
        nb.addColor(4, new Color(226, 222, 131));
        navigationBar1.setnavigationBackgroundColor(nb);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        materialTabbed1 = new tabbed.MaterialTabbed();
        navigationBar1 = new raven.swing.NavigationBar();
        panelTransitions1 = new raven.transitions.PanelTransitions();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout navigationBar1Layout = new javax.swing.GroupLayout(navigationBar1);
        navigationBar1.setLayout(navigationBar1Layout);
        navigationBar1Layout.setHorizontalGroup(
            navigationBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        navigationBar1Layout.setVerticalGroup(
            navigationBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navigationBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTransitions1, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTransitions1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(navigationBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
         navigationBar1.initSelectedIndex(0);
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
            java.util.logging.Logger.getLogger(TestDesain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestDesain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestDesain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestDesain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestDesain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tabbed.MaterialTabbed materialTabbed1;
    private raven.swing.NavigationBar navigationBar1;
    private raven.transitions.PanelTransitions panelTransitions1;
    // End of variables declaration//GEN-END:variables
}
