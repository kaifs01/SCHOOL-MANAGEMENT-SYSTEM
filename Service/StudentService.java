/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.ResultSet;
import Repository.StudentRepository;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class StudentService {

    StudentRepository studentRepository = new StudentRepository();

    public ResultSet getStud() throws SQLException {

        return studentRepository.getStudent();
    }

    public ResultSet getTeach() throws SQLException {
        return studentRepository.getTeacher();
    }

    public int deleteStud(String studMail) throws SQLException {
        return studentRepository.deleteStudent(studMail);
    }

    public int DeleteTeach(String teachMail) throws SQLException {
        return studentRepository.DeleteTeacher(teachMail);
    }

    public int Addstud(String name, String email, String pass1, int age, String gender, int height, float weight) throws SQLException {
        return studentRepository.Addstudent(name, email, pass1, age, gender, height, weight);
    }

    public int AddTeach(int id, String name, String email, String address, int age) throws SQLException {
        return studentRepository.Addteacher(id, name, email, address, age);
    }

    public ResultSet Editstud(String studMail) throws SQLException {
        return studentRepository.EditStudent(studMail);
    }

    public ResultSet EditTeach(int teachid) throws SQLException {
        return studentRepository.Edteacher(teachid);
    }

    public int UpdateTeach(int tid, String name, String email, String address, int age) throws SQLException {
        return studentRepository.UpdateTeacher(tid, name, email, address, age);
    }

    public int UpdateStud(String studMail, String name, String password, int age, String gender, int height, float weight) throws SQLException {
        return studentRepository.UpdateStud(studMail, name, password, age, gender, height, weight);
    }

    public int Checklogin(String email, String pass1) throws SQLException {
        return studentRepository.CheckLogin(email, pass1);
    }

    public ResultSet getLib() throws SQLException {
        return studentRepository.getLibrary();
    }

    public String getEmail(String email, String pass1) throws SQLException {
        return studentRepository.getemail(email, pass1);
    }

    public String getUser(String email, String pass1) throws SQLException {
        return studentRepository.getUser(email, pass1);
    }

    public String getGender(String email, String pass1) throws SQLException {
        return studentRepository.getGender(email, pass1);
    }

    public int UpdateProfile(String email, String name, String gender) throws SQLException {
        return studentRepository.Updateprofiles(email, name, gender);

    }

    public ResultSet EditLib(String Bookauth) throws SQLException {
        return studentRepository.EditLib(Bookauth);
    }
}
