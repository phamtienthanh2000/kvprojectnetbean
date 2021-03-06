/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.billmanagement;

import controller.BillDAO;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Bill;
import model.OrderLine;
import model.Product;

/**
 *
 * @author Admin
 */
public class ConfirmCreateBillFrm extends javax.swing.JFrame {
    private Bill bill;
    /**
     * Creates new form ConfirmCreateBillFrm
     */
    public ConfirmCreateBillFrm(Bill b) {
        this.bill = b;
        initComponents();
        setLocationRelativeTo(null);
        this.setValue();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblClientName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblClientPhoneNumber = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrderLine = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblTotalAmount = new javax.swing.JLabel();
        lblShipmentFee = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblDiscount = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblDeposit = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblOweAmount = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblBillStatus = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblWriteDate = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("T??n kh??ch h??ng");

        lblClientName.setText("jLabel2");

        jLabel3.setText("S??? ??i???n tho???i");

        lblClientPhoneNumber.setText("jLabel2");

        jLabel5.setText("?????a ch???");

        lblAddress.setText("jLabel6");

        tblOrderLine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No .", "Id s???n ph???m", "T??n s???n ph???m", "S??? l?????ng", "Gi?? b??n", "Th??nh ti???n"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblOrderLine);

        jLabel7.setText("ph?? v???n chuy???n");

        jLabel8.setText("T???ng c???ng");

        lblTotalAmount.setText("jLabel9");

        lblShipmentFee.setText("jLabel10");

        jLabel11.setText("Gi???m gi??");

        lblDiscount.setText("jLabel12");

        jLabel13.setText("?????t tr?????c");

        lblDeposit.setText("jLabel14");

        jLabel15.setText("C??n l???i");

        lblOweAmount.setText("jLabel14");

        jLabel17.setText("Tr???ng th??i h??a ????n");

        lblBillStatus.setText("jLabel14");

        jLabel19.setText("Ng??y vi???t");

        lblWriteDate.setText("jLabel20");

        btnConfirm.setText("X??c nh???n");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnBack.setText("Quay L???i");
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblClientPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblWriteDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblOweAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblShipmentFee, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblBillStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193)
                        .addComponent(btnConfirm)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblClientName)
                    .addComponent(jLabel3)
                    .addComponent(lblClientPhoneNumber)
                    .addComponent(jLabel19)
                    .addComponent(lblWriteDate))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(lblTotalAmount)
                    .addComponent(lblShipmentFee)
                    .addComponent(jLabel11)
                    .addComponent(lblDiscount))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblBillStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(lblOweAmount)
                            .addComponent(jLabel17)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(lblDeposit)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm)
                    .addComponent(btnBack))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
       BillDAO billDAO = new BillDAO();
       if(billDAO.createBill(bill)){
       JOptionPane.showMessageDialog(null, "Th??m h??a ????n th??nh c??ng !");
       
       }else{
             JOptionPane.showMessageDialog(null, "Th??m h??a ????n th???t b???i!");
 
       
       };
        BillManagementFrm billManagementFrm = new BillManagementFrm(bill.getUser());
        billManagementFrm.setVisible(true);
        this.dispose();
        
        
        
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        BillManagementFrm billManagementFrm = new BillManagementFrm(bill.getUser());
        billManagementFrm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBillStatus;
    private javax.swing.JLabel lblClientName;
    private javax.swing.JLabel lblClientPhoneNumber;
    private javax.swing.JLabel lblDeposit;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblOweAmount;
    private javax.swing.JLabel lblShipmentFee;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JLabel lblWriteDate;
    private javax.swing.JTable tblOrderLine;
    // End of variables declaration//GEN-END:variables
private void setValue(){
this.lblClientName.setText(bill.getClient().getName());
this.lblClientPhoneNumber.setText(bill.getClient().getPhoneNumber());
String pattern = "dd/MM/yyyy";

this.lblWriteDate.setText(bill.getWriteDate().format(DateTimeFormatter.ofPattern("d-M-y")));
this.lblAddress.setText(bill.getClient().getAddress());
lblShipmentFee.setText(bill.getShipmentFee()+"");
lblTotalAmount.setText(bill.getTotalAmount()+"");
lblDiscount.setText(bill.getDiscount()+"");
lblDeposit.setText(bill.getDeposit()+"");
lblOweAmount.setText(bill.getOweAmount()+"");
lblBillStatus.setText(bill.getStatus());


updateTable();

}

    private void updateTable() {
       ArrayList<OrderLine> orderLines = this.bill.getOrderLines();
      String[][] data = new String[orderLines.size()+1][6];
      OrderLine orderLine = null;
      Product product = null;
      for(int i = 0 ; i <= orderLines.size();i++){
          if(i==orderLines.size()){
              data[i][0] ="T???ng ti???n h??ng";
              data[i][tblOrderLine.getColumnCount()-1] = calculateTableSum(orderLines)+"";
              break;
          }
      orderLine = orderLines.get(i);
      product = orderLine.getProduct();
      data[i][0] = i+1+"";
      data[i][1] = product.getId()+"";
      data[i][2] = product.getProductName();
      data[i][3] = orderLine.getAmount()+"";
      data[i][4] =orderLine.getSellPrice()+"";
      data[i][5] =orderLine.getTotal()+"";
      
      }
      DefaultTableModel model = new DefaultTableModel(data, new String [] {
                "No .", "Id s???n ph???m", "T??n s???n ph???m", "S??? l?????ng", "Gi?? b??n", "Th??nh ti???n"
            });
      tblOrderLine.setModel(model);
      
    }
      private int calculateTableSum(ArrayList<OrderLine> orderLines) {
        int sum = 0;
        for (OrderLine orderLine : orderLines) {
            sum += orderLine.getTotal();
        }

        return sum;
    }

 
      
}
