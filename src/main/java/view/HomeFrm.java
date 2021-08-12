/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.User;
import view.billmanagement.BillManagementFrm;
import view.productmanagement.ProductManagementFrm;
import view.stat.StatFrm;

/**
 *
 * @author Admin
 */
public class HomeFrm extends javax.swing.JFrame {
    private User user;
    /**
     * Creates new form HomeFrm
     */
    public HomeFrm(User u) {
        this.user = u;
        initComponents();
        this.setLocationRelativeTo(null);
        lblUserName.setText(user.getFullName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClientManagement = new javax.swing.JButton();
        btnProductManagement = new javax.swing.JButton();
        btnBillManagement = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnClientManagement.setText("Quản lý khách hàng");
        btnClientManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientManagementActionPerformed(evt);
            }
        });

        btnProductManagement.setText("Quản lý sản phẩm");
        btnProductManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductManagementActionPerformed(evt);
            }
        });

        btnBillManagement.setText("Quản lý hóa đơn");
        btnBillManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBillManagementActionPerformed(evt);
            }
        });

        jButton1.setText("Xem số liệu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Xin chào");

        lblUserName.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnClientManagement, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                        .addComponent(btnProductManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBillManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblUserName))
                .addGap(45, 45, 45)
                .addComponent(btnClientManagement)
                .addGap(30, 30, 30)
                .addComponent(btnProductManagement)
                .addGap(28, 28, 28)
                .addComponent(btnBillManagement)
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClientManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientManagementActionPerformed
        ClientManagementFrm clientManagementFrm = new ClientManagementFrm(user);
        clientManagementFrm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnClientManagementActionPerformed

    private void btnProductManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductManagementActionPerformed
        ProductManagementFrm productManagementFrm = new ProductManagementFrm(user);
        productManagementFrm.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnProductManagementActionPerformed

    private void btnBillManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillManagementActionPerformed
        BillManagementFrm billManagementFrm = new BillManagementFrm(user);
        billManagementFrm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBillManagementActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        StatFrm statFrm = new StatFrm(user);
        statFrm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBillManagement;
    private javax.swing.JButton btnClientManagement;
    private javax.swing.JButton btnProductManagement;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblUserName;
    // End of variables declaration//GEN-END:variables
}
