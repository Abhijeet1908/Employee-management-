<%@page import="java.io.PrintWriter"%>
<%@page import="com.ty.dto.SalaryDto"%>
<%@page import="com.ty.dto.EmployeeDto"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.service.SalaryService"%>
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
	{
	int id=(int)session.getAttribute("empid");
	SalaryService salaryService=new SalaryService();
	List<SalaryDto> list=salaryService.getListByEmpId(id);
	if(list!=null)
	{
	%>
	
<h1>Your salary slip</h1>
	<table border="2px solid black">
	<thead>
	<tr>
	<th>Employee ID</th>
	<th>Leaves</th>
	<th>Month</th>
	<th>Total salary</th>
	</tr>
	
	<%
	for(SalaryDto dto:list)
	{%>
	<tr>
	<td><%=dto.getDto().getEmpid() %></td>
	<td><%=dto.getLop()%></td>
	<td><%=dto.getMonth()%></td>
	<td><%=dto.getIssuedSal()%></td>
	</tr>
	<%}
	%>
		
		<%}else
		{%>
			<h1>No salary issued for your Employee Id</h1>
		 <%}
}else
		{
		response.sendRedirect("employeelogin.jsp");
		}%>
	</thead>
	</table>
</body>
</html>