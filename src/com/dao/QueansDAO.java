package com.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import com.model.Queans;

public class QueansDAO 
{
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	static PreparedStatement ps=null;


	public static List<Queans> getQueans()
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

	                List<Queans>local =new ArrayList<>();
	                try{
	                                String query ="Select * from queans";
	                                rs=stmt.executeQuery(query);
	                                
	                                while(rs.next())
	                                {
	                                            //System.out.println(">>>>>>>>>>>>>>>>>Trainer id: "+rs.getString(1));
	                                                         
	                                                 String answerid=rs.getString(1);           
	                                                String questionid=rs.getString(2);
	                                local.add(new Queans( answerid, questionid));
	                                }
	                }catch(Exception ex){
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
	                                   System.out.println("Closing Exception-User");
	                                }
	                }
	                return local;
	}

	public static boolean insertQueans(List<Queans> queans)
	{

	boolean r=false;
	                for(Queans q:queans)
	                {
	                	try{
                            
                            String url ="jdbc:mysql://localhost:3306/otp";
                            Class.forName("com.mysql.jdbc.Driver");
                            con =DriverManager.getConnection(url,"root","root");
                            stmt= con.createStatement();
                            }catch(Exception ex){
                            System.out.println("Open Exception-User");        
                            }
	                	String query ="insert into queans value(?,?)";
	                
	 	               try{
	 	                                ps=con.prepareStatement(query);
	 	                                ps.setString(1,q.getAnswerid());
	 	                                ps.setString(2, q.getQuestionid());
	 	                               r= ps.execute();
	 	                                
	 	                }catch(Exception ex)
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
	 	                                                System.out.println("Closing Exception-User");
	 	                                }
	 	                }

	                }
	                	                return r;
	}


	public static boolean insertQueans(Queans queans)
	{

	boolean r=true;
	               
	                	try{
                            
                            String url ="jdbc:mysql://localhost:3306/otp";
                            Class.forName("com.mysql.jdbc.Driver");
                            con =DriverManager.getConnection(url,"root","root");
                            stmt= con.createStatement();
                            }catch(Exception ex){
                            System.out.println("Open Exception-User");        
                            }
	                	String query ="insert into queans value(?,?)";
	                
	 	               try{
	 	                                ps=con.prepareStatement(query);
	 	                                ps.setString(1,queans.getAnswerid());
	 	                                ps.setString(2, queans.getQuestionid());
	 	                               r= ps.execute();
	 	                                
	 	                }catch(Exception ex)
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
	 	                                                System.out.println("Closing Exception-User");
	 	                                }
	 	                }

	                
	                	                return r;
	}


}

