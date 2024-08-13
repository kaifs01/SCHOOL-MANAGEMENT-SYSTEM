/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Contolller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Service.StudentService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Admin
 */
public class StudentProcess extends HttpServlet {

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
            if (process.equals("deleteStud")) {
                String studMail = request.getParameter("studMail");
                int status = studentService.deleteStud(studMail);
                out.print(status);
            } else if (process.equals("deleteteach")) {
                String teachMail = request.getParameter("teachMail");
                int status = studentService.DeleteTeach(teachMail);
                out.print(status);
            } else if (process.equals("addstudent")) {
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String pass = request.getParameter("pass");
                int age = Integer.parseInt(request.getParameter("age"));
                String gender = request.getParameter("gender");
                int height = Integer.parseInt(request.getParameter("height"));
                float weight = Float.parseFloat(request.getParameter("weight"));
                int status = studentService.Addstud(name, email, pass, age, gender, height, weight);
                out.print(status);

            } else if (process.equals("addteacher")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                int age = Integer.parseInt(request.getParameter("age"));
                int status = studentService.AddTeach(id, name, email, address, age);
                out.print(status);
            } else if (process.equals("updatestudent")) {
                String studMail = request.getParameter("studMail");
                String name = request.getParameter("name");
                String password = request.getParameter("password");
                int age = Integer.parseInt(request.getParameter("age"));
                String gender = request.getParameter("gender");
                int height = Integer.parseInt(request.getParameter("height"));
                float weight = Float.parseFloat(request.getParameter("weight"));
                int status = studentService.UpdateStud(studMail, name, password, age, gender, height, weight);
                out.print(status);
            } else if (process.equals("supdate")) {
                request.setAttribute("process", process);
                RequestDispatcher view = request.getRequestDispatcher("process.jsp");
                view.forward(request, response);
            } else if (process.equals("updateprofile")) {
                String email = request.getParameter("email");
                String name = request.getParameter("name");
                String gender = request.getParameter("gender");
                int status = studentService.UpdateProfile(email,name,gender);
                out.print(status);
            }
        } catch (SQLException e) {
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
            Logger.getLogger(StudentProcess.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(StudentProcess.class.getName()).log(Level.SEVERE, null, ex);
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
