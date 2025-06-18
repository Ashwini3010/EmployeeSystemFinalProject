<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
        function validateForm() {
            const id = document.forms["employeeForm"]["id"].value.trim();
            const department = document.forms["employeeForm"]["department"].value.trim();
            const salary = document.forms["employeeForm"]["salary"].value.trim();

            if (id === "" || department === "" || salary === "") {
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
<body>
	<form name="employeeForm" action="UpdateEmployeeDeptServlet" method="post" onsubmit="return validateForm();">
    ID: <input type="text" name="id"><br><br>
    Enter Updated Department: <input type="text" name="department"><br><br>
    Enter Updated Salary: <input type="text" name="salary"><br><br>
    <input type="submit" value="update Employee" name="update">
</body>
</html>