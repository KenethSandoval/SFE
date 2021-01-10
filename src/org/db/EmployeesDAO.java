package org.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.beans.Employees;


public interface EmployeesDAO extends  ConnectionDB, MappingEmployees{
    default  ArrayList<Employees> getEmployees () {
        ArrayList<Employees> employees = new ArrayList<>();
        PreparedStatement prst;
        ResultSet rs;

        try (Connection conn = initConnection()){
            prst = conn.prepareStatement(GET_EMPLOYEES);
            rs = prst.executeQuery(GET_EMPLOYEES);

            while (rs.next()) {
                System.out.println(rs.getString(NAME_EMPLOYEE));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
