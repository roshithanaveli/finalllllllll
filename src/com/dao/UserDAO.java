package com.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import com.model.Decryption;
import com.model.Encryption;
import com.model.Trainee;
import com.model.Trainer;
import com.model.User;

public class UserDAO {
private static Connection con;
private static Statement stmt;
private static ResultSet rs;
static PreparedStatement ps=null;


public static List<User> getUser()
{
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
	try{
		String query ="Select * from user";
		rs=stmt.executeQuery(query);
		
		while(rs.next())
		{
			String userid=rs.getString(1);     
			String username=rs.getString(2);   
			String password=Decryption.decry(rs.getString(3));   
			
		local.add(new User(userid,username, password));
		}
	}catch(Exception ex){
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
	return local;
}




public static boolean insertUser(User u,Trainer t)
{
try{
		
		String url ="jdbc:mysql://localhost:3306/otp";
		Class.forName("com.mysql.jdbc.Driver");
		con =DriverManager.getConnection(url,"root","root");
		stmt= con.createStatement();
		}catch(Exception ex){
		System.out.println("Open Exception-User");	
		}
	
	String query ="insert into user value(?,?,?)";
	boolean r=true;
	try
	{
		ps=con.prepareStatement(query);
		ps.setString(1, u.getUserid());
		ps.setString(2, u.getUsername());
		ps.setString(3, Encryption.encryp(u.getPassword()));
		
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
			System.out.println("Closing Exception-User");
		}
	}
	
	TrainerDAO.insertTrainer(t);
	
	return r;
}
public static boolean insertUser(User u,Trainee tr)
{
try{
		
		String url ="jdbc:mysql://localhost:3306/otp";
		Class.forName("com.mysql.jdbc.Driver");
		con =DriverManager.getConnection(url,"root","root");
		stmt= con.createStatement();
		}catch(Exception ex){
		System.out.println("Open Exception-User");	
		}
	
	String query ="insert into user value(?,?,?)";
	boolean r=true;
	try
	{
		ps=con.prepareStatement(query);
		ps.setString(1, u.getUserid());
		ps.setString(2, u.getUsername());
		ps.setString(3, Encryption.encryp(u.getPassword()));
		
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
			System.out.println("Closing Exception-User");
		}
	}
	
	TraineeDAO.insertTrainee(tr);
	return r;
}
public static boolean check_id(User a)
{
	boolean ret =false;
	
	List<User> ulist= UserDAO.getUser();
	
	System.out.println("from "+a.getUsername());
	
	for(User x: ulist)
	{
		System.out.println(x.getUsername());
	}
	for(User x: ulist)
	{
		if(x.getUsername().equals(a.getUsername()) && x.getPassword().equals(a.getPassword()))
		{
			System.out.println(a.getPassword());
			ret=true;
			break;
		}
	}
	
	return ret;
}
public User search(String uname) throws ClassNotFoundException, SQLException
{
		User u1=null;
	try
	{
	
		String query="Select * from user where username='"+uname+"';";
		ResultSet rs=stmt.executeQuery(query);
		u1=null;
			if(rs.next())
			{
				String userid=rs.getString(1);
				String username=rs.getString(2);
				String pass=rs.getString(3);
				System.out.println(username);
				System.out.println(pass);
				u1=new User(userid,username,pass);
				
			}
	}
	catch(Exception ex)
	{
		System.out.println(ex+" at UserDAO");
	}
	return u1;
}
public void finalize_User()
{

		try{
			con.close();
		}catch(Exception ex)
		{
			System.out.println("Closing Exception");
		}
	

}

}
