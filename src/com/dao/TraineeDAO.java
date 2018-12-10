package com.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import com.model.Trainee;
public class TraineeDAO {
private static Connection con;
private static Statement stmt;
private static ResultSet rs;
static PreparedStatement ps=null;


public static List<Trainee> getTrainee()
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

                List<Trainee>local =new ArrayList<>();
                try{
                                String query ="Select * from trainee";
                                rs=stmt.executeQuery(query);
                                
                                while(rs.next())
                                {
                                	System.out.println(">>>>>>>>>>>>>>>>>Trainee id: "+rs.getString(1));
                                                String userid=rs.getString(1);           
                                                 String traineename=rs.getString(2);      
                                                 String technology=rs.getString(3);       
                                                 String location=rs.getString(4);         
                                                 String trainername=rs.getString(5);      
                                                 String contact=rs.getString(6);         
                                                 String domain=rs.getString(7);           
                                                 String education=rs.getString(8);        
                                                 Integer passoutyear=rs.getInt(9);          
                                                
                                local.add(new Trainee(userid, traineename, technology, location, trainername, contact, domain, education, passoutyear));
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

public static boolean insertTrainee(Trainee trainee)
{
try{
                                
                                String url ="jdbc:mysql://localhost:3306/otp";
                                Class.forName("com.mysql.jdbc.Driver");
                                con =DriverManager.getConnection(url,"root","root");
                                stmt= con.createStatement();
                                }catch(Exception ex){
                                System.out.println("Open Exception-User");        
                                }
                
                String query ="insert into trainee value(?,?,?,?,?,?,?,?,?)";
                boolean r=true;
                try{
                                ps=con.prepareStatement(query);
                                ps.setString(1,trainee.getUserid());
                                ps.setString(2, trainee.getTraineename());
                                ps.setString(3, trainee.getTechnology());
                                ps.setString(4, trainee.getLocation());
                                ps.setString(5, trainee.getTrainername());
                                ps.setString(6, trainee.getContact());
                                ps.setString(7, trainee.getDomain());
                                ps.setString(8, trainee.getEducation());
                                ps.setInt(9, trainee.getPassoutyear());
                                
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
                return r;
}

public static List<String> findTrainer(String technology) {
	// TODO Auto-generated method stub
	
	  List<String> trainers = new ArrayList<>();
      Connection con=null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      String url = "jdbc:mysql://localhost:3306/otp";
      String user="root";
      String pass="root";
      String query = "Select userid,trainername from trainer where technology like ?";
      
      try
      {
                      Class.forName("com.mysql.jdbc.Driver");
                      con = DriverManager.getConnection(url,user,pass);
                      ps = con.prepareStatement(query);
                      ps.setString(1,"%"+technology+"%");
                      
                      rs = ps.executeQuery();
                      while(rs.next())
                      {
                    	  String val = "{\"trainerid\":\""+rs.getString(1)+"\",";
                          val+="\"trainername\":\""+rs.getString(2)+"\"}";
                                       
                    	  trainers.add(val);
                      }
                      
      }
      catch(Exception ex)
      {
                      System.out.println("Exception at TrainerDAO find user method:in1 "+ex);
      }
      finally
      {
        try
        {
	        if(con!=null)
	        {
	            con.close();
	        }
        }
        catch(Exception ex2)
        {
           System.out.println("Exception while closing conn at find user: in2"+ex2);
        }
      }
      return trainers;
	
}
public static List<String> findTrainerr(String location) {
	// TODO Auto-generated method stub
	
	  List<String> trainer = new ArrayList<>();
      Connection con=null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      String url = "jdbc:mysql://localhost:3306/otp";
      String user="root";
      String pass="root";
      String query = "Select userid,trainername from trainer where location like ?";
      
      try
      {
                      Class.forName("com.mysql.jdbc.Driver");
                      con = DriverManager.getConnection(url,user,pass);
                      ps = con.prepareStatement(query);
                      ps.setString(1,location);
                      
                      rs = ps.executeQuery();
                      while(rs.next())
                      {
                    	  String val = "{\"trainerid\":\""+rs.getString(1)+"\",";
                          val+="\"trainername\":\""+rs.getString(2)+"\"}";
                                       
                    	  trainer.add(val);
                      }
                      
      }
      catch(Exception ex)
      {
                      System.out.println("Exception at TrainerDAO find user method:in1 "+ex);
      }
      finally
      {
        try
        {
	        if(con!=null)
	        {
	            con.close();
	        }
        }
        catch(Exception ex2)
        {
           System.out.println("Exception while closing conn at find user: in2"+ex2);
        }
      }
      return trainer;
	
}
}
