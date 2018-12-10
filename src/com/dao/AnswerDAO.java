package com.dao;

import java.sql.*;
import java.text.*;
import java.util.*;

import com.model.Answer;
import com.model.Queans;

public class AnswerDAO 
{
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	static PreparedStatement ps=null;
	
	
	public static List<Answer> getAnswer(String qId)
	{
		List<Answer> local = new ArrayList<>();
		try{
			
			String url ="jdbc:mysql://localhost:3306/otp";
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection(url,"root","root");
			ps = con.prepareStatement("Select * from answer where questionid=?");
			ps.setString(1, qId);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				String answerid=rs.getString(1);           
				String answerdescription=rs.getString(2);      
				String questionid=rs.getString(3);       
				local.add(new Answer(answerid, answerdescription, questionid));
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		finally
		{
	
			try
			{
				con.close();
			}
			catch(Exception ex)
			{
				System.out.println("Closing Exception-Answer");
			}
		}
		return local;
	}
	public static boolean insertAnswer(Answer answer)
	{
	try{ 
			
			String url ="jdbc:mysql://localhost:3306/otp";
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection(url,"root","root");
			stmt= con.createStatement();
			}catch(Exception ex){
			System.out.println("Open Exception-Answer");	
			}
	boolean r=true;
		
			String query ="insert into answer value(?,?,?)";
			
			try{
				ps=con.prepareStatement(query);
				ps.setString(1,answer.getAnswerid());
				ps.setString(2, answer.getAnswerdescription());
				ps.setString(3, answer.getQuestionid());
				
				
				r=ps.execute();
				
			}catch(Exception ex)
			{
				System.out.println(ex);
			}
			finally
			{
		
				try{
					con.close();
				}catch(Exception ex)
				{
					System.out.println("Closing Exception-Answer");
				}
			}
		
		
			//QueansDAO.insertQueans(queans);
		
		return r;
	}
	public static boolean insertAnswer(List<Answer> answer,List<Queans> queans)
	{
	try{ 
			
			String url ="jdbc:mysql://localhost:3306/otp";
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection(url,"root","root");
			stmt= con.createStatement();
			}catch(Exception ex){
			System.out.println("Open Exception-Answer");	
			}
	boolean r=false;
		for(Answer x:answer)
		{
			String query ="insert into answer value(?,?,?)";
			
			try{
				ps=con.prepareStatement(query);
				ps.setString(1,x.getAnswerid());
				ps.setString(2, x.getAnswerdescription());
				ps.setString(3, x.getQuestionid());
				
				
				r=ps.execute();
				
			}catch(Exception ex)
			{
				System.out.println(ex);
			}
			finally
			{
		
				try{
					con.close();
				}catch(Exception ex)
				{
					System.out.println("Closing Exception-Answer");
				}
			}
		}
		
			QueansDAO.insertQueans(queans);
		
		return r;
	}
}
