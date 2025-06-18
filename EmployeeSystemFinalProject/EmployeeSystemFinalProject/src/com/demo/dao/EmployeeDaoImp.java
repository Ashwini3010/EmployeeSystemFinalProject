package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import com.demo.bean.Book;
import com.demo.model.Employee;

public class EmployeeDaoImp implements EmployeeDao{
	public int addEmployee(String name,String department,double salary) {
        int status = 0;
        try (Connection conn = DBUtility.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO employees1 (id,name, department, salary) VALUES (emp_id_seq.NEXTVAL, ?, ?, ?)");
            Employee employee=new Employee(name,department,salary);
            //ps.setInt(1, employee.getId());
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getDepartment());
            ps.setDouble(3, employee.getSalary());
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = DBUtility.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id,name,department,salary FROM employees1");
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setDepartment(rs.getString("department"));
                emp.setSalary(rs.getDouble("salary"));
                System.out.println(emp);
                employees.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in getAllEmployees: " + e.getMessage());
        }
//        System.out.println("Number of employees fetched: " + employees.size());
        return employees;
    }

//    public int deleteEmployee(int id) {
//        int status = 0;
//        try (Connection conn = DBUtility.getConnection()) {
//            PreparedStatement ps = conn.prepareStatement("DELETE FROM employees1 WHERE id = ?");
//            ps.setInt(1, id);
//            status = ps.executeUpdate();
//            if(status>0)
//            {
////            	System.out.println("record deleted");
////            	System.out.print(b);
//            	ArrayList<Employee>e=(ArrayList<Employee>) getAllEmployees() ;
//    			for(int j=0;j<e.size();j++)
//    			{
//    				
//    				if(id==e.get(j).getId())
//    				{
//    					System.out.println(e);
//    					e.remove(e.get(j));
//    					System.out.println(e.get(j));
//    					break;
//    				}
//    			}
//    			System.out.println("Record deleted successfully");
//            }
//            else
//            {
//            	System.out.println("unable to delete record");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Number of employees fetched: " + status);
//        return status;
//    }
    public int deleteEmployee(int id) {
        int status = 0;
        try (Connection conn = DBUtility.getConnection()) {
            if (conn != null) {
                // Prepare the DELETE SQL query
                String sql = "DELETE FROM employees1 WHERE id = ?";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setInt(1, id);
                    status = ps.executeUpdate(); // Execute the query
                    
                    if (status > 0) {
                        System.out.println("Record with ID " + id + " deleted successfully.");
                    } else {
                        System.out.println("No record found with ID " + id + ".");
                    }
                }
            } else {
                System.err.println("Failed to establish a database connection.");
            }
        } catch (Exception e) {
            System.err.println("Error while deleting employee: " + e.getMessage());
            e.printStackTrace();
        }
        return status;
    }


    public int updateEmployee(Employee employee) {
        int status = 0;
        try (Connection conn = DBUtility.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE employees1 SET name = ?, department = ?, salary = ? WHERE id = ?");
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getDepartment());
            ps.setDouble(3, employee.getSalary());
            ps.setInt(4, employee.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    public int updateEmployeeByDept(Employee employee)
    {
        int status = 0;
        try (Connection conn = DBUtility.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE employees1 SET department = ?, salary = ? WHERE id = ?");
//            ps.setString(1, employee.getName());
            ps.setString(1, employee.getDepartment());
            ps.setDouble(2, employee.getSalary());
            ps.setInt(3, employee.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try {
        Connection conn = DBUtility.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT id, name, department, salary FROM employees1 WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                employee = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("department"),
                    rs.getDouble("salary")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

}
