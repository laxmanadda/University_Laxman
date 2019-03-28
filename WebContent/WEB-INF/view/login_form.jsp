<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
	<head>
		<meta charset="ISO-8859-1">
		<title>Login Page</title>
		<link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Dosis|Indie+Flower" rel="stylesheet">
		<style type="text/css">
			.error {color:red}
			.other_links {
				position:absolute;
				left:750px;
				top:20px;
				word-spacing: 30px;
			}
			.other_links a{
				text-decoration:none;
				font-size:18px;
			}
			label {
				font-size: 15px;
				font-family: 'Dosis', sans-serif;
			}
			.full_form {
				position: relative;
				top: 30px;
			}
			.name{
				font-size: 15px;
				font-family: 'Dosis', sans-serif;
				border :1px solid black;
				border-radius: 6px;
			}
			.password {
				font-size: 15px;
				font-family: 'Dosis', sans-serif;
				border :1px solid black;
				border-radius: 6px;
			}
			
			td{
				padding-top: .5em;
    			padding-bottom: .5em;
    			border-collapse: collapse;
			}
			#submit {
				position :relative;
				left:40px;
				border-radius: 5px;
				border:none;
				color: white;
				background-color: grey;
				font-size :15px;
				padding-left: 15px;
				padding-right: 15px;
				padding-top: 5px;
				padding-bottom: 5px;
			}
			
			.reset {
				position :relative;
				left:40px;
				border-radius: 5px;
				border:none;
				color: white;
				background-color: grey;
				font-size :15px;
				padding-left: 15px;
				padding-right: 15px;
				padding-top: 5px;
				padding-bottom: 5px;
			}
			.red-star {
			color:red;}
		</style>
		
	</head>
	<body>
		<div class="other_links">
			<a href="/University_Laxman/About">About</a>
			<a href="/University_Laxman/Create_Student_Account">CreateAccount</a>
		</div>
		<div class="full_form">
		
			<div align="center">
				<h2>Please Enter your Credentials for login</h2>
			</div>
			
			
			<div align="center">
				<form:form action="check_user" modelAttribute="new_user" method="POST">
				<%
					String error_msg=(String)request.getAttribute("error");  
					if(error_msg!=null){
						out.println("<font color=red size=4px>"+error_msg+"</font>");
					}
				%>
			
				<form:hidden path="id"/>
					<table class="table">
						<tbody>
							
							<tr>
								<td>
									<label>User Name</label>
									<span class="red-star">(*)</span>
								</td>
								<td>
									<form:input path="user_name" cssClass="name" onfocusout="check_name()" onkeyup="checkform()"/>
									<span id="user" style="color:red"></span>
								</td>
								
							</tr>
							<tr>
								<td>
									<label>Password</label>
									<span class="red-star">(*)</span></td>
								<td>
									<form:password path="password" cssClass="password" onfocusout="check_pass()" onkeyup="checkform()"/>
									<span id="pass" style="color:red"></span>
								</td>
							</tr>
							<tr>
								<td><input type="submit" value="login" id="submit"/></td>
								<td><input type="reset" value="reset" class="reset"/></td>
							</tr>
						</tbody>
					</table>
				</form:form>
				
				<p>
					<a href="${pageContext.request.contextPath}"> Back to Home</a>
				</p>
			</div>
			
		</div>
		
		<script>
			function check_name() {
			  var name = document.getElementsByClassName("name")[0];
			  
			  if(name.value==""){
				  document.getElementById("user").innerHTML = "User Name cannot be empty";
			  }
			}
			function check_pass() {
			  var pass = document.getElementsByClassName("password")[0];
			  if(pass.value==""){
				  document.getElementById("pass").innerHTML = "Password cannot be empty";
			  }
			}
			function checkform() {
				var name = document.getElementsByClassName("name")[0];
				var pass = document.getElementsByClassName("password")[0];
			    var cansubmit = true;

		        if (name.value=="" || pass.value==""){
		        	cansubmit = false;	
		        }

			    document.getElementById('submit').disabled = !cansubmit;
			}
			window.onload = checkform;
		</script>
	</body>
</html>