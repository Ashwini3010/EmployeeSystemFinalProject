<!--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddEmployeeServlet" method="post">
    Name: <input type="text" name="name"><br>
    Department: <input type="text" name="department"><br>
    Salary: <input type="text" name="salary"><br>
    <input type="submit" value="Add Employee">
</form>
</body>
</html>-->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Employee</title>
    <script>
        function validateForm() {
            const name = document.forms["employeeForm"]["name"].value.trim();
            const department = document.forms["employeeForm"]["department"].value.trim();
            const salary = document.forms["employeeForm"]["salary"].value.trim();

            if (name === "" || department === "" || salary === "") {
                alert("All fields are required!");
                return false;
            }
            if (isNaN(salary) || salary <= 0) {
                alert("Salary must be a positive number!");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <h1>Add Employee</h1>
    <form name="employeeForm" action="AddEmployeeServlet" method="post" onsubmit="return validateForm();">
        Name: <input type="text" name="name"><br><br>
        Department: <input type="text" name="department"><br><br>
        Salary: <input type="text" name="salary"><br><br>
        <input type="submit" value="Add Employee"><br><br>
    </form>
    <a href="index.jsp">Go Back</a>
</body>
</html>
