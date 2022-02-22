<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DeleteEmp</title>
</head>
<body>
	<h1>Enter Employee Details to delete</h1>
	
	<form action="delete" method="post">
	<pre>
ID: <input type="text" name="id" />
Name: <input type="text" name="name" />
<input type="submit" value="delete">
	</pre>
	</form>
</body>
</html>