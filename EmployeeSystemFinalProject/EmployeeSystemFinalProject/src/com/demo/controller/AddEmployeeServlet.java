package com.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImp;
import com.demo.model.Employee;

/**
 * Servlet implementation class AddEmployeeServlet
 */
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
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
		//doGet(request, response);
		String name = request.getParameter("name");
        String department = request.getParameter("department");
        double salary = Double.parseDouble(request.getParameter("salary"));

        //Employee emp = new Employee(name, department, salary);
        EmployeeDao e=new EmployeeDaoImp();
        int status =e.addEmployee(name, department, salary);
        PrintWriter out=response.getWriter();
		response.setContentType("text/html");
        if (status > 0) 
        {
        	out.println("<h1>Data added successfully!!!</h1>");
        	out.println("<br><br><a href='index.jsp'>Go Back</a>");
//        	RequestDispatcher rd=request.getRequestDispatcher("index.js");
//        	rd.include(request,response);
//        	out.println("<br><br><a href='index.jsp'>Go Back</a>");
        } else 
        {
           out.println("<h1>Error adding employee!<h1>");
           out.println("<br><br><a href='addEmployee.jsp'>Go Back</a>");
        }
	}

}
