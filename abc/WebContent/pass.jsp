<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.io.*,java.sql.*" %>


<%

 String sn = request.getParameter("var");
   Class.forName("com.mysql.jdbc.Driver");

	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/job_portal?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
	PreparedStatement pst = con.prepareStatement("SELECT * FROM register WHERE email='"+sn+"'");
	ResultSet rs = pst.executeQuery();
	
	if(rs.next()){
		
		out.println("<font color=red>");
		out.println("Email Already Exists");
		out.println("</font>");
		
	}else{
		out.println("<font color=blue>");
		out.println("Email Available");
		out.println("</font>");
		
	}
	rs.close();;
	pst.close();;
	con.close();;
	
%>