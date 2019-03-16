<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<style>
			.search{
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
			tr {display:inline;padding-right: 2.5em;}
			.total{
				position:relative;
				top:20px;
			}
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
	<form:form action="mac_search" modelAttribute="mac_drop" method="POST">
			<table>
					<tbody>
						<tr>
							<td><label>Program_Offered_Name: </label></td>
							<td>
								<form:select path="program_name">
									<form:options items="${mac_drop.getPrograms_dropdown()}" />
								</form:select>							
							</td>
						</tr>
						<tr>
							<td><label>Application_Status: </label></td>
							<td>
								<form:select path="status">
									<form:options items="${mac_drop.getStatus_dropdown()}" />
								</form:select>
							</td>
						</tr>
						
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="search" class="save"/></td>
						</tr>
					</tbody>
			</table>
		</form:form>
		<table id="customers">
				<tr>
					<th>Application ID</th>
					<th>Full Name</th>
					<th>Date of Birth</th>
					<th>Highest Qualification</th>
					<th>Marks Obtained</th>
					<th>Goals</th>
					<th>Email ID</th>
					<th>Scheduled Program ID</th>
					<th>Status</th>
					<th>Date of Interview</th>
					<th colspan="2">Action</th>
				</tr>
				
				<c:forEach var="fresh_app" items="${applications}">
					<c:url var="approve_link" value="/approve_interview_app">
						<c:param name="App_id" value="${fresh_app.application_id}"/>
					</c:url>
					
					<c:url var="reject_link" value="/reject_app">
						<c:param name="App_id" value="${fresh_app.application_id}"/>
					</c:url>
					
					<tr>
						<td>${fresh_app.application_id}</td>
						<td>${fresh_app.full_name}</td>
						<td>${fresh_app.date_of_birth}</td>
						<td>${fresh_app.highest_qualification}</td>
						<td>${fresh_app.marks_obtained}</td>
						<td>${fresh_app.goals}</td>
						<td>${fresh_app.email_id}</td>
						<td>${fresh_app.schedule_program_id}</td>
						<td>${fresh_app.status}</td>
						<td>${fresh_app.date_of_interview}</td>
						
						<td><a href="${approve_link}">Approve</a></td>
						<td><a href="${reject_link}">Reject</a></td>
					</tr>
				</c:forEach>
				
			</table>
	</body>
</html>