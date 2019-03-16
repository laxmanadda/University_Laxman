<%@ page import="java.sql.*"%> 
  
<%  
	String s=request.getParameter("val");
	
	    
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