package com.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class CheckData extends HttpServlet
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c1=DriverManager.getConnection("jdbc:mysql://localhost/faultmanagement?useSSL=false","root","root");
		Statement s1=c1.createStatement();

		ResultSet rs=s1.executeQuery("Select * from Mysql1;" );
		out.println("<html><head><title>Subject Data</title>");
		out.println("<style>");
		out.println("table { border-collapse: collapse; width: 100%; }");
		out.println("th, td { border: 1px solid #dddddd; text-align: left; padding: 8px; }");
		out.println("th { background-color: #f2f2f2; }");
		out.println("tr:nth-child(even) { background-color: #f9f9f9; }");
		out.println("</style>");
		out.println("</head><body>");
		out.println("<table><tr><th>Component_id</th><th>Type</th><th>Model</th><th>Status</th><th>Location</th><th>Vendor_id</th></tr>");
		
		while (rs.next())
		{
			 out.println("<tr><td>" + rs.getInt("component_id") + "</td><td>" + rs.getString("type") + "</td><td>"
                     + rs.getString("model")+"</td><td>" + rs.getString("status")+ "</td><td>"+ rs.getString("location")+"</td><td>"+ rs.getString("vendor_id")+"</td></tr>");
		}
		  out.println("</table></body></html>");
	}
		catch(Exception e)
		{
		}
}
}
