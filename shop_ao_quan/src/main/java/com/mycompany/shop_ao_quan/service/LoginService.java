package com.mycompany.shop_ao_quan.service;
import com.mycompany.shop_ao_quan.dao.*;
import com.mycompany.shop_ao_quan.model.Employee;

public class LoginService {
    // check thong tin dang nhap
    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
    public Employee authenticate(String username, String password) throws Exception {
        // Thong tin dang nhap mac dinh
            Employee e = employeeDAO.findByUsername(username);
            if (e != null && e.getPassword().equals(password)) {
                return e;
            }
        return null;
    }
    // dang ki
    public void register(String username, String password, String name, String role) throws Exception {
        Employee newEmployee = new Employee(username, password, name, role);
        employeeDAO.save(newEmployee);
    }
}
