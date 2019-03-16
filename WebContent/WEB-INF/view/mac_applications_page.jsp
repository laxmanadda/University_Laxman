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
									<form:options items="${mac_drop.programs_dropdown}" />
								</form:select>							
							</td>
						</tr>
						<tr>
							<td><label>Application_Status: </label></td>
							<td>
								<form:select path="status">
									<form:options items="${mac_drop.status_dropdown}" />
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

	</body>
</html>