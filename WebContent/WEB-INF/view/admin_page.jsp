<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home-Admin</title>
		<link href="<c:url value="/resources/Admin.css"/>" rel="stylesheet">
	</head>
	
	<body>
		
		<a style="position:relative;left:1000px;top:15px;font-size:20px;color:green;text-decoration:none" href="/University_Laxman/logout">Logout</a>
		
		<input class="start" type="button" value="Start Process" onclick="window.location.href='admin_start';" <c:if test="${start}"><c:out value="disabled='disabled'"/></c:if>>
		<%
			Boolean start=(Boolean)request.getAttribute("start");  
			if(start){
				out.println("<font color=red size=4px>"+"Application process has been started"+"</font>");
			}
		%>
		<div class="program_offered">
			<a style="font-size:20px;margin:20px;" href="/University_Laxman/a/add_programs_offered">Add Program Offered</a><br>
			
			<table id="customers">
				<tr>
					<th>ProgramName</th>
					<th>description</th>
					<th>applicant_eligibility</th>
					<th>duration</th>
					<th>degree_certificate_offered</th>
					<th colspan="2">Action</th>
				</tr>
				
				<c:forEach var="program_offered" items="${programs_offered_list}">
					<c:url var="update_link" value="/update_programs_offered">
						<c:param name="program_name" value="${program_offered.getProgramName()}"/>
					</c:url>
					
					<c:url var="delete_link" value="/delete_programs_offered">
						<c:param name="program_name" value="${program_offered.getProgramName()}"/>
					</c:url>
					
					<tr>
						<td>${program_offered.getProgramName()}</td>
						<td>${program_offered.getDescription()}</td>
						<td>${program_offered.getApplicant_eligibility()}</td>
						<td>${program_offered.getDuration()}</td>
						<td>${program_offered.getDegree_certificate_offered()}</td>
						<td><a href="${update_link}">Update</a></td>
						<td><a href="${delete_link}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<br><br>
			
		<div class="program_offered">
			<a style="font-size:20px;margin:20px;" href="/University_Laxman/a/add_programs_scheduled">Add Program Scheduled</a>
			<table id="customers">
				<tr>
					<th>schedule_program_id</th>
					<th>ProgramName</th>
					<th>location</th>
					<th>start_date</th>
					<th>end_date</th>
					<th>sessions_per_week</th>
					<th colspan="2">Action</th>
				</tr>
				
				<c:forEach var="program_schedule" items="${programs_scheduled_list}">
					<c:url var="update_link" value="/update_programs_scheduled">
						<c:param name="schedule_id" value="${program_schedule.getScheduled_program_id()}"/>
					</c:url>
					
					<c:url var="delete_link" value="/delete_programs_scheduled">
						<c:param name="schedule_id" value="${program_schedule.getScheduled_program_id()}"/>
					</c:url>
					
					<tr>
						<td>${program_schedule.getScheduled_program_id()}</td>
						<td>${program_schedule.getProgramName()}</td>
						<td>${program_schedule.getLocation()}</td>
						<td>${program_schedule.getStart_date() }</td>
						<td>${program_schedule.getEnd_date()}</td>
						<td>${program_schedule.getSessions_per_week()}</td>
						<td><a href="${update_link}">Update</a></td>
						<td><a href="${delete_link}">Delete</a></td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</body>
</html>