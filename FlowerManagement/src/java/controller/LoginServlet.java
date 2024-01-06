package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AccountDAO;
import dao.CustomerDAO;
import dto.Account;
import dto.Customer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String fail = "login fail";
            String input = "wrong input";
            
            String email = request.getParameter("txtemail");
            String password = request.getParameter("txtpassword");
            if (email != null && password != null) {
                //check account              
                if (AccountDAO.checkAccount(email)){                     
                    Account a = AccountDAO.getAccount(email, password);
                    HttpSession session = request.getSession();                   
                    if (a.getRole().equalsIgnoreCase("admin")) {
                        session.setAttribute("admin", a);   
                        response.sendRedirect("AdminController?action=adminjsp");
                    } else if(a.getRole().equalsIgnoreCase("shipper")) {
                        session.setAttribute("shipper", a);
                        response.sendRedirect("AdminController?action=shipperjsp");
                    } else{
                        request.setAttribute("FAIL", fail);
                        request.getRequestDispatcher("loginForm.jsp").forward(request, response);
                    }                    
                //check customer                
                }else if (CustomerDAO.checkCustomer(email)){
                Customer c = CustomerDAO.getCustomer(email, password);
                if(c != null && c.getPassword().equals(password)){
                    HttpSession session = request.getSession();    
                session.setAttribute("customer", c);   
                response.sendRedirect("home.jsp");
                //sai customer
                }else{
                    request.setAttribute("FAIL", fail);
                    request.getRequestDispatcher("loginForm.jsp").forward(request, response);
                }
            // ko phai la account/customer
                }else {                   
                    request.setAttribute("FAIL", fail);
                    request.getRequestDispatcher("loginForm.jsp").forward(request, response);
                }                
            } else {
                request.setAttribute("FAIL", fail);
                request.getRequestDispatcher("loginForm.jsp").forward(request, response);
            }           
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
