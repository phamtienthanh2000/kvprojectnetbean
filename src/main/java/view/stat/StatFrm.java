/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.stat;

import controller.StatDAO;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Statistic;
import model.User;
import view.HomeFrm;

/**
 *
 * @author Admin
 */
public class StatFrm extends javax.swing.JFrame {
    private User user;
    private ArrayList<Statistic> allStats;
    private StatDAO statDAO;
    /**
     * Creates new form StatFrm
     */
    public StatFrm(User u) {
        this.user = u;
        statDAO = new StatDAO();
        initComponents();
        loadTableData();
        lblTitle.setFont(new Font("Serif", Font.PLAIN, 20));
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSearchKey = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStat = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setText("Xem số liệu");

        jLabel2.setText("Nhập tên sản phẩm");

        txtSearchKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchKeyActionPerformed(evt);
            }
        });

        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblStat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No .", "Mã sản phẩm", "Tên sản phẩm", "Số lượng đã bán", "Lợi nhuận"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblStat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStatMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblStat);

        btnBack.setText("Quay Lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearchKey, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchKeyActionPerformed
    
    }//GEN-LAST:event_txtSearchKeyActionPerformed

    private void tblStatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStatMouseClicked
         int column = tblStat.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblStat.getRowHeight();
        if (row < tblStat.getRowCount() && row >= 0 && column < tblStat.getColumnCount() && column >= 0) {
            Statistic chosenStat = null;
            for (Statistic stat : allStats) {
                if(stat.getId() == Integer.parseInt(tblStat.getValueAt(row, 1).toString())){
                    chosenStat= stat;
                }

            }

            StatDetailFrm statDetailFrm = new StatDetailFrm(chosenStat,user);
            statDetailFrm.setVisible(true);

            this.dispose();
        }


    }//GEN-LAST:event_tblStatMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
            String searchKey = txtSearchKey.getText();
        if(searchKey.isBlank()||searchKey.isEmpty()){
        JOptionPane.showMessageDialog(null, "Vui lòng nhập tên sản phẩm");
            return;
        }
      ArrayList<Statistic> searchStats =   statDAO.getByProductName(searchKey);
        updateTable(searchStats);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        HomeFrm homeFrm = new HomeFrm(user);
        homeFrm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblStat;
    private javax.swing.JTextField txtSearchKey;
    // End of variables declaration//GEN-END:variables

    private void loadTableData() {
        this.allStats = statDAO.getAllStats();
        updateTable(allStats);

    }

    private void updateTable(ArrayList<Statistic> stats) {
        String[][] data = new String[stats.size()][5];
        for(int i = 0 ;i < stats.size();i++){
            Statistic stat = stats.get(i);
            data[i][0] = i+1+"";
            data[i][1] = stat.getId()+"";
            data[i][2] = stat.getProductName();
            data[i][3] = stat.getSaleNumber() + "";
            data[i][4] = stat.getRevenue() + "";

        }
        DefaultTableModel model = new DefaultTableModel(data, new String[]{"No .","Mã sản phẩm","Tên sản phẩm","Số lượng đã bán","Lợi nhuận"});
        tblStat.setModel(model);
    }
}
