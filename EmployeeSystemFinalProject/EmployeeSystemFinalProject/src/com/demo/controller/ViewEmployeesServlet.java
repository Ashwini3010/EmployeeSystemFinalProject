package com.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImp;
import com.demo.model.Employee;

/**
 * Servlet implementation class ViewEmployeesServlet
 */
public class ViewEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEmployeesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		EmployeeDao e=new EmployeeDaoImp();
		List<Employee> employees = e.getAllEmployees();
        request.setAttribute("employeeList", employees);
        RequestDispatcher rd = request.getRequestDispatcher("viewEmployees.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
//		List<Employee> employees = EmployeeDao.getAllEmployees();
//        request.setAttribute("employeeList", employees);
//        RequestDispatcher rd = request.getRequestDispatcher("viewEmployees.jsp");
//        rd.forward(request, response);
	}

}
