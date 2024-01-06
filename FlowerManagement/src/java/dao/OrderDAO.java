package dao;

import dto.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mylib.DBUtils;

public class OrderDAO {

    public static ArrayList<Order> viewOrder() throws Exception {
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnetion();
        if (cn != null) {
            String sql = "SELECT [OrderID],[OrderDate],[OrderStatus],[ShipperID],[CusID] FROM [dbo].[Order]";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int orderID = rs.getInt("OrderID");
                    Date orderDate = rs.getDate("OrderDate");
                    int orderStatus = rs.getInt("OrderStatus");
                    String ShipperID = rs.getString("ShipperID");
                    int cusID = rs.getInt("CusID");
                    Order o = new Order(orderID, orderDate, orderStatus, ShipperID, cusID);
                    list.add(o);
                }
            }
            cn.close();
        }
        return list;
    }

    public static ArrayList<Order> searchOrderByCusID(int cusid) throws Exception {
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnetion();
        if (cn != null) {
            String sql = "SELECT [OrderID],[OrderDate],[OrderStatus],[ShipperID],[CusID] FROM [dbo].[Order] WHERE [CusID] = ?";
            PreparedStatement pst = cn.prepareCall(sql);
            pst.setInt(1, cusid);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int orderID = rs.getInt("OrderID");
                    Date orderDate = rs.getDate("OrderDate");
                    int orderStatus = rs.getInt("OrderStatus");
                    String shipperID = rs.getString("ShipperID");
                    int cusID = rs.getInt("CusID");
                    Order o = new Order(orderID, orderDate, orderStatus, shipperID, cusID);
                    list.add(o);
                }
            }
            cn.close();
        }
        return list;
    }

    public static Order searchOrderByID(int orderid) throws Exception {
        Order o = new Order();
        Connection cn = DBUtils.makeConnetion();
        if (cn != null) {
            String sql = "SELECT [OrderID],[OrderDate],[OrderStatus],[ShipperID],[CusID]\n"
                    + "FROM [dbo].[Order] WHERE [OrderID] = ?";
            PreparedStatement pst = cn.prepareCall(sql);
            pst.setInt(1, orderid);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int orderID = rs.getInt("OrderID");
                    Date orderDate = rs.getDate("OrderDate");
                    int orderStatus = rs.getInt("OrderStatus");
                    String shipperID = rs.getString("ShipperID");
                    int cusID = rs.getInt("CusID");
                    o = new Order(orderID, orderDate, orderStatus, shipperID, cusID);
                }
            }
            cn.close();
        }
        return o;
    }

    public static void changeStatus(int orderid, int status) throws Exception {
        Connection cn = DBUtils.makeConnetion();
        if (cn != null) {
            String sql = "UPDATE [Order] SET\n"
                    + "[OrderStatus] = ?\n"
                    + "WHERE [OrderID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, status);
            pst.setInt(2, orderid);
            int rowsAffected = pst.executeUpdate();
        }
    }

    public static void assignShipper(int orderid, String shipperid) throws Exception {
        Connection cn = DBUtils.makeConnetion();
        if (cn != null) {
            String sql = "UPDATE [Order] SET\n"
                    + "[ShipperID] = ?\n"
                    + "WHERE [OrderID] = ?" ;
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, shipperid);
            pst.setInt(2, orderid);
            int rowsAffected = pst.executeUpdate();
        }
    }
    //hoang
        public static ArrayList<Order> searchOrderByShipperID(String shipperid) throws Exception {
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnetion();
        if (cn != null) {
            String sql = "SELECT [OrderID],[OrderDate],[OrderStatus],[ShipperID],[CusID] FROM [dbo].[Order] WHERE [ShipperID] = ?";
            PreparedStatement pst = cn.prepareCall(sql);
            pst.setString(1, shipperid);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int orderID = rs.getInt("OrderID");
                    Date orderDate = rs.getDate("OrderDate");
                    int orderStatus = rs.getInt("OrderStatus");
                    String shipperID = rs.getString("ShipperID");
                    int cusID = rs.getInt("CusID");
                    Order o = new Order(orderID, orderDate, orderStatus, shipperID, cusID);
                    list.add(o);
                }
            }
            cn.close();
        }
        return list;
    }

}
