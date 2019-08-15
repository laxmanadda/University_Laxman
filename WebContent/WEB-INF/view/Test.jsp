<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	</head>
	<body>
	
		<input type="text" id="mySelect" onblur="myFunction()">
		
		<p id="demo"></p>
		
		<script>
			function myFunction() {
				var request;
				var v=document.getElementById("mySelect").value;
			  
				if(window.XMLHttpRequest){  
					request=new XMLHttpRequest();  
				}else if(window.ActiveXObject){  
					request=new ActiveXObject("Microsoft.XMLHTTP");  
				}
				
				request.onreadystatechange= function (){
					console.log(request.readyState);
					if(request.readyState==4 && request.status==200){
						document.getElementById("demo").innerHTML ="something";
					}
				}
			  
				try{
					request.open("GET","/University_Laxman/s/check_user_name?val="+v,true);
					request.send();
				}catch(e){
					alert("Unable to connect to server");
				}  
			}
		</script>
	</body>
</html>