/*
 
 -------------------------login-----------------------
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            /* TODO output your page here. You may use following sample code. */
            String id = request.getParameter("txtuserid");
            String pass = request.getParameter("txtuserpassword");
            UserDao dao = new UserDao();
            User user = dao.getUser(id, pass);

            if (user != null) {
                session.setAttribute("user", user);
                response.sendRedirect("fashionList.jsp");
                
            } else {
                request.setAttribute("msg", "incorrect id or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	---logout----
 HttpSession session = request.getSession();
            session.removeAttribute("user");
            response.sendRedirect("login.jsp");	
	
	---userdao--
	public class UserDao {
    public User getUser(String userID, String password) throws SQLException, ClassNotFoundException{
             User result = null;
        Connection cn = DBUtils.getConnection();
        if (cn != null) {
                String sql = "SELECT * FROM tblUsers\n"
                    + "WHERE [userID] = ? and [password]=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, userID);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if(rs!= null && rs.next()){
                String id = rs.getString("userID");
                String pass = rs.getString("password");
                String name = rs.getString("fullName");
                String role = rs.getString("roleID");
                Boolean stt = rs.getBoolean("status");
                result = new User(id, pass, name, role, stt);
            }
            cn.close();
            
        }
        return result;
    }
    
}	---itemdao---
public class ItemDao {
    public static ArrayList<item> getItemByName(String search) throws ClassNotFoundException, SQLException{
      item result = null;
      Connection cn = DBUtils.getConnection();
      ArrayList<item> itemList = new ArrayList<>();
      if(cn!=null){
          String sql ="SELECT * FROM [dbo].[tblFashion] WHERE [name] LIKE ? and [status] = 'true' ";
          PreparedStatement pst= cn.prepareStatement(sql);
          pst.setString(1,"%"+search+"%");
          ResultSet rs = pst.executeQuery();
          if(rs!=null){
              while(rs.next()){
                  String id = rs.getString("id");
                  String name = rs.getString("name");
                  String des = rs.getString("description");
                  float price = rs.getFloat("price");
                  String size = rs.getString("size");
                  boolean stt = rs.getBoolean("status");
                  item it = new item(id, name, des, price, size, stt);
                  itemList.add(it);
              }
          }cn.close();
      }    return itemList;
          } 
    
}

	<%-- 
    Document   : viewcart
    Created on : Oct 28, 2023, 9:44:20 PM
    Author     : Admin
--%>

<%@page import="java.math.BigDecimal"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="dto.cartItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <p><a href="index.jsp">Home</a></p>


        <h4><%
            Customer cus = (Customer) session.getAttribute("customer");
            if (cus != null) {
                out.print("your cart is here " + cus.getName());


            %>

            <table border="">
                <thead> 
                <th>Product ID</th>
                <th> Name</th>
                <th> Price</th>
                <th> Quantity</th>
                </thead>
                <form action="UpdateQuantityServlet" method="post">
                    <tbody>
                        <%                        ArrayList<cartItem> cart = (ArrayList<cartItem>) session.getAttribute("cart");
                       
                        for (cartItem i : cart) {
                        %>   
                    <input type="hidden" name="txtid" value="<%= i.getItemID()%>"/>

                    <tr>
                        
                        <td><%=i.getItemID()%></td>
                        <td><%=i.getName()%></td>
                        <td><%=i.getPrice()%></td>
                        <td><input type="number" name="txtquantity"value="<%=i.getQuantity()%>"></td>
                        <td>

                            <input type="submit" value="update" name="btnType">
                            <input type="submit" value="remove" name="btnType">

                            <!--<button name="bttonType" value="remove">remove</button>-->  
                        </td>
                    </tr>
                    <%   
                            }
                    
                    %>

                    </tbody>  
                    <p>
                   your total price: <%= session.getAttribute("total") %>

                    </p>

                </form>



            </table>





            <%}%>
        </h4>
    </body>
</html>

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.cartItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class UpdateQuantityServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            String itemid = request.getParameter("txtid");
            int newQuantity = Integer.parseInt(request.getParameter("txtquantity"));
            String type = request.getParameter("btnType");

            ArrayList<cartItem> cart = (ArrayList<cartItem>) session.getAttribute("cart");

            if (cart != null) {
                if (type.equalsIgnoreCase("update")) {
                    for (cartItem item : cart) {
                        if (item.getItemID().equals(itemid)) {
                            item.setQuantity(newQuantity);
                            break;
                        }
                    }

                    float sum = 0;
                    for (cartItem i : cart) {
                        sum = sum + i.getPrice() * i.getQuantity();
                    }
                    session.setAttribute("total", sum);

                } else if (type.equalsIgnoreCase("remove")) {
                    // Xóa sản phẩm khỏi giỏ hàng
                    cartItem itemToRemove = null;
                    for (cartItem item : cart) {
                        if (item.getItemID().equals(itemid)) {
                            itemToRemove = item;
                            break;
                        }
                    }
                    if (itemToRemove != null) {
                        cart.remove(itemToRemove);
                    }
                }
            }

            session.setAttribute("cart", cart);
tinh toan tong gia tri hang 

            response.sendRedirect("viewcart.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
---------------------------HASHMAP----------------------------
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.prj301.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.prj301.shopping.DAO;
import pe.prj301.shopping.Products;

/**
 *
 * @author TuanDat
 */
public class AddCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String id = request.getParameter("txtid");
            //id = id.trim();
            Products pd = DAO.getAProduct(id);
            
            HttpSession session = request.getSession();
            HashMap<Products, Integer> cart = (HashMap<Products, Integer>) session.getAttribute("cart");

            if (cart == null) {
                cart = new HashMap<>();
                cart.put(pd, 1);
            } else {
                boolean flag = false;
                for (Products p : cart.keySet()) {
                    if (p.getProductID().equals(pd.getProductID())) {
                        flag = true;
                        int quantity = cart.get(p);
                        quantity++;
                        cart.put(p, quanlity);
                    }
                }
                if (!flag) {//flag==false
                    cart.put(pd, 1);
                }
            }
            session.setAttribute("cart", cart);
            response.sendRedirect("shopping.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	---------------------------------------HashMapjsp-------------------------------------------
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
<%-- 
    Document   : viewCart
    Created on : au 28, 2023, 9:07:46 PM
    Author     : hd
--%>

<%@page import="java.util.HashMap"%>
<%@page import="pe.prj301.shopping.Products"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
    </head>
    <body>
        <h1>Your Shopping cart</h1>
        <!--your code here--> 
        <%//HashMap <Item,Integer>cart =(HashMap)session.getAttribute("cart");
            HashMap<Products, Integer> cart = (HashMap<Products, Integer>) session.getAttribute("cart");
            if (cart == null) {
                cart = new HashMap<>();
                out.print("Your Product is empty");
            }
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Quality</th>
                    <th>Total</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    float sum = 0;
                    int i = 0;
                    for (Products p : cart.keySet()) {
                %>
                <tr>
                    <td><%=i++%></td>
                    <td><%=p.getProductID()%></td>
                    <td><%=p.getProductName()%></td>
                    <td><%=p.getDescription()%></td>
                    <td><%=p.getPrice()%></td>
            <form action="MainController?action=UPQUANTITY" method="POST">
                <td><input type="number" value="<%=cart.get(p)%>" min="1"max="10" name="txtquantity"></td>
                <td><%=p.getPrice() * cart.get(p)%></td>
                <td> 
                    <input type="hidden" name="txtid" value="<%=p.getProductID()%>"/>
                    <input type="submit" value="Update"/>
                </td>
            </form>

        </tr>
        <%
            sum += (p.getPrice() * cart.get(p));
        %>
        <%}//for%>

    </tbody>
</table>
<p>
    <%=sum%>
</p>

<h3>
    <a href="shopping.jsp">add more</a>

</h3>
</body>
</html>

	

	*/
	-----
	/*
	String id = request.getParameter("txtid");
            //id = id.trim();
            Products pd = DAO.getAProduct(id);
            
            HttpSession session = request.getSession();
            HashMap<Products, Integer> cart = (HashMap<Products, Integer>) session.getAttribute("cart");

            if (cart == null) {
                cart = new HashMap<>();
                cart.put(pd, 1);
            } else {
                boolean flag = false;
                for (Products p : cart.keySet()) {
                    if (p.getProductID().equals(pd.getProductID())) {
                        flag = true;
                        int quanlity = cart.get(p);
                        quanlity++;
                        cart.put(p, quanlity);
                    }
                }
                if (!flag) {//flag==false
                    cart.put(pd, 1);
                }
            }
            session.setAttribute("cart", cart);
            response.sendRedirect("shopping.jsp");
	*/