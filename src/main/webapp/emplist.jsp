<%@page import="java.io.PrintWriter"%>
<%@page import="com.ty.service.SalaryService"%>
<%@page import="com.ty.dto.SalaryDto"%>
<%@page import="com.ty.dto.EmployeeDto"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.service.EmployeeService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(session.getAttribute("empid")!=null)
	{%>
	<table border="2px solid black">
	<thead>
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
	</tr>
	
	<%EmployeeService employeeService=new EmployeeService();
      List<EmployeeDto> employees=employeeService.getAllEmployees();%>
     <% for(EmployeeDto dto:employees)
      {%>
      <tr>
      <td><%=dto.getEmpid() %></td>
      <td><%=dto.getFname() %></td>
      <td><%=dto.getLname() %></td>
      <td><%=dto.getDoj()%></td>
      <td><%=dto.getDob() %></td>
      <td><%=dto.getDeptname() %></td>
      <td><%=dto.getGrade()%></td>
      <td><%=dto.getDesignation() %></td>
      <td><%=dto.getGender()%></td>
      <td><%=dto.getStatus()%></td>
      <td><%=dto.getAddress()%></td>
      <td><%=dto.getPhone()%></td>
		<td><%=dto.getSal()%></td>
      </tr>
      <%} %>
      
	</thead>
	</table>

	<%}else
		{
		response.sendRedirect("employeelogin.jsp");
		}%>
	<h1><a href="logout">Logout</a></h1>
</body>
</html>