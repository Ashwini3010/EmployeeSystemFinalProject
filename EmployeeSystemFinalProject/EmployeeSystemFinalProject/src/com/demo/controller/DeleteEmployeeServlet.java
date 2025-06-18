package com.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImp;

/**
 * Servlet implementation class DeleteEmployeeServlet
 */
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployeeServlet() {
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
		String idStr = request.getParameter("id").trim();
		if (idStr.isEmpty()) {
            response.getWriter().println("<h1>Employee ID is required!</h1>");
            response.getWriter().println("<a href='deleteEmployee.jsp'>Go Back</a>");
            return;
        }
		try 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			EmployeeDao e=new EmployeeDaoImp();
			int status = e.deleteEmployee(id);
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			if (status > 0) {
            //response.sendRedirect("viewEmployees.jsp");
				out.print("<h1>Record Deleted successfully!!!</h1>");
				out.println("<br><br><a href='index.jsp'>Go Back</a>");
			} 
			else 
			{
            //response.getWriter().println("Error deleting employee!");
				out.print("<h1>No employee found with ID: " + id + "</h1>");
				out.println("<br><br><a href='deleteEmployee.jsp'>Go Back</a>");
			}
		}
		catch(NumberFormatException e) {
            response.getWriter().println("<h1>Invalid ID format! ID must be a number.</h1>");
            response.getWriter().println("<a href='deleteEmployee.jsp'>Go Back</a>");
	}
	
	}
}
