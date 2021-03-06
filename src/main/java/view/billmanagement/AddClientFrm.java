/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.billmanagement;

import controller.ClientDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Bill;
import model.Client;

/**
 *
 * @author Admin
 */
public class AddClientFrm extends javax.swing.JFrame implements ActionListener {

    private Bill bill;
    private ArrayList<Client> allClients;
    private ClientDAO clientDAO;
    private Client chosenClient;

    /**
     * Creates new form AddClientFrm
     */
    public AddClientFrm(Bill b) {
        this.bill = b;
        initComponents();
        this.setLocationRelativeTo(null);
        newClientDialog.setLocationRelativeTo(null);
        clientDAO = new ClientDAO();
        allClients = clientDAO.getAllClients();
        updateTable(allClients);
        this.btnNext.addActionListener(this);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newClientDialog = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        txtNewClientName = new javax.swing.JTextField();
        txtNewClientPhoneNumber = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNewClientAddress = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnNewClient = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtSearchKey = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnAddNewClient = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClient = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblClientID = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblClientName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblClientPhoneNumber = new javax.swing.JLabel();
        lblClientAddress = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        newClientDialog.setMinimumSize(new java.awt.Dimension(451, 300));
        newClientDialog.setModal(true);

        jLabel10.setText("T??n kh??ch h??ng");

        jLabel11.setText("S??? ??i???n tho???i");

        jLabel12.setText("?????a ch???");

        btnNewClient.setText("Th??m");
        btnNewClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout newClientDialogLayout = new javax.swing.GroupLayout(newClientDialog.getContentPane());
        newClientDialog.getContentPane().setLayout(newClientDialogLayout);
        newClientDialogLayout.setHorizontalGroup(
            newClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newClientDialogLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(newClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(newClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(newClientDialogLayout.createSequentialGroup()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtNewClientPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(newClientDialogLayout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtNewClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(newClientDialogLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(newClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNewClientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNewClient, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39))
        );
        newClientDialogLayout.setVerticalGroup(
            newClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newClientDialogLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(newClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNewClientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(newClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtNewClientPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(newClientDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNewClientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btnNewClient)
                .addGap(48, 48, 48))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("T??m kh??ch h??ng");

        btnSearch.setText("T??m");
        btnSearch.setActionCommand("");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnAddNewClient.setText("Th??m kh??ch h??ng");
        btnAddNewClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewClientActionPerformed(evt);
            }
        });

        tblClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M?? Kh??ch h??ng", "T??n kh??ch h??ng", "S??? ??i???n tho???i", "?????a ch???"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tblClient);

        jLabel2.setText("M?? kh??ch h??ng");

        lblClientID.setToolTipText("");

        jLabel4.setText("T??n kh??ch h??ng");

        jLabel6.setText("S??? ??i???n tho???i");

        jLabel9.setText("?????a ch???");

        btnNext.setText("Next");

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearchKey, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddNewClient))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblClientID, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblClientPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblClientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(32, 32, 32)
                                        .addComponent(lblClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 35, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearchKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(btnAddNewClient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(lblClientID, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(lblClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblClientPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblClientAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNext)
                            .addComponent(btnBack))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientMouseClicked
        int column = tblClient.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblClient.getRowHeight();
        if (row < tblClient.getRowCount() && row >= 0 && column < tblClient.getColumnCount() && column >= 0) {
            for (Client c : this.allClients) {
                if (c.getId() == Integer.parseInt(tblClient.getValueAt(row, 0).toString())) {
                    this.chosenClient = c;
                };

            }

            onChooseClient(chosenClient);
        }
    }//GEN-LAST:event_tblClientMouseClicked


    private void btnAddNewClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewClientActionPerformed
        newClientDialog.setVisible(true);
        String phoneNumberKey = txtNewClientPhoneNumber.getText();

        if (clientDAO.checkClientExistByPhoneNumber(phoneNumberKey)) {
            JOptionPane.showMessageDialog(null, "Kh??ch h??ng ???? t???n t???i !");
            return;

        }
        chosenClient = new Client();
        chosenClient.setName(txtNewClientName.getText());
        chosenClient.setAddress(txtNewClientAddress.getText());
        chosenClient.setPhoneNumber(txtNewClientPhoneNumber.getText());

        onChooseClient(chosenClient);


    }//GEN-LAST:event_btnAddNewClientActionPerformed

    private void btnNewClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewClientActionPerformed
        String newName = txtNewClientName.getText();
        String newPhoneNumber = txtNewClientPhoneNumber.getText();
        String newAddress = txtNewClientAddress.getText();

        if (newName == "") {
            JOptionPane.showMessageDialog(null, "Vui l??ng ??i???n t??n kh??ch h??ng !");
            return;
        }
        if (newPhoneNumber == "") {
            JOptionPane.showMessageDialog(null, "Vui l??ng ??i???n s??? ??i???n tho???i !");
            return;

        }
        if (newAddress == "") {
            JOptionPane.showMessageDialog(null, "Vui l??ng ??i???n ?????a ch??? !");
            return;

        }

        newClientDialog.setVisible(false);


    }//GEN-LAST:event_btnNewClientActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtSearchKey.getText() == "") {
            JOptionPane.showMessageDialog(null, "Vui l??ng nh???p t??n kh??ch h??ng !");
            return;
        }

        ArrayList<Client> searchClients = clientDAO.searchClient(txtSearchKey.getText());
        updateTable(searchClients);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        BillManagementFrm billManagementFrm = new BillManagementFrm(bill.getUser());
        billManagementFrm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewClient;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNewClient;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClientAddress;
    private javax.swing.JLabel lblClientID;
    private javax.swing.JLabel lblClientName;
    private javax.swing.JLabel lblClientPhoneNumber;
    private javax.swing.JDialog newClientDialog;
    private javax.swing.JTable tblClient;
    private javax.swing.JTextField txtNewClientAddress;
    private javax.swing.JTextField txtNewClientName;
    private javax.swing.JTextField txtNewClientPhoneNumber;
    private javax.swing.JTextField txtSearchKey;
    // End of variables declaration//GEN-END:variables

    private void updateTable(ArrayList<Client> clients) {
        String[][] data = new String[clients.size()][5];
        Client client = null;
        for (int i = 0; i < clients.size(); i++) {
            client = clients.get(i);

            data[i][0] = client.getId() + "";
            data[i][1] = client.getName();
            data[i][2] = client.getPhoneNumber();
            data[i][3] = client.getAddress();

        }
        DefaultTableModel model = new DefaultTableModel(data, new String[]{
            "M?? Kh??ch h??ng", "T??n kh??ch h??ng", "S??? ??i???n tho???i", "?????a ch???"
        });
        tblClient.setModel(model);

    }

    private void onChooseClient(Client client) {
        lblClientID.setText(client.getId() + "");
        lblClientName.setText(client.getName());
        lblClientPhoneNumber.setText(client.getPhoneNumber());
        lblClientAddress.setText(client.getAddress());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(chosenClient);
        bill.setClient(chosenClient);
        ConfirmCreateBillFrm confirmCreateBillFrm = new ConfirmCreateBillFrm(bill);
        confirmCreateBillFrm.setVisible(true);
        this.dispose();
    }

}
