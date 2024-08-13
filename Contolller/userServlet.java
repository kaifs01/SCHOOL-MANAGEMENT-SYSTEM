/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Contolller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Service.UserDashboard;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class userServlet extends HttpServlet {

    UserDashboard userDashboard = new UserDashboard();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws java.sql.SQLException
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String process = request.getParameter("process");
            if (process.equals("dash")) {
                int branchCount = userDashboard.getBranchCount();
                int studCount = userDashboard.getStudCount();
                int teacherCount = userDashboard.getTeacherCount();
                int moduleCount = userDashboard.getModulesCount();
                int companiesCount = userDashboard.getCompaniesCount();
                int internCount = userDashboard.getInternCount();
                request.setAttribute("BranchCount", branchCount);
                request.setAttribute("StudCount", studCount);
                request.setAttribute("TeacherCount", teacherCount);
                request.setAttribute("ModulesCount", moduleCount);
                request.setAttribute("CompaniesCount", companiesCount);
                request.setAttribute("InternCount", internCount);
                request.setAttribute("process", process);
                RequestDispatcher rd = request.getRequestDispatcher("dashboardload.jsp");
                rd.forward(request, response);
            } else if (process.equals("user")) {
                request.setAttribute("process", process);
                RequestDispatcher view = request.getRequestDispatcher("profile.jsp");
                view.forward(request, response);
            } else if (process.equals("contact")) {
                request.setAttribute("process", process);
                RequestDispatcher view = request.getRequestDispatcher("contact.jsp");
                view.forward(request, response);
            } else if (process.equals("class")) {
                ResultSet rs = userDashboard.getStuden();
                request.setAttribute("ResultSet", rs);
                request.setAttribute("process", process);
                RequestDispatcher rd = request.getRequestDispatcher("class.jsp");
                rd.forward(request, response);
            } else if (process.equals("lib")) {
                ResultSet rs = userDashboard.getBook();
                request.setAttribute("process", process);
                request.setAttribute("ResultSet", rs);
                RequestDispatcher view = request.getRequestDispatcher("library.jsp");
                view.forward(request, response);
            } else if (process.equals("setting")) {
                request.setAttribute("process", process);
                RequestDispatcher view = request.getRequestDispatcher("setting.jsp");
                view.forward(request, response);
            } else if (process.equals("contacts")) {
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String subject = request.getParameter("subject");
                String message = request.getParameter("message");
                int status = userDashboard.AddContact(name, email, subject, message);
                out.print(status);
            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(userServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(userServlet.class.getName()).log(Level.SEVERE, null, ex);
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
