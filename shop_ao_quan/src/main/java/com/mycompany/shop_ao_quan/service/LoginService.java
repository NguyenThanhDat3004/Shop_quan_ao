package com.mycompany.shop_ao_quan.service;
import com.mycompany.shop_ao_quan.dao.*;
import com.mycompany.shop_ao_quan.model.Employee;

public class LoginService {
    // check thong tin dang nhap
    public boolean authenticate(String username, String password) throws Exception {
        // Thong tin dang nhap mac dinh
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
            Employee e = employeeDAO.findByUsername(username);
            if (e != null && e.getPassword().equals(password)) {
                return true;
            }
        return false;
    }
}
