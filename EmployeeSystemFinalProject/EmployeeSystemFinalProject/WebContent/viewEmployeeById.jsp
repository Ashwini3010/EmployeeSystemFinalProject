<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.demo.model.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Employee Details</h1>
    <%
        Employee employee = (Employee) request.getAttribute("employee");
    %>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>Department</th><th>Salary</th></tr>
        <tr>
            <td><%= employee.getId() %></td>
            <td><%= employee.getName() %></td>
            <td><%= employee.getDepartment() %></td>
            <td><%= employee.getSalary() %></td>
        </tr>
    </table>
    <br><br><a href="index.jsp">Go Back</a>
</body>
</html>