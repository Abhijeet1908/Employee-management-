<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="paysalary">
<h1>Pay salary</h1>
<%int id=Integer.parseInt(request.getParameter("empid"));%>
EmpId<input type="text" name="empid" value="<%=id%>"><br>
Number of LOP<input type="text" name="lop"><br>
Date<input type="date" name="date"><br>
<input type="submit" name="submit">
</form>
</body>
</html>