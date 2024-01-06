package controller;

import dao.CustomerDAO;
import dto.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String url = "";
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "adminjsp":
                    url = "admin.jsp";
                    break;
                case "Admin page":
                    url = "admin.jsp";
                    break;
                case "shipperjsp":
                    url = "shipper.jsp";
                    break;
                //manage customer
                case "Manage Customer":
                    url = "manageCustomer.jsp";
                    break;
                case "Show all customer":
                    url = "ListCustomerServlet";
                    break;
                case "Find customer":
                    url = "FindCustomerServlet";
                    break;
                case "Block":
                    url = "StatusServlet";
                    break;
                case "Unblock":
                    url = "StatusServlet";
                    break;
                //manage flower
                case "Manage Flower":
                    url = "manageFlower.jsp";
                    break;
                case "CREATE":
                    url = "CreateCategoryServlet";
                    break;
                case "VIEW CATEGORY":
                    url = "ListCategoryServlet";
                    break;
                case "ADD":
                    url = "AddItemServlet";
                    break;
                case "VIEW ITEM":
                    url = "ListItemServlet";
                    break;
                case "SEARCH":
                    url = "SearchItemServlet";
                    break;
                case "CHANGE":
                    url = "ChangeItemServlet";
                    break;

                //manage order
                case "Manage Order":
                    url = "manageOrder.jsp";
                    break;
                case "VIEW ORDER":
                    url = "ViewOrderServlet";
                    break;
                case "SEARCH BY CUSTOMER":
                    url = "SearchOrderByCusIDServlet";
                    break;
                case "SEARCH BY ID":
                    url = "SearchOrderByIDServlet";
                    break;
                case "CHANGE STATUS":
                    url = "ChangeStatusOrderServlet";
                    break;
                case "ASSIGN":
                    url = "AssignShipperServlet";
                    break;

            }
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
