/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Description;
import model.OrderLine;
import model.Product;

/**
 *
 * @author Admin
 */
public class OrderLineDAO extends DAO {

    public ArrayList<OrderLine> getAllOrderLinesByBillId(int idBill) {
        ArrayList<OrderLine> result = new ArrayList<>();

        try {

            PreparedStatement ps = connection.prepareStatement("select o.id as idOrderLine , o.amount as orderLineAmount, o.sellPrice , p.id as idProduct,p.productName,p.calculationUnit,p.amount as productAmount,p.stickerPrice,d.id as idDescription , d.origin,d.supplyCompany from tblOrderLine as o left join tblProduct as  p on o.idProduct = p.id  left join tblDescription as d on p.id = d.idProduct where o.idBill = ?");
            ps.setInt(1, idBill);
            ResultSet rs = ps.executeQuery();
            OrderLine orderLine = null;
            Product product = null;
            Description description = null;
            while (rs.next()) {
                orderLine = new OrderLine();
                
                orderLine.setId(rs.getInt("idOrderLine"));
                orderLine.setAmount(rs.getInt("orderLineAmount"));
                orderLine.setSellPrice(rs.getInt("sellPrice"));
                product = new Product();
                product.setId(rs.getInt("idProduct"));
                product.setProductName(rs.getString("productName"));
                product.setCalculationUnit(rs.getString("calculationUnit"));
                product.setAmount(rs.getInt("productAmount"));
                product.setStickerPrice(rs.getInt("stickerPrice"));

                description = new Description();
                description.setId(rs.getInt("idDescription"));
                description.setOrigin(rs.getString("origin"));
                description.setSupplyCompany(rs.getString("supplyCompany"));

                product.setDescription(description);
                orderLine.setProduct(product);

                result.add(orderLine);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderLineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
    
    public boolean deleteOrderLineById(int id){
        try {
            PreparedStatement ps= connection.prepareStatement("Delete from tblOrderLine Where id = ? ");
            ps.setInt(1, id);
            int rowCount = ps.executeUpdate();
            return  rowCount > 0;
        } catch (SQLException ex) {
            Logger.getLogger(OrderLineDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    
    }

    public boolean updateOrderLine(OrderLine orderLine) {
        try {
            String updateOrderLine = "Update tblOrderLine set amount = ?,sellPrice = ?,idProduct = ? Where id = ?";
            PreparedStatement ps = connection.prepareStatement(updateOrderLine);
            ps.setInt(1, orderLine.getAmount());
            ps.setInt(2, orderLine.getSellPrice());
            ps.setInt(3, orderLine.getProduct().getId());
            ps.setInt(4, orderLine.getId());
            int rowCount = ps.executeUpdate();
            return rowCount > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public OrderLine findByIdProductAndIdBill(int idProduct, int idBill) {
        OrderLine result = null;
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("select o.id as idOrderLine, o.amount as orderLineAmount,o.sellPrice ,p.id as idProduct,p.productName,p.calculationUnit,p.amount as productAmount, p.stickerPrice , d.id as idDescription, d.origin,d.supplyCompany from tblOrderLine as o left join tblProduct as p on o.idProduct = p.id left join tblDescription as d on  p.id = d.idProduct where o.idBill = ? And o.idProduct = ?");
            ps.setInt(1, idBill);
            ps.setInt(2, idProduct);
            ResultSet rs = ps.executeQuery();
            OrderLine orderLine = null;
            Product product = null;
            Description description = null;
            while (rs.next()) {
                orderLine = new OrderLine();

                orderLine.setId(rs.getInt("idOrderLine"));
                orderLine.setAmount(rs.getInt("orderLineAmount"));
                orderLine.setSellPrice(rs.getInt("sellPrice"));
                product = new Product();
                product.setId(rs.getInt("idProduct"));
                product.setProductName(rs.getString("productName"));
                product.setCalculationUnit(rs.getString("calculationUnit"));
                product.setAmount(rs.getInt("productAmount"));
                product.setStickerPrice(rs.getInt("stickerPrice"));

                description = new Description();
                description.setId(rs.getInt("idDescription"));
                description.setOrigin(rs.getString("origin"));
                description.setSupplyCompany(rs.getString("supplyCompany"));

                product.setDescription(description);
                orderLine.setProduct(product);

                result = orderLine;
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderLineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
