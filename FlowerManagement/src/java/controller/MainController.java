package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String url = "index.jsp";
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "":
                    url = "index.jsp";
                    break;
                case "Login":
                    url = "LoginServlet";
                    break;
                case "LOGIN":
                    url = "loginForm.jsp";
                    break;
                case "Logout":
                    url = "loginForm.jsp";
                    break;
                case "REGISTER":
                    url = "RegisterServlet";
                    break;
                case "register":
                    url = "registerForm.jsp";
                    break;
                case "BUY NOW":
                    url = "registerForm.jsp";
                    break;
            }
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
