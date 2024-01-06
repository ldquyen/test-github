/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("txtemail");
            String pwd = request.getParameter("txtpassword");
            String name = request.getParameter("txtname");
            String address = request.getParameter("txtaddress");
            String phone = request.getParameter("txtphone");
            if (!email.isEmpty() && !pwd.isEmpty() && !name.isEmpty() && !address.isEmpty() && !phone.isEmpty()) {
                CustomerDAO cus = new CustomerDAO();
                if (cus.checkCustomer(email)) {
                    request.setAttribute("FAIL", "Vui lòng đăng kí lại");
                    request.getRequestDispatcher("MainController?action=register").forward(request, response);
                } else {

                    boolean bl = cus.insertCustomer(email, pwd, name, address, phone);
                    request.setAttribute("SUCCESS", "Đăng kí thành công vui lòng đăng nhập");
                    request.getRequestDispatcher("MainController?action=LOGIN").forward(request, response);
                }
            } else {
                request.setAttribute("FAIL", "Vui lòng đăng kí lại");
                request.getRequestDispatcher("MainController?action=register").forward(request, response);
            }
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
