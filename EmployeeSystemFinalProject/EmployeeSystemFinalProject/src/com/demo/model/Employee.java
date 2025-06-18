package com.demo.model;
public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private static int count=100;

    public Employee() {}

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    

//    public Employee(int id, double salary) {
//		super();
//		this.id = id;
//		this.salary = salary;
//	}
    public Employee(int id,String name, String department, double salary) {
    	this.id=id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public Employee(int id,String department, double salary) {
    	this.id=id;
        this.department = department;
        this.salary = salary;
    }

	public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary + "]";
	}
    
}
