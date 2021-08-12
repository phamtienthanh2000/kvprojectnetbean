package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Bill;
import model.Client;
import model.Description;
import model.OrderLine;
import model.Product;
import model.User;

public class BillDAO extends DAO {
    private ProductDAO productDAO;
    private Bill bill;
    private ClientDAO clientDAO;
    private OrderLineDAO orderLineDAO;

    public BillDAO() {
        productDAO = new ProductDAO();
        clientDAO = new ClientDAO();
        orderLineDAO = new OrderLineDAO();
    }

    public boolean createBill(Bill b) {
        this.bill = b;
        boolean result = true;
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps;

            // tao khach hangf
             Client client = bill.getClient();
            if (client.getId() == 0) {
                System.out.println(client.getName());

                ps = connection.prepareStatement("Insert into tblClient (`name`,address,phoneNumber)VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, client.getName());
                ps.setString(2, client.getAddress());
                ps.setString(3, client.getPhoneNumber());
                // cap nhat khach hang xong
                int rowCount = ps.executeUpdate();
                System.out.println("row count client : " + rowCount);
                if (rowCount < 0) {
                    System.out.println("Them khach hang that bai");
                } else {
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()) {
                        client.setId(rs.getInt(1));

                    }

                }

            }
            // insert bill de lay id truoc

            ps = connection.prepareStatement("Insert into tblBill(shipmentFee,deposit,discount,oweAmount,writeDate,idClient,idUser)VALUES(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, bill.getShipmentFee());
            ps.setInt(2, bill.getDeposit());
            ps.setInt(3, bill.getDiscount());
            ps.setInt(4, bill.getOweAmount());
            ps.setDate(5, java.sql.Date.valueOf(bill.getWriteDate()));
            ps.setInt(6, bill.getClient().getId());
            ps.setInt(7, bill.getUser().getId());
            int rowCount = ps.executeUpdate();
            if (rowCount > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    bill.setId(rs.getInt(1));
                }

            } else {
                System.out.println("Them hoa don that bai");
            }
            // insert orderLines
            ArrayList<OrderLine> orderLines = bill.getOrderLines();

            String addOrderLineSQL = "Insert into tblOrderLine(amount,sellPrice,idBill,idProduct)VALUES";
            for (OrderLine orderLine : orderLines) {

                Product product = orderLine.getProduct();
                addOrderLineSQL += "(" + orderLine.getAmount() + "," + orderLine.getSellPrice() + "," + bill.getId() + "," + product.getId() + "),";
                // tru so luong hang da tra
                product.setAmount(product.getAmount() - orderLine.getAmount());
                if (!productDAO.updateProduct(product)) {
                    System.out.println("chinh sua so luong that bai");

                };
            }

            addOrderLineSQL = addOrderLineSQL.substring(0, addOrderLineSQL.length() - 1);
            ps = connection.prepareStatement(addOrderLineSQL);
            int addRowCount = ps.executeUpdate();
            if (addRowCount < 0) {
                System.out.println("TThem orderLine that bai !");
            }
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            } catch (SQLException ex1) {
                ex1.printStackTrace();
                return false;
            }
        }

        return result;


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

    public boolean updateBill(Bill b) {
        boolean result = true;
        this.bill = b;
        try {

            PreparedStatement ps;

            connection.setAutoCommit(false);
            clientDAO.editClient(bill.getClient());
            String sqlAddOrderLine = "Insert into tblOrderLine(amount,sellPrice,idBill,idProduct)VALUES";
            // cac orderLine cu trong bill
            ArrayList<OrderLine> orderLines = orderLineDAO.getAllOrderLinesByBillId(bill.getId());
            // nguoi dung co the xoa di viet lai -> id = 0;
            for (int i = 0; i < orderLines.size(); i++) {
                OrderLine orderLine = orderLines.get(i);
                Product product = orderLine.getProduct();
                boolean remove = true;
                // cac orderLine moi - > id = 0
                for (OrderLine newOrderLine : bill.getOrderLines()) {
                    // du cu hay moi thi deu co chung productID
                    if (orderLine.getProduct().getId() == newOrderLine.getProduct().getId()) {
                        remove = false;
                        break;
                    }

                }
                if (remove == true) {

                    product.setAmount(product.getAmount() + orderLine.getAmount());
                    productDAO.updateProduct(product);
                    orderLineDAO.deleteOrderLineById(orderLine.getId());
                    orderLines.remove(i);
                }

            }
            boolean existNewOrderLine = false;
            // co the chua orderLine cu nhung duoc viet lai
            for (OrderLine orderLine : bill.getOrderLines()) {
                Product product = orderLine.getProduct();
                if (orderLine.getId() == 0) {
                    OrderLine checkExistOrderLine = orderLineDAO.findByIdProductAndIdBill(product.getId(), bill.getId());
                    if (checkExistOrderLine != null) {
                        // logic
                        int amountDiff = orderLine.getAmount() - checkExistOrderLine.getAmount();
                        product.setAmount(product.getAmount() - amountDiff);
                        productDAO.updateProduct(product);
                        checkExistOrderLine.setProduct(product);
                        checkExistOrderLine.setAmount(orderLine.getAmount());
                        checkExistOrderLine.setSellPrice(orderLine.getSellPrice());
                        orderLineDAO.updateOrderLine(checkExistOrderLine);
                    } else {
                        existNewOrderLine = true;
                        sqlAddOrderLine += "(" + orderLine.getAmount() + "," + orderLine.getSellPrice() + "," + bill.getId() + "," + product.getId() + "),";
                        product.setAmount(product.getAmount() - orderLine.getAmount());
                        productDAO.updateProduct(product);

                    }


                } else {
                    for (OrderLine oldOrderLine : orderLines) {
                        int amountDiff = 0;
                        if (oldOrderLine.getId() == orderLine.getId()) {
                            amountDiff = orderLine.getAmount() - oldOrderLine.getAmount();
                            // lay nhieu hon 
                            if (amountDiff > 0) {
                                product.setAmount(product.getAmount() - amountDiff);
                                
                            } else {
                                product.setAmount(product.getAmount() - amountDiff);

                            }
                            productDAO.updateProduct(product);
                            orderLineDAO.updateOrderLine(orderLine);
                            break;
                        }

                    }


                }
            }
            if (existNewOrderLine) {
                sqlAddOrderLine = sqlAddOrderLine.substring(0, sqlAddOrderLine.length() - 1);
                ps = connection.prepareStatement(sqlAddOrderLine);
                ps.executeUpdate();
            }


            ps = connection.prepareStatement("Update tblBill Set shipmentFee = ? ,deposit = ?, discount = ?,oweAmount = ? Where id = ?");
            ps.setInt(1, bill.getShipmentFee());
            ps.setInt(2, bill.getDeposit());
            ps.setInt(3, bill.getDiscount());
            ps.setInt(4, bill.getOweAmount());
            ps.setInt(5, bill.getId());
            ps.executeUpdate();

            connection.commit();


        } catch (Exception e) {
            try {
                connection.rollback();
                e.printStackTrace();
                return false;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }

        }

        return result;

    }

    public ArrayList<Bill> getBillsByProductId(int id) {
        ArrayList<Bill> result = new ArrayList<Bill>();
        try {
            PreparedStatement ps = connection.prepareStatement("select o.amount,o.sellPrice,(o.amount*o.sellPrice) as `total`,b.id as idBill, b.writeDate,c.id as `idClient`,c.`name` as `clientName`, u.fullName as `userFullName`  from tblorderline as o Inner join tblBill as b  on o.idBill = b.id left join tblClient as c on b.idClient = c.id left join tbluser as u on b.idUser = u.id where o.idProduct = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Bill bill = null;
            OrderLine orderLine = null;
            User user = null;
            Client client = null;
            while (rs.next()) {
                bill = new Bill();
                bill.setId(rs.getInt("idBill"));
                bill.setWriteDate(rs.getDate("writeDate").toLocalDate());
                orderLine = new OrderLine();
                orderLine.setAmount(rs.getInt("amount"));
                orderLine.setSellPrice(rs.getInt("sellPrice"));
                orderLine.setTotal(rs.getInt("total"));
                client = new Client();
                client.setId(rs.getInt("idClient"));
                client.setName(rs.getString("clientName"));
                user = new User();
                user.setFullName(rs.getString("userFullName"));
                bill.getOrderLines().add(orderLine);
                bill.setClient(client);
                bill.setUser(user);
                result.add(bill);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return result;

    }

    public ArrayList<Bill> getBillsByProductIdAndDateBetweenStartDateAndEndDate(int productID, LocalDate startDate, LocalDate endDate) {
        ArrayList<Bill> result = new ArrayList<Bill>();
        
        try {
            PreparedStatement ps = connection.prepareStatement("select o.amount,o.sellPrice,(o.amount*o.sellPrice) as `total`,b.id as idBill, b.writeDate,c.id as `idClient`,c.`name` as `clientName`, u.fullName as `userFullName`  from tblorderline as o Inner join tblBill as b  on o.idBill = b.id left join tblClient as c on b.idClient = c.id left join tbluser as u on b.idUser = u.id where o.idProduct = ? and b.writeDate between ? AND ?");
            ps.setInt(1, productID);
            ps.setDate(2, java.sql.Date.valueOf(startDate));
            ps.setDate(3, java.sql.Date.valueOf(endDate));
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            Bill bill = null;
            OrderLine orderLine = null;
            User user = null;
            Client client = null;
            while (rs.next()) {
                bill = new Bill();
                bill.setId(rs.getInt("idBill"));
                bill.setWriteDate(rs.getDate("writeDate").toLocalDate());
                orderLine = new OrderLine();
                orderLine.setAmount(rs.getInt("amount"));
                orderLine.setSellPrice(rs.getInt("sellPrice"));
                orderLine.setTotal(rs.getInt("total"));
                client = new Client();
                client.setId(rs.getInt("idClient"));
                client.setName(rs.getString("clientName"));
                user = new User();
                user.setFullName(rs.getString("userFullName"));
                bill.getOrderLines().add(orderLine);
                bill.setClient(client);
                bill.setUser(user);
                result.add(bill);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return result;
    }
}
