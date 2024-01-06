package dao;

import dto.Account;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mylib.DBUtils;

public class AccountDAO {

    public static boolean checkAccount(String Email) throws Exception {
        Connection cn = DBUtils.makeConnetion();
        if (cn != null) {
            String sql = "SELECT [Email] FROM [dbo].[Account] WHERE [Email] = ? ";
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

    public static Account getAccount(String Email, String Password) throws Exception {
        Account result = new Account();
        Connection cn = DBUtils.makeConnetion();
        if (cn != null) {
            String sql = "SELECT [AccID],[Email],[Password],[Role] FROM [dbo].[Account] WHERE [Email] = ? and [Password] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, Email);
            pst.setString(2, Password);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String accountID = rs.getString("AccID");
                    String email = rs.getString("Email");
                    String password = rs.getString("Password");
                    String role = rs.getString("Role");
                    result = new Account(accountID, email, password, role);
                }
            }
            cn.close();
        }
        return result;
    }
    
    //list gán assign to order
    public static ArrayList<Account> listShipper() throws Exception {
       ArrayList<Account> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnetion();
        if (cn != null) {
            String sql = "SELECT [AccID],[Email],[Password],[Role] FROM [dbo].[Account] WHERE [Role] = 'shipper'";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String accountID = rs.getString("AccID");
                    String email = rs.getString("Email");
                    String password = rs.getString("Password");
                    String role = rs.getString("Role");
                    Account a = new Account(accountID, email, password, role);
                    list.add(a);
                }
            }
            cn.close();
        }
        return list;
    }
    
  
}
