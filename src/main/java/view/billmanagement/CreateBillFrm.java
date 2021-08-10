/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.billmanagement;

import controller.ProductDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Bill;
import model.OrderLine;
import model.Product;
import model.User;

/**
 *
 * @author Admin
 */
public class CreateBillFrm extends javax.swing.JFrame {

    private User user;
    private ProductDAO productDAO;
    private ArrayList<Product> allProducts;
    private ArrayList<OrderLine> addedOrderLines;

    /**
     * Creates new form CreateBillFrm
     */
    public CreateBillFrm(User u) {
        this.user = u;
        initComponents();
        productDAO = new ProductDAO();
        allProducts = productDAO.getAllProduct();
        addedOrderLines = new ArrayList<>();
        ArrayList<String> selection = new ArrayList<>();
        for (int i = 0; i < allProducts.size(); i++) {
            Product p = allProducts.get(i);

            selection.add(p.getProductName());
        }

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addAll(selection);
        cbxProductName.setModel(model);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrderLine = new javax.swing.JTable();
        cbxProductName = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSellPrice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        btnAddOrderline = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtShipmentFee = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDeposit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblOrderLine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No .", "Id sản phẩm", "Tên sản phẩm", "Số lượng", "Giá bán", "Thành tiền "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblOrderLine);

        cbxProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProductNameActionPerformed(evt);
            }
        });

        jLabel1.setText("Chọn mặt hàng");

        jLabel2.setText("Giá bán");

        jLabel3.setText("Số lượng");

        btnAddOrderline.setText("Thêm");
        btnAddOrderline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrderlineActionPerformed(evt);
            }
        });

        jLabel4.setText("Tiền vận chuyển");

        jLabel5.setText("Đặt trước");

        jLabel6.setText("Giảm giá");

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSellPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddOrderline))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtShipmentFee, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtSellPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddOrderline))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtShipmentFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(btnNext)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProductNameActionPerformed
        String selectedItem = cbxProductName.getSelectedItem().toString();
        txtAmount.setText("");
        for (Product p : allProducts) {
            if (p.getProductName().equalsIgnoreCase(selectedItem)) {

                txtSellPrice.setText(p.getStickerPrice() + "");
                break;
            }

        }


    }//GEN-LAST:event_cbxProductNameActionPerformed

    private void btnAddOrderlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrderlineActionPerformed

        if (cbxProductName.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm");
            return;

        }
        if (!Pattern.matches("^\\d{1,}$", txtSellPrice.getText())) {
            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra giá bán");
            return;

        }
        if (!Pattern.matches("^\\d{1,}$", txtAmount.getText())) {
            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra số lượng");
            return;

        }

        String selectedItem = cbxProductName.getSelectedItem().toString();

        for (Product p : allProducts) {
            if (p.getProductName().equalsIgnoreCase(selectedItem)) {
                boolean duplicate = false;

                for (OrderLine orderLine : addedOrderLines) {
                    Product product = orderLine.getProduct();
                    if (product.getProductName().equalsIgnoreCase(selectedItem)) {

                        duplicate = true;
                        break;
                    }
                }
                if (!duplicate) {
                    OrderLine orderLine = new OrderLine();
                    orderLine.setProduct(p);
                    orderLine.setAmount(Integer.parseInt(txtAmount.getText()));
                    orderLine.setSellPrice(Integer.parseInt(txtSellPrice.getText()));
                    orderLine.setTotal(orderLine.getTotal());
                    addedOrderLines.add(orderLine);
                    updateTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Sản phẩm đã được thêm !");

                }

                break;
            }

        }
    }//GEN-LAST:event_btnAddOrderlineActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (tblOrderLine.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Hãy chọn ít nhất 1 sản phẩm !");
            return;
        }
        String regexNumber = "^\\d{1,}$";
        if (!Pattern.matches(regexNumber, txtShipmentFee.getText())) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tiền vận chuyển !");
            return;
        }
        if (!Pattern.matches(regexNumber, txtDeposit.getText())) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tiền đặt trước !");
            return;
        }
        if (!Pattern.matches(regexNumber, txtDiscount.getText())) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mục giảm giá!");
            return;

        }
        
        Bill bill = new Bill();
        bill.setUser(this.user);
        bill.setShipmentFee(Integer.parseInt(txtShipmentFee.getText()));
        bill.setDeposit(Integer.parseInt(txtDeposit.getText()));
        bill.setDiscount(Integer.parseInt(txtDiscount.getText()));
        bill.setWriteDate(LocalDate.now());
        bill.setOrderLines(addedOrderLines);
        bill.setTotalAmount(bill.calculateTotalAmount());
        bill.setOweAmount(bill.getTotalAmount()-bill.getDeposit());
        bill.setStatus(bill.getOweAmount()>0?"Còn nợ":"Hết nợ");
        
        AddClientFrm addClientFrm = new AddClientFrm(bill);
        addClientFrm.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_btnNextActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddOrderline;
    private javax.swing.JButton btnNext;
    private javax.swing.JComboBox<String> cbxProductName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblOrderLine;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtDeposit;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtSellPrice;
    private javax.swing.JTextField txtShipmentFee;
    // End of variables declaration//GEN-END:variables

    private int calculateTableSum(ArrayList<OrderLine> orderLines) {
        int sum = 0;
        for (OrderLine orderLine : orderLines) {
            sum += orderLine.getTotal();
        }

        return sum;
    }

    private void updateTable() {
        String[][] data = new String[addedOrderLines.size() + 1][6];
        OrderLine orderLine = null;
        Product product = null;
        for (int i = 0; i <= addedOrderLines.size(); i++) {
            if (i == addedOrderLines.size()) {
                data[i][0] = "Tổng tiền hàng";
                data[i][tblOrderLine.getColumnCount() - 1] = calculateTableSum(addedOrderLines) + "";
                break;
            }

            orderLine = addedOrderLines.get(i);
            product = orderLine.getProduct();
            data[i][0] = i + 1 + "";
            data[i][1] = product.getId() + "";
            data[i][2] = product.getProductName();
            data[i][3] = orderLine.getAmount() + "";
            data[i][4] = orderLine.getSellPrice() + "";
            data[i][5] = orderLine.getTotal() + "";

        }

        DefaultTableModel model = new DefaultTableModel(data, new String[]{"No .", "Id sản phẩm", "Tên sản phẩm", "Số lượng", "Giá bán", "Thành tiền "});
        tblOrderLine.setModel(model);

    }
}
