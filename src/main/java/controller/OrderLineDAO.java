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
import model.OrderLine;

/**
 *
 * @author Admin
 */
public class OrderLineDAO extends DAO {

    public ArrayList<OrderLine> getAllOrderLinesByBillId(int idBill) {
        ArrayList<OrderLine> result = new ArrayList<>();

        try {

            PreparedStatement ps = connection.prepareStatement("Select * from tblOrderLine Where idBill = ?");
            ps.setInt(1, idBill);
            ResultSet rs = ps.executeQuery();
            OrderLine orderLine = null;
            while (rs.next()) {
                orderLine = new OrderLine();

                orderLine.setId(rs.getInt("id"));
                orderLine.setAmount(rs.getInt("amount"));
                orderLine.setSellPrice(rs.getInt("sellPrice"));
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

}
