<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Program Scheduled</title>
		<style>
			#add {
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
			#red-star{color:red;}
		</style>
	</head>
	<body>
		<div align="center" class="total">
			<h2>Add Program Scheduled</h2>
			<form:form action="save_Program_scheduled" modelAttribute="new_program_scheduled" method="POST">
		
			<form:hidden path="scheduled_program_id"/>
				<table>
					<tbody>
						<tr>
							<td><label>ProgramName: </label><span id="red-star"> (*) </span></td>
							<td><form:input path="ProgramName" onfocusout="check_name()"  onkeyup="checkform()" cssClass="name"/><span id="pro_name" style="color:red"></span></td>
						</tr>
						<tr>
							<td><label>location: </label><span id="red-star"> (*) </span></td>
							<td><form:input path="location" onfocusout="check_location()"  onkeyup="checkform()" cssClass="name"/><span id="loc" style="color:red"></span></td>
						</tr>
						<tr>
							<td><label>start_date: </label><span id="red-star"> (*) </span></td>
							<td><form:input path="start_date" type="date" onfocusout="check_start_date()"  onkeyup="checkform()" cssClass="name"/><span id="start" style="color:red"></span></td>
						</tr>
						<tr>
							<td><label>end_date: </label><span id="red-star"> (*) </span></td>
							<td><form:input type="date" path="end_date" onfocusout="check_end_date()"  onkeyup="checkform()" cssClass="name"/><span id="end" style="color:red"></span></td>
						</tr>
						<tr>
							<td><label>sessions_per_week: </label><span id="red-star"> (*) </span></td>
							<td><form:input path="sessions_per_week" onfocusout="check_sessions()"  onkeyup="checkform()" cssClass="name"/><span id="sessions" style="color:red"></span></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Add" id="add"/></td>
						</tr>
					</tbody>
				</table>
			</form:form>
		</div>
		
		<script>
			function check_name() {
			  var name = document.getElementsByClassName("name")[0];
			  
			  if(name.value==""){
				  document.getElementById("pro_name").innerHTML = "Program Name cannot be empty";
			  }
			}
			function check_location() {
				  var name = document.getElementsByClassName("name")[1];
				  
				  if(name.value==""){
					  document.getElementById("loc").innerHTML = "Location cannot be empty";
				  }
				}
			function check_start_date() {
				  var name = document.getElementsByClassName("name")[2].value;
				  var start_date=new Date(name);
				  var now=new Date();
				  
				  if(start_date=="" || start_date<now){
					  document.getElementById("start").innerHTML = "Enter Future Date";
				  }
				}
			function check_end_date() {
				var name = document.getElementsByClassName("name")[3].value;
				  var end_date=new Date(name);
				  var now=new Date();
				  
				  if(end_date=="" || end_date<now){
					  document.getElementById("start").innerHTML = "Enter Future Date";
				  }
				}
			function check_sessions() {
				  var name = document.getElementsByClassName("name")[4];
				  
				  if(isNaN(name.value) || name.value<1){
					  document.getElementById("session").innerHTML = "Sessions should be non negative";
				  }
				}	
		
			function checkform() {
				var name = document.getElementsByClassName("name")[0].value;
				var loc = document.getElementsByClassName("name")[1].value;
				var start = document.getElementsByClassName("name")[2].value;
				var end = document.getElementsByClassName("name")[3].value;
				var sessions = document.getElementsByClassName("name")[4].value;
			    var cansubmit = true;
	
		        if (name=="" || loc=="" || start=="" || end=="" || sessions==""){
		        	cansubmit = false;	
		        }
	
			    document.getElementById('add').disabled = !cansubmit;
			}
			window.onload = checkform;
		</script>
		
	</body>
</html>