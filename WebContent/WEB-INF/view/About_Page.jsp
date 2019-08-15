<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>About University Application</title>
		<style>
			a {
				color: #6c757d;
				font-family: "Merriweather Sans", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
				font-weight: 700;
				font-size: 1.2rem;
				padding: 0.75rem 0;
				text-decoration: none;
				position: relative;
				left: 600px;
				top: 20px;
			}
			a:hover {color: rgba(0, 0, 0, 0.7);}
			div {word-spacing: 30px;}
			html {
				background: url(/resources/images/bg-masthead.jpg) no-repeat center center fixed; 
				-webkit-background-size: cover;
				-moz-background-size: cover;
				-o-background-size: cover;
				background-size: cover;
			}
		</style>
	</head>
	
	<body>
		<div>
			<a href="/University_Laxman/About">About</a>
			<a href="/University_Laxman/Create_Student_Account">CreateAccount</a>
			<a href="/University_Laxman/login">Login</a>
			<a href="/University_Laxman/test">Test</a>
		</div>
		<br><br>
			<p>This is a small application created while learning Spring Framework and Hibernate. 
			It's for Univeristy procedure which has 3 access roles Admin, MAC, Student. Spring modules MVC, Security, 
			Hibernate with MySQL,JSP,AJAX are used. Admin role can add/delete/update the programs_offered or programs_scheduled. 
			Student apply for the programs and MAC will approve the applications he received. Both student and MAC cannot apply and 
			approve respectively in between application process start and after it ends. Application approval is a 2 step procedure. 
			If MAC approves an application, the next step is interview step and again MAC can either approve/reject. 
			Java Mail API is used for mailing. Student and MAC are shown applications according to the status.</p>
		
	</body>
</html>