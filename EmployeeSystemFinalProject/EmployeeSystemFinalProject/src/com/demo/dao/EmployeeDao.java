package com.demo.dao;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeDao {
	public int addEmployee(String name,String department,double salary);
	public List<Employee> getAllEmployees();
    public int deleteEmployee(int id);
    public int updateEmployee(Employee employee);
    public int updateEmployeeByDept(Employee employee);
    public Employee getEmployeeById(int id);
}
