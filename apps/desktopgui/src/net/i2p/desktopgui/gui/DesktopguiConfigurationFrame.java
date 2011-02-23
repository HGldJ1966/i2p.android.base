/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConfigurationFrame.java
 *
 * Created on Feb 16, 2011, 8:03:14 AM
 */

package net.i2p.desktopgui.gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.i2p.desktopgui.i18n.DesktopguiTranslator;
import net.i2p.desktopgui.router.RouterManager;

/**
 *
 * @author mathias
 */
public class DesktopguiConfigurationFrame extends javax.swing.JFrame {

    /** Creates new form ConfigurationFrame */
    public DesktopguiConfigurationFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopguiEnabled = new javax.swing.JCheckBox();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(_("Tray icon configuration"));

        desktopguiEnabled.setSelected(true);
        desktopguiEnabled.setText(_("Should tray icon be enabled?"));
        desktopguiEnabled.setActionCommand("shouldDesktopguiBeEnabled");

        okButton.setText("OK");
        okButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okButtonMouseClicked(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desktopguiEnabled)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton)))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopguiEnabled)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okButtonMouseClicked
        String property = "desktopgui.enabled";
        String value;
        if(!desktopguiEnabled.isSelected()) {
            value = "false";
            System.out.println("Disabling desktopgui");
        }
        else {
            value = "true";
            System.out.println("Enabling desktopgui");
        }
        try {
            RouterManager.getRouterContext().setProperty(property, value);
        } catch (Exception ex) {
            Logger.getLogger(DesktopguiConfigurationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Applying desktopgui configuration!");
        this.dispose();
    }//GEN-LAST:event_okButtonMouseClicked

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        System.out.println("Cancelling configuration!");
        this.dispose();
    }//GEN-LAST:event_cancelButtonMouseClicked

    protected static String _(String s) {
        return DesktopguiTranslator._(s);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox desktopguiEnabled;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

}