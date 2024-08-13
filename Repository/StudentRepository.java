/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/college2";
    String user = "root";
    String pass = "";

    public ResultSet getStudent() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("select username,email,password,age,gender,HEIGHT,WEIGHT from student2;");
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

    public ResultSet getTeacher() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("select T_id,T_name,T_email,T_address,T_age from teacher;");
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

    public int deleteStudent(String studMail) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("delete from student2 where email = ?;");
        stmt.setString(1, studMail);
        int status = stmt.executeUpdate();
        return status;
    }

    public int DeleteTeacher(String teachMail) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("delete from teacher where T_email=?;");
        stmt.setString(1, teachMail);
        int status = stmt.executeUpdate();
        return status;
    }

    public int Addstudent(String name, String email, String pass1, int age, String gender, int height, float weight) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("insert into student2(username,email,password,age,gender,HEIGHT,WEIGHT)values (?,?,?,?,?,?,?);");
        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.setString(3, pass1);
        stmt.setInt(4, age);
        stmt.setString(5, gender);
        stmt.setInt(6, height);
        stmt.setFloat(7, weight);
        int status = stmt.executeUpdate();
        return status;
    }

    public int Addteacher(int id, String name, String email, String address, int age) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("insert into teacher(T_id,T_name,T_email,T_address,T_age)values (?,?,?,?,?);");
        stmt.setInt(1, id);
        stmt.setString(2, name);
        stmt.setString(3, email);
        stmt.setString(4, address);
        stmt.setInt(5, age);
        int status = stmt.executeUpdate();
        return status;
    }

    public ResultSet EditStudent(String studMail) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("select username,email,password,age,gender,HEIGHT,WEIGHT from student2 where email=?");
        stmt.setString(1, studMail);
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

    public ResultSet Edteacher(int teachid) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("select T_id,T_name,T_email,T_address,T_age from teacher where T_id=?");
        stmt.setInt(1, teachid);
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

    public int UpdateTeacher(int tid, String name, String email, String address, int age) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("update teacher set T_name = ? ,T_email = ?,T_address = ?,T_age = ? where T_id = ?;");
        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.setString(3, address);
        stmt.setInt(4, age);
        stmt.setInt(5, tid);
        int status = stmt.executeUpdate();
        return status;

    }

    public int UpdateStud(String studMail, String name, String password, int age, String gender, int height, float weight) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("update student2 set username = ? , password= ?, age = ?,gender = ?, HEIGHT = ? , WEIGHT = ? where email = ?;");
        stmt.setString(1, name);
        stmt.setString(2, password);
        stmt.setInt(3, age);
        stmt.setString(4, gender);
        stmt.setInt(5, height);
        stmt.setFloat(6, weight);
        stmt.setString(7, studMail);
        int status = stmt.executeUpdate();
        return status;

    }

    public int CheckLogin(String email, String pass1) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("select count(email) from student2 where email = ? and password = ?;");
        stmt.setString(1, email);
        stmt.setString(2, pass1);
        ResultSet rs = stmt.executeQuery();
        int status = 0;
        if (rs.next()) {
            status = rs.getInt(1);
        }
        con.close();
        return status;
    }

    public ResultSet getLibrary() throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("select BookTitle,BookAuthor,ImgUrl,Description from LibraryDetails;");
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

    public String getemail(String email, String pass1) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("select email from student2 where email = ? and password = ?;");
        stmt.setString(1, email);
        stmt.setString(2, pass1);
        ResultSet rs = stmt.executeQuery();
        String emaill = "";
        if (rs.next()) {
            emaill = rs.getString("email");
        }
        return emaill;
    }

    public String getUser(String email, String pass1) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("select username from student2 where email = ? and password = ?;");
        stmt.setString(1, email);
        stmt.setString(2, pass1);
        ResultSet rs = stmt.executeQuery();
        String username = "";
        if (rs.next()) {
            username = rs.getString("username");
        }
        return username;
    }

    public String getGender(String email, String pass1) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("select gender from student2 where email = ? and password = ?;");
        stmt.setString(1, email);
        stmt.setString(2, pass1);
        ResultSet rs = stmt.executeQuery();
        String gender = "";
        if (rs.next()) {
            gender = rs.getString("gender");
        }
        return gender;
    }

    public int Updateprofiles(String email, String name, String gender) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("update student2 set username = ? ,gender = ? where email = ?;");
        stmt.setString(1, name);
        stmt.setString(2, gender);
        stmt.setString(3, email);
        int status = stmt.executeUpdate();
        return status;
    }

    public ResultSet EditLib(String Bookauth) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt = con.prepareStatement("select BookTitle,BookAuthor,ImgUrl,Description from LibraryDetails where BookAuthor = ?");
        stmt.setString(1, Bookauth);
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

}
