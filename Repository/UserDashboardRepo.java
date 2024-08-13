/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class UserDashboardRepo {

    String url = "jdbc:mysql://localhost:3306/college2";
    String user = "root";
    String pass = "";

    public ResultSet getStuds() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("select username,email,password,age,gender,HEIGHT,WEIGHT from student2;");
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

    public int getBranchCounts() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("select count(Branch_id) from Branch;");
        ResultSet rs = stmt.executeQuery();
        int branchCount = 0;
        if (rs.next()) {
            branchCount = rs.getInt(1);
        }
        return branchCount;
    }

    public int getStudCounts() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("select count(email) from student2;");
        ResultSet rs = stmt.executeQuery();
        int studCount = 0;
        if (rs.next()) {
            studCount = rs.getInt(1);
        }
        return studCount;
    }

    public int getTeacherCounts() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("select count(T_id) from teacher;");
        ResultSet rs = stmt.executeQuery();
        int teacherCount = 0;
        if (rs.next()) {
            teacherCount = rs.getInt(1);
        }
        return teacherCount;
    }

    public int getModulesCounts() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("select count(Modules_id) from Modules;");
        ResultSet rs = stmt.executeQuery();
        int moduleCount = 0;
        if (rs.next()) {
            moduleCount = rs.getInt(1);
        }
        return moduleCount;
    }

    public int getCompaniesCounts() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("select count(Comp_id) from Companies;");
        ResultSet rs = stmt.executeQuery();
        int companiesCount = 0;
        if (rs.next()) {
            companiesCount = rs.getInt(1);
        }
        return companiesCount;
    }

    public int getInternCounts() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("select count(Internship_id) from Internship;");
        ResultSet rs = stmt.executeQuery();
        int internshipCount = 0;
        if (rs.next()) {
            internshipCount = rs.getInt(1);
        }
        return internshipCount;
    }

    public int getContacts(String name, String email, String subject, String message) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("insert into ContactUs(name,email,subject,massage)values (?,?,?,?);");
        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.setString(3, subject);
        stmt.setString(4, message);
        int status = stmt.executeUpdate();
        return status;
    }

    public ResultSet getBooks() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("select BookTitle,BookAuthor,ImgUrl,Description from LibraryDetails;");
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

}
