    package dao;

import dto.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mylib.DBUtils;

public class ItemDAO {

    public static void addItem(Item i) throws Exception {
        Connection cn = DBUtils.makeConnetion();
        if (cn != null) {
            String sql = " INSERT INTO [Item] ([ItemName],[Price],[ItemStatus],[FileIMG],[CatID])\n"
                    + "  VALUES (?,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, i.getItemName());
            pst.setFloat(2, i.getPrice());
            pst.setInt(3, i.getItemStatus());
            pst.setString(4, i.getFileIMG());
            pst.setInt(5, i.getCatID());
            int rowsAffected = pst.executeUpdate();
        }
    }

    public static ArrayList<Item> listItem() throws Exception {
        ArrayList<Item> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnetion();
        if (cn != null) {
            String sql = "  SELECT [ItemID],[ItemName],[Price],[ItemStatus],[FileIMG],[CatID] FROM [dbo].[Item]";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int itemID = rs.getInt("ItemID");
                    String itemName = rs.getString("ItemName");
                    float price = rs.getFloat("Price");
                    int itemStatus = rs.getInt("ItemStatus");
                    String fileIMG = rs.getString("FileIMG");
                    int catID = rs.getInt("CatID");
                    Item i = new Item(itemID, itemName, price, itemStatus, fileIMG, catID);
                    list.add(i);
                }
            }
            cn.close();
        }
        return list;
    }

    public static Item searchItem(String name) throws Exception {
        Item result = new Item();
        Connection cn = DBUtils.makeConnetion();
        if (cn != null) {
            String sql = "SELECT [ItemID],[ItemName],[Price],[ItemStatus],[FileIMG],[CatID] FROM [dbo].[Item] WHERE [ItemName] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int itemID = rs.getInt("ItemID");
                    String itemName = rs.getString("ItemName");
                    float price = rs.getFloat("Price");
                    int itemStatus = rs.getInt("ItemStatus");
                    String fileIMG = rs.getString("FileIMG");
                    int catID = rs.getInt("CatID");
                    result = new Item(itemID, itemName, price, itemStatus, fileIMG, catID);
                }
            }
            cn.close();
        }
        return result;
    }

    public static void changeItem(Item i) throws Exception {
        Connection cn = DBUtils.makeConnetion();
        if (cn != null) {
            String sql = "UPDATE [Item] SET \n"
                    + "[ItemName] = ?,\n"
                    + "[Price] = ?,\n"
                    + "[FileIMG] = ?,\n"
                    + "[ItemStatus] = ?\n"
                    + "WHERE [ItemID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, i.getItemName());
            pst.setFloat(2, i.getPrice());
            pst.setString(3, i.getFileIMG());
            pst.setInt(4, i.getItemStatus());
            pst.setInt(5, i.getItemID());
            int rowsAffected = pst.executeUpdate();
        }
    }

}
