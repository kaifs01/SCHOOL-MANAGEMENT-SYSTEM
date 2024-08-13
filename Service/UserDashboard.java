/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.ResultSet;
import Repository.UserDashboardRepo;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class UserDashboard {

    UserDashboardRepo userDashboardRepo = new UserDashboardRepo();

    public ResultSet getStuden() throws SQLException {
        return userDashboardRepo.getStuds();
    }

    public int getBranchCount() throws SQLException {
        return userDashboardRepo.getBranchCounts();
    }

    public int getStudCount() throws SQLException {
        return userDashboardRepo.getStudCounts();

    }

    public int getTeacherCount() throws SQLException {
        return userDashboardRepo.getTeacherCounts();
    }

    public int getModulesCount() throws SQLException {
        return userDashboardRepo.getModulesCounts();
    }

    public int getCompaniesCount() throws SQLException {
        return userDashboardRepo.getCompaniesCounts();
    }

    public int getInternCount() throws SQLException {
        return userDashboardRepo.getInternCounts();
    }

    public int AddContact(String name, String email, String subject, String message) throws SQLException {
        return userDashboardRepo.getContacts(name,email,subject,message);
    }

    public ResultSet getBook() throws SQLException {
        return userDashboardRepo.getBooks();
    }

}
