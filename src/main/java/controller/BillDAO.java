package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Bill;
import model.Client;
import controller.DAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Description;
import model.OrderLine;
import model.Product;
import model.User;

public class BillDAO extends DAO {

    private Bill bill;

    public boolean createBill(Bill b) {
        this.bill = b;
        PreparedStatement ps;
        int rowCount;
        try {
            // check client exist in db ?

            Client client = bill.getClient();
            if (client.getId() == 0) {
                ps = connection.prepareStatement("Insert into tblClient (`name`,address,phoneNumber)VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, client.getName());
                ps.setString(2, client.getAddress());
                ps.setString(3, client.getPhoneNumber());
                rowCount = ps.executeUpdate();
                if (rowCount > 0) {
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()) {
                        client.setId(rs.getInt(1));

                    }

                } else {
                    return false;

                }
            }

            ps = connection.prepareStatement("Insert into tblBill(shipmentFee,deposit,discount,oweAmount,writeDate,idClient,idUser)VALUES(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, bill.getShipmentFee());
            ps.setInt(2, bill.getDeposit());
            ps.setInt(3, bill.getDiscount());
            ps.setInt(4, bill.getOweAmount());
            ps.setDate(5, java.sql.Date.valueOf(bill.getWriteDate()));
            ps.setInt(6, bill.getClient().getId());
            ps.setInt(7, bill.getUser().getId());
            rowCount = ps.executeUpdate();
            // neu tao hoa don thanh cong roi
            if (rowCount > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    bill.setId(rs.getInt(1));
                    String sql = "Insert Into tblOrderline(amount,sellPrice,idBill,idProduct) VALUES";
                    int count = 0;
                    for (OrderLine orderLine : bill.getOrderLines()) {
                        if (count == bill.getOrderLines().size() - 1) {
                            sql += "(" + orderLine.getAmount() + "," + orderLine.getSellPrice() + "," + bill.getId() + "," + orderLine.getProduct().getId() + ")";
                            break;

                        }
                        sql += "(" + orderLine.getAmount() + "," + orderLine.getSellPrice() + "," + bill.getId() + "," + orderLine.getProduct().getId() + "),";

                        count++;
                    }

                    ps = connection.prepareStatement(sql);
                    rowCount = ps.executeUpdate();
                    // cac orderLine da dc cap nhat
                    if (rowCount > 0) {
                        String SQL = "Update tblProduct Set amount = ? Where id = ?";
                        for (OrderLine orderLine : bill.getOrderLines()) {
                            int boughtAmount = orderLine.getAmount();
                            ps = connection.prepareStatement(SQL);
                            ps.setInt(1, orderLine.getProduct().getAmount() - boughtAmount);
                            ps.setInt(2, orderLine.getProduct().getId());
                            rowCount = ps.executeUpdate();
                            return rowCount > 0;
                        }

                    } else {
                        return false;
                    }
                }

            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;

    }

    public ArrayList<Bill> getAllBillsGeneralInformation() {
        ArrayList<Bill> result = new ArrayList<Bill>();
        try {
            PreparedStatement ps = connection.prepareStatement("select b.id as idBill, b.shipmentFee,b.deposit,b.discount,b.oweAmount,b.writeDate,\n"
                    + "u.id as idUser,u.fullName,\n"
                    + " c.id as idClient,c.`name` as clientName ,c.address ,c.phoneNumber as clientPhoneNumber \n"
                    + " from tblBill as b left join tblUser as u  on b.idUser = u.id left join tblClient as c  on b.idClient = c.id");

            ResultSet rs = ps.executeQuery();
            Bill bill = null;
            User user = null;
            Client client = null;
            while (rs.next()) {
                bill = new Bill();
                bill.setId(rs.getInt("idBill"));
                bill.setShipmentFee(rs.getInt("shipmentfee"));
                bill.setDeposit(rs.getInt("deposit"));
                bill.setDiscount(rs.getInt("discount"));
                bill.setOweAmount(rs.getInt("oweAmount"));
                bill.setWriteDate(rs.getDate("writeDate").toLocalDate());

                user = new User();
                user.setId(rs.getInt("idUser"));
                user.setFullName(rs.getString("fullName"));
                client = new Client();
                client.setId(rs.getInt("idClient"));
                client.setName(rs.getString("clientName"));
                client.setAddress(rs.getString("address"));
                client.setPhoneNumber(rs.getString("clientPhoneNumber"));
                bill.setClient(client);
                bill.setUser(user);

                result.add(bill);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return result;

    }

    public ArrayList<Bill> searchBillsGeneralInformationByClientName(String key) {

        ArrayList<Bill> result = new ArrayList<Bill>();

        try {
            PreparedStatement ps = connection.prepareStatement(" select c.`name` as clientName,c.phoneNumber ,b.id as idBill,b.writeDate,u.fullName from tblClient c inner join tblbill b on c.id = b.idClient inner join tbluser as u Where c.`name` LIKE ?");
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            Bill bill = null;
            Client client = null;
            User user = null;
            while (rs.next()) {
                bill = new Bill();
                bill.setId(rs.getInt("idBill"));
                bill.setWriteDate(rs.getDate("writeDate").toLocalDate());
                user = new User();
                user.setFullName(rs.getString("fullName"));
                client = new Client();
                client.setName(rs.getString("clientName"));
                client.setPhoneNumber(rs.getString("c.phoneNumber"));
                bill.setClient(client);
                bill.setUser(user);
                result.add(bill);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return result;

    }

    public Bill getById(int idBill) {
        Bill result = null;
        try {
            PreparedStatement ps = connection.prepareStatement("select b.id as idBill ,b.shipmentFee, b.deposit, b.discount,b.oweAmount,b.writeDate,\r\n"
                    + " o.id as idOrderLine,o.amount,o.sellPrice,\r\n"
                    + " p.id as idProduct,p.productName,p.calculationUnit,p.amount as productAmount ,p.stickerPrice,\r\n"
                    + " d.origin ,d.supplyCompany,\r\n"
                    + " c.id as idClient,c.`name` as clientName,c.address,c.phoneNumber,\r\n"
                    + " u.id as idUser,u.fullName from \r\n"
                    + "tblBill b left join tblOrderLine  o on b.id = o.idBill \r\n"
                    + "left join tblClient c on b.idClient = c.id \r\n"
                    + "inner join tblUser u On  b.idUser = u.id\r\n"
                    + "left join tblProduct p on o.idProduct = p.id\r\n"
                    + "left join tblDescription d on p.id = d.idProduct\r\n"
                    + "where b.id = ?");
            ps.setInt(1, idBill);
            ResultSet rs = ps.executeQuery();

            Bill bill = new Bill();
            bill.setOrderLines(new ArrayList<OrderLine>());
            User user = null;
            Client client = null;
            while (rs.next()) {
                if (bill.getId() == 0) {
                    bill.setId(rs.getInt("idBill"));
                    bill.setShipmentFee(rs.getInt("shipmentFee"));
                    bill.setDeposit(rs.getInt("deposit"));
                    bill.setDiscount(rs.getInt("discount"));
                    bill.setOweAmount(rs.getInt("oweAmount"));
                    bill.setWriteDate(rs.getDate("writeDate").toLocalDate());
                    user = new User();
                    user.setFullName(rs.getString("fullName"));
                    client = new Client();
                    client.setId(rs.getInt("idClient"));
                    client.setName(rs.getString("clientName"));
                    client.setAddress(rs.getString("address"));
                    client.setPhoneNumber(rs.getString("phoneNumber"));
                    bill.setClient(client);
                    bill.setUser(user);
                }
                // set orderline
                OrderLine orderLine = new OrderLine();
                orderLine.setId(rs.getInt("idOrderLine"));
                orderLine.setAmount(rs.getInt("amount"));
                orderLine.setSellPrice(rs.getInt("sellPrice"));

                Product product = new Product();
                product.setId(rs.getInt("idProduct"));
                product.setProductName(rs.getString("productName"));
                product.setCalculationUnit(rs.getString("calculationUnit"));
                product.setAmount(rs.getInt("productAmount"));
                product.setStickerPrice(rs.getInt("stickerPrice"));

                Description description = new Description();
                description.setOrigin(rs.getString("origin"));
                description.setSupplyCompany(rs.getString("supplyCompany"));
                orderLine.setProduct(product);

                product.setDescription(description);

                orderLine.setProduct(product);
                bill.getOrderLines().add(orderLine);

            }
            return result = bill;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;

    }

    public boolean updateBill(Bill bill) {
        boolean result = true;

        try {
            connection.setAutoCommit(false);
            ClientDAO clientDAO = new ClientDAO();
            clientDAO.editClient(bill.getClient());
            String sqlAddOrderLine = "Insert into tblOrderLine(amount,sellPrice,idBill,idProduct)VALUES";
            String updateOrderLine = "Update tblOrderLine set amount = ?,sellPrice = ?,idProduct = ? Where id = ?";

            // xoa cac orderLine khong con
            OrderLineDAO orderLineDAO = new OrderLineDAO();
            // cac orderLine cu van con nhung chua update
            ProductDAO productDAO = new ProductDAO();

            ArrayList<OrderLine> orderLines = orderLineDAO.getAllOrderLinesByBillId(bill.getId());
            for (int i = 0; i < orderLines.size(); i++) {
                OrderLine orderLine = orderLines.get(i);
                boolean remove = true;
                for (OrderLine order : bill.getOrderLines()) {
                    if (orderLine.getId() == order.getId()) {
                        remove = false;
                        break;
                    }

                }
                if (remove == true) {
                    orderLine.getProduct().setAmount(orderLine.getProduct().getAmount() + orderLine.getAmount());
                    productDAO.updateProduct(orderLine.getProduct());
                     orderLineDAO.deleteOrderLineById(orderLine.getId());
                    orderLines.remove(i);
                }

            }

            ArrayList<OrderLine> newOrderLines = new ArrayList<>();

            for (OrderLine orderLine : bill.getOrderLines()) {

                if (orderLine.getId() == 0) {
                    newOrderLines.add(orderLine);
                    sqlAddOrderLine += "(" + orderLine.getAmount() + "," + orderLine.getSellPrice() + "," + bill.getId() + "," + orderLine.getProduct().getId() + "),";
                    // can thiep so luong product
                    orderLine.getProduct().setAmount(orderLine.getProduct().getAmount() - orderLine.getAmount());
                    productDAO.updateProduct(orderLine.getProduct());
                } else {
                    int chenhLechSoLuong = 0;

                    for (OrderLine getNumberOrderLine : orderLines) {
                        if (orderLine.getId() == getNumberOrderLine.getId()) {
                            chenhLechSoLuong = orderLine.getAmount() - getNumberOrderLine.getAmount();
                            // neu lay nhieu hnnhieu hon
                            if (chenhLechSoLuong > 0) {
                                getNumberOrderLine.getProduct().setAmount(getNumberOrderLine.getProduct().getAmount() - chenhLechSoLuong);

                            } else if (chenhLechSoLuong < 0) {
                                getNumberOrderLine.getProduct().setAmount(getNumberOrderLine.getProduct().getAmount() + chenhLechSoLuong);

                            }
                            productDAO.updateProduct(getNumberOrderLine.getProduct());

                        }

                    }

                    PreparedStatement ps = connection.prepareStatement(updateOrderLine);
                    ps.setInt(1, orderLine.getAmount());
                    ps.setInt(2, orderLine.getSellPrice());
                    ps.setInt(3, orderLine.getProduct().getId());
                    ps.setInt(4, orderLine.getId());
                    ps.executeUpdate();
                    //

                }

            }

            sqlAddOrderLine = sqlAddOrderLine.substring(0, sqlAddOrderLine.length() - 1);
            PreparedStatement ps = connection.prepareStatement(sqlAddOrderLine);
            ps.executeUpdate();

            PreparedStatement updateBillPs = connection.prepareStatement("Update tblBill Set shipmentFee = ? ,deposit = ?, discount = ?,oweAmount = ? Where id = ?");
            updateBillPs.setInt(1, bill.getShipmentFee());
            updateBillPs.setInt(2, bill.getDeposit());
            updateBillPs.setInt(3, bill.getDiscount());
            updateBillPs.setInt(4, bill.getOweAmount());
            updateBillPs.setInt(5, bill.getId());

            updateBillPs.executeUpdate();

        } catch (Exception ex) {
            try {
                result = false;
                connection.rollback();
                return result;
            } catch (SQLException ex1) {
                return false;
            }
        }
        try {
            connection.commit();
            connection.setAutoCommit(true);

            return true;
        } catch (Exception e) {
            try {
                connection.setAutoCommit(true);
                e.printStackTrace();
                return false;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }

    }
}
