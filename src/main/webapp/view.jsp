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
<%if(session.getAttribute("email")!=null)
	{
	%>
	
	<%@include file="searchbar.jsp" %><br><br><br>
	
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
	<th>Edit</th>
	<th>Delete</th>
	<th>PaySal</th>
	</tr>
	
	<%EmployeeService employeeService=new EmployeeService();
      List<EmployeeDto> list=employeeService.getAllEmployees();%>
     <% for(EmployeeDto dto:list)
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
		<td><a href="editemployee?empid=<%=dto.getEmpid()%>">Edit</a></td>
		<td><a href="deleteemployee?empid=<%=dto.getEmpid()%>">Delete</a></td>
		<td><a href="paysal.jsp?empid=<%=dto.getEmpid()%>">PaySal</a></td>
      </tr>
      <%} %>
	</thead>
	</table>
	<%}else
		{
		response.sendRedirect("login.jsp");
		}%>
<h1><a href="logout">Logout</a></h1>	
</body>
</html>