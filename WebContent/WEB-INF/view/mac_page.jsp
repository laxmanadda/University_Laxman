<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home-MAC</title>
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
		</style>
	</head>
	
	
	<body>
		<div align="center" class="total">
			<%
				String error_msg=(String)request.getAttribute("no_app_error");  
				if(error_msg!=null){
					out.println("<font color=red size=4px>"+error_msg+"</font>");
				}
			%>
			<h2>Select Program name and Application Type</h2>
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
							<td><input type="submit" value="search" class="search"/></td>
						</tr>
					</tbody>
				</table>
			</form:form>
		</div>
	</body>
</html>