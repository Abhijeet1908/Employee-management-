<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addemployee">
	<%
	if (session.getAttribute("email") != null) {
	%>

	
		Emp-ID: &nbsp <input type="text" name="empid"
			pattern="[1-9]{1}[0-9]{5}"
			title="Id should be six digits and does not start with zero example - 123409"><br>
		<br> First Name : &nbsp <input type="text" name="fname"
			pattern="[a-zA-Z'-'\s]*"
			title="name should start with Uppercase and should have not spcial characters"><br>
		<br> Last Name : &nbsp <input type="text" name="lname"
			pattern="[a-zA-Z'-'\s]*"
			title="name should start with Uppercase and should have not spcial characters"><br>
		<br> <label for="doj">Date of joining: &nbsp</label> <input
			type="date" id="doj" name="doj"> <br> <br> <label
			for="dob">Date of Birth: &nbsp</label> <input type="date" id="dob"
			name="dob"> <br> <br> <label for="deptname">Department
			Name : &nbsp</label> <select name="deptname" id="deptname">
			<option value="Developer">Developer</option>
			<option value="Testing">Testing</option>
			<option value="Maintainance">Maintainance</option>
			<option value="Admin">Admin</option>
			<option value="HouseKeeping">HouseKeeping</option>
		</select><br> <br> <label for="grade">Grade : &nbsp</label> <select
			name="grade" id="grade">
			<option value="M1">M1</option>
			<option value="M2">M2</option>
			<option value="M3">M3</option>
			<option value="M4">M4</option>
			<option value="M5">M5</option>
			<option value="M6">M6</option>
			<option value="M7">M7</option>
		</select><br> <br> <br> <br> <label for="designation">Designation
			: &nbsp</label> <select name="designation" id="designation">
			<option value="manager">Manager</option>
			<option value="developer">Developer</option>
			<option value="trainee">Trainee</option>
			<option value="techsupport">Tech Support</option>
			<option value="teamlead">Team Lead</option>
		</select><br> <br> <label for="PersonGender">Gender : &nbsp </label>
		Male<input type="radio" value="Male" name="gender"> Female<input
			type="radio" value="Female" name="gender"> <br> <br>
		<label for="status">Status : &nbsp</label> <select name="status"
			id="status">
			<option value="single">Single</option>
			<option value="married">Married</option>
			<option value="divorced">Divorced</option>
			<option value="separated">Separated</option>
			<option value="widowed">Widowed</option>
		</select> <br> <br> Phone <input type="text" name="phone"
			pattern="[6-9]{1}[0-9]{9}"
			title="1 st digit should be '6-9' and phone number should be of 10 digits">
		<br> <br> Address: &nbsp
		<textarea rows="3" col="5" name="address"></textarea><br> <br>
		<input type="submit" name="submit">


	
	<%
	} else {
	response.sendRedirect("adminlogin");
	}
	%>




</form>
</body>
</html>