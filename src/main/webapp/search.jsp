<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ty.dto.EmployeeDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
		
		List<EmployeeDto> employees = (ArrayList)request.getAttribute("list") ;
	%>

	<table border="2px solid black" >
		<tr>
			<th>EmployeeID</th>
	<th>FirstName</th>
	<th>LastName</th>
	<th>DOJ</th>
	<th>DOB</th>
	<th>DeptName</th>
	<th>Grade</th>
	<th>Designation</th>
	<th>Gender</th>
	<th>Status</th>
	<th>Address</th>
	<th>Phone</th>
	<th>Salary</th>
	<th>Edit</th>
	<th>Delete</th>
	<th>PaySal</th>
		</tr>
		
		<tr>
		<%
			for (EmployeeDto employee : employees) {
		%>
			<td><%=employee.getEmpid()%></td>
			<td><%=employee.getFname()%></td>
			<td><%=employee.getLname()%></td>
			<td><%=employee.getDob()%></td>
			<td><%=employee.getDoj()%></td>
			<td><%=employee.getDeptname()%></td>
			<td><%=employee.getGrade()%></td>
			<td><%=employee.getDesignation()%></td>
			<td><%=employee.getGender()%></td>
			<td><%=employee.getStatus()%></td>
			<td><%=employee.getAddress()%></td>
			<td><%=employee.getPhone()%></td>
			<td><%=employee.getSal()%></td>
			<td><a href="editemployee?empid=<%=employee.getEmpid()%>">Edit</a></td>
		<td><a href="deleteemployee?empid=<%=employee.getEmpid()%>">Delete</a></td>
		<td><a href="paysal.jsp?empid=<%=employee.getEmpid()%>">PaySal</a></td>
			  </tr>
		<%
			}
		%>
			
			
			  
			
		
</body>
</html>