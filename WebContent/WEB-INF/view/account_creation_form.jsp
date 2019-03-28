<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Create Account</title>
		<style>
			.other_links {
				position:absolute;
				left:800px;
				top:20px;
				word-spacing: 30px;
			}
			.other_links a{
				text-decoration:none;
				font-size:18px;
			}
			.form{
				position:relative;
				top:50px;
			}
			td{
				padding-top: .5em;
    			padding-bottom: .5em;
    			border-collapse: collapse;
			}
			.name{
				font-size: 15px;
				font-family: 'Dosis', sans-serif;
				border :1px solid black;
				border-radius: 6px;
			}
			.pass{
				font-size: 15px;
				font-family: 'Dosis', sans-serif;
				border :1px solid black;
				border-radius: 6px;
			}
			.create{
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
		</style>
		
	</head>
	
	<body>
		<div class="other_links">
			<a href="/University_Laxman/About">About</a>
			<a href="/University_Laxman/login">Login</a>
		</div>
		<div align="center" class="form">
			<h2>Create your Student Account</h2>
			<form:form name="new_user_form" action="create_account" modelAttribute="new_student" method="POST">
				<form:hidden path="id"/>				
				<table>
					<tbody>
						<tr>
							<td><label>User Name: </label></td>
							<td><form:input onfocusout="sendInfo()" path="user_name" cssClass="name"/><span id="isE"> </span></td>
						</tr>
						
						<tr>
							<td><label>Password: </label></td>
							<td><form:input path="password" cssClass="pass"/></td>
						</tr>
						
						<tr>
							<td><label>Email: </label></td>
							<td><form:input onfocusout="sendInfo()" path="email" cssClass="name"/><span id="isE"> </span></td>
						</tr>
						
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Create" class="create"/></td>
						</tr>
					</tbody>
				</table>
			</form:form>
		</div>
		
		<script>  
			var request;  
			function sendInfo()  {  
				var v=document.getElementsByClassName("name")[0].value;
				var url="account_creation_form.jsp?val="+v;				
			  
				if(window.XMLHttpRequest){  
					request=new XMLHttpRequest();  
				}else if(window.ActiveXObject){  
					request=new ActiveXObject("Microsoft.XMLHTTP");  
				}  
				request.onreadystatechange= function (){ 
					if(request.readyState==4 && request.status==200){ 
						if(xmlhttp.responseText == "\n\n\n\n\nUser already exists"){
							document.getElementById("isE").innerHTML="User already Exists";
							document.getElementById("isE").style.color = "red";	
						}else{
							document.getElementById("isE").innerHTML="User Name Available";
                        	document.getElementById("isE").style.color = "green";
                        }                             
						document.getElementById("isE").innerHTML = xmlhttp.responseText;
					}
				}
			  
				try{
					request.open("GET",url,true);  
					request.send();					
				}catch(e){
					alert("Unable to connect to server");
				}  
			}  
			  
			  
		  
		</script>
		
	</body>
</html>