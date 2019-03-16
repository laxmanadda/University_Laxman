<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Program Offered</title>
		<style>
			#submit{
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
			#red-star{color:red}
		</style>
	</head>
	<body>
		<div align="center" class="total">
			<form:form action="save_Program_Offered" modelAttribute="new_program_offered" method="POST">
				<h2>Add Program</h2>
				<table>
					<tbody>
						<tr>
							<td><label>Program_Offered_Name</label><span id="red-star"> (*) </span></td>
							<td><form:input path="ProgramName" cssClass="name" onfocusout="check_name()" onkeyup="checkform()"/><span id="name" style="color:red"></span></td>
						</tr>
						<tr>
							<td><label>Description</label><span id="red-star"> (*) </span></td>
							<td><form:input path="description" cssClass="name" onfocusout="check_description()" onkeyup="checkform()"/><span id="des" style="color:red"></span></td>
						</tr>
						<tr>
							<td><label>Applicant_eligibility</label><span id="red-star"> (*) </span></td>
							<td><form:input path="applicant_eligibility" cssClass="name" onfocusout="check_eligibility()" onkeyup="checkform()"/><span id="eligibility" style="color:red"></span></td>
						</tr>
						<tr>
							<td><label>Duration</label><span id="red-star"> (*) </span></td>
							<td><form:input path="duration" cssClass="name" onfocusout="check_duration()" onkeyup="checkform()"/><span id="duration_err" style="color:red"></span></td>
						</tr>
						<tr>
							<td><label>degree_certificate_offered</label><span id="red-star"> (*) </span></td>
							<td><form:input path="degree_certificate_offered" cssClass="name" onfocusout="check_certificate()" onkeyup="checkform()"/><span id="certi" style="color:red"></span></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Add" id="submit"/></td>
						</tr>
					</tbody>
				</table>
			</form:form>
		</div>
		
		<script>
			function check_name() {
			  var name = document.getElementsByClassName("name")[0];
			  
			  if(name.value==""){
				  document.getElementById("name").innerHTML = "Program Name cannot be empty";
			  }
			}
			function check_description() {
				  var name = document.getElementsByClassName("name")[1];
				  
				  if(name.value==""){
					  document.getElementById("des").innerHTML = "Description cannot be empty";
				  }
				}
			function check_eligibility() {
				  var name = document.getElementsByClassName("name")[2];
				  
				  if(name.value==""){
					  document.getElementById("eligibility").innerHTML = "Eligibility cannot be empty";
				  }
				}
			function check_duration() {
				  var name = document.getElementsByClassName("name")[3];
				  
				  if(isNaN(name.value) || name.value<1){
					  document.getElementById("duration_err").innerHTML = "Please enter a number greater than 0";
					  
				  }
				}
			function check_certificate() {
				  var name = document.getElementsByClassName("name")[4];
				  
				  if(name.value==""){
					  document.getElementById("certi").innerHTML = "Certificate name cannot be empty";
				  }
				}
			function checkform() {
				var name = document.getElementsByClassName("name")[0].value;
				var des = document.getElementsByClassName("name")[1].value;
				var elig = document.getElementsByClassName("name")[2].value;
				var dura = document.getElementsByClassName("name")[3].value;
				var certi = document.getElementsByClassName("name")[4].value;
			    var cansubmit = true;

		        if (name=="" || des=="" || elig=="" || dura=="" || certi==""){
		        	cansubmit = false;	
		        }

			    document.getElementById('submit').disabled = !cansubmit;
			}
			window.onload = checkform;
			
			
		</script>
	</body>
</html>