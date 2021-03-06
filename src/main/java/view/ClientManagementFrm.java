/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClientDAO;
import java.awt.Font;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Client;
import model.User;

/**
 *
 * @author Admin
 */
public class ClientManagementFrm extends javax.swing.JFrame {

    private User user;
    private Client chosenClient;
    private ArrayList<Client> allClients;
    private ArrayList<Client> clientSearchList;

    /**
     * Creates new form ClientManagementFrm
     */
    public ClientManagementFrm(User u) {
        this.user = u;
        initComponents();
        this.setLocationRelativeTo(null);
        this.addClientDialog.setLocationRelativeTo(null);
        this.editClientDialog.setLocationRelativeTo(null);
        lblTitle.setFont(new Font("Serif", Font.PLAIN, 20));

        ClientDAO clientDAO = new ClientDAO();
        allClients = clientDAO.getAllClients();

        loadClientTableData(allClients);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addClientDialog = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtClientName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        editClientDialog = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnSaveUpdate = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtUpdateClientAddress = new javax.swing.JTextField();
        txtUpdateClientPhonenumber = new javax.swing.JTextField();
        txtUpdateClientName = new javax.swing.JTextField();
        jDialog1 = new javax.swing.JDialog();
        btnCreateClient = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClient = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();

        addClientDialog.setMinimumSize(new java.awt.Dimension(400, 400));
        addClientDialog.setModal(true);

        jLabel1.setText("T??n kh??ch h??ng");

        jLabel2.setText("S??? ??i???n tho???i");

        txtClientName.setToolTipText("");

        jLabel3.setText("?????a ch???");

        btnAdd.setText("Th??m");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel4.setText("Th??m m???i kh??ch h??ng");

        javax.swing.GroupLayout addClientDialogLayout = new javax.swing.GroupLayout(addClientDialog.getContentPane());
        addClientDialog.getContentPane().setLayout(addClientDialogLayout);
        addClientDialogLayout.setHorizontalGroup(
            addClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addClientDialogLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(addClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addClientDialogLayout.createSequentialGroup()
                        .addGroup(addClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addClientDialogLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addClientDialogLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39))
                    .addGroup(addClientDialogLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addClientDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(addClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addClientDialogLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addClientDialogLayout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(154, 154, 154))))
            .addGroup(addClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addClientDialogLayout.createSequentialGroup()
                    .addContainerGap(157, Short.MAX_VALUE)
                    .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(38, 38, 38)))
        );
        addClientDialogLayout.setVerticalGroup(
            addClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addClientDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(addClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(addClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(btnAdd)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(addClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addClientDialogLayout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(219, Short.MAX_VALUE)))
        );

        editClientDialog.setMinimumSize(new java.awt.Dimension(400, 400));
        editClientDialog.setModal(true);

        jLabel7.setText("T??n kh??ch h??ng");

        jLabel8.setText("S??? ??i???n tho???i");

        jLabel9.setText("?????a ch???");

        btnSaveUpdate.setText("L??u");
        btnSaveUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveUpdateActionPerformed(evt);
            }
        });

        jLabel11.setText("S???a Th??ng tin kh??ch h??ng");

        javax.swing.GroupLayout editClientDialogLayout = new javax.swing.GroupLayout(editClientDialog.getContentPane());
        editClientDialog.getContentPane().setLayout(editClientDialogLayout);
        editClientDialogLayout.setHorizontalGroup(
            editClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editClientDialogLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(editClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(editClientDialogLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUpdateClientPhonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editClientDialogLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUpdateClientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editClientDialogLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtUpdateClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56))
            .addGroup(editClientDialogLayout.createSequentialGroup()
                .addGroup(editClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editClientDialogLayout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel10))
                    .addGroup(editClientDialogLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel11))
                    .addGroup(editClientDialogLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(btnSaveUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editClientDialogLayout.setVerticalGroup(
            editClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editClientDialogLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGap(22, 22, 22)
                .addGroup(editClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtUpdateClientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editClientDialogLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(24, 24, 24)
                        .addGroup(editClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtUpdateClientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtUpdateClientPhonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnSaveUpdate)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCreateClient.setText("Th??m kh??ch h??ng");
        btnCreateClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateClientActionPerformed(evt);
            }
        });

        tblClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "M?? kh??ch h??ng", "T??n kh??ch h??ng", "S??? ??i???n tho???i", "?????a ch???"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblClient);

        lblTitle.setText("Qu???n l?? kh??ch h??ng");

        btnEdit.setText("S???a ");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("X??a");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel6.setText("Nh???p t??n kh??ch h??ng");

        btnSearch.setText("T??m");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnBack.setText("Quay l???i");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btnCreateClient)
                        .addGap(74, 74, 74)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(lblTitle))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6))
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreateClient)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // nut them cua main frame
    private void btnCreateClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateClientActionPerformed
        this.addClientDialog.setVisible(true);
        loadClientTableData(allClients);

    }//GEN-LAST:event_btnCreateClientActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        String clientName = this.txtClientName.getText();
        String clientPhoneNumber = this.txtPhoneNumber.getText();
        String clientAddress = this.txtAddress.getText();
        if (clientName.isBlank() || clientName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui l??ng nh???p t??n kh??ch h??ng h???p l???");
            return;

        }
        if (!Pattern.matches("^0[981]{1}\\d{8,9}$", clientPhoneNumber)) {
            JOptionPane.showMessageDialog(null, "Vui l??ng nh???p s??? ??i???n tho???i h???p l???");
            return;
        }
        if (clientAddress.isBlank() || clientAddress.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui l??ng nh???p ?????a ch??? h???p l???");
            return;
        }
        Client client = new Client();
        client.setName(txtClientName.getText());
        client.setPhoneNumber(txtPhoneNumber.getText());
        client.setAddress(txtAddress.getText());
        ClientDAO clientDAO = new ClientDAO();
        if (clientDAO.createClient(client)) {
            JOptionPane.showMessageDialog(null, "Th??m kh??ch h??ng th??nh c??ng! ");
            allClients.add(client);


        } else {
            JOptionPane.showMessageDialog(null, "Th??m kh??ch h??ng th???t b???i!");

        };

        //        HomeFrm homeFrm = new HomeFrm(user);
         //      homeFrm.setVisible(true);
        //    this.dispose();
        this.addClientDialog.setVisible(false);


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String searchKey = this.txtSearch.getText();
        if (searchKey.isBlank() || searchKey.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui l??ng nh???p t??n kh??ch h??ng !");
            return;
        }
        ClientDAO clientDAO = new ClientDAO();
        clientSearchList = clientDAO.searchClient(searchKey);
        String[][] data = new String[clientSearchList.size()][5];
        for (int i = 0; i < clientSearchList.size(); i++) {
            Client client = clientSearchList.get(i);
            data[i][0] = i + 1 + "";
            data[i][1] = client.getId() + "";
            data[i][2] = client.getName();
            data[i][3] = client.getPhoneNumber();
            data[i][4] = client.getAddress();
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, new String[]{"No.", "M?? kh??ch h??ng", "T??n kh??ch h??ng", "S??? ??i???n tho???i", "?????a ch???"});
        tblClient.setModel(defaultTableModel);


    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientMouseClicked
        int column = tblClient.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblClient.getRowHeight();
        if (row < tblClient.getRowCount() && row >= 0 && column < tblClient.getColumnCount() && column >= 0) {
            for (Client c : this.allClients) {
                if (c.getId() == Integer.parseInt(tblClient.getValueAt(row, 1).toString())) {
                    this.chosenClient = c;
                };

            }
        }
    }//GEN-LAST:event_tblClientMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (this.chosenClient == null) {
            JOptionPane.showMessageDialog(null, "Xin h??y ch???n m???t kh??ch h??ng trong b???ng !");
            return;
        }

        txtUpdateClientName.setText(chosenClient.getName());
        txtUpdateClientAddress.setText(chosenClient.getAddress());
        txtUpdateClientPhonenumber.setText(chosenClient.getPhoneNumber());
        this.editClientDialog.setVisible(true);
 

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveUpdateActionPerformed
        String updateName = this.txtUpdateClientName.getText();
        String updateAddress = this.txtUpdateClientAddress.getText();
        String updatePhoneNumber = this.txtUpdateClientPhonenumber.getText();

        if (updateName.isBlank() || updateName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui l??ng ??i???n t??n kh??ch h??ng");
            return;
        }
        if (updateAddress.isBlank() || updateAddress.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui l??ng ??i???n ?????a ch???");
            return;

        }
        if (updatePhoneNumber.isBlank() || updatePhoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui l??ng ??i???n s??? ??i???n tho???i");
            return;

        }
        Client test = new Client();
        test.setId(chosenClient.getId());
        test.setName(updateName);
        test.setAddress(updateAddress);
        test.setPhoneNumber(updatePhoneNumber);
       
        ClientDAO clientDAO = new ClientDAO();

        if (clientDAO.editClient(test)) {
            JOptionPane.showMessageDialog(null, "C???p nh???t kh??ch h??ng th??nh c??ng !");
            chosenClient.setName(updateName);
            chosenClient.setAddress(updateAddress);
            chosenClient.setPhoneNumber(updatePhoneNumber);
          loadClientTableData(allClients);



        } else {
            JOptionPane.showMessageDialog(null, "C???p nh???t kh??ch h??ng th???t b???i !");
            txtUpdateClientName.setText(chosenClient.getName());
            txtUpdateClientAddress.setText(chosenClient.getAddress());
            txtUpdateClientPhonenumber.setText(chosenClient.getPhoneNumber());
        }



        editClientDialog.setVisible(false);

    }//GEN-LAST:event_btnSaveUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (chosenClient == null) {
            JOptionPane.showMessageDialog(null, "Vui l??ng ch???n m???t kh??ch h??ng trong b???ng !");
            return;
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "X??c nh???n x??a kh??ch h??ng : " + chosenClient.getName() + "?", "X??a kh??ch h??ng", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                ClientDAO clientDAO = new ClientDAO();
                if (clientDAO.deleteClient(chosenClient.getId())) {
                    for( int i = 0 ; i < allClients.size() ; i++){
                        Client client = allClients.get(i);
                        if (client.getId()==chosenClient.getId()){
                        allClients.remove(i);
                            break;
                        }


                    }

                    JOptionPane.showMessageDialog(null, "X??a kh??ch h??ng th??nh c??ng!");
                    loadClientTableData(allClients);
                } else {
                    chosenClient = null;
                    JOptionPane.showMessageDialog(null, "X??a kh??ch h??ng th???t b???i!");
                };
            }

        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        HomeFrm homeFrm = new HomeFrm(user);
        homeFrm.setVisible(true);
        addClientDialog.setLocationRelativeTo(this);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog addClientDialog;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateClient;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSaveUpdate;
    private javax.swing.JButton btnSearch;
    private javax.swing.JDialog editClientDialog;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblClient;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtClientName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtUpdateClientAddress;
    private javax.swing.JTextField txtUpdateClientName;
    private javax.swing.JTextField txtUpdateClientPhonenumber;
    // End of variables declaration//GEN-END:variables

    private void loadClientTableData(ArrayList<Client> clientList) {
        String[][] data = new String[clientList.size()][5];
        for (int i = 0; i < clientList.size(); i++) {
            Client client = clientList.get(i);
            data[i][0] = i + 1 + "";
            data[i][1] = client.getId() + "";
            data[i][2] = client.getName();
            data[i][3] = client.getPhoneNumber();
            data[i][4] = client.getAddress();
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, new String[]{"No.", "M?? kh??ch h??ng", "T??n kh??ch h??ng", "S??? ??i???n tho???i", "?????a ch???"});
        tblClient.setModel(defaultTableModel);


}

}
