package com.mycompany.shop_ao_quan.model;

public class Employee {
    private int employeeId;
    private String username;
    private String password;
    private String name;
    private String role;

    public Employee() {}
    public Employee(int employeeId, String username, String password, String name, String role) {
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}