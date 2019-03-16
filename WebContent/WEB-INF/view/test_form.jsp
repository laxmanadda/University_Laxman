<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login Page</title>
		<style type="text/css">
			.error {color:red}
		</style>
		
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Please Enter your Credentials for login</h2>
			</div>
		</div>
		
		<div id="container">
			<form:form action="check_user_validation" modelAttribute="new_user" method="POST">				
				<table>
					<tbody>
						<tr>
							<td><label>first_name: </label></td>
							<td><form:input path="first_name"/></td>
							
						</tr>
						<tr>
							<td><label>last_name: </label></td>
							<td><form:password path="last_name"/></td>
							<form:errors path="last_name" cssClass="error"/>
						</tr>
						
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="login" class="save"/></td>
						</tr>
					</tbody>
				</table>
			</form:form>
			
			<p>
				<a href="${pageContext.request.contextPath}"> Back to Home</a>
			</p>
		</div>
	</body>
</html>