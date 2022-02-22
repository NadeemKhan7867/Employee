<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddEmployee</title>
</head>
<body>
	<h1>Enter Employee Details</h1>
	
	<form action="create" method="post">
	<pre>
ID: <input type="text" name="id" />
Name: <input type="text" name="name" />
age: <input type="text" name="age" />
Salary: <input type="text" name="sal" />
Designation: <input type="text" name="desig" />
<input type="submit" value="Create">
	</pre>
	</form>
	
</body>
</html>