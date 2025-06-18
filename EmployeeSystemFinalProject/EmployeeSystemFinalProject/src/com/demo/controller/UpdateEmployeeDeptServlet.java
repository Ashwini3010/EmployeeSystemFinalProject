package com.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImp;
import com.demo.model.Employee;

/**
 * Servlet implementation class UpdateEmployeeDeptServlet
 */
public class UpdateEmployeeDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeDeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
        //String name = request.getParameter("name");
        String department = request.getParameter("department");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Employee emp = new Employee(id,department,salary);
        EmployeeDao e=new EmployeeDaoImp();
        int status =e.updateEmployeeByDept(emp);
        PrintWriter out=response.getWriter();
		response.setContentType("text/html");
        if (status > 0) {
            //response.sendRedirect("viewEmployees.jsp");
        	out.print("<h1>Record updated successfully!!!</h1>");
        	out.println("<br><br><a href='index.jsp'>Go Back</a>");
        } else {
            //response.getWriter().println("Error updating employee!");
        	out.print("<h1>No Record found</h1>");
        	out.println("<br><br><a href='updateEmployeeDept.jsp'>Go Back</a>");
        }
//		int id = Integer.parseInt(request.getParameter("id"));
//	    String department = request.getParameter("department");
//	    double salary = Double.parseDouble(request.getParameter("salary"));
//
//	    // Fetch existing employee name to prevent losing it
//	    EmployeeDao e = new EmployeeDaoImp();
//	    Employee existingEmp = e.getEmployeeById(id);  // Fetch current employee details
//
//	    if (existingEmp != null) {
//	        Employee emp = new Employee(id, existingEmp.getName(), department, salary); // Preserve name
//	        int status = e.updateEmployeeByDept(emp);
//
//	        PrintWriter out = response.getWriter();
//	        response.setContentType("text/html");
//
//	        if (status > 0) {
//	            out.print("<h1>Record updated successfully!!!</h1>");
//	            out.println("<br><br><a href='index.jsp'>Go Back</a>");
//	        } else {
//	            out.print("<h1>No Record found</h1>");
//	            out.println("<br><br><a href='updateEmployeeDept.jsp'>Go Back</a>");
//	        }
//	    } else {
//	        PrintWriter out = response.getWriter();
//	        response.setContentType("text/html");
//	        out.print("<h1>Employee not found!</h1>");
//	        out.println("<br><br><a href='updateEmployeeDept.jsp'>Go Back</a>");
//	    }
		
    }
}

