<%@page import="com.ty.dto.SalaryDto"%>
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
	<%
	if (session.getAttribute("email") != null) {
	%>
	<table border="2px solid black">
		<thead>
			<tr>
				<th>Salary ID</th>
				<th>Employee ID</th>
				<th>LOP</th>
				<th>Month</th>
				<th>Total Salary</th>
				<th>Deducted Salary</th>
				<th>Issued Salary</th>
			</tr>

			<%
			SalaryService salaryService = new SalaryService();
			List<SalaryDto> list = salaryService.getList();
			for (SalaryDto dto : list) {
			%>
			<tr>
				<td><%=dto.getId()%></td>
				<td><%=dto.getDto().getEmpid()%></td>
				<td><%=dto.getLop()%></td>
				<td><%=dto.getMonth()%></td>
				<td><%=dto.getTotalSal()%></td>
				<td><%=dto.getDeductedSal()%></td>
				<td><%=dto.getIssuedSal()%></td>
			</tr>
			<%
			}
			%>
		</thead>
	</table>
	<%
	} else {
	response.sendRedirect("login.jsp");
	}
	%>

	<h1>
		<a href="logout">Logout</a>
	</h1>
</body>
</html>