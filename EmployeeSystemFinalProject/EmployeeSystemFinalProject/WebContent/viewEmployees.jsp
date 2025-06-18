<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,com.demo.model.Employee"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Employees</title>
</head>
<body>
    <%
        List<Employee> employees = (List<Employee>) request.getAttribute("employeeList");
        if (employees != null && !employees.isEmpty()) {
    %>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>Department</th><th>Salary</th></tr>
        <%
            for (Employee emp : employees) {
        %>
        <tr>
            <td><%= emp.getId() %></td>
            <td><%= emp.getName() %></td>
            <td><%= emp.getDepartment() %></td>
            <td><%= emp.getSalary() %></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        } else {
    %>
    <p>No employees found.</p>
    <%
        }
    %>
    <br><br><a href="index.jsp">Go Back</a>
</body>
</html>
