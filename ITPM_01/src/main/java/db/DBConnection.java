/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Employee;
import model.Locations;
import model.Session;

/**
 *
 * @author Prabhashwara
 */
public class DBConnection {
    
    private static Connection getConnection() {

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm_timeTable", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return connection;

    }
    
    public static int insertEmplyee(Employee em) {
        int status = 0;

        try {
            Connection connection;
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into employee(employeeID, employeeName, startDate, endDate, "
                    + "workingDays, workingHours) values(?, ?, ?, ?, ?, ?)");

            ps.setString(1, em.getEmployeeID());
            ps.setString(2, em.getEmployeeName());
            ps.setString(3, em.getStartDate());
            ps.setString(4, em.getEndDate());
            ps.setString(5, em.getWorkingDays());
            ps.setString(6, em.getWorkingHours());

            status = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return status;
    }
    
    public static int insertLecture(Session s) {
        int status = 0;

        try {
            Connection connection;
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into lecture(lecture, ssid, stdGroup, timePeriod, "
                    + "subGroup) values(?, ?, ?, ?, ?)");

            ps.setString(1, s.getLecture());
            ps.setString(2, s.getSsid());
            ps.setString(3, s.getGroup());
            ps.setString(4, s.getTime());
            ps.setString(5, s.getSubGroup());

            status = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return status;
    }
    
    public static int insertLocation(Locations loc) {
        int status = 0;

        try {
            Connection connection;
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into Location(room, selectDay, startTime, endTime)"
                    + " values(?, ?, ?, ?)");

            ps.setString(1, loc.getRoom());
            ps.setString(2, loc.getSelectDay());
            ps.setString(3, loc.getStartTime());
            ps.setString(4, loc.getEndTime());

            status = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return status;
    }
    
    public static List<Session> getLecture() {

        List<Session> list = new ArrayList<>();

        try {
            Connection connection = getConnection();
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement("select * from lecture");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Session s = new Session();

                s.setLecture((rs.getString("lecture")));
                s.setSsid(rs.getString("ssid"));
                s.setGroup(rs.getString("stdGroup"));
                s.setTime(rs.getString("timePeriod"));
                s.setSubGroup(rs.getString("subGroup"));

                list.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;

    }
    
    public static List<Employee> getEmployees() {

        List<Employee> list = new ArrayList<>();

        try {
            Connection connection = getConnection();
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement("select * from employee");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee e = new Employee();

                e.setEmployeeID((rs.getString("employeeID")));
                e.setEmployeeName(rs.getString("employeeName"));
                e.setStartDate(rs.getString("startDate"));
                e.setEndDate(rs.getString("endDate"));
                e.setWorkingDays(rs.getString("workingDays"));
                e.setWorkingHours(rs.getString("workingHours"));

                list.add(e);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;

    }
    
    public static int deleteLecture(Session s) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from lecture where ssid=?");
            ps.setString(1, s.getSsid());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return status;
    }
    
    public static int deleteEmployee(Employee e) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from employee where employeeID=?");
            ps.setString(1, e.getEmployeeID());
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return status;
    }
    
}
