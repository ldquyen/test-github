/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import dao.CustomerDAO;
import dao.OrderDAO;
import dto.Account;
import dto.Customer;
import dto.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class SearchOrderByIDServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String id = request.getParameter("orderid");     
            if(id.isEmpty() ){
                request.setAttribute("NULLID", "ID NOT NULL ");
                request.getRequestDispatcher("AdminController?action=Manage Order").forward(request, response);
            }
            
            int orderid = Integer.parseInt(id);
            
            Order o = OrderDAO.searchOrderByID(orderid); 
            Customer c = CustomerDAO.searchCustomerByID(o.getCusID());           
            ArrayList<Account> list = AccountDAO.listShipper();
            
            HttpSession session = request.getSession();
            session.setAttribute("order", o);
            session.setAttribute("customer", c);
            session.setAttribute("listShipper", list);
            request.getRequestDispatcher("AdminController?action=Manage Order").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SearchOrderByIDServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SearchOrderByIDServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
