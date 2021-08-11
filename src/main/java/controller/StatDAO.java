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
import model.Statistic;

/**
 *
 * @author Admin
 */
public class StatDAO extends DAO {

    public StatDAO() {
    }

    public ArrayList<Statistic> getAllStats() {
        ArrayList<Statistic> result = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select p.id as idProduct,p.productName,SUM(o.amount) as `saleAmount`,SUM(o.sellPrice) as `revenue` from tblproduct as  p left join tblOrderLine as o on p.id = o.idProduct group by p.id ");
            ResultSet rs = ps.executeQuery();
            Statistic stat = null;
            while (rs.next()) {
                stat = new Statistic();
                stat.setId(rs.getInt("idProduct"));
                stat.setProductName(rs.getString("productName"));
                stat.setSaleNumber(rs.getInt("saleAmount"));
                stat.setRevenue(rs.getInt("revenue"));
                result.add(stat);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return result;
    }

    public ArrayList<Statistic> getByProductName(String searchKey) {
        ArrayList<Statistic> result = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("select p.id as idProduct,p.productName,SUM(o.amount) as `saleAmount`,SUM(o.sellPrice) as `revenue` from tblproduct as  p left join tblOrderLine as o on p.id = o.idProduct where productName LIKE ? group by p.id  ;");
            ps.setString(1, "%" + searchKey + "%");
            ResultSet rs = ps.executeQuery();
            Statistic stat = null;
            while (rs.next()) {
                stat = new Statistic();
                stat.setId(rs.getInt("idProduct"));
                stat.setProductName(rs.getString("productName"));
                stat.setSaleNumber(rs.getInt("saleAmount"));
                stat.setRevenue(rs.getInt("revenue"));
                result.add(stat);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;

    }
}
