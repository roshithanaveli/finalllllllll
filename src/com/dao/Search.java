package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.User;

public class Search
{
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	static Statement ps=null;


	public static String searchSubject(String subject)
	{
		String subjectid="";
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
			
			String query ="Select subjectid from subject where subjectname='"+subject.toUpperCase()+"'";
			
			rs=stmt.executeQuery(query);
			
			while(rs.next())
			subjectid=rs.getString(1);
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
		return subjectid;
	}


	public static String searchTrainer(String trainername) {
		// TODO Auto-generated method stub
		String trainerid="";
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
			
			String query ="Select userid from trainer where trainername='"+trainername+"'";
			
			rs=stmt.executeQuery(query);
			
			while(rs.next())
				trainerid=rs.getString(1);
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
		return trainerid;
	}
}
