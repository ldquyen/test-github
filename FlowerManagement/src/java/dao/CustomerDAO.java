package dao;

import dto.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mylib.DBUtils;

public class CustomerDAO {

    //admin
    public static ArrayList<Customer> listCustomer() throws Exception {
        ArrayList<Customer> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnetion();
        if (cn != null) {
            String sql = "SELECT [CusID],[Email],[Password],[Name],[Address],[Phone],[CusStatus]FROM [dbo].[Customer]";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int cusID = rs.getInt("CusID");
                    String email = rs.getString("Email");
                    String password = rs.getString("Password");
                    String name = rs.getString("Name");
                    String address = rs.getString("Address");
                    String phone = rs.getString("Phone");
                    boolean cusStatus = rs.getBoolean("CusStatus");
                    Customer c = new Customer(cusID, email, password, name, address, phone, cusStatus);
                    list.add(c);
                }
            }
            cn.close();
        }
        return list;
    }
    
    //tim bang email/name
    public static Customer findCustomer(String s) throws Exception {
        Customer c = new Customer();
        Connection cn = DBUtils.makeConnetion();
        if (cn != null) {
            if (s.endsWith("@gmail.com")) {
                String sql = "SELECT [CusID],[Email],[Password],[Name],[Address],[Phone],[CusStatus]FROM [dbo].[Customer] WHERE [Email] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, s);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int cusID = rs.getInt("CusID");
                        String email = rs.getString("Email");
                        String password = rs.getString("Password");
                        String name = rs.getString("Name");
                        String address = rs.getString("Address");
                        String phone = rs.getString("Phone");
                        boolean cusStatus = rs.getBoolean("CusStatus");
                        c = new Customer(cusID, email, password, name, address, phone, cusStatus);
                    }
                }
            } else {
                String sql = "  SELECT [CusID],[Email],[Password],[Name],[Address],[Phone],[CusStatus]FROM [dbo].[Customer] WHERE [Name] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, s);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int cusID = rs.getInt("CusID");
                        String email = rs.getString("Email");
                        String password = rs.getString("Password");
                        String name = rs.getString("Name");
                        String address = rs.getString("Address");
                        String phone = rs.getString("Phone");
                        boolean cusStatus = rs.getBoolean("CusStatus");
                        c = new Customer(cusID, email, password, name, address, phone, cusStatus);
                    }
                }
            }
        }
        return c;
    }

    //block/unblock
    public static void changeStatusCustomer(int cusid, String cusstatus) throws Exception {
        Connection cn = DBUtils.makeConnetion();
        if (cn != null) {
            if (cusstatus.equalsIgnoreCase("false")) {
                String sql = "UPDATE [dbo].[Customer] SET [CusStatus] = 1 WHERE [CusID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, cusid);
                int rowsAffected = pst.executeUpdate();
            } else {
                String sql = "UPDATE [dbo].[Customer] SET [CusStatus] = 0 WHERE [CusID] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, cusid);
                int rowsAffected = pst.executeUpdate();
            }
        }
    }

    //admin xem
    public static Customer searchCustomerByID(int id) throws Exception {
        Customer c = new Customer();
        Connection cn = DBUtils.makeConnetion();
        if (cn != null) {
            String sql = "SELECT [CusID],[Email],[Password],[Name],[Address],[Phone],[CusStatus]\n"
                    + "FROM [dbo].[Customer] WHERE [CusID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int cusID = rs.getInt("CusID");
                    String email = rs.getString("Email");
                    String password = rs.getString("Password");
                    String name = rs.getString("Name");
                    String address = rs.getString("Address");
                    String phone = rs.getString("Phone");
                    boolean cusStatus = rs.getBoolean("CusStatus");
                    c = new Customer(cusID, email, password, name, address, phone, cusStatus);
                }
            }
            cn.close();
        }

        return c;
    }
    
    public static Customer getCustomer(String Email, String Password) throws Exception {
        Customer c = new Customer();
        Connection cn = DBUtils.makeConnetion();
        if (cn != null) {
            String sql = "SELECT [CusID],[Email],[Password],[Name],[Address],[Phone],[CusStatus] \n"
                    + "FROM [Customer] WHERE [Email] = ? AND [Password] = ? ";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, Email);
            pst.setString(2, Password);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int cusID = rs.getInt("CusID");
                    String email = rs.getString("Email");
                    String password = rs.getString("Password");
                    String name = rs.getString("Name");
                    String address = rs.getString("Address");
                    String phone = rs.getString("Phone");
                    boolean cusStatus = rs.getBoolean("CusStatus");
                    c = new Customer(cusID, email, password, name, address, phone, cusStatus);
                }
            }
            cn.close();
        }

        return c;
    }
    
    //check email của customer login/register
    public static boolean checkCustomer(String Email) throws Exception {
        Connection cn = DBUtils.makeConnetion();
        if (cn != null) {
            String sql = "SELECT [Email] FROM [dbo].[Customer] WHERE [Email] = ? ";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, Email);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String email = rs.getString("Email");
                    if (email != null) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }
    
    //hoang

    public static boolean insertCustomer(String email, String password, String name, String address, String phone) {
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = DBUtils.makeConnetion();
            if (cn != null) {

                String sql = "INSERT INTO [dbo].[Customer]([Email],[Password],[Name],[Address],[Phone],[CusStatus])\n"
                        + "VALUES (?,?,?,?,?,?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, password);
                pst.setString(3, name);
                pst.setString(4, address);
                pst.setString(5, phone);
                pst.setBoolean(6, false);
                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
