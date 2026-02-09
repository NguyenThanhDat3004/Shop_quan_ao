package com.mycompany.shop_ao_quan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mycompany.shop_ao_quan.model.*;
public class EmployeeDAOImpl implements ShopInterface<Employee> {
    @Override
    public void save(Employee entity) {
        // Implementation here
    }
    @Override
    public Employee update(Employee entity) {
        // Implementation here
        return null;
    }

    @Override
    public Boolean delete(int id) {
        // Implementation here
        return null;
    }

    @Override
     public Employee getById(int employeeId) throws Exception {
        String sql = """
            SELECT employee_id, username, name, role
            FROM employee
            WHERE employee_id = ?
        """;
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Employee e = new Employee();
                e.setEmployeeId(rs.getInt("employee_id"));
                e.setUsername(rs.getString("username"));
                e.setName(rs.getString("name"));
                e.setRole(rs.getString("role"));
                return e;
            }
        }
        return null;
    }
    // tim theo username
    public Employee findByUsername(String username) throws Exception {
        String sql = """
            SELECT employee_id, username, password, name, role
            FROM employee
            WHERE username = ?
        """;

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Employee e = new Employee();
                    e.setEmployeeId(rs.getInt("employee_id"));
                    e.setUsername(rs.getString("username"));
                    e.setPassword(rs.getString("password")); 
                    e.setName(rs.getString("name"));
                    e.setRole(rs.getString("role"));
                    return e;
                }
            }
        }
        return null; 
    }
}
