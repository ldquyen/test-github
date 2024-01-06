
package dao;

import dto.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mylib.DBUtils;

public class CategoryDAO {
    public static void createCategory(Category c) throws Exception{
        Connection cn = DBUtils.makeConnetion();
        if(cn != null){
            String sql = "INSERT INTO [Category] ([CatName]) VALUES (?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, c.getCatName());           
            int rowsAffected = pst.executeUpdate();          
        }
    }   
    
    public static ArrayList<Category> listCategory() throws Exception{
        ArrayList<Category> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnetion();
        if(cn != null){
            String sql = "SELECT [CatID],[CatName] FROM [dbo].[Category]";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs != null){
                while(rs.next()){
                     int catID = rs.getInt("CatID");
                     String catName = rs.getString("CatName");
                     Category c = new Category(catID, catName);
                     list.add(c);
                }
            }
            cn.close();
        }
        return list;
    }
    
    public static boolean checkCategory(String s ) throws Exception{
        Connection cn = DBUtils.makeConnetion();
        if(cn != null){
            String sql = "SELECT [CatID],[CatName] FROM [dbo].[Category] WHERE [CatName] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();
            if(rs != null){
                while(rs.next()){
                    return false;
                }
            }
        }        
        return true;
    }
}
