/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Contolller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Service.StudentService;

/**
 *
 * @author Admin
 */
public class DashboarServlet extends HttpServlet {

    StudentService studentService = new StudentService();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String process = request.getParameter("process");
            if (process.equals("homeload")) {
                request.setAttribute("process", process);
                RequestDispatcher view = request.getRequestDispatcher("process.jsp");
                view.forward(request, response);
            } else if (process.equals("studload")) {
                ResultSet rs = studentService.getStud();
                request.setAttribute("ResultSet", rs);
                request.setAttribute("process", process);
                RequestDispatcher rd = request.getRequestDispatcher("Data.jsp");
                rd.forward(request, response);
            } else if (process.equals("libload")) {
                ResultSet rs = studentService.getLib();
                request.setAttribute("ResultSet", rs);
                request.setAttribute("process", process);
                RequestDispatcher rd = request.getRequestDispatcher("Data.jsp");
                rd.forward(request, response);
            } else if (process.equals("teachload")) {
                ResultSet rs = studentService.getTeach();
                request.setAttribute("ResultSet", rs);
                request.setAttribute("process", process);
                RequestDispatcher rd = request.getRequestDispatcher("Data.jsp");
                rd.forward(request, response);
            } else if (process.equals("addstud")) {
                request.setAttribute("process", process);
                RequestDispatcher view = request.getRequestDispatcher("process.jsp");
                view.forward(request, response);
            } else if (process.equals("addteach")) {
                request.setAttribute("process", process);
                RequestDispatcher view = request.getRequestDispatcher("process.jsp");
                view.forward(request, response);
            } else if (process.equals("updatestud")) {
                String studMail = request.getParameter("studMail");
                ResultSet rs = studentService.Editstud(studMail);
                request.setAttribute("ResultSet", rs);
                request.setAttribute("process", process);
                RequestDispatcher rd = request.getRequestDispatcher("Edtstud.jsp");
                rd.forward(request, response);
            } else if (process.equals("updteach")) {
                int teachid = Integer.parseInt(request.getParameter("tid"));
                ResultSet rs = studentService.EditTeach(teachid);
                request.setAttribute("ResultSet", rs);
                request.setAttribute("process", process);
                RequestDispatcher rd = request.getRequestDispatcher("Edtstud.jsp");
                rd.forward(request, response);
            } else if (process.equals("updateteacher")) {
                int tid = Integer.parseInt(request.getParameter("tid"));
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                int age = Integer.parseInt(request.getParameter("age"));
                int status = studentService.UpdateTeach(tid, name, email, address, age);
                out.print(status);

            } else if (process.equals("updatelib")) {
                String Bookauth = request.getParameter("Bookauth");
                ResultSet rs = studentService.EditLib(Bookauth);
                request.setAttribute("ResultSet", rs);
                request.setAttribute("process", process);
                RequestDispatcher rd = request.getRequestDispatcher("Edtstud.jsp");
                rd.forward(request, response);
            }
        } catch (IOException | SQLException | ServletException e) {
            e.getMessage();
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
            Logger.getLogger(DashboarServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DashboarServlet.class.getName()).log(Level.SEVERE, null, ex);
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
