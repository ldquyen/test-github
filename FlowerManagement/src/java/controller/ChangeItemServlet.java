package controller;

import dao.ItemDAO;
import dto.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.coyote.ActionCode;

public class ChangeItemServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String itemid = request.getParameter("itemID");
            String itemName = request.getParameter("itemName");
            String price = request.getParameter("itemPrice");
            String itemstatus = request.getParameter("itemStatus");
            String itemIMG = request.getParameter("itemIMG");
            String catid = request.getParameter("catID");
            
            int itemID = Integer.parseInt(itemid);            
            float Price = Float.parseFloat(price);
            int catID = Integer.parseInt(catid);
            int itemStatus = Integer.parseInt(itemstatus);
            
            Item i = new Item(itemID, itemName, Price, itemStatus, itemIMG, catID);
            
            ItemDAO.changeItem(i);
           
            request.setAttribute("ChangeOKE", "CHANGE ITEM SUCCESSFULLY");
            request.getRequestDispatcher("AdminController?action=Manage Flower").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ChangeItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ChangeItemServlet.class.getName()).log(Level.SEVERE, null, ex);
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
