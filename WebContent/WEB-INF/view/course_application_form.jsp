<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<style>
			.apply {
				margin:20px;
				border-radius: 5px;
				border:none;
				color: white;
				background-color: green;
				font-size :15px;
				padding-left: 15px;
				padding-right: 15px;
				padding-top: 5px;
				padding-bottom: 5px;
			}
			td{
				padding-top: .5em;
    			padding-bottom: .5em;
    			border-collapse: collapse;
			}
			.total{
				position:relative;
				top:70px;
			}
			.name{
				font-size: 15px;
				font-family: 'Dosis', sans-serif;
				border :1px solid black;
				border-radius: 6px;
			}
		</style>
	</head>
	
	<body>
		<div align="center" class="total">
		<h2>Fill Your Details to Apply</h2>
			<form:form action="save_application" modelAttribute="new_app" method="POST">
			<form:hidden path="application_id"/>
			<form:hidden path="user_id"/>
			<form:hidden path="schedule_program_id"/>
			<form:hidden path="date_of_interview"/>
				<table>
					<tbody>
						<tr>
							<td><label>Full Name: </label></td>
							<td><form:input path="full_name" cssClass="name"/></td>
						</tr>
						<tr>
							<td><label>Date of Birth: </label></td>
							<td><form:input type="date" path="date_of_birth" cssClass="name"/></td>
						</tr>
						<tr>
							<td><label>Highest Qualification: </label></td>
							<td><form:input path="highest_qualification" cssClass="name"/></td>
						</tr>
						<tr>
							<td><label>Marks Obtained: </label></td>
							<td><form:input path="marks_obtained" cssClass="name"/></td>
						</tr>
						<tr>
							<td><label>Goals: </label></td>
							<td><form:input path="goals" cssClass="name"/></td>
						</tr>
						<tr>
							<td><label>Email ID: </label></td>
							<td><form:input path="email_id" cssClass="name"/></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Apply" class="apply"/></td>
						</tr>
					</tbody>
				</table>
			</form:form>
		</div>
	</body>
</html>