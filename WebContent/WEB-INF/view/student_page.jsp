<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Programs Offered by Lakshman Adda University</title>
		<style>
			#customers {
			  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
			  border-collapse: collapse;
			  width: 100%;
			  margin-top:20px;
			  
			}
			
			#customers td, #customers th {
			  border: 1px solid #ddd;
			  padding: 8px;
			}
			
			#customers tr:nth-child(even){background-color: #f2f2f2;}
			
			#customers tr:hover {background-color: #ddd;}
			
			#customers th {
			  padding-top: 12px;
			  padding-bottom: 12px;
			  text-align: left;
			  background-color: #4CAF50;
			  color: white;
			}
		
		</style>
	</head>
	<body>
		<a style="position:relative;left:1200px;top:15px;font-size:20px;color:green;text-decoration:none" href="/University_Laxman/Logout">Logout</a>
		<h2>Fresh Programs</h2>
		<table id="customers">
			<tr>
				<th>Scheduled Program ID</th>
				<th>ProgramName</th>
				<th>location</th>
				<th>start_date</th>
				<th>end_date</th>
				<th>sessions_per_week</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="program" items="${not_applied}">
				
				<c:url var="apply_link" value="/form_for_apply" >
					<c:param name="program_schedule_id" value="${program.getScheduled_program_id()}"/>
					<c:param name="user_id" value="${user_id}"/>
				</c:url>
				<tr>
					<td>${program.getScheduled_program_id()}</td>
					<td>${program.getProgramName()}</td>
					<td>${program.getLocation()}</td>
					<td>${program.getStart_date() }</td>
					<td>${program.getEnd_date() }</td>
					<td>${program.getSessions_per_week()}</td>
					<td><a href="${apply_link}">Apply</a></td>
				</tr>
			</c:forEach>
		
		</table>
		
		<h2>Waiting for Interview Approval</h2>
		<table id="customers">
			<tr>
				<th>Scheduled Program ID</th>
				<th>ProgramName</th>
				<th>location</th>
				<th>start_date</th>
				<th>end_date</th>
				<th>sessions_per_week</th>
			</tr>
			<c:forEach var="program" items="${fresh}">
			
				<tr>
					<td>${program.getScheduled_program_id()}</td>
					<td>${program.getProgramName()}</td>
					<td>${program.getLocation()}</td>
					<td>${program.getStart_date() }</td>
					<td>${program.getEnd_date() }</td>
					<td>${program.getSessions_per_week()}</td>
					
				</tr>
			</c:forEach>
		
		</table>
		
		<h2>Waiting for Confirmation</h2>
		<table id="customers">
			<tr>
				<th>Scheduled Program ID</th>
				<th>ProgramName</th>
				<th>location</th>
				<th>start_date</th>
				<th>end_date</th>
				<th>sessions_per_week</th>
			</tr>
			<c:forEach var="program" items="${interview}">
				
				<tr>
					<td>${program.getScheduled_program_id()}</td>
					<td>${program.getProgramName()}</td>
					<td>${program.getLocation()}</td>
					<td>${program.getStart_date() }</td>
					<td>${program.getEnd_date() }</td>
					<td>${program.getSessions_per_week()}</td>
					
				</tr>
			</c:forEach>
		
		</table>
		
		<h2>Confirmed Applications</h2>
		<table id="customers">
			<tr>
				<th>Scheduled Program ID</th>
				<th>ProgramName</th>
				<th>location</th>
				<th>start_date</th>
				<th>end_date</th>
				<th>sessions_per_week</th>
			</tr>
			<c:forEach var="program" items="${confirmed}">

				<tr>
					<td>${program.getScheduled_program_id()}</td>
					<td>${program.getProgramName()}</td>
					<td>${program.getLocation()}</td>
					<td>${program.getStart_date() }</td>
					<td>${program.getEnd_date() }</td>
					<td>${program.getSessions_per_week()}</td>

				</tr>
			</c:forEach>
		
		</table>
		
		<h2>Rejected Applications</h2>
		<table id="customers">
			<tr>
				<th>Scheduled Program ID</th>
				<th>ProgramName</th>
				<th>location</th>
				<th>start_date</th>
				<th>end_date</th>
				<th>sessions_per_week</th>
			</tr>
			<c:forEach var="program" items="${rejected}">

				<tr>
					<td>${program.getScheduled_program_id()}</td>
					<td>${program.getProgramName()}</td>
					<td>${program.getLocation()}</td>
					<td>${program.getStart_date() }</td>
					<td>${program.getEnd_date() }</td>
					<td>${program.getSessions_per_week()}</td>

				</tr>
			</c:forEach>
		
		</table>
	</body>
</html>