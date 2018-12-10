package com.dao;

	import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import com.model.Trainee;
import com.model.Trainer;
import com.model.User;
public class Searchuser
{
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	static Statement ps=null;


	public static String search(String uname)
	{
		String userid="";
		try{
			
			String url ="jdbc:mysql://localhost:3306/otp";
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection(url,"root","root");
			stmt= con.createStatement();
			}
			catch(Exception ex){
			System.out.println("Open Exception-User");	
			}

		List<User>local =new ArrayList<>();
		
		try
		{
			
			String query ="Select userid from user where username='"+uname+"'";
			
			rs=stmt.executeQuery(query);
			
			while(rs.next())
			userid=rs.getString(1);
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		finally
		{

			try{
				con.close();
			}catch(Exception ex)
			{
				System.out.println("Closing Exception-User");
			}
		}
		return userid;
	}
}


	


	
