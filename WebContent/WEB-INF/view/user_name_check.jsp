<%@ page import="java.sql.*"%> 
  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	</head>
	<body>
		<%  
		String s=request.getParameter("val");
		System.out.println("Database");
		
		    
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","Prabhasraju1.");  
			PreparedStatement ps=con.prepareStatement("select * from user where user_name=?");  
			ps.setString(1,s);
			ResultSet rs=ps.executeQuery();  
			if(rs.first()){
	            out.print("User already exists");
	        }else{
	            out.print("User name is valid");
	        } 
		con.close();  
		}catch(Exception e){
			e.printStackTrace();
		}
		%> 
		
	</body>
</html>