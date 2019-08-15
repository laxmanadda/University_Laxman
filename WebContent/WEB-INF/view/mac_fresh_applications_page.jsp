<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Applications MAC</title>
		<link href="<c:url value="/resources/Admin.css"/>" rel="stylesheet">
	</head>
	
	<body>
		<form:form action="mac_search" modelAttribute="mac_drop" method="GET">
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
				<c:url var="approve_link" value="/approve_fresh_app">
					<c:param name="App_id" value="${fresh_app.getApplication_id()}"/>
					<c:param name="schedule_id" value="${fresh_app.getSchedule_program_id()}"/>
				</c:url>
				
				<c:url var="reject_link" value="/reject_app">
					<c:param name="App_id" value="${fresh_app.getApplication_id()}"/>
				</c:url>
				
				<tr>
					<td>${fresh_app.getApplication_id()}</td>
					<td>${fresh_app.getFull_name() }</td>
					<td>${fresh_app.getUser_id()}</td>
					<td>${fresh_app.getDate_of_birth()}</td>
					<td>${fresh_app.getHighest_qualification() }</td>
					<td>${fresh_app.getMarks_obtained() }</td>
					<td>${fresh_app.getGoals() }</td>
					<td>${fresh_app.getEmail_id() }</td>
					<td>${fresh_app.getSchedule_program_id()}</td>
					<td>${fresh_app.getStatus() }</td>
					<td>${fresh_app.getDate_of_interview() }</td>
					
					<td><a href="${approve_link}">Approve</a></td>
					<td><a href="${reject_link}">Reject</a></td>
				</tr>
			</c:forEach>
			
		</table>
	</body>
</html>