package com.demo.controller;

import java.io.IOException;
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
 * Servlet implementation class SearchEmployeeServlet
 */
public class SearchEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmployeeServlet() {
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
		String idStr = request.getParameter("id").trim();

        // Validate ID input
        if (idStr.isEmpty()) {
            response.getWriter().println("<h1>Employee ID is required!</h1>");
            response.getWriter().println("<a href='searchEmployee.jsp'>Go Back</a>");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);

            // Use DAO to search for the employee by ID
            EmployeeDao dao = new EmployeeDaoImp();
            Employee employee = dao.getEmployeeById(id);

            if (employee != null) {
                request.setAttribute("employee", employee);
                RequestDispatcher rd = request.getRequestDispatcher("viewEmployeeById.jsp");
                rd.forward(request, response);
            } else {
                response.getWriter().println("<h1>No employee found with ID: " + id + "</h1>");
                response.getWriter().println("<a href='searchById.jsp'>Go Back</a>");
            }
        } catch (NumberFormatException e) {
            response.getWriter().println("<h1>Invalid ID format! ID must be a number.</h1>");
            response.getWriter().println("<a href='searchById.jsp'>Go Back</a>");
        }

	}
}

